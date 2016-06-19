package com.skillvo.android.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.text.TextUtils;

import com.skillvo.android.model.PagedList;

public class ProjectItemViewModel extends BaseObservable {

    public ObservableField<String> projectTitle = new ObservableField<>();
    public ObservableField<String> totalPhotos = new ObservableField<>();
    public ObservableBoolean projectSelection = new ObservableBoolean();

    public ProjectItemViewModel(boolean isSelected, PagedList pagedList) {
        if (!TextUtils.isEmpty(pagedList.getTitle())) {
            projectTitle.set(pagedList.getTitle());
        }
        if (pagedList.getPortfolio().size() > 0) {
            if (pagedList.getPortfolio().size() > 1) {
                totalPhotos.set(String.format("%d Photos", pagedList.getPortfolio().size()));
            } else {
                totalPhotos.set(String.format("%d Photo", pagedList.getPortfolio().size()));
            }
        } else {
            totalPhotos.set("0 Photos");
        }
        projectSelection.set(isSelected);
    }

}
