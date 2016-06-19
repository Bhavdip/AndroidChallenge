package com.skillvo.android.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class VerifierShortProfile implements Parcelable {

    private String id;
    private Integer userId;
    private String uniqueUrl;
    private String emailAddress;
    private String pictureUrl;
    private Boolean isProvider;
    private String firstName;
    private String lastName;
    private String businessName;
    private Boolean useBusinessNameForProfile;
    private String displayName;
    private Integer totalReviews;
    private Integer totalReviewsWritten;
    private Integer totalVerifications;
    private String keyword;
    private String description;
    private Address address;
    private Integer totalFollowers;
    private Integer totalFollowing;
    private Boolean isFollowing;
    private List<Phone> phones = new ArrayList<>();
    private List<RatingDetailsAverage> ratingDetailsAverage = new ArrayList<>();
    private String sharingUrl;
    private String aliasUrl;
    private String portfolioSharingUrl;


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeValue(this.userId);
        dest.writeString(this.uniqueUrl);
        dest.writeString(this.emailAddress);
        dest.writeString(this.pictureUrl);
        dest.writeValue(this.isProvider);
        dest.writeString(this.firstName);
        dest.writeString(this.lastName);
        dest.writeString(this.businessName);
        dest.writeValue(this.useBusinessNameForProfile);
        dest.writeString(this.displayName);
        dest.writeValue(this.totalReviews);
        dest.writeValue(this.totalReviewsWritten);
        dest.writeValue(this.totalVerifications);
        dest.writeString(this.keyword);
        dest.writeString(this.description);
        dest.writeParcelable(this.address, flags);
        dest.writeValue(this.totalFollowers);
        dest.writeValue(this.totalFollowing);
        dest.writeValue(this.isFollowing);
        dest.writeTypedList(this.phones);
        dest.writeTypedList(this.ratingDetailsAverage);
        dest.writeString(this.sharingUrl);
        dest.writeString(this.aliasUrl);
        dest.writeString(this.portfolioSharingUrl);
    }

    public VerifierShortProfile() {
    }

    protected VerifierShortProfile(Parcel in) {
        this.id = in.readString();
        this.userId = (Integer) in.readValue(Integer.class.getClassLoader());
        this.uniqueUrl = in.readString();
        this.emailAddress = in.readString();
        this.pictureUrl = in.readString();
        this.isProvider = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.firstName = in.readString();
        this.lastName = in.readString();
        this.businessName = in.readString();
        this.useBusinessNameForProfile = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.displayName = in.readString();
        this.totalReviews = (Integer) in.readValue(Integer.class.getClassLoader());
        this.totalReviewsWritten = (Integer) in.readValue(Integer.class.getClassLoader());
        this.totalVerifications = (Integer) in.readValue(Integer.class.getClassLoader());
        this.keyword = in.readString();
        this.description = in.readString();
        this.address = in.readParcelable(Address.class.getClassLoader());
        this.totalFollowers = (Integer) in.readValue(Integer.class.getClassLoader());
        this.totalFollowing = (Integer) in.readValue(Integer.class.getClassLoader());
        this.isFollowing = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.phones = in.createTypedArrayList(Phone.CREATOR);
        this.ratingDetailsAverage = in.createTypedArrayList(RatingDetailsAverage.CREATOR);
        this.sharingUrl = in.readString();
        this.aliasUrl = in.readString();
        this.portfolioSharingUrl = in.readString();
    }

    public static final Parcelable.Creator<VerifierShortProfile> CREATOR = new Parcelable.Creator<VerifierShortProfile>() {
        @Override
        public VerifierShortProfile createFromParcel(Parcel source) {
            return new VerifierShortProfile(source);
        }

        @Override
        public VerifierShortProfile[] newArray(int size) {
            return new VerifierShortProfile[size];
        }
    };
}
