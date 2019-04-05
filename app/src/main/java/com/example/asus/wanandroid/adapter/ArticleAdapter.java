package com.example.asus.wanandroid.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.asus.wanandroid.R;
import com.example.asus.wanandroid.network.bean.home.article.ArticleListBean;
import com.example.asus.wanandroid.network.bean.home.article.ArticleTag;
import com.example.asus.wanandroid.network.bean.home.banner.HomeBannerData;
import com.example.asus.wanandroid.utils.GlideUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ViewHolder> {

    private List<ArticleListBean> mArticleListBeans = new ArrayList<ArticleListBean>();
    private List<HomeBannerData> mHomeBannerDataList = new ArrayList<HomeBannerData>();
    private Context mContext;

    public ArticleAdapter(Context context, List<ArticleListBean> articleListBeans, List<HomeBannerData> homeBannerDataList) {
        mArticleListBeans = articleListBeans;
        mHomeBannerDataList = homeBannerDataList;
        mContext = context;
    }

    public void addArticleListBeans(List<ArticleListBean> articleListBeans) {
        mArticleListBeans.addAll(articleListBeans);
    }

    public void addHomeBannerDataList(List<HomeBannerData> homeBannerDataList) {
        mHomeBannerDataList.addAll(homeBannerDataList);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_home_recycle, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        ArticleListBean articleListBean = mArticleListBeans.get(i);
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
        if (articleListBean.getTags().size() > 0) {
            viewHolder.mTagNameText.setText(articleListBean.getTags().get(0).getName());
        }
        viewHolder.mTitleText.setText(articleListBean.getTitle());
        viewHolder.mDateText.setText(articleListBean.getNiceDate());
        viewHolder.mClassificatfbgion.setText(articleListBean.getSuperChapterName() + "/" + articleListBean.getChapterName());

    }

    @Override
    public int getItemCount() {
        return mArticleListBeans.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

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
            ButterKnife.bind(this, itemView);
        }
    }

}
