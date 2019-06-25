package com.microsoft.msftbreweryworkshop.network;

import com.squareup.moshi.Moshi;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import org.jetbrains.annotations.NotNull;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;
import timber.log.Timber;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class HttpClient {
    private static int CONNECT_TIMEOUT_SECONDS = 30;
    private static int READ_TIMEOUT_SECONDS = 60;

    static public Retrofit buildRetrofit(
            String apiUrl,
            OkHttpClient okHttpClient,
            AuthRequestInterceptor authInterceptor,
            Moshi moshi
    ) {
        return new Retrofit.Builder()
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .baseUrl(apiUrl)
                .client(
                        okHttpClient
                                .newBuilder()
                                .addInterceptor(authInterceptor)
                                .build()
                )
                .build();
    }

    static public OkHttpClient buildOkHttpClient(File cacheDir) {
        Cache cache = new Cache(cacheDir, 10 * 1024 * 1024 /* 10 MiB */);

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(
                new HttpLoggingInterceptor.Logger() {

                    @Override
                    public void log(String message) {
                        Timber.tag("okHttp").d(message);
                    }
                }
        );

        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .connectTimeout(CONNECT_TIMEOUT_SECONDS, TimeUnit.SECONDS)
                .readTimeout(READ_TIMEOUT_SECONDS, TimeUnit.SECONDS)
                .cache(cache)
                .addNetworkInterceptor( new HttpLoggingInterceptor(
                        new HttpLoggingInterceptor.Logger() {

                            @Override
                            public void log(@NotNull String message) {
                                Timber.tag("okHttp").d(message);
                            }
                        }
                ));

        return builder.build();
    }
}
