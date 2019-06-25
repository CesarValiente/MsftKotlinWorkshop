package com.microsoft.msftbreweryworkshop.service

import com.microsoft.msftbreweryworkshop.model.Beer
import com.microsoft.msftbreweryworkshop.model.BeerListItem
import kotlinx.coroutines.Deferred

interface BeerService {
    fun getBeerList(): Deferred<List<BeerListItem>>
    fun getBeer(id: String): Deferred<Beer>
}