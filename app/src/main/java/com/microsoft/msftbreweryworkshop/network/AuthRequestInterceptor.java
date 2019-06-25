package com.microsoft.msftbreweryworkshop.network;

import com.microsoft.msftbreweryworkshop.BuildConfig;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;


public class AuthRequestInterceptor implements Interceptor {
    private static String API_KEY = "key";

    @NotNull
    @Override
    public Response intercept(@NotNull Chain chain) throws IOException {
        Request request = chain.request();

        HttpUrl url = request.url()
                .newBuilder()
                .addQueryParameter(API_KEY, BuildConfig.API_KEY)
                .build();

        request = request.newBuilder().url(url).build();

        return chain.proceed(request);
    }
}