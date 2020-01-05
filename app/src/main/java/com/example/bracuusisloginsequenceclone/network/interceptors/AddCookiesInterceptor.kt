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
//        Log.i("preference","$preferences")
        if (preferences.isNotEmpty()) {
            val cookieString = StringBuilder()
            for (cookie in preferences) {
                val parser: Array<String> = cookie.split(";").toTypedArray()
                cookieString.append(parser[0] + "; ")
            }
//        Log.v(
//            "OkHttp",
//            "Adding Header: $cookieString"
//        )
            builder.addHeader(
                "Cookie",
                cookieString.toString().substring(0, cookieString.length - 2)
            )
            builder.addHeader("Cookie2", "\$Version=1")
        }

        //        Log.i("builder","${builder.build().headers}")
        return chain.proceed(builder.build())
    }

}