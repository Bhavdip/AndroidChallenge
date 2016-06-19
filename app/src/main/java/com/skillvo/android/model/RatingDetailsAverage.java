
package com.skillvo.android.model;


import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RatingDetailsAverage implements Parcelable {

    private String criteria;
    private Integer rating;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.criteria);
        dest.writeValue(this.rating);
    }

    public RatingDetailsAverage() {
    }

    protected RatingDetailsAverage(Parcel in) {
        this.criteria = in.readString();
        this.rating = (Integer) in.readValue(Integer.class.getClassLoader());
    }

    public static final Parcelable.Creator<RatingDetailsAverage> CREATOR = new Parcelable.Creator<RatingDetailsAverage>() {
        @Override
        public RatingDetailsAverage createFromParcel(Parcel source) {
            return new RatingDetailsAverage(source);
        }

        @Override
        public RatingDetailsAverage[] newArray(int size) {
            return new RatingDetailsAverage[size];
        }
    };
}
