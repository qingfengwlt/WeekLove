package com.menghang.wlt.weeklove.fg;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.menghang.wlt.weeklove.R;
import com.menghang.wlt.weeklove.base.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link WelcomeOneFragment#newInstance} factory method to
 * create an instance of this fragment.
 * <p>
 * Copyright (c) 2016 isanwenyu@163.com. All rights reserved.<br>
 */
public class WelcomeOneFragment extends BaseFragment {
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String POSITION_FROM = "positon";
    private static final String TAG = WelcomeOneFragment.class.getSimpleName();

    private int mPositionFrom;

    public WelcomeOneFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param positon 颜色id.
     * @return A new instance of fragment MainTabFragment.
     */
    public static WelcomeOneFragment newInstance(int positon) {
        WelcomeOneFragment fragment = new WelcomeOneFragment();
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
        return R.layout.fg_welcome_one;
    }
}
