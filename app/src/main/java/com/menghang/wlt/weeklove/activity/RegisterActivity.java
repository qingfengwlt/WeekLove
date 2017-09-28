package com.menghang.wlt.weeklove.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.menghang.wlt.weeklove.R;
import com.menghang.wlt.weeklove.base.BaseActivity;
import com.menghang.wlt.weeklove.common.utils.ToastUtils;

import butterknife.BindView;
import butterknife.OnClick;

public class RegisterActivity extends BaseActivity {


    @BindView(R.id.edt_register_phone)
    EditText mEdtPhone;
    @BindView(R.id.edt__register_wexin)
    EditText mEdtWexin;
    @BindView(R.id.edt_register_password)
    EditText mEdtPassword;
    @Override
    protected int resId() {
        return R.layout.activity_register;
    }


    @Override
    protected void initData() {

    }
    @OnClick({R.id.btn_register_ok})
    public void onClick(View v){
        switch (v.getId()){
            case R.id.btn_register_ok://确认注册
                String phone=mEdtPhone.getText().toString().trim();
                String weixin=mEdtWexin.getText().toString().trim();
                String password=mEdtPassword.getText().toString().trim();
                if (TextUtils.isEmpty(phone)){
                    ToastUtils.showMsg("手机号不能空");
                    return;
                }
                if (phone.length()<11){
                    ToastUtils.showMsg(this,"手机号格式不对");
                    return;
                }
                if (TextUtils.isEmpty(weixin)){
                    ToastUtils.showMsg(this,"微信号不能空");
                    return;
                }
                if (TextUtils.isEmpty(password)){
                    ToastUtils.showMsg(this,"密码不能空");
                    return;
                }
                if (phone.length()>16||password.length()<6){
                    ToastUtils.showMsg(this,"密码长度为6-16位");
                    return;
                }
                openActivity(PerfectInfoActivity.class);
                break;
        }

    }
}
