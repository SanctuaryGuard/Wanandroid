package com.example.asus.wanandroid.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.asus.wanandroid.R;
import com.example.asus.wanandroid.base.BaseAdapter;
import com.example.asus.wanandroid.network.bean.architecture.group.ArchitectureGroup;
import com.example.asus.wanandroid.network.bean.architecture.group.ArchitectureGroupData;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class ArchitectureGroupListAdapter extends BaseAdapter<BaseAdapter.ViewHolder> {

    private List<ArchitectureGroupData> mArchitectureGroupData = new ArrayList<>();;
    private Context mContext;

    public ArchitectureGroupListAdapter(Context context, List<ArchitectureGroupData> architectureGroupData) {
        mContext = context;
        mArchitectureGroupData = architectureGroupData;
    }

    public void addArchitectureGroupData(List<ArchitectureGroupData> architectureGroupData) {
        mArchitectureGroupData.addAll(architectureGroupData);

    }

    @NonNull
    @Override
    public BaseAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_architecture_recycle, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BaseAdapter.ViewHolder viewHolder, int i) {
        ArchitectureGroupData architectureGroupData = mArchitectureGroupData.get(i);
        ViewHolder viewHolder1 = (ViewHolder) viewHolder;
        viewHolder1.mTitleTextView.setText(architectureGroupData.getName());
        viewHolder1.updateTagsFlowLayout(architectureGroupData.getChildren());

        if (mOnItemClickListener != null) {
            viewHolder1.itemView.setOnClickListener(v -> {
                mOnItemClickListener.onItemClick(v, viewHolder1.getLayoutPosition());
            });
        }
    }

    @Override
    public int getItemCount() {
        return mArchitectureGroupData.size();
    }

    public class ViewHolder extends BaseAdapter.ViewHolder {

        private List<ArchitectureGroupData> mArchitectureGroupDataList;

        @BindView(R.id.architecture_tag_flow_layout)
        TagFlowLayout mArchitectureFlowLayout;
        @BindView(R.id.architecture_title_text)
        TextView mTitleTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mArchitectureGroupDataList = new ArrayList<>();
            mArchitectureFlowLayout.setAdapter(new TagAdapter<ArchitectureGroupData>(mArchitectureGroupDataList) {
                @Override
                public View getView(FlowLayout parent, int position, ArchitectureGroupData architectureGroupData) {
                    TextView tv = (TextView) LayoutInflater.from(parent.getContext()).inflate(R.layout.item_architecture_tags_flow, parent, false);
                    tv.setText(architectureGroupData.getName());
                    return tv;
                }
            });
        }

        public void updateTagsFlowLayout(List<ArchitectureGroupData> architectureGroupData) {
            mArchitectureGroupDataList.clear();
            mArchitectureGroupDataList.addAll(architectureGroupData);
            mArchitectureFlowLayout.getAdapter().notifyDataChanged();
        }
    }

}
