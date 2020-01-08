package com.example.bracuusisloginsequenceclone.network.interceptors

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Response

class RedirectHandlerInterceptor : Interceptor{
    override fun intercept(chain: Interceptor.Chain): Response {
        var req = chain.request()
        var originalResponse = chain.proceed(req)
        Log.i("url",originalResponse.headers("Location").toString())
        if(originalResponse.isRedirect && originalResponse.header("Location")!!.isNotEmpty()){
            req = req.newBuilder()
                .get()
                .url(originalResponse.header("Location")!!).build()
            originalResponse = chain.proceed(req)
        }
        return originalResponse
    }

}