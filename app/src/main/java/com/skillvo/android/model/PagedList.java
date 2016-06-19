
package com.skillvo.android.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PagedList implements Parcelable {

    private String id;
    private String title;
    private String description;
    private List<String> services = new ArrayList<>();
    private String status;
    private String started;
    private String completed;
    private Address address;
    private String consumer;
    private String provider;
    private ShortProvider shortProvider;
    private Boolean isVerified;
    private String verifiedDate;
    private String uniqueUrl;
    private List<Portfolio> portfolio = new ArrayList<>();
    private String sharingUrl;
    private Integer position;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public List<String> getServices() {
        return services;
    }

    public void setServices(List<String> services) {
        this.services = services;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStarted() {
        return started;
    }

    public void setStarted(String started) {
        this.started = started;
    }

    public String getCompleted() {
        return completed;
    }

    public void setCompleted(String completed) {
        this.completed = completed;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getConsumer() {
        return consumer;
    }

    public void setConsumer(String consumer) {
        this.consumer = consumer;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public ShortProvider getShortProvider() {
        return shortProvider;
    }

    public void setShortProvider(ShortProvider shortProvider) {
        this.shortProvider = shortProvider;
    }

    public Boolean getVerified() {
        return isVerified;
    }

    public void setVerified(Boolean verified) {
        isVerified = verified;
    }

    public String getVerifiedDate() {
        return verifiedDate;
    }

    public void setVerifiedDate(String verifiedDate) {
        this.verifiedDate = verifiedDate;
    }

    public String getUniqueUrl() {
        return uniqueUrl;
    }

    public void setUniqueUrl(String uniqueUrl) {
        this.uniqueUrl = uniqueUrl;
    }

    public List<Portfolio> getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(List<Portfolio> portfolio) {
        this.portfolio = portfolio;
    }

    public String getSharingUrl() {
        return sharingUrl;
    }

    public void setSharingUrl(String sharingUrl) {
        this.sharingUrl = sharingUrl;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

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
        dest.writeParcelable(this.shortProvider, flags);
        dest.writeValue(this.isVerified);
        dest.writeString(this.verifiedDate);
        dest.writeString(this.uniqueUrl);
        dest.writeList(this.portfolio);
        dest.writeString(this.sharingUrl);
        dest.writeValue(this.position);
    }

    public PagedList() {
    }

    protected PagedList(Parcel in) {
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
        this.shortProvider = in.readParcelable(ShortProvider.class.getClassLoader());
        this.isVerified = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.verifiedDate = in.readString();
        this.uniqueUrl = in.readString();
        this.portfolio = new ArrayList<Portfolio>();
        in.readList(this.portfolio, Portfolio.class.getClassLoader());
        this.sharingUrl = in.readString();
        this.position = (Integer) in.readValue(Integer.class.getClassLoader());
    }

    public static final Parcelable.Creator<PagedList> CREATOR = new Parcelable.Creator<PagedList>() {
        @Override
        public PagedList createFromParcel(Parcel source) {
            return new PagedList(source);
        }

        @Override
        public PagedList[] newArray(int size) {
            return new PagedList[size];
        }
    };
}
