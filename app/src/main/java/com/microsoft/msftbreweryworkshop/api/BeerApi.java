package com.microsoft.msftbreweryworkshop.api;

import com.microsoft.msftbreweryworkshop.api.model.BeerItem;
import com.microsoft.msftbreweryworkshop.api.model.BeerDetail;
import com.microsoft.msftbreweryworkshop.api.model.DetailResponse;
import com.microsoft.msftbreweryworkshop.api.model.ListResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface BeerApi {
    @GET("beers")
    public Call<ListResponse<BeerItem>> getBeers();

    @GET("beer/{id}")
    public Call<DetailResponse<BeerDetail>> getBeer(
        @Path("id") String beerId
    );
}