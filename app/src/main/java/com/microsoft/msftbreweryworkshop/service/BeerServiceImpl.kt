package com.microsoft.msftbreweryworkshop.service

import com.microsoft.msftbreweryworkshop.api.BeerApi
import com.microsoft.msftbreweryworkshop.api.model.BeerDetail
import com.microsoft.msftbreweryworkshop.api.model.BeerItem
import com.microsoft.msftbreweryworkshop.api.model.DetailResponse
import com.microsoft.msftbreweryworkshop.api.model.ListResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BeerServiceImpl(private val beerApi: BeerApi) : BeerService {
    override fun getBeerList(listener: ServiceListener<ListResponse<BeerItem>>) {
        beerApi.getBeers().enqueue(object : Callback<ListResponse<BeerItem>> {
            override fun onFailure(call: Call<ListResponse<BeerItem>>, t: Throwable) {
                listener.onFailure(t.localizedMessage)
            }

            override fun onResponse(
                call: Call<ListResponse<BeerItem>>,
                response: Response<ListResponse<BeerItem>>
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

    override fun getBeer(id: String, listener: ServiceListener<DetailResponse<BeerDetail>>) {
        beerApi.getBeer(id).enqueue(object : Callback<DetailResponse<BeerDetail>> {
            override fun onFailure(call: Call<DetailResponse<BeerDetail>>, t: Throwable) {
                listener.onFailure(t.localizedMessage)
            }

            override fun onResponse(
                call: Call<DetailResponse<BeerDetail>>,
                response: Response<DetailResponse<BeerDetail>>
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