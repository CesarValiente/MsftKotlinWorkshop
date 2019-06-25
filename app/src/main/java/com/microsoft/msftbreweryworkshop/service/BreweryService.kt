package com.microsoft.msftbreweryworkshop.service

import com.microsoft.msftbreweryworkshop.api.model.BreweryDetail
import com.microsoft.msftbreweryworkshop.api.model.BreweryItem
import com.microsoft.msftbreweryworkshop.api.model.DetailResponse
import com.microsoft.msftbreweryworkshop.api.model.ListResponse

interface BreweryService {
    fun getBreweries(listener: ServiceListener<ListResponse<BreweryItem>>)
    fun getBrewery(id: String, listener: ServiceListener<DetailResponse<BreweryDetail>>)
}