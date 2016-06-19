package com.skillvo.android.adapter;

import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.skillvo.android.R;
import com.skillvo.android.databinding.ItemPhotoBinding;
import com.skillvo.android.model.Portfolio;
import com.skillvo.android.utils.RotationUtils;
import com.skillvo.android.viewmodel.PhotoItemViewModel;

import java.util.ArrayList;
import java.util.List;

public class PortfolioPhotoAdapter extends RecyclerView.Adapter<PortfolioPhotoAdapter.PhotoViewHolder> {

    private List<Portfolio> mPortfolioList = new ArrayList<>();
    private AdapterItemListener<Portfolio> adapterItemListener;
    private int mSelectedItem = -1;
    private SparseIntArray mSparseIntArray;

    public PortfolioPhotoAdapter(AdapterItemListener<Portfolio> adapterItemListener) {
        this.adapterItemListener = adapterItemListener;
    }

    public void addPortfolioDataSet(List<Portfolio> portfolioList) {
        if (mPortfolioList.size() > 0) {
            this.mPortfolioList.clear();
        }
        this.mPortfolioList.addAll(portfolioList);
        mSparseIntArray = new SparseIntArray(portfolioList.size());
    }

    public int getmSelectedItem() {
        return mSelectedItem;
    }

    public void updateSelectedItemRoatation(int key, int value) {
        mSparseIntArray.put(key, value);
        notifyItemChanged(key);
    }

    @Override
    public PhotoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemPhotoBinding photoBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.row_portfolio_photo, parent, false);
        return new PhotoViewHolder(photoBinding);
    }

    @Override
    public void onBindViewHolder(PhotoViewHolder holder, int position) {
        holder.onBindPhotoView(position, mPortfolioList.get(position));
    }

    @Override
    public int getItemCount() {
        return mPortfolioList.size();
    }

    public class PhotoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ItemPhotoBinding mItemPhotoBinding;

        public PhotoViewHolder(ItemPhotoBinding itemPhotoBinding) {
            super(itemPhotoBinding.getRoot());
            this.mItemPhotoBinding = itemPhotoBinding;
            this.mItemPhotoBinding.getRoot().setOnClickListener(this);
        }

        public void onBindPhotoView(int position, Portfolio portfolio) {
            mItemPhotoBinding.setViewmodel(new PhotoItemViewModel(mSelectedItem == position, portfolio));
            //this will apply the frame board to the select image view
            mItemPhotoBinding.portfolioPhotosFrame.setSelected(position == mSelectedItem);
            int anglePosition = mSparseIntArray.get(position);
            if (mItemPhotoBinding.imageViewThumbnail != null && mItemPhotoBinding.imageViewThumbnail.getWidth() > 0) {
                mItemPhotoBinding.imageViewThumbnail.setDrawingCacheEnabled(true);
                Bitmap bitmap = mItemPhotoBinding.imageViewThumbnail.getDrawingCache();
                mItemPhotoBinding.imageViewThumbnail.setImageBitmap(RotationUtils.rotateBitmap(bitmap, anglePosition));
                mItemPhotoBinding.imageViewThumbnail.setDrawingCacheEnabled(false);
            }
        }

        @Override
        public void onClick(View v) {
            mSelectedItem = getAdapterPosition();
            notifyItemRangeChanged(0, mPortfolioList.size());
            adapterItemListener.onItemClickListener(mPortfolioList.get(mSelectedItem), mSelectedItem);
        }
    }
}
