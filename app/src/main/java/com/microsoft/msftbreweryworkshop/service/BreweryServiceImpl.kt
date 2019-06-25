package com.microsoft.msftbreweryworkshop.service

import com.microsoft.msftbreweryworkshop.api.BreweryApi
import com.microsoft.msftbreweryworkshop.ext.toBrewery
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async

class BreweryServiceImpl(private val breweryApi: BreweryApi) : BreweryService {
    override fun getBreweries() = CoroutineScope(Dispatchers.Default).async(start = CoroutineStart.LAZY) {
        val response = breweryApi.getBreweries()

        val breweryListData = response.body()?.data ?: throw IllegalStateException("List doesn't exists")

        breweryListData.map {
            it.toBrewery()
        }
    }

    override fun getBrewery(id: String) = CoroutineScope(Dispatchers.Default).async(start = CoroutineStart.LAZY) {
        val response = breweryApi.getBrewery(id)
        val breweryDetail = response.body()?.data ?: throw IllegalStateException("Detail doesn't exists")

        breweryDetail.toBrewery()
    }
}