package com.microsoft.msftbreweryworkshop.api

import com.microsoft.msftbreweryworkshop.api.model.BreweryDetail
import com.microsoft.msftbreweryworkshop.api.model.BreweryItem
import com.microsoft.msftbreweryworkshop.api.model.DetailResponse
import com.microsoft.msftbreweryworkshop.api.model.ListResponse
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface BreweryApi {
    @GET("breweries")
    suspend fun getBreweries(): Response<ListResponse<BreweryItem>>

    @GET("brewery/{id}")
    suspend fun getBrewery(
        @Path("id") breweryId: String
    ): Response<DetailResponse<BreweryDetail>>
}