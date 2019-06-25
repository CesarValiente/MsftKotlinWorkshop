package com.microsoft.msftbreweryworkshop.model

import com.microsoft.msftbreweryworkshop.api.model.BeerItem as ApiBeer

data class Beer(
    val id: String,
    val name: String,
    val description: String?,
    val abv: String?,
    val isOrganic: Boolean = false,
    val icon: String?,
    val imageMedium: String?,
    val imageLarge: String?,
    val status: String?,
    val foodPairings: String?,
    val style: String?
)
