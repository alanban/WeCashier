package com.example.bansen.wecashier_2.utills.rxbluetooth;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.functions.Action;
import io.reactivex.functions.Cancellable;

/**
 * Created by bansen on 16/12/28.
 *
 * 使用以下权限
 * <uses-permission android:name="android.permission.BLUETOOTH" />
 * <uses-permission android:name="android.permission.BLUETOOTH_ADMIN" />
 */

public class RxBlueTooth {

    private static RxBlueTooth instance;

    private Context mContext;

    private BluetoothAdapter mBluetoothAdapter;

    public RxBlueTooth(Context context) {
        mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        mContext = context;
    }

    public void setmContext(Context mContext) {
        this.mContext = mContext;
    }

    public static RxBlueTooth getInstance(Context context) {
        if (instance==null){
            synchronized (RxBlueTooth.class){
                if (instance==null)
                    instance = new RxBlueTooth(context);
            }
        }
        instance.setmContext(context);
        return instance;
    }

    /**
     * 监测设备是否拥有设备
     * @return 当设备无蓝牙模块 返回false 反之
     */
    public boolean checkDeviceOwnBL(){
        return mBluetoothAdapter!=null & mBluetoothAdapter.getAddress().isEmpty();
    }

    /**
     * 是否开启蓝牙中
     * @return
     */
    public boolean isEnableBL(){
        return mBluetoothAdapter.isEnabled();
    }

    /**
     *
     * @return 开启蓝牙
     */
    public RxBlueTooth EnableDeviceBL(){
        mContext.startActivity(new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE));
        return instance;
    }



    public Observable<String> observeDiscovery(){
        return Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(final ObservableEmitter<String> e) throws Exception {
                final BroadcastReceiver deviceReceiver = new BroadcastReceiver() {
                    @Override
                    public void onReceive(Context context, Intent intent) {
                        e.onNext(intent.getAction());
                    }
                };

                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction(BluetoothAdapter.ACTION_DISCOVERY_STARTED);
                intentFilter.addAction(BluetoothAdapter.ACTION_DISCOVERY_FINISHED);

                mContext.registerReceiver(deviceReceiver,intentFilter);
                mBluetoothAdapter.startDiscovery();
                e.setCancellable(new Cancellable() {
                    @Override
                    public void cancel() throws Exception {
                        Log.e("rxBL","取消了搜索");
                        mContext.unregisterReceiver(deviceReceiver);
                    }
                });
            }
        });
    }

    /**
     * 监听设备扫描结果
     * @return
     */
    public Observable<BluetoothDevice> observeDevice(){
        return new Observable<BluetoothDevice>() {
            @Override
            protected void subscribeActual(Observer<? super BluetoothDevice> observer) {
                BroadcastReceiver BLReciver = new BroadcastReceiver() {
                    @Override
                    public void onReceive(Context context, Intent intent) {

                    }
                };
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction(BluetoothAdapter.ACTION_DISCOVERY_STARTED);
                intentFilter.addAction(BluetoothAdapter.ACTION_DISCOVERY_FINISHED);

                mContext.registerReceiver(BLReciver,intentFilter);
            }
        };
    }

    public void UnDiscovery(){

    }

}
