package com.microsoft.msftbreweryworkshop.api

import com.microsoft.msftbreweryworkshop.api.model.BeerItem
import com.microsoft.msftbreweryworkshop.api.model.BeerDetail
import com.microsoft.msftbreweryworkshop.api.model.DetailResponse
import com.microsoft.msftbreweryworkshop.api.model.ListResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface BeerApi {
    @GET("beers")
    fun getBeers(): Call<ListResponse<BeerItem>>

    @GET("beer/{id}")
    fun getBeer(
        @Path("id") beerId: String
    ): Call<DetailResponse<BeerDetail>>
}