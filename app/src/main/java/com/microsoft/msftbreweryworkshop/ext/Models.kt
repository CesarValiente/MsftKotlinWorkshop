package com.microsoft.msftbreweryworkshop.ext

import com.microsoft.msftbreweryworkshop.model.BeerListItem
import com.microsoft.msftbreweryworkshop.model.BreweryListItem
import com.microsoft.msftbreweryworkshop.api.model.BeerItem
import com.microsoft.msftbreweryworkshop.api.model.BeerDetail
import com.microsoft.msftbreweryworkshop.api.model.BreweryDetail
import com.microsoft.msftbreweryworkshop.api.model.BreweryItem
import com.microsoft.msftbreweryworkshop.model.Beer
import com.microsoft.msftbreweryworkshop.model.Brewery

fun BreweryItem.toBrewery() = BreweryListItem(
    id = id,
    name = if (nameShortDisplay != null) nameShortDisplay else name,
    icon = images?.icon,
    established = established,
    isOrganic = isOrganic != "N",
    isActive = isInBusiness != "N"
)

fun BeerItem.toBeer(): BeerListItem =
    BeerListItem(
        id = id,
        name = if (nameShortDisplay != null) nameShortDisplay else name,
        description = description,
        isOrganic = isOrganic != "N",
        icon = labels?.icon,
        status = status,
        abv = abv,
        style = style?.name
    )

fun BeerDetail.toBeer() = Beer (
    id = id,
    name = name,
    abv = abv,
    description = description,
    foodPairings = foodPairings,
    isOrganic = isOrganic != "N",
    icon = labels?.icon,
    imageMedium = labels?.medium,
    imageLarge = labels?.large,
    status = status,
    style = style?.name
)

fun BreweryDetail.toBrewery() = Brewery (
    id = id,
    name = name,
    description = description,
    isOrganic = isOrganic != "N",
    status = status,
    createDate = createDate,
    imageMedium = images?.medium
)