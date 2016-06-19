
package com.skillvo.android.model;


import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Address implements Parcelable {

    private String streetAddress1;
    private String streetAddress2;
    private String city;
    private String state;
    private String zip;
    private String country;
    private Boolean displayFullAddress;
    private MapLoc mapLoc;
    private Float latitude;
    private Float longitude;

    public String getStreetAddress1() {
        return streetAddress1;
    }

    public void setStreetAddress1(String streetAddress1) {
        this.streetAddress1 = streetAddress1;
    }

    public String getStreetAddress2() {
        return streetAddress2;
    }

    public void setStreetAddress2(String streetAddress2) {
        this.streetAddress2 = streetAddress2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Boolean getDisplayFullAddress() {
        return displayFullAddress;
    }

    public void setDisplayFullAddress(Boolean displayFullAddress) {
        this.displayFullAddress = displayFullAddress;
    }

    public MapLoc getMapLoc() {
        return mapLoc;
    }

    public void setMapLoc(MapLoc mapLoc) {
        this.mapLoc = mapLoc;
    }

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.streetAddress1);
        dest.writeString(this.streetAddress2);
        dest.writeString(this.city);
        dest.writeString(this.state);
        dest.writeString(this.zip);
        dest.writeString(this.country);
        dest.writeValue(this.displayFullAddress);
        dest.writeParcelable(this.mapLoc, flags);
        dest.writeValue(this.latitude);
        dest.writeValue(this.longitude);
    }

    public Address() {
    }

    protected Address(Parcel in) {
        this.streetAddress1 = in.readString();
        this.streetAddress2 = in.readString();
        this.city = in.readString();
        this.state = in.readString();
        this.zip = in.readString();
        this.country = in.readString();
        this.displayFullAddress = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.mapLoc = in.readParcelable(MapLoc.class.getClassLoader());
        this.latitude = (Float) in.readValue(Float.class.getClassLoader());
        this.longitude = (Float) in.readValue(Float.class.getClassLoader());
    }

    public static final Parcelable.Creator<Address> CREATOR = new Parcelable.Creator<Address>() {
        @Override
        public Address createFromParcel(Parcel source) {
            return new Address(source);
        }

        @Override
        public Address[] newArray(int size) {
            return new Address[size];
        }
    };
}
