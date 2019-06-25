package com.microsoft.msftbreweryworkshop.api.model;


import com.squareup.moshi.Json;

public class DetailResponse<T> {

    @Json(name = "message")
    private String message;

    @Json(name = "data")
    private T data = null;

    @Json(name = "status")
    private String status;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
