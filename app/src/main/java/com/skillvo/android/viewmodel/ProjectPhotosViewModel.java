package com.skillvo.android.viewmodel;

import android.app.Activity;
import android.content.Intent;
import android.database.Observable;
import android.databinding.ObservableField;
import android.view.View;

import com.skillvo.android.model.PagedList;
import com.skillvo.android.model.ProjectResponse;
import com.skillvo.android.rest.RestClient;
import com.skillvo.android.views.PortFolioActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProjectPhotosViewModel implements ActivityViewModel {

    public interface ProjectPhotosViewModelInterface {
        void setUpProjectRecyclerView();

        void onLoadProjectsList(List<PagedList> projectList);

        void failToLoadProjectList(String failMessage);

        void resetProjectList();
    }

    private ProjectPhotosViewModelInterface modelInterface;
    public ObservableField<Integer> visibilityProgressBar = new ObservableField<>();

    public ProjectPhotosViewModel(ProjectPhotosViewModelInterface modelInterface) {
        this.modelInterface = modelInterface;
        visibilityProgressBar.set(View.GONE);
    }

    @Override
    public void onCreate(Activity activity) {
        modelInterface.setUpProjectRecyclerView();
        loadProjectList();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == PortFolioActivity.REQUEST_CODE) {
            //modelInterface.resetProjectList();
        }
    }

    @Override
    public void onResumeActivity(Activity activity) {

    }

    @Override
    public void onPauseActivity(Activity activity) {

    }

    @Override
    public void onBackPressed(Activity activity) {

    }

    @Override
    public void onDestroy() {
    }

    private void loadProjectList() {
        visibilityProgressBar.set(View.VISIBLE);
        Call<ProjectResponse> requestForProjectList = RestClient.getProjectAPI().getProjectList();
        requestForProjectList.enqueue(new Callback<ProjectResponse>() {
            @Override
            public void onResponse(Call<ProjectResponse> call, Response<ProjectResponse> response) {
                if (response != null && response.body() != null) {
                    if (modelInterface != null) {
                        modelInterface.onLoadProjectsList(response.body().getPagedList());
                    }
                } else {
                    if (modelInterface != null) {
                        modelInterface.failToLoadProjectList("");
                    }
                }
                visibilityProgressBar.set(View.GONE);
            }

            @Override
            public void onFailure(Call<ProjectResponse> call, Throwable t) {
                visibilityProgressBar.set(View.GONE);
                if (modelInterface != null) {
                    modelInterface.failToLoadProjectList(t.getMessage());
                }
            }
        });
    }
}
