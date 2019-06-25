package com.microsoft.msftbreweryworkshop.ui

interface ListItemHandler<T> {
    fun onItemClick(item: T)
}