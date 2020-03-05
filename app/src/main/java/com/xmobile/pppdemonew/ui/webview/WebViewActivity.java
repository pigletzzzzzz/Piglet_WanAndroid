package com.xmobile.pppdemonew.ui.webview;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;

import com.xmobile.pppdemonew.R;
import com.xmobile.pppdemonew.databinding.ActivityWebviewBinding;
import com.xmobile.xframework.ui.BaseActivity;

/**
 * Created By 刘纯贵
 * Created Time 2020/2/26
 */
public class WebViewActivity extends BaseActivity {
    ActivityWebviewBinding binding;

    @Override
    protected void initViews(Bundle savedInstanceState) {
        super.initViews(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_webview);

        WebViewFragment fragment = new WebViewFragment();
        Bundle bundle = new Bundle();
        bundle.putString("link",getIntent().getStringExtra("link"));
        bundle.putString("title",getIntent().getStringExtra("title"));
        fragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().replace(binding.fl.getId(),fragment).commit();
    }
}
