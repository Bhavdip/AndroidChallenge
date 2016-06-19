package com.skillvo.android.views;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.ImageView;

import com.skillvo.android.R;
import com.skillvo.android.adapter.AdapterItemListener;
import com.skillvo.android.adapter.PortfolioPhotoAdapter;
import com.skillvo.android.databinding.PortfolioDataBinding;
import com.skillvo.android.model.PagedList;
import com.skillvo.android.model.Portfolio;
import com.skillvo.android.utils.DialogUtils;
import com.skillvo.android.utils.RotationUtils;
import com.skillvo.android.viewmodel.PortFolioViewModel;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class PortFolioActivity extends AppCompatActivity implements PortFolioViewModel.PortfolioViewModelListener, AdapterItemListener<Portfolio> {

    public static final int REQUEST_CODE = 121;
    private static final String KEY_DATA_MODEL = "project_model";
    private PortfolioDataBinding portfolioDataBinding;
    private PortFolioViewModel portfolioViewModel;
    private PagedList mPagedDataModel;
    private PortfolioPhotoAdapter mPortfolioPhotoAdapter;

    public static void startPortFolioActivity(Activity activity, PagedList dataModel) {
        Intent portFolioIntent = new Intent(activity, PortFolioActivity.class);
        portFolioIntent.putExtra(KEY_DATA_MODEL, dataModel);
        activity.startActivityForResult(portFolioIntent, REQUEST_CODE);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        portfolioDataBinding = DataBindingUtil.setContentView(PortFolioActivity.this, R.layout.activity_portfolio);
        portfolioViewModel = new PortFolioViewModel(this);
        portfolioDataBinding.setViewmodel(portfolioViewModel);
        portfolioViewModel.onCreate(this);
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    protected void onResume() {
        super.onResume();
        portfolioViewModel.onResumeActivity(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        portfolioViewModel.onPauseActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        portfolioViewModel.onDestroy();
    }

    @Override
    public void extractIntentData() {
        if (getIntent().hasExtra(KEY_DATA_MODEL)) {
            mPagedDataModel = getIntent().getParcelableExtra(KEY_DATA_MODEL);
            portfolioViewModel.bindPagedDataModel(mPagedDataModel);
            DialogUtils.showToast(getApplicationContext(), "Portfolio Object Found");
        }
    }

    @Override
    public void setUpHorizontalRecyclerView() {
        portfolioDataBinding.portfolioPhotos.setLayoutManager(new LinearLayoutManager(PortFolioActivity.this, LinearLayoutManager.HORIZONTAL, false));
        portfolioDataBinding.portfolioPhotos.setHasFixedSize(true);
        mPortfolioPhotoAdapter = new PortfolioPhotoAdapter(this);
        portfolioDataBinding.portfolioPhotos.setAdapter(mPortfolioPhotoAdapter);
        mPortfolioPhotoAdapter.addPortfolioDataSet(mPagedDataModel.getPortfolio());
    }

    @Override
    public void onLeftRotation() {
        portfolioDataBinding.rotatedImageView.setDrawingCacheEnabled(true);
        Bitmap bitmap = portfolioDataBinding.rotatedImageView.getDrawingCache();
        portfolioDataBinding.rotatedImageView.setImageBitmap(RotationUtils.rotateBitmap(bitmap, 90));
        portfolioDataBinding.rotatedImageView.setDrawingCacheEnabled(false);
        if(mPortfolioPhotoAdapter.getmSelectedItem() != -1){
            mPortfolioPhotoAdapter.updateSelectedItemRoatation(mPortfolioPhotoAdapter.getmSelectedItem(),90);
        }
    }

    @Override
    public void onRightRotation() {
        portfolioDataBinding.rotatedImageView.setDrawingCacheEnabled(true);
        Bitmap bitmap = portfolioDataBinding.rotatedImageView.getDrawingCache();
        portfolioDataBinding.rotatedImageView.setImageBitmap(RotationUtils.rotateBitmap(bitmap, 90));
        portfolioDataBinding.rotatedImageView.setDrawingCacheEnabled(false);
        if(mPortfolioPhotoAdapter.getmSelectedItem() != -1){
            mPortfolioPhotoAdapter.updateSelectedItemRoatation(mPortfolioPhotoAdapter.getmSelectedItem(),90);
        }
    }


    @Override
    public void onItemClickListener(Portfolio portfolio, int position) {
        if (portfolio != null) {
            portfolioViewModel.bindPorfolioModel(portfolio);
        }
    }
}
