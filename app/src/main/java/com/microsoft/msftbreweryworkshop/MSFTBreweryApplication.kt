package com.microsoft.msftbreweryworkshop

import android.app.Application
import com.microsoft.msftbreweryworkshop.service.ServiceLocator
import com.microsoft.msftbreweryworkshop.service.ServiceLocatorImpl
import com.microsoft.msftbreweryworkshop.utils.initApp

class MSFTBreweryApplication : Application() {
    private lateinit var serviceLocator: ServiceLocator

    override fun onCreate() {
        super.onCreate()

        initApp(this)

        serviceLocator = ServiceLocatorImpl(this)
    }

    fun provideBreweryService() = serviceLocator.getBreweryService()

    fun provideBeerService() = serviceLocator.getBeerService()
}