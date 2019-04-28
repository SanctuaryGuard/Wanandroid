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
import com.example.asus.wanandroid.network.bean.home.article.HomeArticleListBean;
import com.example.asus.wanandroid.network.bean.project.article.ProjectArticleListBean;
import com.example.asus.wanandroid.utils.GlideUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class PublicNumberArticleAdapter extends BaseAdapter<BaseAdapter.ViewHolder> {
    private List<HomeArticleListBean> mHomeArticleListBeans;
    private Context mContext;

    public PublicNumberArticleAdapter(List<HomeArticleListBean> homeArticleListBeans, Context context) {
        mHomeArticleListBeans = new ArrayList<>();
        mHomeArticleListBeans = homeArticleListBeans;
        mContext = context;
    }

    public void addHomeArticleListBean(List<HomeArticleListBean> homeArticleListBean) {
        mHomeArticleListBeans.addAll(homeArticleListBean);
    }

    @NonNull
    @Override
    public BaseAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_home_recycle, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BaseAdapter.ViewHolder viewHolder1, int i) {
        ViewHolder viewHolder = (ViewHolder) viewHolder1;

        HomeArticleListBean homeArticleListBean = mHomeArticleListBeans.get(i);
        if (!TextUtils.isEmpty(homeArticleListBean.getDesc())) {
            viewHolder.mContentText.setVisibility(View.VISIBLE);
            viewHolder.mContentText.setText(homeArticleListBean.getDesc());
        } else {
            if (viewHolder.mContentText.getVisibility() == View.VISIBLE) {
                viewHolder.mContentText.setVisibility(View.GONE);
            }
        }
        if (!TextUtils.isEmpty(homeArticleListBean.getEnvelopePic())) {
            viewHolder.mPicImage.setVisibility(View.VISIBLE);
            GlideUtil.getInstance().displayImage(mContext, homeArticleListBean.getEnvelopePic(), viewHolder.mPicImage);
        } else {
            if (viewHolder.mPicImage.getVisibility() == View.VISIBLE) {
                viewHolder.mPicImage.setVisibility(View.GONE);
            }
        }
        if (homeArticleListBean.getTags().size() > 0) {
            viewHolder.mTagNameText.setText(homeArticleListBean.getTags().get(0).getName());
        }
        viewHolder.mTitleText.setText(homeArticleListBean.getTitle());
        viewHolder.mDateText.setText(homeArticleListBean.getNiceDate() + " " + homeArticleListBean.getAuthor());
        viewHolder.mClassificatfbgion.setText(homeArticleListBean.getSuperChapterName() + "/" + homeArticleListBean.getChapterName());
    }


    @Override
    public int getItemCount() {
        return mHomeArticleListBeans.size();
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
