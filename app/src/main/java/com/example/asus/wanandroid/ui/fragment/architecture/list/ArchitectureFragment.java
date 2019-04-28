package com.example.asus.wanandroid.ui.fragment.architecture.list;

import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.asus.wanandroid.R;
import com.example.asus.wanandroid.adapter.ArchitectureGroupListAdapter;
import com.example.asus.wanandroid.base.BaseAdapter;
import com.example.asus.wanandroid.base.MVPFragment;
import com.example.asus.wanandroid.network.bean.architecture.group.ArchitectureGroup;
import com.example.asus.wanandroid.network.bean.architecture.group.ArchitectureGroupData;
import com.example.asus.wanandroid.ui.fragment.architecture.list.presenter.ArchitecturePresenter;
import com.example.asus.wanandroid.ui.fragment.architecture.pagearticle.ArchitectureViewPageActivity;
import com.example.asus.wanandroid.ui.fragment.contract.HomeContract;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class ArchitectureFragment extends MVPFragment<ArchitecturePresenter> implements HomeContract.SimpleView {

    public List<ArchitectureGroupData> mArchitectureGroupData;
    private ArchitectureGroupListAdapter mArchitectureGroupListAdapter;

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 1) {
                mArchitectureGroupData = (List<ArchitectureGroupData>) msg.obj;
            }
        }
    };

    @BindView(R.id.architecture_recycler_view)
    RecyclerView mArchitectureRecyclerView;


    @Override
    public int getLayoutId() {
        return R.layout.fragment_architecture;
    }

    @Override
    public void init() {
        mArchitectureGroupData = new ArrayList<ArchitectureGroupData>();

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mArchitectureRecyclerView.setLayoutManager(layoutManager);

        mArchitectureGroupListAdapter = new ArchitectureGroupListAdapter(getContext(), mArchitectureGroupData);
        mArchitectureRecyclerView.setAdapter(mArchitectureGroupListAdapter);

        presenter.getArchitectureGroupData();

        mArchitectureGroupListAdapter.setOnItemClickListener(new BaseAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                ArchitectureViewPageActivity.actionStart(getActivity(), mArchitectureGroupData.get(position));
            }

            @Override
            public void onItemLongClick(View view, int position) {

            }
        });

    }

    @Override
    protected ArchitecturePresenter initPresenter() {
        return new ArchitecturePresenter();
    }

    @Override
    public void onSuccess(Object object) {
        if (object instanceof ArchitectureGroup) {
            ArchitectureGroup architectureGroup = (ArchitectureGroup) object;

            Message message = new Message();
            message.what = 1;
            message.obj = architectureGroup.getData();
            mHandler.sendMessage(message);

            mArchitectureGroupListAdapter.addArchitectureGroupData(architectureGroup.getData());
            mArchitectureGroupListAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onFail(Throwable e) {

    }

    @Override
    public void onCompleted() {

    }
}
