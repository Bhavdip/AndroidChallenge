
package com.skillvo.android.model;


import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Phone implements Parcelable {

    private String number;
    private String extension;
    private Boolean isPrimary;
    private String type;


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.number);
        dest.writeString(this.extension);
        dest.writeValue(this.isPrimary);
        dest.writeString(this.type);
    }

    public Phone() {
    }

    protected Phone(Parcel in) {
        this.number = in.readString();
        this.extension = in.readString();
        this.isPrimary = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.type = in.readString();
    }

    public static final Parcelable.Creator<Phone> CREATOR = new Parcelable.Creator<Phone>() {
        @Override
        public Phone createFromParcel(Parcel source) {
            return new Phone(source);
        }

        @Override
        public Phone[] newArray(int size) {
            return new Phone[size];
        }
    };
}
