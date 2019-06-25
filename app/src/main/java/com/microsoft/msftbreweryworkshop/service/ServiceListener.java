package com.microsoft.msftbreweryworkshop.service;

public interface ServiceListener<T> {
    void onSuccess(T response);
    void onFailure(String error);
}