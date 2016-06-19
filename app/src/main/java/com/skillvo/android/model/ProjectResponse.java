
package com.skillvo.android.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProjectResponse implements Parcelable {

    private List<PagedList> pagedList = new ArrayList<>();
    private Integer totalResults;

    public List<PagedList> getPagedList() {
        return pagedList;
    }

    public void setPagedList(List<PagedList> pagedList) {
        this.pagedList = pagedList;
    }

    public Integer getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(this.pagedList);
        dest.writeValue(this.totalResults);
    }

    public ProjectResponse() {
    }

    protected ProjectResponse(Parcel in) {
        this.pagedList = new ArrayList<>();
        in.readList(this.pagedList, PagedList.class.getClassLoader());
        this.totalResults = (Integer) in.readValue(Integer.class.getClassLoader());
    }

    public static final Parcelable.Creator<ProjectResponse> CREATOR = new Parcelable.Creator<ProjectResponse>() {
        @Override
        public ProjectResponse createFromParcel(Parcel source) {
            return new ProjectResponse(source);
        }

        @Override
        public ProjectResponse[] newArray(int size) {
            return new ProjectResponse[size];
        }
    };
}
