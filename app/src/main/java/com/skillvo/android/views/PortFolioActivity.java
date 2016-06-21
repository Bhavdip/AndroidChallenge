package com.skillvo.android.views;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;

import com.skillvo.android.R;
import com.skillvo.android.adapter.AdapterItemListener;
import com.skillvo.android.adapter.PortfolioPhotoAdapter;
import com.skillvo.android.databinding.PortfolioDataBinding;
import com.skillvo.android.model.PagedList;
import com.skillvo.android.model.Portfolio;
import com.skillvo.android.utils.DialogUtils;
import com.skillvo.android.viewmodel.PortFolioViewModel;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class PortFolioActivity extends AppCompatActivity implements PortFolioViewModel.PortfolioViewModelListener, AdapterItemListener<Portfolio> {

    private static final String TAG = "PortFolioActivity";
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
        leftSideRotation();
    }

    @Override
    public void onRightRotation() {
        rightSideRotation();
    }

    @Override
    public void onItemClickListener(Portfolio portfolio, int position) {
        if (portfolio != null) {
            int lastRotation = mPortfolioPhotoAdapter.getStateOfRotation();
            portfolioViewModel.bindPortfolioModel(portfolio, lastRotation);
        }
    }

    private void leftSideRotation() {
        int lastRotation = mPortfolioPhotoAdapter.getStateOfRotation();
        Log.d(TAG, String.format("LeftSideRotation : Last Left Rotation:%1d", lastRotation));
        int nwRotation = (lastRotation - 90);
        Log.d(TAG, String.format("LeftSideRotation : New Left Rotation:%1d", lastRotation));
        if (mPortfolioPhotoAdapter.getSelectedItem() != -1) {
            mPortfolioPhotoAdapter.updateSelectedItemDegrees(mPortfolioPhotoAdapter.getSelectedItem(), nwRotation);
            portfolioViewModel.updateOriginalImageDegree(nwRotation);
        }
    }

    private void rightSideRotation() {
        int lastRotation = mPortfolioPhotoAdapter.getStateOfRotation();
        Log.d(TAG, String.format("RightSideRotation : Last Right Rotation:%1d", lastRotation));
        int nwRotation = (lastRotation + 90);
        if (mPortfolioPhotoAdapter.getSelectedItem() != -1) {
            mPortfolioPhotoAdapter.updateSelectedItemDegrees(mPortfolioPhotoAdapter.getSelectedItem(), nwRotation);
            portfolioViewModel.updateOriginalImageDegree(nwRotation);
        }
    }

    public void onBackClick() {
        finish();
    }
}
