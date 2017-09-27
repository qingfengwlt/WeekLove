package com.menghang.wlt.weeklove.fg;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MainTabFragment#newInstance} factory method to
 * create an instance of this fragment.
 * <p>
 * Copyright (c) 2016 isanwenyu@163.com. All rights reserved.<br>
 */
public class MainTabFragment extends Fragment {
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_ITEM_BG_COLOR_ID = "bg_color_id";
    private static final String TAG = MainTabFragment.class.getSimpleName();

    private int mBgColorId;

    public MainTabFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param colorId 颜色id.
     * @return A new instance of fragment MainTabFragment.
     */
    public static MainTabFragment newInstance(int colorId) {
        MainTabFragment fragment = new MainTabFragment();
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

//    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        ViewGroup parent = (ViewGroup) container.getParent();
//        if (parent != null) {
//            parent.removeAllViews();
//        }
//        LinearLayout linearLayout = new LinearLayout(getContext());
//        linearLayout.setBackgroundColor(getResources().getColor(mBgColorId));
//        container.addView(linearLayout, new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
//        return linearLayout;
//    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        TextView tv=new TextView(getContext());
        tv.setBackgroundColor(getResources().getColor(mBgColorId));
        tv.setGravity(Gravity.CENTER);
//        LinearLayout linearLayout = new LinearLayout(getContext());
//        linearLayout.setBackgroundColor(getResources().getColor(mBgColorId));
//        ViewGroup parent = (ViewGroup) linearLayout.getParent();
//        if (parent != null) {
//            parent.removeAllViews();
//        }
//        container.addView(linearLayout, new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        return tv;
    }
}
