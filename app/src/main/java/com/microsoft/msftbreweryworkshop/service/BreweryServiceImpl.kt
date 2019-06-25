package com.microsoft.msftbreweryworkshop.service

import com.microsoft.msftbreweryworkshop.api.BreweryApi
import com.microsoft.msftbreweryworkshop.api.model.BreweryDetail
import com.microsoft.msftbreweryworkshop.api.model.BreweryItem
import com.microsoft.msftbreweryworkshop.api.model.DetailResponse
import com.microsoft.msftbreweryworkshop.api.model.ListResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BreweryServiceImpl(private val breweryApi: BreweryApi) : BreweryService {
    override fun getBreweries(listener: ServiceListener<ListResponse<BreweryItem>>) {
        breweryApi.getBreweries().enqueue(object : Callback<ListResponse<BreweryItem>> {
            override fun onFailure(call: Call<ListResponse<BreweryItem>>, t: Throwable) {
                listener.onFailure(t.localizedMessage)
            }

            override fun onResponse(
                call: Call<ListResponse<BreweryItem>>,
                response: Response<ListResponse<BreweryItem>>
            ) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        listener.onSuccess(it)
                    }
                } else {
                    listener.onFailure(response.message())
                }
            }

        })
    }

    override fun getBrewery(id: String, listener: ServiceListener<DetailResponse<BreweryDetail>>) {
        breweryApi.getBrewery(id).enqueue(object : Callback<DetailResponse<BreweryDetail>> {
            override fun onFailure(call: Call<DetailResponse<BreweryDetail>>, t: Throwable) {
                listener.onFailure(t.localizedMessage)
            }

            override fun onResponse(
                call: Call<DetailResponse<BreweryDetail>>,
                response: Response<DetailResponse<BreweryDetail>>
            ) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        listener.onSuccess(it)
                    }
                } else {
                    listener.onFailure(response.message())
                }
            }

        })
    }
}