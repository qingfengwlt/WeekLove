package com.menghang.wlt.weeklove.fg;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.menghang.wlt.weeklove.R;
import com.menghang.wlt.weeklove.base.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link UserTabFragment#newInstance} factory method to
 * create an instance of this fragment.
 * <p>
 *  fg 我的
 */
public class UserTabFragment extends BaseFragment {
    private static final String ARG_ITEM_BG_COLOR_ID = "bg_color_id";

    private int mBgColorId;


    public static UserTabFragment newInstance(int colorId) {
        UserTabFragment fragment = new UserTabFragment();
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
        return R.layout.fg_user;
    }
}
