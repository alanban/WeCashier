package com.example.bansen.wecashier_2.bean.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;

import java.util.Date;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Transient;

@Entity
public class GOODS {
    @Id(autoincrement = true )
    public long GOODS_NO ;
    @NotNull
    public String MAIN_BARCODE = "主条码";
    @NotNull
    public String GOODS_NAME = "商品名称";
    public String TAG = "商品类别";//商品类别
    public String BRAND = "品牌";
    public String PROPERTY = "商品属性";
    public String UNIT = "单位";
    @NotNull
    public double ACQUISITION_VALUE = 0.0;//进价
    @NotNull
    public double SELLING_VALUE = 0.0;//售价
    public String ABSTRACT = "商品简介";
    @NotNull
    public int IS_OFF = 0; //是否特价 0->FALSE  1->TRUE
    public Double HOW_MUCH_OFF = 0.0; //特价规则  98% ->98折
    public int INVENTORY = 0;//库存
    @NotNull
    public Date OFF_START_DATE =new Date(System.currentTimeMillis());//促销起始时间
    @NotNull
    public Date OFF_END_DATE =new Date(System.currentTimeMillis());
    @Transient
    public int GOODS_NUM;
    @Generated(hash = 1886322694)
    public GOODS(long GOODS_NO, @NotNull String MAIN_BARCODE,
            @NotNull String GOODS_NAME, String TAG, String BRAND, String PROPERTY,
            String UNIT, double ACQUISITION_VALUE, double SELLING_VALUE,
            String ABSTRACT, int IS_OFF, Double HOW_MUCH_OFF, int INVENTORY,
            @NotNull Date OFF_START_DATE, @NotNull Date OFF_END_DATE) {
        this.GOODS_NO = GOODS_NO;
        this.MAIN_BARCODE = MAIN_BARCODE;
        this.GOODS_NAME = GOODS_NAME;
        this.TAG = TAG;
        this.BRAND = BRAND;
        this.PROPERTY = PROPERTY;
        this.UNIT = UNIT;
        this.ACQUISITION_VALUE = ACQUISITION_VALUE;
        this.SELLING_VALUE = SELLING_VALUE;
        this.ABSTRACT = ABSTRACT;
        this.IS_OFF = IS_OFF;
        this.HOW_MUCH_OFF = HOW_MUCH_OFF;
        this.INVENTORY = INVENTORY;
        this.OFF_START_DATE = OFF_START_DATE;
        this.OFF_END_DATE = OFF_END_DATE;
    }
    @Generated(hash = 379204778)
    public GOODS() {
    }
    public long getGOODS_NO() {
        return this.GOODS_NO;
    }
    public void setGOODS_NO(long GOODS_NO) {
        this.GOODS_NO = GOODS_NO;
    }
    public String getMAIN_BARCODE() {
        return this.MAIN_BARCODE;
    }
    public void setMAIN_BARCODE(String MAIN_BARCODE) {
        this.MAIN_BARCODE = MAIN_BARCODE;
    }
    public String getGOODS_NAME() {
        return this.GOODS_NAME;
    }
    public void setGOODS_NAME(String GOODS_NAME) {
        this.GOODS_NAME = GOODS_NAME;
    }
    public String getTAG() {
        return this.TAG;
    }
    public void setTAG(String TAG) {
        this.TAG = TAG;
    }
    public String getBRAND() {
        return this.BRAND;
    }
    public void setBRAND(String BRAND) {
        this.BRAND = BRAND;
    }
    public String getPROPERTY() {
        return this.PROPERTY;
    }
    public void setPROPERTY(String PROPERTY) {
        this.PROPERTY = PROPERTY;
    }
    public String getUNIT() {
        return this.UNIT;
    }
    public void setUNIT(String UNIT) {
        this.UNIT = UNIT;
    }
    public double getACQUISITION_VALUE() {
        return this.ACQUISITION_VALUE;
    }
    public void setACQUISITION_VALUE(double ACQUISITION_VALUE) {
        this.ACQUISITION_VALUE = ACQUISITION_VALUE;
    }
    public double getSELLING_VALUE() {
        return this.SELLING_VALUE;
    }
    public void setSELLING_VALUE(double SELLING_VALUE) {
        this.SELLING_VALUE = SELLING_VALUE;
    }
    public String getABSTRACT() {
        return this.ABSTRACT;
    }
    public void setABSTRACT(String ABSTRACT) {
        this.ABSTRACT = ABSTRACT;
    }
    public int getIS_OFF() {
        return this.IS_OFF;
    }
    public void setIS_OFF(int IS_OFF) {
        this.IS_OFF = IS_OFF;
    }
    public Double getHOW_MUCH_OFF() {
        return this.HOW_MUCH_OFF;
    }
    public void setHOW_MUCH_OFF(Double HOW_MUCH_OFF) {
        this.HOW_MUCH_OFF = HOW_MUCH_OFF;
    }
    public int getINVENTORY() {
        return this.INVENTORY;
    }
    public void setINVENTORY(int INVENTORY) {
        this.INVENTORY = INVENTORY;
    }
    public Date getOFF_START_DATE() {
        return this.OFF_START_DATE;
    }
    public void setOFF_START_DATE(Date OFF_START_DATE) {
        this.OFF_START_DATE = OFF_START_DATE;
    }
    public Date getOFF_END_DATE() {
        return this.OFF_END_DATE;
    }
    public void setOFF_END_DATE(Date OFF_END_DATE) {
        this.OFF_END_DATE = OFF_END_DATE;
    }

    public int getGOODS_NUM() {
        return GOODS_NUM;
    }

    public void setGOODS_NUM(int GOODS_NUM) {
        this.GOODS_NUM = GOODS_NUM;
    }
}