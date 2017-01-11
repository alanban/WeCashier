package com.example.bansen.wecashier_2.utills;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.Toast;

/**
 * Created by alan on 2016/1/17.
 */
public class ToastUtil {
    /*  第一次使用时
        1 getToastUtil获取到ToastUtil
        2 需设置Context
     */
    public static  ToastUtil toastUtil;
    public static Context mycontext;

    private ToastUtil(){

    }
    public static ToastUtil getToastUtil(Context context){
        if (toastUtil==null){
            toastUtil=new ToastUtil();
        }
        mycontext = context;
        return toastUtil;
    }
    public  void SetContext(Context context){
        mycontext=context;
    }
    public void MakeAShortToast(String string){
        Toast.makeText(mycontext,string,Toast.LENGTH_SHORT).show();
    }
    public void MakeALongToast(String string){
        Toast.makeText(mycontext,string,Toast.LENGTH_LONG).show();
    }
    public void ShowSnakeBar(View view, String show){
        Snackbar.make(view, show, Snackbar.LENGTH_LONG).show();
    }

}
