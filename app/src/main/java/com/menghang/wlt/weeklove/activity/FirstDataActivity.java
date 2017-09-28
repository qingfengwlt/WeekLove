package com.menghang.wlt.weeklove.activity;


import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.menghang.wlt.weeklove.R;
import com.menghang.wlt.weeklove.base.BaseActivity;
import com.menghang.wlt.weeklove.common.utils.ToastUtils;

import butterknife.BindView;
import butterknife.OnClick;
import cn.bingoogolapple.titlebar.BGATitleBar;

public class FirstDataActivity extends BaseActivity {

    @BindView(R.id.fg_first_data_title)
    BGATitleBar mTabTitle;

    @BindView(R.id.edt_first_data_location)
    EditText mEdtLocation;
    @BindView(R.id.edt_first_data_address)
    EditText mEdtAddress;
    @BindView(R.id.edt_first_data_sex)
    EditText mEdtSex;
    @Override
    protected int resId() {
        return R.layout.activity_first_data;
    }

    @Override
    protected void initData() {
    }
    @OnClick({R.id.btn_first_data_next})
    public void onClick(View v){
        switch (v.getId()){
            case R.id.btn_first_data_next:
                String location=mEdtLocation.getText().toString().trim();
                String address=mEdtAddress.getText().toString().trim();
                String sex=mEdtSex.getText().toString().trim();
                if (TextUtils.isEmpty(location)){
                    ToastUtils.showMsg(this,"请选择地区");
                    return;
                }
                if (TextUtils.isEmpty(address)){
                    ToastUtils.showMsg(this,"请选择区域");
                    return;
                }
                if (TextUtils.isEmpty(sex)){
                    ToastUtils.showMsg(this,"请选择性别");
                    return;
                }
                openActivity(LoginActivity.class);
                break;
        }

    }
}
