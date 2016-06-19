
package com.skillvo.android.model;


import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class VerifierInfo implements Parcelable {

    private String userId;
    private String firstName;
    private String lastName;
    private String email;


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.userId);
        dest.writeString(this.firstName);
        dest.writeString(this.lastName);
        dest.writeString(this.email);
    }

    public VerifierInfo() {
    }

    protected VerifierInfo(Parcel in) {
        this.userId = in.readString();
        this.firstName = in.readString();
        this.lastName = in.readString();
        this.email = in.readString();
    }

    public static final Creator<VerifierInfo> CREATOR = new Creator<VerifierInfo>() {
        @Override
        public VerifierInfo createFromParcel(Parcel source) {
            return new VerifierInfo(source);
        }

        @Override
        public VerifierInfo[] newArray(int size) {
            return new VerifierInfo[size];
        }
    };
}
