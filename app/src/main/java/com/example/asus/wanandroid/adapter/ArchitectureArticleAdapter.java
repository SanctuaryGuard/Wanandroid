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
import com.example.asus.wanandroid.network.bean.architecture.article.ArchitectureArticleListBean;
import com.example.asus.wanandroid.utils.GlideUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class ArchitectureArticleAdapter extends BaseAdapter<BaseAdapter.ViewHolder> {
    private List<ArchitectureArticleListBean> mArchitectureArticleListBeans;
    private Context mContext;

    public ArchitectureArticleAdapter(List<ArchitectureArticleListBean> architectureArticleListBeans, Context context) {
        mArchitectureArticleListBeans = new ArrayList<>();
        mArchitectureArticleListBeans = architectureArticleListBeans;
        mContext = context;
    }

    public void addArchitectureArticleListBean(List<ArchitectureArticleListBean> architectureArticleListBeans) {
        mArchitectureArticleListBeans.addAll(architectureArticleListBeans);
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
        ArchitectureArticleListBean articleListBean = mArchitectureArticleListBeans.get(i);
        if (!TextUtils.isEmpty(articleListBean.getDesc())) {
            viewHolder.mContentText.setVisibility(View.VISIBLE);
            viewHolder.mContentText.setText(articleListBean.getDesc());
        } else {
            if (viewHolder.mContentText.getVisibility() == View.VISIBLE) {
                viewHolder.mContentText.setVisibility(View.GONE);
            }
        }
        if (!TextUtils.isEmpty(articleListBean.getEnvelopePic())) {
            viewHolder.mPicImage.setVisibility(View.VISIBLE);
            GlideUtil.getInstance().displayImage(mContext, articleListBean.getEnvelopePic(), viewHolder.mPicImage);
        } else {
            if (viewHolder.mPicImage.getVisibility() == View.VISIBLE) {
                viewHolder.mPicImage.setVisibility(View.GONE);
            }
        }
        viewHolder.mTitleText.setText(articleListBean.getTitle());
        viewHolder.mDateText.setText(articleListBean.getNiceDate() + " " + articleListBean.getAuthor());
        viewHolder.mClassificatfbgion.setText(articleListBean.getSuperChapterName() + "/" + articleListBean.getChapterName());

    }

    @Override
    public int getItemCount() {
        return mArchitectureArticleListBeans.size();
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
