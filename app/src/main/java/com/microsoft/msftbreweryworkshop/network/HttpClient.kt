package com.microsoft.msftbreweryworkshop.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.experimental.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import timber.log.Timber
import java.io.File
import java.util.concurrent.TimeUnit

const val CONNECT_TIMEOUT_SECONDS: Long = 30
const val READ_TIMEOUT_SECONDS: Long = 60

fun buildRetrofit(
    apiUrl: String,
    okHttpClient: OkHttpClient,
    authInterceptor: AuthRequestInterceptor,
    moshi: Moshi
) = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(apiUrl)
    .client(
        okHttpClient
            .newBuilder()
            .addInterceptor(authInterceptor)
            .build()
    )
    .build()

fun buildOkHttpClient(cacheDir: File): OkHttpClient {
    val cache = Cache(cacheDir, 10 * 1024 * 1024 /* 10 MiB */)

    val builder = OkHttpClient.Builder()
        .connectTimeout(CONNECT_TIMEOUT_SECONDS, TimeUnit.SECONDS)
        .readTimeout(READ_TIMEOUT_SECONDS, TimeUnit.SECONDS)
        .cache(cache)
        .addNetworkInterceptor(HttpLoggingInterceptor(
            HttpLoggingInterceptor.Logger { msg -> Timber.tag("okHttp").d(msg) }
        ).apply {
            level = HttpLoggingInterceptor.Level.BODY
        })

    return builder.build()
}