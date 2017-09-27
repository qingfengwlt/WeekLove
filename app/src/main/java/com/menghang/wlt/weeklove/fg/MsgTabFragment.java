package com.menghang.wlt.weeklove.fg;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.lcodecore.tkrefreshlayout.RefreshListenerAdapter;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.menghang.wlt.weeklove.R;
import com.menghang.wlt.weeklove.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import pc.wlt.com.superlibrary.common.CommonAdapter;
import pc.wlt.com.superlibrary.common.CommonViewHolder;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MsgTabFragment#newInstance} factory method to
 * create an instance of this fragment.
 * <p>
 *  fg 单约
 */
public class MsgTabFragment extends BaseFragment {
    private static final String ARG_ITEM_BG_COLOR_ID = "bg_color_id";
    private int mBgColorId;

    @BindView(R.id.tv_tab_title)
    TextView mTvTitle;
    @BindView(R.id.tv_tab_title_left)
    TextView mTvLeft;
    @BindView(R.id.tv_tab_title_right)
    TextView mTvRight;



    @BindView(R.id.refresh_msg)
    TwinklingRefreshLayout mRefreshLayout;

    @BindView(R.id.lv_msg)
    ListView mLv;
    List<String> mList;
    CommonAdapter mAdapter;

    public static MsgTabFragment newInstance(int colorId) {
        MsgTabFragment fragment = new MsgTabFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_ITEM_BG_COLOR_ID, colorId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mBgColorId = getArguments().getInt(ARG_ITEM_BG_COLOR_ID);
        }
    }

    @Override
    protected int resLayout() {
        return R.layout.fg_msg;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initData();
    }

    private void initData() {
        mTvTitle.setText("单约专区");
        mTvLeft.setText("北京");
//        mTvRight.setText("消息记录");
        mTvRight.setText("");
        mList=new ArrayList<>();
        for (int i=0;i<30;i++){
            mList.add(i+"");
        }
        mAdapter =new CommonAdapter<String>(getActivity(),mList,R.layout.list_item_fg_msg) {
            @Override
            public void setViewContent(CommonViewHolder viewHolder, String o) {

            }
        };
        mLv.setAdapter(mAdapter);
        mRefreshLayout.setAutoLoadMore(true);
        mRefreshLayout.setOnRefreshListener(new RefreshListenerAdapter() {
            @Override
            public void onRefresh(TwinklingRefreshLayout refreshLayout) {
                super.onRefresh(refreshLayout);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mRefreshLayout.finishRefreshing();
                    }
                },2000);
            }

            @Override
            public void onLoadMore(TwinklingRefreshLayout refreshLayout) {
                super.onLoadMore(refreshLayout);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mRefreshLayout.finishLoadmore();
                    }
                },2000);
            }
        });
    }
}
