package com.microsoft.msftbreweryworkshop.service;

import com.microsoft.msftbreweryworkshop.api.BeerApi;
import com.microsoft.msftbreweryworkshop.api.model.BeerDetail;
import com.microsoft.msftbreweryworkshop.api.model.BeerItem;
import com.microsoft.msftbreweryworkshop.api.model.DetailResponse;
import com.microsoft.msftbreweryworkshop.api.model.ListResponse;
import org.jetbrains.annotations.NotNull;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BeerServiceImpl implements BeerService {
    private BeerApi beerApi;

    public BeerServiceImpl(BeerApi beerApi) {
        this.beerApi = beerApi;
    }

    @Override
    public void getBeerList(final ServiceListener<ListResponse<BeerItem>> listener) {
        beerApi.getBeers().enqueue(new Callback<ListResponse<BeerItem>>() {
            @Override
            public void onResponse(@NotNull Call<ListResponse<BeerItem>> call, @NotNull Response<ListResponse<BeerItem>> response) {
                if (response.isSuccessful()) {
                    listener.onSuccess(response.body());
                } else {
                    listener.onFailure(response.message());
                }
            }

            @Override
            public void onFailure(@NotNull Call<ListResponse<BeerItem>> call, Throwable t) {
                listener.onFailure(t.getLocalizedMessage());
            }
        });
    }

    @Override
    public void getBeer(String id, final ServiceListener<DetailResponse<BeerDetail>> listener) {
        beerApi.getBeer(id).enqueue(new Callback<DetailResponse<BeerDetail>>() {
            @Override
            public void onResponse(Call<DetailResponse<BeerDetail>> call, Response<DetailResponse<BeerDetail>> response) {
                if (response.isSuccessful()) {
                    listener.onSuccess(response.body());
                } else {
                    listener.onFailure(response.message());
                }
            }

            @Override
            public void onFailure(Call<DetailResponse<BeerDetail>> call, Throwable t) {
                listener.onFailure(t.getLocalizedMessage());
            }
        });
    }
}