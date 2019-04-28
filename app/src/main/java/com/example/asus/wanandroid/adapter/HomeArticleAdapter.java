package com.example.asus.wanandroid.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.asus.wanandroid.R;
import com.example.asus.wanandroid.base.BaseAdapter;
import com.example.asus.wanandroid.network.bean.home.article.HomeArticleListBean;
import com.example.asus.wanandroid.utils.GlideUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeArticleAdapter extends BaseAdapter<BaseAdapter.ViewHolder> {

    private List<HomeArticleListBean> mArticleListBeans = new ArrayList<HomeArticleListBean>();
    private View mHeaderView;
    private View mFooterView;
    private Context mContext;
    private int ITEM_TYPE_HEADER = -1;
    private int ITEM_TYPE_FOOTER = -2;

    public HomeArticleAdapter(Context context, List<HomeArticleListBean> articleListBeans) {
        mArticleListBeans = articleListBeans;
        mContext = context;
    }

    public void addArticleListBeans(List<HomeArticleListBean> articleListBeans) {
        mArticleListBeans.addAll(articleListBeans);
    }

    public void addHeaderView(View view) {
        mHeaderView = view;
    }

    public void addFooterView(View view) {
        mFooterView = view;
    }

    @NonNull
    @Override
    public BaseAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (i == ITEM_TYPE_HEADER) {
            return new HeaderViewHolder(mHeaderView);
        }
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_home_recycle, viewGroup, false);
        return new ViewHolder(view);
    }


    @Override
    public int getItemViewType(int position) {
        if (null != mHeaderView && position == 0) {
            return ITEM_TYPE_HEADER;
        } else if (null != mFooterView && position == getItemCount() - 1) {
            return ITEM_TYPE_FOOTER;
        }
        HomeArticleListBean listBean = null;
        if (null != mHeaderView) {
            listBean = mArticleListBeans.get(position - 1);
        }
        return listBean.getType();
    }

    @Override
    public void onBindViewHolder(@NonNull BaseAdapter.ViewHolder viewHolder1, int i) {
        if (getItemViewType(i) == ITEM_TYPE_HEADER) {
            return;
        } else {
            ViewHolder viewHolder = (ViewHolder) viewHolder1;
            if (null != mHeaderView) {
                i--;
            }
            HomeArticleListBean articleListBean = mArticleListBeans.get(i);
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
            viewHolder.mDateText.setText(articleListBean.getNiceDate() + " " + articleListBean.getAuthor());
            viewHolder.mClassificatfbgion.setText(articleListBean.getSuperChapterName() + "/" + articleListBean.getChapterName());
        }
    }

    @Override
    public int getItemCount() {
        int itemCount = 0;
        if (null != mHeaderView) {
            itemCount ++;
        }
        if (null != mFooterView) {
            itemCount ++;
        }
        return mArticleListBeans.size() + itemCount;
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

    public class HeaderViewHolder extends BaseAdapter.ViewHolder {

        public HeaderViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
