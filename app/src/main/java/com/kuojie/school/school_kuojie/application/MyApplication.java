package com.kuojie.school.school_kuojie.application;

import android.app.Application;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;

import com.alibaba.sdk.android.oss.ClientConfiguration;
import com.alibaba.sdk.android.oss.OSS;
import com.alibaba.sdk.android.oss.OSSClient;
import com.alibaba.sdk.android.oss.common.auth.OSSCredentialProvider;
import com.alibaba.sdk.android.oss.common.auth.OSSStsTokenCredentialProvider;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 胡俊焰 on 2017/8/2.q
 */

public class MyApplication extends Application {

    private static MyApplication mApplication;
    /**
     * 用于管理Activity的集合
     */
    private static List<AppCompatActivity> mActivityList = new ArrayList<>();

    public static MyApplication getInstances() {
        if (mApplication == null) {
            mApplication = new MyApplication();
        }
        return mApplication;
    }

    public static SharedPreferences getSharePreferences() {
        SharedPreferences sp = getInstances().getSharedPreferences("school", MODE_PRIVATE);
        return sp;
    }

    @Override
    public void onCreate() {
        super.onCreate();
//        init();
    }

    private void init() {
        /*String endpoint = "http://oss-cn-hangzhou.aliyuncs.com";
// 明文设置secret的方式建议只在测试时使用，更多鉴权模式请参考访问控制章节
        OSSCredentialProvider credentialProvider = new OSSStsTokenCredentialProvider("<StsToken.AccessKeyId>", "<StsToken.SecretKeyId>", "<StsToken.SecurityToken>");
        OSS oss = new OSSClient(getApplicationContext(), endpoint, credentialProvider);*/


        String endpoint = "http://oss-cn-beijing.aliyuncs.com";
// 在移动端建议使用STS的方式初始化OSSClient，更多信息参考：[访问控制]
        OSSCredentialProvider credentialProvider = new OSSStsTokenCredentialProvider("LTAIx3dQ0X7ckrfR", "FxFSahnPiDy9SwIZkWoF5b1tmggAJC ", "<StsToken.SecurityToken>");
        ClientConfiguration conf = new ClientConfiguration();
        conf.setConnectionTimeout(15 * 1000); // 连接超时，默认15秒
        conf.setSocketTimeout(15 * 1000); // socket超时，默认15秒
        conf.setMaxConcurrentRequest(5); // 最大并发请求书，默认5个
        conf.setMaxErrorRetry(2); // 失败后最大重试次数，默认2次
        OSS oss = new OSSClient(getApplicationContext(), endpoint, credentialProvider, conf);
    }

    /**
     * 添加Activity到集合
     *
     * @param activity
     */
    public void addActivity(AppCompatActivity activity) {
        if (!mActivityList.contains(activity)) {
            mActivityList.add(activity);
        }
    }

    /**
     * 从集合中移出Activity
     *
     * @param activity
     */
    public void removeActivity(AppCompatActivity activity) {
        mActivityList.remove(activity);
    }

    /**
     * 对外提供获取Activity集合的方法
     *
     * @return
     */
    public List<AppCompatActivity> getActivityList() {
        if (mActivityList.size() > 0)
            return mActivityList;
        else return null;
    }
}
