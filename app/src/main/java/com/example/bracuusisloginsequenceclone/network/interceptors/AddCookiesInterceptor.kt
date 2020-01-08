package com.example.bracuusisloginsequenceclone.network.interceptors

import android.content.Context
import com.example.bracuusisloginsequenceclone.network.CookiesHelper
import okhttp3.Interceptor
import okhttp3.Response


/**
 * AddCookiesInterceptor is responsible for adding saved cookies on SharedPreferences as headers.
 * @constructor {context} is passed as a parameter in constructor.
 * @return {Interceptor} return as an Interceptor instance that overrides request headers.
 * **/

class AddCookiesInterceptor(private var context: Context) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val builder = chain.request().newBuilder()
        val preferences: HashSet<String> = CookiesHelper.getCookies(context)
        lateinit var parser : Array<String>
        if (preferences.isNotEmpty()) {
            for (cookie in preferences) {
                parser = cookie.split(";").toTypedArray()
            }
            builder.addHeader(
                "Cookie",
                parser[0]
            )
        }

        return chain.proceed(builder.build())
    }

}