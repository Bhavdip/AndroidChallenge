package com.skillvo.android.rest.services;

import com.skillvo.android.model.ProjectResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ProjectAPI {
    @GET("sampledata?format=json")
    Call<ProjectResponse> getProjectList();
}
