package com.microsoft.msftbreweryworkshop.service;

import com.microsoft.msftbreweryworkshop.api.model.BeerDetail;
import com.microsoft.msftbreweryworkshop.api.model.BeerItem;
import com.microsoft.msftbreweryworkshop.api.model.DetailResponse;
import com.microsoft.msftbreweryworkshop.api.model.ListResponse;

interface BeerService {
    void getBeerList(ServiceListener<ListResponse<BeerItem>> listener);
    void getBeer(String id, ServiceListener<DetailResponse<BeerDetail>> listener);
}