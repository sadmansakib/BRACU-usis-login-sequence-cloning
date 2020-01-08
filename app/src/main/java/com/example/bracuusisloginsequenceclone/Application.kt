package com.example.bracuusisloginsequenceclone

import android.app.Application
import android.content.Context
import com.example.bracuusisloginsequenceclone.network.ApiInterface
import com.example.bracuusisloginsequenceclone.network.interceptors.*
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


/**Center Application class that creates a retrofit singleton
 * @param (null)**/

class Application : Application() {

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }

    companion object {
        lateinit var context: Context

        /**
         * Function to create an instance of The API interface.
         * Uses custom OKHTTP client that overrides headers and disables followRedirects
         * to deal with HTTP 302 response
         * **/

        fun createInstance(): ApiInterface {
            val gson = GsonBuilder().setLenient().create()
            val httpLoggingInterceptor = HttpLoggingInterceptor().apply {
                this.level = HttpLoggingInterceptor.Level.BODY
            }

            val client = OkHttpClient.Builder().apply {
                followRedirects(false)
                connectTimeout(30, TimeUnit.SECONDS)
                readTimeout(30, TimeUnit.SECONDS)
                retryOnConnectionFailure(true)
                addInterceptor(AuthenticationHeaderInterceptor())
                addInterceptor(AddCookiesInterceptor(context))
                addInterceptor(ReceivedCookiesInterceptor(context))
                addInterceptor(RedirectHandlerInterceptor())
                addInterceptor(AddCookiesInterceptor(context))
                addInterceptor(ReceivedCookiesInterceptor(context))
                addInterceptor(httpLoggingInterceptor)

            }.build()
            return Retrofit.Builder()
                .baseUrl("http://usis.bracu.ac.bd/academia/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client).build().create(ApiInterface::class.java)
        }
    }
}
