
package com.skillvo.android.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Portfolio implements Parcelable {

    private Integer position;
    private Boolean isPortfolioCover;
    private VerifierInfo verifierInfo;
    private VerifierShortProfile verifierShortProfile;
    private String verificationFirstRequestDate;
    private String verificationRequestDate;
    private String verificationStatusDate;
    private Integer verificationStatus;
    private Boolean isEmail;
    private Boolean canVerifierChange;
    private Integer remainingWaitHours;
    private Integer remainingWaitDays;
    private String completed;
    private String id;
    private String ownerId;
    private Owner owner;
    private Project project;
    private String projectId;
    private String title;
    private String description;
    private Address address;
    private String timeStamp;
    private String url;
    private Integer size;
    private Integer likesCount;
    private Integer viewsCount;
    private List<String> services = new ArrayList<String>();
    private String sharingUrl;

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public Boolean getPortfolioCover() {
        return isPortfolioCover;
    }

    public void setPortfolioCover(Boolean portfolioCover) {
        isPortfolioCover = portfolioCover;
    }

    public VerifierInfo getVerifierInfo() {
        return verifierInfo;
    }

    public void setVerifierInfo(VerifierInfo verifierInfo) {
        this.verifierInfo = verifierInfo;
    }

    public VerifierShortProfile getVerifierShortProfile() {
        return verifierShortProfile;
    }

    public void setVerifierShortProfile(VerifierShortProfile verifierShortProfile) {
        this.verifierShortProfile = verifierShortProfile;
    }

    public String getVerificationFirstRequestDate() {
        return verificationFirstRequestDate;
    }

    public void setVerificationFirstRequestDate(String verificationFirstRequestDate) {
        this.verificationFirstRequestDate = verificationFirstRequestDate;
    }

    public String getVerificationRequestDate() {
        return verificationRequestDate;
    }

    public void setVerificationRequestDate(String verificationRequestDate) {
        this.verificationRequestDate = verificationRequestDate;
    }

    public String getVerificationStatusDate() {
        return verificationStatusDate;
    }

    public void setVerificationStatusDate(String verificationStatusDate) {
        this.verificationStatusDate = verificationStatusDate;
    }

    public Integer getVerificationStatus() {
        return verificationStatus;
    }

    public void setVerificationStatus(Integer verificationStatus) {
        this.verificationStatus = verificationStatus;
    }

    public Boolean getEmail() {
        return isEmail;
    }

    public void setEmail(Boolean email) {
        isEmail = email;
    }

    public Boolean getCanVerifierChange() {
        return canVerifierChange;
    }

    public void setCanVerifierChange(Boolean canVerifierChange) {
        this.canVerifierChange = canVerifierChange;
    }

    public Integer getRemainingWaitHours() {
        return remainingWaitHours;
    }

    public void setRemainingWaitHours(Integer remainingWaitHours) {
        this.remainingWaitHours = remainingWaitHours;
    }

    public Integer getRemainingWaitDays() {
        return remainingWaitDays;
    }

    public void setRemainingWaitDays(Integer remainingWaitDays) {
        this.remainingWaitDays = remainingWaitDays;
    }

    public String getCompleted() {
        return completed;
    }

    public void setCompleted(String completed) {
        this.completed = completed;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getUrl() {
        return url;
    }


    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getLikesCount() {
        return likesCount;
    }

    public void setLikesCount(Integer likesCount) {
        this.likesCount = likesCount;
    }

    public Integer getViewsCount() {
        return viewsCount;
    }

    public void setViewsCount(Integer viewsCount) {
        this.viewsCount = viewsCount;
    }

    public List<String> getServices() {
        return services;
    }

    public void setServices(List<String> services) {
        this.services = services;
    }

    public String getSharingUrl() {
        return sharingUrl;
    }

    public void setSharingUrl(String sharingUrl) {
        this.sharingUrl = sharingUrl;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.position);
        dest.writeValue(this.isPortfolioCover);
        dest.writeParcelable(this.verifierInfo, flags);
        dest.writeParcelable(this.verifierShortProfile, flags);
        dest.writeString(this.verificationFirstRequestDate);
        dest.writeString(this.verificationRequestDate);
        dest.writeString(this.verificationStatusDate);
        dest.writeValue(this.verificationStatus);
        dest.writeValue(this.isEmail);
        dest.writeValue(this.canVerifierChange);
        dest.writeValue(this.remainingWaitHours);
        dest.writeValue(this.remainingWaitDays);
        dest.writeString(this.completed);
        dest.writeString(this.id);
        dest.writeString(this.ownerId);
        dest.writeParcelable(this.owner, flags);
        dest.writeParcelable(this.project, flags);
        dest.writeString(this.projectId);
        dest.writeString(this.title);
        dest.writeString(this.description);
        dest.writeParcelable(this.address, flags);
        dest.writeString(this.timeStamp);
        dest.writeString(this.url);
        dest.writeValue(this.size);
        dest.writeValue(this.likesCount);
        dest.writeValue(this.viewsCount);
        dest.writeStringList(this.services);
        dest.writeString(this.sharingUrl);
    }

    public Portfolio() {
    }

    protected Portfolio(Parcel in) {
        this.position = (Integer) in.readValue(Integer.class.getClassLoader());
        this.isPortfolioCover = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.verifierInfo = in.readParcelable(VerifierInfo.class.getClassLoader());
        this.verifierShortProfile = in.readParcelable(VerifierShortProfile.class.getClassLoader());
        this.verificationFirstRequestDate = in.readString();
        this.verificationRequestDate = in.readString();
        this.verificationStatusDate = in.readString();
        this.verificationStatus = (Integer) in.readValue(Integer.class.getClassLoader());
        this.isEmail = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.canVerifierChange = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.remainingWaitHours = (Integer) in.readValue(Integer.class.getClassLoader());
        this.remainingWaitDays = (Integer) in.readValue(Integer.class.getClassLoader());
        this.completed = in.readString();
        this.id = in.readString();
        this.ownerId = in.readString();
        this.owner = in.readParcelable(Owner.class.getClassLoader());
        this.project = in.readParcelable(Project.class.getClassLoader());
        this.projectId = in.readString();
        this.title = in.readString();
        this.description = in.readString();
        this.address = in.readParcelable(Address.class.getClassLoader());
        this.timeStamp = in.readString();
        this.url = in.readString();
        this.size = (Integer) in.readValue(Integer.class.getClassLoader());
        this.likesCount = (Integer) in.readValue(Integer.class.getClassLoader());
        this.viewsCount = (Integer) in.readValue(Integer.class.getClassLoader());
        this.services = in.createStringArrayList();
        this.sharingUrl = in.readString();
    }

    public static final Parcelable.Creator<Portfolio> CREATOR = new Parcelable.Creator<Portfolio>() {
        @Override
        public Portfolio createFromParcel(Parcel source) {
            return new Portfolio(source);
        }

        @Override
        public Portfolio[] newArray(int size) {
            return new Portfolio[size];
        }
    };
}
