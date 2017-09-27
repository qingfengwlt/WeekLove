package com.menghang.wlt.weeklove.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import butterknife.ButterKnife;

/**
 * Created by PC_WLT on 2017/5/12.
 */

public abstract class BaseFragment extends Fragment {

    protected  String TAG = BaseFragment.class.getSimpleName();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(resLayout(),container,false);
        this.TAG=this.getClass().getSimpleName();
        ButterKnife.bind(this,view);
        return resLayout()==0?super.onCreateView(inflater, container, savedInstanceState):view;
    }
    protected abstract int resLayout();

}
