package com.microsoft.msftbreweryworkshop.api.model;

import com.squareup.moshi.Json;

public class Style {

    @Json(name = "id")
    private int id;

    @Json(name = "categoryId")
    private int categoryId;

    @Json(name = "category")
    private Category category;

    @Json(name = "name")
    private String name;

    @Json(name = "shortName")
    private String shortName;

    @Json(name = "description")
    private String description;

    @Json(name = "createDate")
    private String createDate;

    @Json(name = "updateDate")
    private String updateDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
}
