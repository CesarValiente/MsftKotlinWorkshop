package com.microsoft.msftbreweryworkshop.api.model;


import android.os.Parcel;
import android.os.Parcelable;

public class Labels implements Parcelable {
    private String medium;
    private String large;
    private String icon;

    protected Labels(Parcel in) {
        medium = in.readString();
        large = in.readString();
        icon = in.readString();
    }

    public static final Creator<Labels> CREATOR = new Creator<Labels>() {
        @Override
        public Labels createFromParcel(Parcel in) {
            return new Labels(in);
        }

        @Override
        public Labels[] newArray(int size) {
            return new Labels[size];
        }
    };

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

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(medium);
        dest.writeString(large);
        dest.writeString(icon);
    }
}
