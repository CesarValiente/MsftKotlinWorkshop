package com.microsoft.msftbreweryworkshop.service

import com.microsoft.msftbreweryworkshop.model.Brewery
import com.microsoft.msftbreweryworkshop.model.BreweryListItem
import kotlinx.coroutines.Deferred

interface BreweryService {
    fun getBreweries(): Deferred<List<BreweryListItem>>
    fun getBrewery(id: String): Deferred<Brewery>
}