package com.microsoft.msftbreweryworkshop.service

interface ServiceLocator {
    fun getBreweryService(): BreweryService
    fun getBeerService(): BeerService
}