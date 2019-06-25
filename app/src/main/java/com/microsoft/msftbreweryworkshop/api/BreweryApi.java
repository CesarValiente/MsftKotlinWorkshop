package com.microsoft.msftbreweryworkshop.api;

import com.microsoft.msftbreweryworkshop.api.model.BreweryDetail;
import com.microsoft.msftbreweryworkshop.api.model.BreweryItem;
import com.microsoft.msftbreweryworkshop.api.model.DetailResponse;
import com.microsoft.msftbreweryworkshop.api.model.ListResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface BreweryApi {
    @GET("breweries")
    public Call<ListResponse<BreweryItem>> getBreweries();

    @GET("brewery/{id}")
    public Call<DetailResponse<BreweryDetail>> getBrewery(
        @Path("id") String breweryId
    );
}