package com.microsoft.msftbreweryworkshop.api.model;

import com.squareup.moshi.Json;

public class Images {

    @Json(name = "icon")
    private String icon;

    @Json(name = "medium")
    private String medium;

    @Json(name = "large")
    private String large;

    @Json(name = "squareMedium")
    private String squareMedium;

    @Json(name = "squareLarge")
    private String squareLarge;

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    public String getLarge() {
        return large;
    }

    public void setLarge(String large) {
        this.large = large;
    }

    public String getSquareMedium() {
        return squareMedium;
    }

    public void setSquareMedium(String squareMedium) {
        this.squareMedium = squareMedium;
    }

    public String getSquareLarge() {
        return squareLarge;
    }

    public void setSquareLarge(String squareLarge) {
        this.squareLarge = squareLarge;
    }
}
