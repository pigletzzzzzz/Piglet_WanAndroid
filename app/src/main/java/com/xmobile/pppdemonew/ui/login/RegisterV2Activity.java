package com.xmobile.pppdemonew.ui.login;

import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.MotionEvent;
import android.view.View;

import androidx.databinding.DataBindingUtil;

import com.xmobile.pppdemonew.R;
import com.xmobile.pppdemonew.databinding.ActivityRegisteredV2Binding;
import com.xmobile.xframework.ui.BaseActivity;

/**
 * Created By 刘纯贵
 * Created Time 2020/2/27
 */
public class RegisterV2Activity extends BaseActivity {

    ActivityRegisteredV2Binding binding;

    @Override
    protected void initViews(Bundle savedInstanceState) {
        super.initViews(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_registered_v2);
        ShowOrHidePWD();
        ShowOrHidePWDAgain();
    }

    private void ShowOrHidePWD(){
        binding.showHide.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        binding.loginEditPwd.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                        binding.showHide.setBackgroundResource(R.mipmap.inputsee);
                        break;
                    case MotionEvent.ACTION_UP:
                        binding.loginEditPwd.setTransformationMethod(PasswordTransformationMethod.getInstance());
                        binding.showHide.setBackgroundResource(R.mipmap.inputhide);
                        break;
                }
                return true;
            }
        });
    }

    private void ShowOrHidePWDAgain(){
        binding.showHideAgain.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        binding.loginEditPwd.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                        binding.showHideAgain.setBackgroundResource(R.mipmap.inputsee);
                        break;
                    case MotionEvent.ACTION_UP:
                        binding.loginEditPwd.setTransformationMethod(PasswordTransformationMethod.getInstance());
                        binding.showHideAgain.setBackgroundResource(R.mipmap.inputhide);
                        break;
                }
                return true;
            }
        });
    }
}
