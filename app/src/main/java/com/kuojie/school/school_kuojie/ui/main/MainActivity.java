package com.kuojie.school.school_kuojie.ui.main;

import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.alibaba.sdk.android.oss.ClientException;
import com.alibaba.sdk.android.oss.OSS;
import com.alibaba.sdk.android.oss.OSSClient;
import com.alibaba.sdk.android.oss.ServiceException;
import com.alibaba.sdk.android.oss.callback.OSSCompletedCallback;
import com.alibaba.sdk.android.oss.callback.OSSProgressCallback;
import com.alibaba.sdk.android.oss.common.auth.OSSCredentialProvider;
import com.alibaba.sdk.android.oss.common.auth.OSSStsTokenCredentialProvider;
import com.alibaba.sdk.android.oss.internal.OSSAsyncTask;
import com.alibaba.sdk.android.oss.model.PutObjectRequest;
import com.alibaba.sdk.android.oss.model.PutObjectResult;
import com.baoyz.actionsheet.ActionSheet;
import com.kuojie.school.school_kuojie.R;
import com.kuojie.school.school_kuojie.base.BaseActivity;
import com.kuojie.school.school_kuojie.util.KouJieConfig;
import com.kuojie.school.school_kuojie.util.SystemPhotoUtils;

import java.util.List;
import java.util.Random;
import java.util.UUID;

import cn.finalteam.galleryfinal.GalleryFinal;
import cn.finalteam.galleryfinal.model.PhotoInfo;

public class MainActivity extends BaseActivity implements ActionSheet.ActionSheetListener {


    private static final int REQUEST_CODE_CAMERA = 100;
    private static final int REQUEST_CODE_GALLERY = 101;
    private String mEndpoint;
    private String mFilename;
    private GalleryFinal.OnHanlderResultCallback mOnHanlderResultCallback = new GalleryFinal.OnHanlderResultCallback() {
        @Override
        public void onHanlderSuccess(int reqeustCode, List<PhotoInfo> resultList) {
            if (resultList != null) {
                PhotoInfo photoInfo = resultList.get(0);

                upImage(photoInfo.getPhotoPath());
                getfileName();
            }
        }

        @Override
        public void onHanlderFailure(int requestCode, String errorMsg) {
            Toast.makeText(getApplication(), errorMsg, Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    protected void initView() {
        setContentLayout(R.layout.activity_main);
    }

    public void updatefile(View view) {
        //初始化配置
        SystemPhotoUtils.initGalleryFinal(this, 1, true);
        ActionSheet.createBuilder(this, getSupportFragmentManager())
                .setCancelButtonTitle("取消")
                .setOtherButtonTitles("拍照", "从相册中选取")
                .setCancelableOnTouchOutside(true)
                .setListener(this).show();

    }

    @Override
    protected void initData() {


    }

    @Override
    public void onDismiss(ActionSheet actionSheet, boolean isCancel) {

    }

    @Override
    public void onOtherButtonClick(ActionSheet actionSheet, int index) {

        chooseImage(index);
    }

    /**
     * 根据索引值选取图片
     * 0 拍照选取
     * 1 相册选取
     *
     * @param index
     */
    private void chooseImage(int index) {

        switch (index) {
            case 0:

                GalleryFinal.openCamera(REQUEST_CODE_CAMERA, mOnHanlderResultCallback);
                break;

            case 1:
                GalleryFinal.openGallerySingle(REQUEST_CODE_GALLERY, mOnHanlderResultCallback);
                break;
        }

    }

    private void upImage(String photoPath) {
        mFilename = getfileName() + ".png";
        mEndpoint = "oss-cn-hangzhou.aliyuncs.com";
// 在移动端建议使用STS方式初始化OSSClient。更多鉴权模式请参考后面的`访问控制`章节
        OSSCredentialProvider credentialProvider = new OSSStsTokenCredentialProvider("LTAIx3dQ0X7ckrfR", "FxFSahnPiDy9SwIZkWoF5b1tmggAJC ", "");
        OSS oss = new OSSClient(getApplicationContext(), KouJieConfig.HTTP + mEndpoint, credentialProvider);

        // 构造上传请求
        PutObjectRequest put = new PutObjectRequest(KouJieConfig.BUKKETNAME, mFilename, photoPath);
// 异步上传时可以设置进度回调
      /*  put.setProgressCallback(new OSSProgressCallback<PutObjectRequest>() {
            @Override
            public void onProgress(PutObjectRequest request, long currentSize, long totalSize) {
                Log.d("PutObject", "currentSize: " + currentSize + " totalSize: " + totalSize);
            }
        });*/

        put.setProgressCallback(new OSSProgressCallback<PutObjectRequest>() {
            @Override
            public void onProgress(PutObjectRequest request, long currentSize, long totalSize) {

                Log.d("PutObject", "currentSize: " + currentSize + " totalSize: " + totalSize);

            }
        });


        OSSAsyncTask task = oss.asyncPutObject(put, new OSSCompletedCallback<PutObjectRequest, PutObjectResult>() {
            @Override
            public void onSuccess(PutObjectRequest request, PutObjectResult result) {
                Log.d("PutObject", "UploadSuccess");
                Log.d("name", KouJieConfig.HTTP + KouJieConfig.BUKKETNAME + mEndpoint + "/" + mFilename);
            }

            @Override
            public void onFailure(PutObjectRequest request, ClientException clientExcepion, ServiceException serviceException) {
                // 请求异常
                if (clientExcepion != null) {
                    // 本地异常如网络异常等
                    clientExcepion.printStackTrace();
                }
                if (serviceException != null) {
                    // 服务异常
                    Log.e("ErrorCode", serviceException.getErrorCode());
                    Log.e("RequestId", serviceException.getRequestId());
                    Log.e("HostId", serviceException.getHostId());
                    Log.e("RawMessage", serviceException.getRawMessage());
                }
            }
        });


    }


    public String getfileName() {
        UUID uuid = UUID.randomUUID();
        String str = uuid.toString();
        String uuidStr = str.replace("-", "");

        Random rm = new Random();

        // 获得随机数
        double pross = (1 + rm.nextDouble()) * Math.pow(10, 6);

        // 将获得的获得随机数转化为字符串
        String fixLenthString = String.valueOf(pross);

        /*// 返回固定的长度的随机数
        return fixLenthString.substring(1, 5 + 1);*/
        return uuidStr + fixLenthString.substring(1, 6 + 1);
    }
}
