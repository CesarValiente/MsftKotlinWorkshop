package com.microsoft.msftbreweryworkshop.api.model;

import com.squareup.moshi.Json;

public class BeerDetail {
    @Json(name ="id")
    private String id;

    @Json(name ="name")
    private String name;

    @Json(name ="nameDisplay")
    private String nameDisplay;

    @Json(name ="description")
    private String description;

    @Json(name ="abv")
    private String abv;

    @Json(name ="ibu")
    private String ibu;

    @Json(name ="styleId")
    private int styleId;

    @Json(name ="isOrganic")
    private String isOrganic;

    @Json(name ="status")
    private String status;

    @Json(name = "foodPairings")
    private String foodPairings;

    @Json(name ="statusDisplay")
    private String statusDisplay;

    @Json(name ="createDate")
    private String createDate;

    @Json(name ="updateDate")
    private String updateDate;

    @Json(name ="style")
    private Style style;

    @Json(name ="labels")
    private Images labels;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameDisplay() {
        return nameDisplay;
    }

    public void setNameDisplay(String nameDisplay) {
        this.nameDisplay = nameDisplay;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAbv() {
        return abv;
    }

    public void setAbv(String abv) {
        this.abv = abv;
    }

    public String getIbu() {
        return ibu;
    }

    public void setIbu(String ibu) {
        this.ibu = ibu;
    }

    public int getStyleId() {
        return styleId;
    }

    public void setStyleId(int styleId) {
        this.styleId = styleId;
    }

    public String getIsOrganic() {
        return isOrganic;
    }

    public void setIsOrganic(String isOrganic) {
        this.isOrganic = isOrganic;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusDisplay() {
        return statusDisplay;
    }

    public void setStatusDisplay(String statusDisplay) {
        this.statusDisplay = statusDisplay;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public Style getStyle() {
        return style;
    }

    public void setStyle(Style style) {
        this.style = style;
    }

    public Images getLabels() {
        return labels;
    }

    public void setLabels(Images labels) {
        this.labels = labels;
    }

    public String getFoodPairings() {
        return foodPairings;
    }

    public void setFoodPairings(String foodPairings) {
        this.foodPairings = foodPairings;
    }
}
