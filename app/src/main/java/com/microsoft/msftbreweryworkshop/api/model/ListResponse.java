package com.microsoft.msftbreweryworkshop.api.model;

import com.squareup.moshi.Json;

import java.util.List;

public class ListResponse<T> {

    @Json(name = "currentPage")
    private int currentPage;

    @Json(name = "numberOfPages")
    private int numberOfPages;

    @Json(name = "totalResults")
    private int totalResults;

    @Json(name = "data")
    private List<T> data = null;

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

}
