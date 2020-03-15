package com.xmobile.pppdemonew.ui.my;

import android.os.Bundle;
import android.view.View;

import androidx.databinding.DataBindingUtil;

import com.xmobile.pppdemonew.R;
import com.xmobile.pppdemonew.databinding.ActivityOpenBinding;
import com.xmobile.xframework.ui.BaseActivity;

/**
 * Created By 刘纯贵
 * Created Time 2020/3/15
 */
public class MyOpenActivity extends BaseActivity {
    ActivityOpenBinding binding;
    @Override
    protected void initViews(Bundle savedInstanceState) {
        super.initViews(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_open);

        binding.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
