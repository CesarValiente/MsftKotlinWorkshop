package com.microsoft.msftbreweryworkshop.api.model;

import com.squareup.moshi.Json;

public class Category {

    @Json(name = "id")
    private int id;

    @Json(name = "name")
    private String name;

    @Json(name = "createDate")
    private String createDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

}
