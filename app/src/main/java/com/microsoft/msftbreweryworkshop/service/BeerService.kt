package com.microsoft.msftbreweryworkshop.service

import com.microsoft.msftbreweryworkshop.api.model.BeerDetail
import com.microsoft.msftbreweryworkshop.api.model.BeerItem
import com.microsoft.msftbreweryworkshop.api.model.DetailResponse
import com.microsoft.msftbreweryworkshop.api.model.ListResponse

interface BeerService {
    fun getBeerList(listener: ServiceListener<ListResponse<BeerItem>>)
    fun getBeer(id: String, listener: ServiceListener<DetailResponse<BeerDetail>>)
}