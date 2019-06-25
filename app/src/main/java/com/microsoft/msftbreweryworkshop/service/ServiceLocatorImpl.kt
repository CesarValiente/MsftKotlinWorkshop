package com.microsoft.msftbreweryworkshop.service

import android.app.Application
import com.microsoft.msftbreweryworkshop.BuildConfig
import com.microsoft.msftbreweryworkshop.api.BeerApi
import com.microsoft.msftbreweryworkshop.api.BreweryApi
import com.microsoft.msftbreweryworkshop.network.AuthRequestInterceptor
import com.microsoft.msftbreweryworkshop.network.buildOkHttpClient
import com.microsoft.msftbreweryworkshop.network.buildRetrofit
import com.squareup.moshi.Moshi
import retrofit2.Retrofit

class ServiceLocatorImpl(val app: Application) : ServiceLocator {
    private val retrofit: Retrofit by lazy {
        buildRetrofit(
            BuildConfig.API_URL,
            buildOkHttpClient(app.cacheDir),
            AuthRequestInterceptor(),
            moshi = Moshi.Builder().build()
        )
    }

    override fun getBreweryService(): BreweryService {
        val breweryApi = retrofit.create(BreweryApi::class.java)
        return BreweryServiceImpl(breweryApi)
    }

    override fun getBeerService(): BeerService {
        val beerApi = retrofit.create(BeerApi::class.java)
        return BeerServiceImpl(beerApi)
    }
}