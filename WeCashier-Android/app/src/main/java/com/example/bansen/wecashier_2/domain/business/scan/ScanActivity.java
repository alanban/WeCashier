package com.example.bansen.wecashier_2.domain.business.scan;

import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.Loader;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.bansen.wecashier_2.R;
import com.example.bansen.wecashier_2.base.BaseActivity;
import com.example.bansen.wecashier_2.base.PresentLoader;
import com.example.bansen.wecashier_2.base.PresenterFactory;
import com.example.bansen.wecashier_2.bean.entity.GOODS;
import com.example.bansen.wecashier_2.domain.main.MainModel;
import com.example.bansen.wecashier_2.domain.main.MainPresenter;
import com.google.zxing.Result;

import java.util.ArrayList;
import java.util.List;

import com.google.zxing.BarcodeFormat;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnLongClick;
import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class ScanActivity extends BaseActivity<ScanPresenter,ScanContract.ScanViewImp> implements ScanContract.ScanViewImp,
        ZXingScannerView.ResultHandler{

    @BindView(R.id.barinput)
    LinearLayout barinput;
    @BindView(R.id.editText)
    EditText editText;
    @BindView(R.id.goods_name)
    TextView goodsName;
    @BindView(R.id.goods_isAdd)
    TextView goodsIsAdd;
    @BindView(R.id.bar1)
    LinearLayout bar1;
    @BindView(R.id.content_frame)
    FrameLayout contentFrame;



    private ArrayList<GOODS> goodses;
    private ZXingScannerView mScannerView;
    private boolean mFlash;
    private boolean mAutoFocus;
    private int mCameraId = -1;
    @Override
    public void onCreate(Bundle state) {
        super.onCreate(state);

        mCameraId = -1;//后置摄像头
        mFlash = false;
        mAutoFocus = true;

        setContentView(R.layout.activity_scan);
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        ViewGroup contentFrame = (ViewGroup) findViewById(R.id.content_frame);
        mScannerView = new ZXingScannerView(this);
        setupFormats();
        contentFrame.addView(mScannerView);
    }

    @Override
    protected void initData() {
        mScannerView.setResultHandler(this);
        mScannerView.startCamera(mCameraId);
        mScannerView.setFlash(mFlash);
        mScannerView.setAutoFocus(mAutoFocus);
    }
    @Override
    public Loader<ScanPresenter> onCreateLoader(int id, Bundle args) {
        return new PresentLoader<>(this, new PresenterFactory<ScanPresenter>() {
            @Override
            public ScanPresenter crate() {
                return new ScanPresenter(new ScanModel());
            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

    }



    @Override
    public void handleResult(Result rawResult) {
        try {
            Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
            Ringtone r = RingtoneManager.getRingtone(getApplicationContext(), notification);
            r.play();
        } catch (Exception e) {}
//        showMessageDialog("Contents = " + rawResult.getText() + ", Format = " + rawResult.getBarcodeFormat().toString());
    }





    public void setupFormats() {
        List<BarcodeFormat> formats = new ArrayList<>();
        formats.add(0,BarcodeFormat.EAN_13);
        if(mScannerView != null) {
            mScannerView.setFormats(formats);
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        mScannerView.stopCamera();
    }

    /**
     * 手动添加商品
     */
    @OnClick(R.id.addBarcode) void onAddBarcodeClick() {
        //TODO implement
    }



    @OnClick(R.id.Open_camera_light) void onOpenCameraLightClick() {
        //TODO implement
    }



    @OnClick(R.id.confuse) void onConfuseClick() {
        //TODO implement
    }


}
