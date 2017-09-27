package com.menghang.wlt.weeklove;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.util.TypedValue;

import com.andexert.library.RippleView;
import com.isanwenyu.tabview.TabGroup;
import com.isanwenyu.tabview.TabView;
import com.menghang.wlt.weeklove.adapter.ContentFragmentAdapter;
import com.menghang.wlt.weeklove.base.BaseActivity;
import com.menghang.wlt.weeklove.fg.AssociationTabFragment;
import com.menghang.wlt.weeklove.fg.MainTabFragment;
import com.menghang.wlt.weeklove.fg.MsgTabFragment;
import com.menghang.wlt.weeklove.fg.TeacherTabFragment;
import com.menghang.wlt.weeklove.fg.UserTabFragment;
import com.menghang.wlt.weeklove.fg.VipTabFragment;

import butterknife.BindView;


public class MainActivity extends BaseActivity {
    public static final int TAB_MSG = 0x03;
    public static final int TAB_TEACHER = 0x01;
    public static final int TAB_ASSOCIATION = 0x02;
    public static final int TAB_USER = 0x04;
    public static final int TAB_VIP = 0x00;
    @BindView(R.id.vp_main)
    ViewPager mViewPager;
    @BindView(R.id.tg_tab)
    TabGroup mTabGroup;
    @BindView(R.id.tb_msg)
    TabView mChatTabView;
    @Override
    protected int resId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData() {
        initView();
    }

    /**
     * 初始化布局
     */
    private void initView() {
        initViewPager();
        mTabGroup.setOnCheckedChangeListener(new TabGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(TabGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.tb_vip:
                        setCurrentFragment(TAB_VIP);
                        break;
                    case R.id.tb_msg:
                        setCurrentFragment(TAB_MSG);
                        break;
                    case R.id.tb_association:
                        setCurrentFragment(TAB_ASSOCIATION);
                        break;
                    case R.id.tb_teacher:
                        setCurrentFragment(TAB_TEACHER);
                        break;
                    case R.id.tb_user:
                        setCurrentFragment(TAB_USER);
                        break;
                }
            }
        });
        //init tab badge view && ripple view,the others setted in activity_main.xml
        mChatTabView
                .setBadgeColor(getResources().getColor(android.R.color.holo_blue_dark))
                .setmDefaultTopPadding((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 2, getResources().getDisplayMetrics()))
                .setBadgeShown(true)
                .setTabRippleCentered(false)
                .setTabRippleColor(android.R.color.holo_blue_dark)
                .setTabRippleDuration(100)
                //override setOnRippleCompleteListener method in rippleView
                .setOnRippleCompleteListener(new RippleView.OnRippleCompleteListener() {
                    @Override
                    public void onComplete(RippleView rippleView) {
                        mChatTabView.setChecked(true);
                    }
                });
        ((TabView) mTabGroup.getChildAt(1)).setBadgeCount(999)
                .setmDefaultTopPadding((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 2, getResources().getDisplayMetrics()))
                .setBadgeShown(true)
                .setTabRippleEnable(false);
    }

    /**
     * 初始化viewpager
     */
    private void initViewPager() {

        //缓存3页避免切换时出现空指针
        mViewPager.setOffscreenPageLimit(3);
        mViewPager.setAdapter(new ContentFragmentAdapter.Holder(getSupportFragmentManager())
                .add(MsgTabFragment.newInstance(android.R.color.holo_orange_dark))
                .add(VipTabFragment.newInstance(android.R.color.holo_blue_dark))
                .add(TeacherTabFragment.newInstance(android.R.color.holo_red_dark))
                .add(AssociationTabFragment.newInstance(android.R.color.holo_green_dark))
                .add(UserTabFragment.newInstance(android.R.color.holo_purple))
                .set());
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {


            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                ((TabView) mTabGroup.getChildAt(position)).setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    /**
     * 改变fragment状态
     *
     * @param position
     */
    public void setCurrentFragment(final int position) {
        Log.i(TAG, "position:" + position);
        //不使用切换动画 避免与自定义动画冲突
        mViewPager.setCurrentItem(position, false);
    }

}
