package com.microsoft.msftbreweryworkshop.model

data class BreweryListItem(
    val id: String,
    val name: String,
    val icon: String?,
    val established: String? = null,
    val isOrganic: Boolean = false,
    val isActive: Boolean = true
)
