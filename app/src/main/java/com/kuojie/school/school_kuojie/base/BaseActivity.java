package com.kuojie.school.school_kuojie.base;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.kuojie.school.school_kuojie.R;
import com.kuojie.school.school_kuojie.application.MyApplication;

/**
 * Created by gys on 2017/3/11.
 * Activity基类
 */

public class BaseActivity extends AppCompatActivity {

    private static final String TAG = "BaseActivity";
    private RelativeLayout mContent;
    private TextView mTitle;
    private Toolbar mToolbar;
    private MyApplication mApplication;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);//竖屏
        setContentView(R.layout.activity_base);
        /*//将Activity添加到集合中，便于管理
        mApplication = (MyApplication) getApplication();
        mApplication.addActivity(this);*/


        initToolbar();
        initView();
        initData();
    }

    /**
     * 初始化布局 子类使用
     */
    protected void initView() {

    }

    /**
     * 初始化数据 子类使用
     */
    protected void initData() {
    }

    /**
     * 初始化ToolBar
     */
    private void initToolbar() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        if (mToolbar != null) {
            setSupportActionBar(mToolbar);
        }
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        }
        mTitle = (TextView) findViewById(R.id.title);
        mContent = (RelativeLayout) findViewById(R.id.content);

    }

    /**
     * 设置Toolbar下面的内容区域
     *
     * @param layoutId 布局ID
     */
    public void setContentLayout(int layoutId) {
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View contentView = inflater.inflate(layoutId, null);
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        mContent.addView(contentView, params);
    }

    public TextView getToolbarTextView() {
        if (mTitle != null) {
            return mTitle;
        } else {
            mTitle = (TextView) findViewById(R.id.title);
            return mTitle;
        }
    }

    /**
     * 设置头部的标题
     *
     * @param msg 标题内容
     */
    protected void setTitle(String msg) {
        if (mTitle != null) {
            mTitle.setText(msg);
        }
    }

    /**
     * 头部返回按钮点击事件
     */
    protected void setBackArrow() {
        Drawable backArrow = getResources().getDrawable(R.drawable.arrow_left);
        //为toolbar设置左侧图标
        getSupportActionBar().setHomeAsUpIndicator(backArrow);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //设置图标点击事件
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    /**
     * 设置Menu的点击事件
     *
     * @param listener menu点击事件
     */
    protected void setToolbarMenuOnClickListener(Toolbar.OnMenuItemClickListener listener) {
        mToolbar.setOnMenuItemClickListener(listener);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        mApplication.removeActivity(this);
    }
}
