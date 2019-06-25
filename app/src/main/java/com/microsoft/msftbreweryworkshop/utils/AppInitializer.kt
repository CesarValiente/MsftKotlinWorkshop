package com.microsoft.msftbreweryworkshop.utils

import com.microsoft.msftbreweryworkshop.MSFTBreweryApplication
import timber.log.Timber


fun initApp(app: MSFTBreweryApplication) {
    Timber.plant(DebugTree())
}

private class DebugTree : Timber.DebugTree() {
    override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
        super.log(priority, "MyBeer:" + tag!!, message, t)
    }
}