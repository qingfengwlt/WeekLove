package com.menghang.wlt.weeklove.fg;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.Button;

import com.menghang.wlt.weeklove.MainActivity;
import com.menghang.wlt.weeklove.R;
import com.menghang.wlt.weeklove.activity.FirstDataActivity;
import com.menghang.wlt.weeklove.base.BaseFragment;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link WelcomeThreeFragment#newInstance} factory method to
 * create an instance of this fragment.
 * <p>
 * Copyright (c) 2016 isanwenyu@163.com. All rights reserved.<br>
 */
public class WelcomeThreeFragment extends BaseFragment {
    private static final String POSITION_FROM = "positon";
    private static final String TAG = WelcomeThreeFragment.class.getSimpleName();
    private int mPositionFrom;

    @BindView(R.id.btn_welcome_start)
    Button mBtnStart;
    public WelcomeThreeFragment() {
    }
    public static WelcomeThreeFragment newInstance(int positon) {
        WelcomeThreeFragment fragment = new WelcomeThreeFragment();
        Bundle args = new Bundle();
        args.putInt(POSITION_FROM, positon);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mPositionFrom = getArguments().getInt(POSITION_FROM);
        }
    }


    @Override
    protected int resLayout() {
        return R.layout.fg_welcome_three;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initData();
    }

    @OnClick({R.id.btn_welcome_start})
    public void onClick(View v){
        switch (v.getId()){
            case R.id.btn_welcome_start:
                startActivity(new Intent(getActivity(), FirstDataActivity.class));
                break;
        }
    }
    private void initData() {

    }
}
