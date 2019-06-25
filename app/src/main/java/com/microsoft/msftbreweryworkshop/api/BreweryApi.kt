package com.microsoft.msftbreweryworkshop.api

import com.microsoft.msftbreweryworkshop.api.model.BreweryDetail
import com.microsoft.msftbreweryworkshop.api.model.BreweryItem
import com.microsoft.msftbreweryworkshop.api.model.DetailResponse
import com.microsoft.msftbreweryworkshop.api.model.ListResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface BreweryApi {
    @GET("breweries")
    fun getBreweries(): Call<ListResponse<BreweryItem>>

    @GET("brewery/{id}")
    fun getBrewery(
        @Path("id") breweryId: String
    ): Call<DetailResponse<BreweryDetail>>
}