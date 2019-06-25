package com.microsoft.msftbreweryworkshop.service;

interface ServiceLocator {
    public BreweryService getBreweryService();
    public BeerService getBeerService();
}