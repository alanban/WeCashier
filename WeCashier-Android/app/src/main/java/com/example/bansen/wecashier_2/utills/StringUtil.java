package com.example.bansen.wecashier_2.utills;

/**
 * Created by alan on 2016/4/4.
 */
public class StringUtil {
    public static boolean IsNumber(String string){
        for(int i=0;i<string.length();i++){
            if(!Character.isDigit(string.charAt(i))){
                return false;
            }
        }
        return true;
    }

    /**
     *
     * @param month
     * @return
     */
    public static String getFormatMonth(String month){
        int month_f = Integer.valueOf(month);
        if(month.length()>1){
            return month;
        }else if(month.length() ==1) {
            StringBuilder sb = new StringBuilder(month);
            sb.insert(0,"0");
            return sb.toString();
        }
        else {
            return month;
        }
    }
}
