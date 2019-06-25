package com.microsoft.msftbreweryworkshop.api.model;

import com.squareup.moshi.Json;

import java.util.List;

public class ShortListResponse<T> {

    @Json(name = "message")
    private String message;

    @Json(name = "data")
    private List<T> data = null;

    @Json(name = "status")
    private String status;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
