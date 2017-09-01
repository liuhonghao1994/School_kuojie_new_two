package com.kuojie.school.school_kuojie.ui.admin;

import com.kuojie.school.school_kuojie.R;
import com.kuojie.school.school_kuojie.base.BaseActivity;

/**
 * 行政任务界面
 */
public class TaskActivity extends BaseActivity {

    @Override
    protected void initView() {
        setTitle("任务");
        setBackArrow();
        setContentLayout(R.layout.activity_admin_task);
    }

    @Override
    protected void initData() {
        super.initData();
    }
}
