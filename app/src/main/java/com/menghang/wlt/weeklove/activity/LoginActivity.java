package com.menghang.wlt.weeklove.activity;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.menghang.wlt.weeklove.MainActivity;
import com.menghang.wlt.weeklove.R;
import com.menghang.wlt.weeklove.base.BaseActivity;
import com.menghang.wlt.weeklove.common.utils.ToastUtils;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity {

    @BindView(R.id.tv_login_user)
    TextView mTvUser;
    @BindView(R.id.tv_login_teacher)
    TextView mTvTeacher;
    @BindView(R.id.edt_login_work_phone)
    EditText mEdtPhone;
    @BindView(R.id.edt_login_password)
    EditText mEdtPassword;
    @BindView(R.id.btn_login_login)
    Button mBtnLogin;
    @BindView(R.id.btn_login_register)
    Button mBtnRegister;

    @Override
    protected int resId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initData() {

    }
    @OnClick({R.id.tv_login_user,R.id.tv_login_teacher,R.id.btn_login_login,R.id.btn_login_register,R.id.tv_login_qq,R.id.tv_login_weixin})
    public void onClick(View v){
        switch (v.getId()){
            case R.id.tv_login_user://会员
                mTvUser.setTextSize(16);
                mTvTeacher.setTextSize(14);
                break;
            case R.id.tv_login_teacher://导师
                mTvUser.setTextSize(14);
                mTvTeacher.setTextSize(16);
                break;
            case R.id.btn_login_login://登录
                String phone=mEdtPhone.getText().toString().trim();
                String password=mEdtPassword.getText().toString().trim();
                if (TextUtils.isEmpty(phone)){
                    ToastUtils.showMsg("手机号不能空");
                    return;
                }
                if (phone.length()<11){
                    ToastUtils.showMsg(this,"手机号格式不对");
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
                openActivity(MainActivity.class);
                break;
            case R.id.btn_login_register://注册
                openActivity(RegisterActivity.class);
                break;
            case R.id.tv_login_qq:
                ToastUtils.showMsg("QQ登录");
                break;
            case R.id.tv_login_weixin:
                ToastUtils.showMsg("微信登录");
                break;
        }
    }
}
