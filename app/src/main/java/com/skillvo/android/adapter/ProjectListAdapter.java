package com.skillvo.android.adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.skillvo.android.R;
import com.skillvo.android.databinding.ProjectItemBinding;
import com.skillvo.android.model.PagedList;
import com.skillvo.android.viewmodel.ProjectItemViewModel;

import java.util.ArrayList;
import java.util.List;

public class ProjectListAdapter extends RecyclerView.Adapter<ProjectListAdapter.ProjectItemViewHolder> {

    private int mSelectedItem = -1;
    private List<PagedList> pagedLists = new ArrayList<>();
    private AdapterItemListener<PagedList> adapterItemListener = null;

    public ProjectListAdapter() {
    }

    public void registerAdapterItemCallback(AdapterItemListener<PagedList> adapterItemCallback) {
        this.adapterItemListener = adapterItemCallback;
    }

    public void resetSelectedItem() {
        mSelectedItem = -1;
    }

    public void addPagedList(List<PagedList> inputPagedList) {
        if (pagedLists.size() > 0) {
            pagedLists.clear();
        }
        pagedLists.addAll(inputPagedList);
    }

    @Override
    public ProjectItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ProjectItemBinding rowBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.row_project, parent, false);
        return new ProjectItemViewHolder(rowBinding);
    }

    @Override
    public void onBindViewHolder(ProjectItemViewHolder holder, int position) {
        holder.onBindRowItem(position, pagedLists.get(position));
    }

    @Override
    public int getItemCount() {
        return pagedLists.size();
    }

    public class ProjectItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ProjectItemBinding mProjectItemBinding;

        public ProjectItemViewHolder(ProjectItemBinding rowBinding) {
            super(rowBinding.getRoot());
            mProjectItemBinding = rowBinding;
            mProjectItemBinding.getRoot().setOnClickListener(this);
            mProjectItemBinding.selectProject.setOnClickListener(this);

        }

        public void onBindRowItem(int currentPosition, PagedList pageDataSet) {
            mProjectItemBinding.setViewmodel(new ProjectItemViewModel(currentPosition == mSelectedItem, pageDataSet));
            //this will responsible for change the state color of background for higlight the selected row
            mProjectItemBinding.rowParentLayout.setSelected(currentPosition == mSelectedItem);
        }

        @Override
        public void onClick(View v) {
            mSelectedItem = getAdapterPosition();
            notifyItemRangeChanged(0, pagedLists.size());
            adapterItemListener.onItemClickListener(pagedLists.get(mSelectedItem),mSelectedItem);
        }
    }
}
