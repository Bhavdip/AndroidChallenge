
package com.skillvo.android.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MapLoc implements Parcelable {

    private String type;
    private List<Float> coordinates = new ArrayList<Float>();


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.type);
        dest.writeList(this.coordinates);
    }

    public MapLoc() {
    }

    protected MapLoc(Parcel in) {
        this.type = in.readString();
        this.coordinates = new ArrayList<Float>();
        in.readList(this.coordinates, Float.class.getClassLoader());
    }

    public static final Parcelable.Creator<MapLoc> CREATOR = new Parcelable.Creator<MapLoc>() {
        @Override
        public MapLoc createFromParcel(Parcel source) {
            return new MapLoc(source);
        }

        @Override
        public MapLoc[] newArray(int size) {
            return new MapLoc[size];
        }
    };
}
