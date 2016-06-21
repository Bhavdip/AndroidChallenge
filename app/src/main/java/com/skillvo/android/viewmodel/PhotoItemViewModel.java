package com.skillvo.android.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.BindingAdapter;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.text.TextUtils;
import android.widget.ImageView;

import com.skillvo.android.model.Portfolio;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import java.net.URL;

public class PhotoItemViewModel extends BaseObservable {

    private Portfolio mPortfolioModel;
    private boolean isActivated;
    public ObservableField<String> photoUrl = new ObservableField<>();
    public ObservableInt photoDegrees = new ObservableInt();

    public PhotoItemViewModel(Portfolio portfolioModel, boolean isSelected, int degrees) {
        this.mPortfolioModel = portfolioModel;
        this.isActivated = isSelected;
        if (!TextUtils.isEmpty(this.mPortfolioModel.getUrl())) {
            String nwThumbnailURL = getThumbNailUrl(this.mPortfolioModel.getUrl());
            if (!TextUtils.isEmpty(nwThumbnailURL)) {
                photoUrl.set(nwThumbnailURL);
                photoDegrees.set(degrees);
            }
        }
    }

    public String getThumbNailUrl(String sourceUrl) {
        try {
            URL url = new URL(sourceUrl);
            String oldFileName = getFileNameOnly(url);
            String nwFileName = String.format("%s-thumb", oldFileName);
            return sourceUrl.replace(oldFileName, nwFileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getFileNameOnly(URL url) {
        String urlPath = url.getPath();
        String subString = urlPath.substring(urlPath.lastIndexOf('/') + 1);
        return subString.substring(0, subString.indexOf("."));
    }


    @BindingAdapter({"bind:imageUrl", "bind:degrees"})
    public static void loadImage(ImageView view, final String imageUrl, int degrees) {
        if (!TextUtils.isEmpty(imageUrl)) {
            Picasso.with(view.getContext()).load(imageUrl).rotate(degrees).into(view);
        }
    }
}
