package com.microsoft.msftbreweryworkshop.network

import com.microsoft.msftbreweryworkshop.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response


class AuthRequestInterceptor : Interceptor {
    companion object {
        const val API_KEY = "key"
    }

    override fun intercept(chain: Interceptor.Chain): Response? {
        var request = chain.request()

        val url = request.url()
            .newBuilder()
            .addQueryParameter(API_KEY, BuildConfig.API_KEY)
            .build()

        request = request.newBuilder().url(url).build()

        return chain.proceed(request)
    }
}