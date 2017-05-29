package com.orange.cc.activity;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.GLSurfaceView;

import com.orange.cc.AppActivityManager;
import com.orange.cc.BaseActivity;
import com.orange.cc.R;

import java.io.IOException;
import java.io.InputStream;

import butterknife.BindView;
import butterknife.ButterKnife;
import jp.co.cyberagent.android.gpuimage.GPUImage;
import jp.co.cyberagent.android.gpuimage.GPUImageGaussianBlurFilter;


public class MainActivity extends BaseActivity {

    @BindView(R.id.showImage)
    GLSurfaceView showImage;
    private GPUImage mGPUImage;
    private Bitmap bitmap = null;


    @Override
    public void initView() {
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @Override
    public void initInstall() {
        AppActivityManager.getAppManager().addActivity(this);
        mGPUImage = new GPUImage(this);
        mGPUImage.setGLSurfaceView(showImage);
    }

    @Override
    public void initData() {
        openNativeImage();
        mGPUImage.setFilter(new GPUImageGaussianBlurFilter());
        showImage();
    }

    @Override
    public void evenControl() {

    }


    private void showImage() {
//        bitmap = mGPUImage.getBitmapWithFilterApplied();
        mGPUImage.setImage(bitmap);
    }

    private void openNativeImage() {
        AssetManager asset = this.getAssets();
        try {
            InputStream is = asset.open("showing.jpeg");
            bitmap = BitmapFactory.decodeStream(is);
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }





}
