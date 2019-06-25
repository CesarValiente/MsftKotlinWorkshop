package com.microsoft.msftbreweryworkshop.model

import android.annotation.SuppressLint
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import com.microsoft.msftbreweryworkshop.api.model.BeerItem as ApiBeer

@Parcelize
@SuppressLint("ParcelCreator")
data class BeerListItem(
    val id: String,
    val name: String,
    val description: String?,
    val isOrganic: Boolean = false,
    val icon: String?,
    val abv: String?,
    val style: String?,
    val status: String?
) : Parcelable
