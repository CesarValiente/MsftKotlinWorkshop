package com.microsoft.msftbreweryworkshop.service;

import com.microsoft.msftbreweryworkshop.api.BreweryApi;
import com.microsoft.msftbreweryworkshop.api.model.BreweryDetail;
import com.microsoft.msftbreweryworkshop.api.model.BreweryItem;
import com.microsoft.msftbreweryworkshop.api.model.DetailResponse;
import com.microsoft.msftbreweryworkshop.api.model.ListResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BreweryServiceImpl implements BreweryService {
    private BreweryApi breweryApi;

    public BreweryServiceImpl(BreweryApi breweryApi) {
        this.breweryApi = breweryApi;
    }

    @Override
    public void getBreweries(final ServiceListener<ListResponse<BreweryItem>> listener) {
        breweryApi.getBreweries().enqueue(new Callback<ListResponse<BreweryItem>>() {
            @Override
            public void onResponse(Call<ListResponse<BreweryItem>> call, Response<ListResponse<BreweryItem>> response) {
                if (response.isSuccessful()) {
                    listener.onSuccess(response.body());
                } else {
                    listener.onFailure(response.message());
                }
            }

            @Override
            public void onFailure(Call<ListResponse<BreweryItem>> call, Throwable t) {
                listener.onFailure(t.getLocalizedMessage());
            }
        });
    }

    @Override
    public void getBrewery(String id, final ServiceListener<DetailResponse<BreweryDetail>> listener) {
        breweryApi.getBrewery(id).enqueue(new Callback<DetailResponse<BreweryDetail>>() {
            @Override
            public void onResponse(Call<DetailResponse<BreweryDetail>> call, Response<DetailResponse<BreweryDetail>> response) {
                if (response.isSuccessful()) {
                    listener.onSuccess(response.body());
                } else {
                    listener.onFailure(response.message());
                }
            }

            @Override
            public void onFailure(Call<DetailResponse<BreweryDetail>> call, Throwable t) {
                listener.onFailure(t.getLocalizedMessage());
            }
        });
    }
}