package com.microsoft.msftbreweryworkshop.model

import com.microsoft.msftbreweryworkshop.api.model.BeerItem as ApiBeer

data class Brewery(
    val id: String,
    val name: String,
    val description: String?,
    val isOrganic: Boolean = false,
    val status: String?,
    val imageMedium: String?,
    val createDate: String?
)
