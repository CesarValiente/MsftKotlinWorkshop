package com.microsoft.msftbreweryworkshop.service;

import android.app.Application;
import com.microsoft.msftbreweryworkshop.BuildConfig;
import com.microsoft.msftbreweryworkshop.api.BeerApi;
import com.microsoft.msftbreweryworkshop.api.BreweryApi;
import com.microsoft.msftbreweryworkshop.network.AuthRequestInterceptor;
import com.microsoft.msftbreweryworkshop.network.HttpClient;
import com.squareup.moshi.Moshi;
import retrofit2.Retrofit;

public class ServiceLocatorImpl implements ServiceLocator {
    private Retrofit retrofit;
    private Application app;

    public ServiceLocatorImpl(Application application) {
        app = application;
        retrofit = HttpClient.buildRetrofit(
                BuildConfig.API_URL,
                HttpClient.buildOkHttpClient(app.getCacheDir()),
                new AuthRequestInterceptor(),
                new Moshi.Builder().build()
        );
    }

    @Override
    public BreweryService getBreweryService() {
        BreweryApi breweryApi = retrofit.create(BreweryApi.class);
        return new BreweryServiceImpl(breweryApi);
    }

    @Override
    public BeerService getBeerService() {
        BeerApi beerApi = retrofit.create(BeerApi.class);
        return new BeerServiceImpl(beerApi);
    }
}