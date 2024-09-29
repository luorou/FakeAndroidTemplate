package com.bye.ane.core.network.interceptor

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class HeaderInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val build = chain.request().newBuilder()
        //
        build.addHeader("channel", "Android")
        //
        val request: Request = build.build()
        // 开始请求
        val response: Response
        try {
            response = chain.proceed(request)
        } catch (ex: Exception) {
            throw ex
        }
        return response
    }
}