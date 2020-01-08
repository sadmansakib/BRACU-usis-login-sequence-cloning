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
//            .header("notificationToken","fI4vxs6qWgk:APA91bGenoHPMb4R7y0RmEhSUbv3GeWMlrEDZS-QCRDhxv0NBFSrVhjBqQ5KxnczQHS1wTqkgohmr-uAmLvRRU2NFZmy5vF8AKTQeabp0vINKDl737x5C0x2aRizHth5gLjfcKulFPb5")
//            .header("appKey","AX32WOHH231FDS2158N14L8N")
            .build()
        return  chain.proceed(req)
    }
}