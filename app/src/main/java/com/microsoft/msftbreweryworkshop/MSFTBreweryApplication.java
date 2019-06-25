package com.microsoft.msftbreweryworkshop;

import android.app.Application;
import com.microsoft.msftbreweryworkshop.service.BeerService;
import com.microsoft.msftbreweryworkshop.service.BreweryService;
import com.microsoft.msftbreweryworkshop.service.ServiceLocator;
import com.microsoft.msftbreweryworkshop.service.ServiceLocatorImpl;
import org.jetbrains.annotations.NotNull;
import timber.log.Timber;

public class MSFTBreweryApplication extends Application {
    private ServiceLocator serviceLocator;

    @Override
    public void onCreate() {
        super.onCreate();

        Timber.plant(new DebugTree());

        serviceLocator = new ServiceLocatorImpl(this);
    }

    public BreweryService provideBreweryService() {
        return serviceLocator.getBreweryService();
    }

    public BeerService provideBeerService() {
        return serviceLocator.getBeerService();
    }

    private class DebugTree extends Timber.DebugTree {
        @Override
        protected void log(int priority, String tag, @NotNull String message, Throwable t) {
            super.log(priority, "MyBeer:" + tag, message, t);
        }
    }
}