package com.example.bracuusisloginsequenceclone.network.interceptors

import okhttp3.Interceptor
import okhttp3.Response

/**
 * AuthenticationHeaderInterceptor is responsible for adding required headers explicitly.
 * These headers are determined by observing packets of original BRACU Mobile application.
 * @constructor null
 * @return {Interceptor} return as an Interceptor instance that overrides request headers.
 * **/

class AuthenticationHeaderInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var req = chain.request()
        req = req.newBuilder()
            .header("notificationToken", " ")
            .header("Host", "usis.bracu.ac.bd")
            .header("isLatest", "updated")
            .header("Connection", "Keep-Alive")
            .header("User-Agent", "Apache-HttpClient/UNAVAILABLE (java 1.4)")
            .build()
        return chain.proceed(req)
    }
}