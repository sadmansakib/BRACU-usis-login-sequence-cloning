package com.example.bracuusisloginsequenceclone.network.interceptors

import android.content.Context
import android.util.Log
import com.example.bracuusisloginsequenceclone.network.CookiesHelper
import okhttp3.Interceptor
import okhttp3.Response

/**
 * ReceivedCookiesInterceptor is responsible for saving Cookies value we fetch from sending request to API.
 * @constructor {context} is passed as a parameter in constructor.
 * @return {Interceptor} return as an Interceptor instance that fetches all cookies form "Set-Cookie"
 * header file and saves them Using CookiesHelper class
 * **/

class ReceivedCookiesInterceptor(private var context: Context) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val originalResponse = chain.proceed(chain.request())
        val responseURL = originalResponse.headers("Location").toString()
        if(responseURL.contains("jsessionid=")){
            val cookies:HashSet<String> = HashSet()
            val responseArray:Array<String> = responseURL.split(';').toTypedArray()
            cookies.add(responseArray[1].replace("jsessionid","JSESSIONID"))
            CookiesHelper.setCookies(context,cookies)
            Log.i("cookie from url", responseArray[1].replace("jsessionid","JSESSIONID"))
        }
        if (originalResponse.headers("Set-Cookie").isNotEmpty()) {
            val cookies: HashSet<String> = HashSet()
            for (header in originalResponse.headers("Set-Cookie")) {
                cookies.add(header)
            }
            CookiesHelper.setCookies(context, cookies)

        }
        return originalResponse
    }
}