package com.microsoft.msftbreweryworkshop.service;

import com.microsoft.msftbreweryworkshop.api.model.BreweryDetail;
import com.microsoft.msftbreweryworkshop.api.model.BreweryItem;
import com.microsoft.msftbreweryworkshop.api.model.DetailResponse;
import com.microsoft.msftbreweryworkshop.api.model.ListResponse;

public interface BreweryService {
    void getBreweries(ServiceListener<ListResponse<BreweryItem>> listener);
    void getBrewery(String id, ServiceListener<DetailResponse<BreweryDetail>> listener);
}