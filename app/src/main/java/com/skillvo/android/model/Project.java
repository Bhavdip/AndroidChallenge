
package com.skillvo.android.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Project implements Parcelable {

    private String id;
    private String title;
    private String description;
    private List<String> services = new ArrayList<String>();
    private String status;
    private String started;
    private String completed;
    private Address address;
    private String consumer;
    private String provider;
    private Boolean isVerified;
    private String verifiedDate;
    private String uniqueUrl;
    private String sharingUrl;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.title);
        dest.writeString(this.description);
        dest.writeStringList(this.services);
        dest.writeString(this.status);
        dest.writeString(this.started);
        dest.writeString(this.completed);
        dest.writeParcelable(this.address, flags);
        dest.writeString(this.consumer);
        dest.writeString(this.provider);
        dest.writeValue(this.isVerified);
        dest.writeString(this.verifiedDate);
        dest.writeString(this.uniqueUrl);
        dest.writeString(this.sharingUrl);
    }

    public Project() {
    }

    protected Project(Parcel in) {
        this.id = in.readString();
        this.title = in.readString();
        this.description = in.readString();
        this.services = in.createStringArrayList();
        this.status = in.readString();
        this.started = in.readString();
        this.completed = in.readString();
        this.address = in.readParcelable(Address.class.getClassLoader());
        this.consumer = in.readString();
        this.provider = in.readString();
        this.isVerified = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.verifiedDate = in.readString();
        this.uniqueUrl = in.readString();
        this.sharingUrl = in.readString();
    }

    public static final Parcelable.Creator<Project> CREATOR = new Parcelable.Creator<Project>() {
        @Override
        public Project createFromParcel(Parcel source) {
            return new Project(source);
        }

        @Override
        public Project[] newArray(int size) {
            return new Project[size];
        }
    };
}
