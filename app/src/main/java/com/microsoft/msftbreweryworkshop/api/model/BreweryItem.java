package com.microsoft.msftbreweryworkshop.api.model;


import com.squareup.moshi.Json;

public class BreweryItem {

    @Json(name = "id")
    private String id;

    @Json(name = "name")
    private String name;

    @Json(name = "nameShortDisplay")
    private String nameShortDisplay;

    @Json(name = "description")
    private String description;

    @Json(name = "website")
    private String website;

    @Json(name = "abv")
    private String abv;

    @Json(name = "ibu")
    private String ibu;

    @Json(name = "styleId")
    private int styleId;

    @Json(name = "isOrganic")
    private String isOrganic;

    @Json(name = "images")
    private Images images;

    @Json(name = "status")
    private String status;

    @Json(name = "statusDisplay")
    private String statusDisplay;

    @Json(name = "createDate")
    private String createDate;

    @Json(name = "updateDate")
    private String updateDate;

    @Json(name = "style")
    private Style style;

    @Json(name = "established")
    private String established;

    @Json(name = "isInBusiness")
    private String isInBusiness;

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

    public String getNameShortDisplay() {
        return nameShortDisplay;
    }

    public void setNameShortDisplay(String nameShortDisplay) {
        this.nameShortDisplay = nameShortDisplay;
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

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getEstablished() {
        return established;
    }

    public void setEstablished(String established) {
        this.established = established;
    }

    public Images getImages() {
        return images;
    }

    public void setImages(Images images) {
        this.images = images;
    }

    public String getIsInBusiness() {
        return isInBusiness;
    }

    public void setIsInBusiness(String established) {
        this.isInBusiness = isInBusiness;
    }
}