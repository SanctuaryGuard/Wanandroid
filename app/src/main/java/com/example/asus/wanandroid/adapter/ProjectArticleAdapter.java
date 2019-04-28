package com.example.asus.wanandroid.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.asus.wanandroid.R;
import com.example.asus.wanandroid.base.BaseAdapter;
import com.example.asus.wanandroid.network.bean.project.article.ProjectArticleListBean;
import com.example.asus.wanandroid.utils.GlideUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class ProjectArticleAdapter extends BaseAdapter<BaseAdapter.ViewHolder> {
    private List<ProjectArticleListBean> mProjectArticleListBeans;
    private Context mContext;

    public ProjectArticleAdapter(List<ProjectArticleListBean> projectArticleData, Context context) {
        mProjectArticleListBeans = new ArrayList<>();
        mProjectArticleListBeans = projectArticleData;
        mContext = context;
    }

    public void addProjectArticleData(List<ProjectArticleListBean> projectArticleDatalist) {
        mProjectArticleListBeans.addAll(projectArticleDatalist);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_home_recycle, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BaseAdapter.ViewHolder viewHolder1, int i) {
        ViewHolder viewHolder = (ViewHolder) viewHolder1;

        ProjectArticleListBean projectArticleListBean = mProjectArticleListBeans.get(i);
        if (!TextUtils.isEmpty(projectArticleListBean.getDesc())) {
            viewHolder.mContentText.setVisibility(View.VISIBLE);
            viewHolder.mContentText.setText(projectArticleListBean.getDesc());
        } else {
            if (viewHolder.mContentText.getVisibility() == View.VISIBLE) {
                viewHolder.mContentText.setVisibility(View.GONE);
            }
        }
        if (!TextUtils.isEmpty(projectArticleListBean.getEnvelopePic())) {
            viewHolder.mPicImage.setVisibility(View.VISIBLE);
            GlideUtil.getInstance().displayImage(mContext, projectArticleListBean.getEnvelopePic(), viewHolder.mPicImage);
        } else {
            if (viewHolder.mPicImage.getVisibility() == View.VISIBLE) {
                viewHolder.mPicImage.setVisibility(View.GONE);
            }
        }
        if (projectArticleListBean.getTags().size() > 0) {
            viewHolder.mTagNameText.setText(projectArticleListBean.getTags().get(0).getName());
        }
        viewHolder.mTitleText.setText(projectArticleListBean.getTitle());
        viewHolder.mDateText.setText(projectArticleListBean.getNiceDate() + " " + projectArticleListBean.getAuthor());
        viewHolder.mClassificatfbgion.setText(projectArticleListBean.getSuperChapterName() + "/" + projectArticleListBean.getChapterName());
    }


    @Override
    public int getItemCount() {
        return mProjectArticleListBeans.size();
    }

    public class ViewHolder extends BaseAdapter.ViewHolder {
        @BindView(R.id.title_home_recycle)
        TextView mTitleText;
        @BindView(R.id.content_home_recycle)
        TextView mContentText;
        @BindView(R.id.date_home_recycle)
        TextView mDateText;
        @BindView(R.id.tag_name_home_recycle)
        TextView mTagNameText;
        @BindView(R.id.classificatfbgion_home_recycle)
        TextView mClassificatfbgion;
        @BindView(R.id.pic_home_image)
        ImageView mPicImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
