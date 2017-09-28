package com.menghang.wlt.weeklove.activity;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.menghang.wlt.weeklove.R;
import com.menghang.wlt.weeklove.base.BaseActivity;
import com.menghang.wlt.weeklove.fg.MainTabFragment;
import com.menghang.wlt.weeklove.fg.WelcomeOneFragment;
import com.menghang.wlt.weeklove.fg.WelcomeThreeFragment;
import com.menghang.wlt.weeklove.fg.WelcomeTwoFragment;

import butterknife.BindView;
import pc.wlt.com.superlibrary.adapter.ComFragmentAdapter;

public class WelcomeActivity extends BaseActivity {

    @BindView(R.id.vp_welcome)
    ViewPager mVp;

    ComFragmentAdapter mFAdapter;
    Fragment currentFragment=new MainTabFragment();
    @Override
    protected int resId() {
        return R.layout.activity_welcome;
    }

    @Override
    protected void initData() {
        mFAdapter=new ComFragmentAdapter(getSupportFragmentManager(),new String[]{"1","2","3"}) {
            @Override
            public Fragment getItem(int postion) {
                switch (postion){
                    case 0:
                        currentFragment=WelcomeOneFragment.newInstance(postion);
                        break;
                    case 1:
                        currentFragment= WelcomeTwoFragment.newInstance(postion);
                        break;
                    case 2:
                        currentFragment= WelcomeThreeFragment.newInstance(postion);
                        break;
                }
                return  currentFragment;
            }
        };
        mVp.setAdapter(mFAdapter);
    }
}
