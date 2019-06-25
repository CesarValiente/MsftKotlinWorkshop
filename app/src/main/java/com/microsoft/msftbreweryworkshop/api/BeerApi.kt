package com.microsoft.msftbreweryworkshop.api

import com.microsoft.msftbreweryworkshop.api.model.BeerItem
import com.microsoft.msftbreweryworkshop.api.model.BeerDetail
import com.microsoft.msftbreweryworkshop.api.model.DetailResponse
import com.microsoft.msftbreweryworkshop.api.model.ListResponse
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface BeerApi {
    @GET("beers")
    suspend fun getBeers(): Response<ListResponse<BeerItem>>

    @GET("beer/{id}")
    suspend fun getBeer(
        @Path("id") beerId: String
    ): Response<DetailResponse<BeerDetail>>
}