package com.example.bracuusisloginsequenceclone.network.interceptors

import android.content.Context
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