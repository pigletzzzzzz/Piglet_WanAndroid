package com.xmobile.pppdemonew.ui.knowledgeSystem.system.systembranch;

import android.os.Bundle;

import com.xmobile.pppdemonew.R;
import com.xmobile.pppdemonew.data.bean.SystemBean;
import com.xmobile.xframework.ui.BaseActivityWithFragment;

/**
 * Created By 刘纯贵
 * Created Time 2020/2/25
 */
public class SystemBranchActivity extends BaseActivityWithFragment<SystemBranchFragment> {

    private int pos;
    private SystemBean systemBean;

    @Override
    protected void initImmersionBar() {
//        super.initImmersionBar();
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        super.initViews(savedInstanceState);
        pos = getIntent().getIntExtra("pos",-1);
        systemBean = (SystemBean) getIntent().getSerializableExtra("datas");
//        Bundle bundle = new Bundle();
//        bundle.putSerializable("datas",systemBean);
//        bundle.putInt("pos",pos);
//        SystemBranchFragment fragment = createFragment();
//        fragment.setArguments(bundle);
    }

    public SystemBean getSystemBean(){
        return systemBean;
    }

    public int getPos(){
        return pos;
    }

}
