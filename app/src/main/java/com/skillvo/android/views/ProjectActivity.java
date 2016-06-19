package com.skillvo.android.views;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.text.TextUtils;

import com.skillvo.android.R;
import com.skillvo.android.adapter.AdapterItemListener;
import com.skillvo.android.adapter.ProjectListAdapter;
import com.skillvo.android.databinding.ProjectsDataBinding;
import com.skillvo.android.model.PagedList;
import com.skillvo.android.utils.DialogUtils;
import com.skillvo.android.viewmodel.ProjectPhotosViewModel;

import java.util.List;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class ProjectActivity extends AppCompatActivity implements ProjectPhotosViewModel.ProjectPhotosViewModelInterface, AdapterItemListener<PagedList> {

    private ProjectsDataBinding mProjectBinding;
    private ProjectPhotosViewModel mViewModel;
    private ProjectListAdapter mProjectListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //call data binding
        mProjectBinding = DataBindingUtil.setContentView(ProjectActivity.this, R.layout.activity_project);
        // activity view model
        mViewModel = new ProjectPhotosViewModel(this);
        //pass the view mode instance to data binding
        mProjectBinding.setViewmodel(mViewModel);
        //start create of view model
        mViewModel.onCreate(this);
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    protected void onResume() {
        super.onResume();
        mViewModel.onResumeActivity(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mViewModel.onPauseActivity(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mViewModel.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onDestroy() {
        mViewModel.onDestroy();
        super.onDestroy();
    }


    @Override
    public void setUpProjectRecyclerView() {
        mProjectBinding.projectList.setLayoutManager(new LinearLayoutManager(ProjectActivity.this));
        mProjectListAdapter = new ProjectListAdapter();
        mProjectListAdapter.registerAdapterItemCallback(this);
        mProjectBinding.projectList.setAdapter(mProjectListAdapter);
    }

    @Override
    public void onLoadProjectsList(List<PagedList> projectList) {
        mProjectListAdapter.addPagedList(projectList);
        mProjectListAdapter.notifyDataSetChanged();
    }

    @Override
    public void failToLoadProjectList(String failMessage) {
        if (!TextUtils.isEmpty(failMessage)) {
            DialogUtils.showToast(ProjectActivity.this, failMessage);
        }
    }

    @Override
    public void resetProjectList() {
        mProjectListAdapter.resetSelectedItem();
        mProjectListAdapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClickListener(PagedList pagedData, int position) {
        //we start the Portfolio activity getting the data from adapter
        if (pagedData != null) {
            PortFolioActivity.startPortFolioActivity(this, pagedData);
        }
    }
}
