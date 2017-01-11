package com.example.bansen.wecashier_2.bean.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Transient;

import java.lang.ref.PhantomReference;
import java.util.Date;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by bansen on 16/12/19.
 */
@Entity
public class ORDER {

    @Transient
    private GOODS[] goodses;

    @Id(autoincrement = true)
    private long ID;
    @NotNull
    private String OR_GOODS_LIST; //SPLIT -> "|"
    @NotNull
    private Date OR_SELL_DATE;
    @NotNull
    private Double OR_SUM_PRICE; //应收金额
    @NotNull
    private Double OR_MONEY_RECVD; //已收金额
    @Generated(hash = 174322221)
    public ORDER(long ID, @NotNull String OR_GOODS_LIST, @NotNull Date OR_SELL_DATE,
            @NotNull Double OR_SUM_PRICE, @NotNull Double OR_MONEY_RECVD) {
        this.ID = ID;
        this.OR_GOODS_LIST = OR_GOODS_LIST;
        this.OR_SELL_DATE = OR_SELL_DATE;
        this.OR_SUM_PRICE = OR_SUM_PRICE;
        this.OR_MONEY_RECVD = OR_MONEY_RECVD;
    }
    @Generated(hash = 149208096)
    public ORDER() {
    }
    public long getID() {
        return this.ID;
    }
    public void setID(long ID) {
        this.ID = ID;
    }
    public String getOR_GOODS_LIST() {
        return this.OR_GOODS_LIST;
    }
    public void setOR_GOODS_LIST(String OR_GOODS_LIST) {
        this.OR_GOODS_LIST = OR_GOODS_LIST;
    }
    public Date getOR_SELL_DATE() {
        return this.OR_SELL_DATE;
    }
    public void setOR_SELL_DATE(Date OR_SELL_DATE) {
        this.OR_SELL_DATE = OR_SELL_DATE;
    }
    public Double getOR_SUM_PRICE() {
        return this.OR_SUM_PRICE;
    }
    public void setOR_SUM_PRICE(Double OR_SUM_PRICE) {
        this.OR_SUM_PRICE = OR_SUM_PRICE;
    }
    public Double getOR_MONEY_RECVD() {
        return this.OR_MONEY_RECVD;
    }
    public void setOR_MONEY_RECVD(Double OR_MONEY_RECVD) {
        this.OR_MONEY_RECVD = OR_MONEY_RECVD;
    }
    

}
