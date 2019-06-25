package com.microsoft.msftbreweryworkshop.service

interface ServiceListener<T> {
    fun onSuccess(response: T)
    fun onFailure(error: String)
}