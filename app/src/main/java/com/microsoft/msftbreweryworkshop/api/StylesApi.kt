package com.microsoft.msftbreweryworkshop.api

import com.microsoft.msftbreweryworkshop.api.model.DetailResponse
import com.microsoft.msftbreweryworkshop.api.model.ShortListResponse
import com.microsoft.msftbreweryworkshop.api.model.Style
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface StylesApi {
    @GET("styles")
    fun getBreweries(): Call<ShortListResponse<Style>>

    @GET("style/{id}")
    fun getBrewery(
        @Path("id") styleId: String
    ): Call<DetailResponse<Style>>
}