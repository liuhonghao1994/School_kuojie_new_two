package com.kuojie.school.school_kuojie.ui.admin;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.enrique.stackblur.StackBlurManager;
import com.example.zhouwei.library.CustomPopWindow;
import com.kuojie.school.school_kuojie.R;
import com.kuojie.school.school_kuojie.base.BaseActivity;
import com.kuojie.school.school_kuojie.util.ScreenUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * 行政主界面
 */
public class AdminMainActivity extends BaseActivity {


    @BindView(R.id.addmsg)
    ImageView mAddmsg;
    @BindView(R.id.relayout)
    RelativeLayout mRelayout;
    private Unbinder mBind;
    private CustomPopWindow mMCustomPopWindow;
    private Intent intent;
    private String[] adminType = {"sq", "hb", "sj", "bx", "sf", "pk", "rw", "dh"};
    private String[] adminTitle = {"申请", "汇报", "申假", "报销", "申费", "评课", "任务", "调拨"};
    private Class[] adminActivity = {SqActivity.class, HbActivity.class, SjActivity.class, BxActivity.class, SfActivity.class, PkActivity.class, TaskActivity.class, DhActivity.class};
    private ImageView iv_select;
    private DrawerLayout drawerLayout;
    private StackBlurManager _stackBlurManager;


    @Override
    protected void initView() {

        setContentLayout(R.layout.activity_admin_main);
        mBind = ButterKnife.bind(this);
    }


    @Override
    protected void initData() {
        drawerLayout = (DrawerLayout) findViewById(R.id.draw_show);
        iv_select = (ImageView) findViewById(R.id.iv_select);
        iv_select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AdminMainActivity.this, "haha", Toast.LENGTH_SHORT).show();
                drawerLayout.openDrawer(Gravity.RIGHT);
            }
        });
    }

    @OnClick({R.id.addmsg, R.id.relayout})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.addmsg:
                mAddmsg.setVisibility(View.GONE);
                getScreenPthoto();
                popuShow();
                break;
            case R.id.relayout:
                break;
        }
    }

    private void getScreenPthoto() {
        Bitmap bitmap = ScreenUtils.snapShotWithoutStatusBar(this);
        _stackBlurManager = new StackBlurManager(bitmap);
        bitmap = _stackBlurManager.process(50);
        Drawable drawable = new BitmapDrawable(bitmap);
        mRelayout.setBackground(drawable);
    }


    private void popuShow() {

        View contentView = LayoutInflater.from(this).inflate(R.layout.admin_bottom_dialog, null);
        //处理popWindow 显示内容
        handleLogic(contentView);
        //创建并显示popWindow
        mMCustomPopWindow = new CustomPopWindow.PopupWindowBuilder(this)
                .setView(contentView)
                .setAnimationStyle(R.style.CustomPopWindowStyle)
                .size(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
                .setFocusable(false)
                .setOutsideTouchable(true)
                .create()
                .showAtLocation(mAddmsg, Gravity.BOTTOM, 0, 0);


    }

    //初始化布局以及监听事件
    private void handleLogic(View contentView) {
        ImageView tv_close = (ImageView) contentView.findViewById(R.id.admin_close);
        tv_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMCustomPopWindow.dissmiss();
                mAddmsg.setVisibility(View.VISIBLE);
                mRelayout.setBackgroundColor(Color.TRANSPARENT);
//                mAddmsg.setVisibility(View.VISIBLE);
                //背景恢复
                WindowManager.LayoutParams lp = getWindow().getAttributes();
                lp.alpha = 1f;
                getWindow().setAttributes(lp);
            }
        });

        //申请
        ImageView sq = (ImageView) contentView.findViewById(R.id.admin_iv1);
        sq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                whichActivity(0);
            }
        });

        //汇报
        ImageView hb = (ImageView) contentView.findViewById(R.id.admin_iv2);
        hb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                whichActivity(1);
            }
        });

        //申假
        ImageView gg = (ImageView) contentView.findViewById(R.id.admin_iv3);
        gg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                whichActivity(2);
            }
        });

        //报销
        ImageView bx = (ImageView) contentView.findViewById(R.id.admin_iv4);
        bx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                whichActivity(3);
            }
        });
        //申费
        ImageView sf = (ImageView) contentView.findViewById(R.id.admin_iv5);

        sf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                whichActivity(4);
            }
        });
        //评课
        ImageView pk = (ImageView) contentView.findViewById(R.id.admin_iv6);
        setOnMyClick(pk, 5);
        //任务
        ImageView rw = (ImageView) contentView.findViewById(R.id.admin_iv7);
        setOnMyClick(rw, 6);
        //调货
        ImageView dh = (ImageView) contentView.findViewById(R.id.admin_iv8);
        setOnMyClick(dh, 7);


    }

    private void setOnMyClick(View view, final int posotion) {
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                whichActivity(posotion);
            }
        });

    }

    private void whichActivity(int position) {

        intent = new Intent(this, adminActivity[position]);
        intent.putExtra("ADMINMSGTYPE", adminType[position]);
        intent.putExtra("TITLE", adminTitle[position]);

        startActivity(intent);
        mMCustomPopWindow.dissmiss();
        mAddmsg.setVisibility(View.VISIBLE);
        mRelayout.setBackgroundColor(Color.TRANSPARENT);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        mBind.unbind();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }


}
