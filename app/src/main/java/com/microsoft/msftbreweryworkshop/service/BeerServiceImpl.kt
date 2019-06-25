package com.microsoft.msftbreweryworkshop.service

import com.microsoft.msftbreweryworkshop.api.BeerApi
import com.microsoft.msftbreweryworkshop.ext.toBeer
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async

class BeerServiceImpl(private val beerApi: BeerApi) : BeerService {

    override fun getBeerList() = CoroutineScope(Dispatchers.Default).async(start = CoroutineStart.LAZY) {
        val response = beerApi.getBeers()
        val beerListData = response.body()?.data ?: throw IllegalStateException("List doesn't exists")

        beerListData.map {
            it.toBeer()
        }
    }

    override fun getBeer(id: String) = CoroutineScope(Dispatchers.Default).async(start = CoroutineStart.LAZY) {
        val response = beerApi.getBeer(id)
        val beerData = response.body()?.data ?: throw IllegalStateException("Detail doesn't exists")

        beerData.toBeer()
    }
}