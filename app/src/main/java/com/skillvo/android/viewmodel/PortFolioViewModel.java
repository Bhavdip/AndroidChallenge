package com.skillvo.android.viewmodel;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.view.View;

import com.skillvo.android.model.PagedList;
import com.skillvo.android.model.Portfolio;
import com.skillvo.android.utils.DialogUtils;

public class PortFolioViewModel implements ActivityViewModel {

    private PortfolioViewModelListener mViewModelListener;
    public ObservableField<String> projectTitle = new ObservableField<>();
    public ObservableField<String> portfolioPhotoUrl = new ObservableField<>();
    public ObservableInt portfolioPhotoDegrees = new ObservableInt();
    private PagedList mPagedDataModel;
    private Context mActivityContext;

    public interface PortfolioViewModelListener {
        void extractIntentData();

        void setUpHorizontalRecyclerView();

        void onLeftRotation();

        void onRightRotation();

        void onBackClick();
    }

    public PortFolioViewModel(PortfolioViewModelListener modelListener) {
        this.mViewModelListener = modelListener;

    }

    public void bindPagedDataModel(PagedList pagedDataModel) {
        this.mPagedDataModel = pagedDataModel;
        projectTitle.set(mPagedDataModel.getTitle());
        if(mPagedDataModel.getPortfolio().size() > 0){
            //load the default portfolio image
            bindPortfolioModel(mPagedDataModel.getPortfolio().get(0),0);
        }
    }

    public void bindPortfolioModel(Portfolio portfolioModel, int lastRotation) {
        if (portfolioModel != null) {
            portfolioPhotoUrl.set(portfolioModel.getUrl());
            portfolioPhotoDegrees.set(lastRotation);
        }
    }

    public void updateOriginalImageDegree(int nwRotation){
        portfolioPhotoDegrees.set(nwRotation);

    }

    @Override
    public void onCreate(Activity activity) {
        this.mActivityContext = activity;
        mViewModelListener.extractIntentData();
        mViewModelListener.setUpHorizontalRecyclerView();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

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

    public void onRotateLeftClick(View view) {
        mViewModelListener.onLeftRotation();
    }

    public void onRotateRightClick(View view) {
        mViewModelListener.onRightRotation();
    }

    public void onCropClick(View view) {
        DialogUtils.showToast(mActivityContext, "On Crop");
    }

    public void onSetThumbnail(View view) {
        DialogUtils.showToast(mActivityContext, "Set Thumbnail");
    }

    public void onMoreOption(View view) {
        DialogUtils.showToast(mActivityContext, "More option");
    }

    public void onAddMorePhotos(View view) {
        DialogUtils.showToast(mActivityContext, "Add More Photos");
    }

    public void onBackClick(View view){
        mViewModelListener.onBackClick();
    }
}
