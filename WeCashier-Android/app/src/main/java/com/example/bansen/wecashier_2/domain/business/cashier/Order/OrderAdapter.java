package com.example.bansen.wecashier_2.domain.business.cashier.Order;

import android.support.annotation.IntegerRes;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.bansen.wecashier_2.R;
import com.example.bansen.wecashier_2.bean.entity.GOODS;
import com.example.bansen.wecashier_2.utills.rxbus.RxBus;

import java.util.ArrayList;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;

/**
 * Created by bansen on 16/12/21.
 *
 * 支持footer 的adpater
 */

public class OrderAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener {

    private ArrayList<GOODS> goodses;

    public static final int ITEM_TYPE_HEADER = 0;
    public static final int ITEM_TYPE_CONTENT = 1;
    public static final int ITEM_TYPE_BOTTOM = 2;

    public int footerNum = 1;

    public OrderAdapter() {
        this.goodses = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            goodses.add(new GOODS());
        }
    }

    public void addData(GOODS goods) {
        goodses.add(goods);
        notifyItemInserted(getDataCount());
    }

    public void removeData(int position){
        goodses.remove(position);

        notifyItemRemoved(position);

        if(position !=getDataCount()){
            notifyItemRangeChanged(position,getDataCount()-position);
        }

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType == ITEM_TYPE_CONTENT){
            OrderItemViewHolder orderItemViewHolder = new OrderItemViewHolder(
                    LayoutInflater.from(parent.getContext())
                            .inflate(R.layout.cashier_goods_item_layout,parent,false)
            );
            Timber.d("生成试图",orderItemViewHolder);
            return orderItemViewHolder;
        }else if(viewType == ITEM_TYPE_BOTTOM){
            FooterViewHolder footerViewHolder = new FooterViewHolder(
                    LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.addgoodsbutton,parent,false)
            );
            return footerViewHolder;
        }
        return null;
    }

    @Override
    public int getItemViewType(int position) {
        if(position >= getDataCount()){
            return ITEM_TYPE_BOTTOM;
        }else {
            return ITEM_TYPE_CONTENT;
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

       if(getItemViewType(position)==ITEM_TYPE_CONTENT){
           Log.e("onBindViewHolder","position="+position);
           ((OrderItemViewHolder)holder).bt_remove.setOnClickListener(this);
           ((OrderItemViewHolder)holder).bt_remove.setTag(position);
           ((OrderItemViewHolder)holder).bt_reduce.setOnClickListener(this);

           ((OrderItemViewHolder)holder).bt_reduce.setTag(position);
           ((OrderItemViewHolder)holder).bt_plus.setOnClickListener(this);
           ((OrderItemViewHolder)holder).bt_plus.setTag(position);

           ((OrderItemViewHolder)holder).tv_barCode.setText(goodses.get(position).getGOODS_NAME());
           ((OrderItemViewHolder)holder).tv_unit.setText(goodses.get(position).getUNIT());
           ((OrderItemViewHolder)holder).tv_tag.setText(goodses.get(position).getTAG());
           ((OrderItemViewHolder)holder).tv_price.setText("" + goodses.get(position).getSELLING_VALUE());
           ((OrderItemViewHolder)holder).tv_num.setText(""+goodses.get(position).getGOODS_NUM());
           ((OrderItemViewHolder)holder).tv_name.setText(goodses.get(position).getGOODS_NAME());
       }else if (getItemViewType(position)==ITEM_TYPE_BOTTOM){
           ((FooterViewHolder)holder).bt_addGood.setTag(position);
           ((FooterViewHolder)holder).bt_addGood.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {

               }
           });
       }
    }

    public int getDataCount(){
        return goodses.size();
    }

    @Override
    public int getItemCount() {
        return goodses.size()+ footerNum;
    }

    @Override
    public void onClick(final View view) {

        if (view.getTag()==null)
            return;
        int position = Integer.valueOf(view.getTag().toString());
        Log.e("view position","="+position);
        if(position == getDataCount()){
            RxBus.getDefault().post(new OrderContract.OrderItemEvent(OrderContract.OrderItemEvent.type.TYPE_ADD,position));
        }else {
            GOODS goods = goodses.get(position);
            switch (view.getId()){
                case R.id.good_item_plus:
                    goods.setGOODS_NUM(goods.getGOODS_NUM()+1);
                    notifyItemChanged(position);
                    break;
                case R.id.good_item_reduce:
                    if (goods.getGOODS_NUM()>0){
                        goods.setGOODS_NUM(goods.getGOODS_NUM()-1);
                        notifyItemChanged(position);
                    }
                    break;
                case R.id.good_item_remove:
                    removeData(position);
                    break;
                default:
                    break;
            }
        }
        Log.e("data count less =",""+getDataCount());
    }

    class OrderItemViewHolder extends RecyclerView.ViewHolder {
        TextView tv_name, tv_barCode, tv_unit, tv_tag, tv_price, tv_num;
        ImageButton bt_plus, bt_remove, bt_reduce;

        public OrderItemViewHolder(View itemView) {
            super(itemView);
            tv_name = (TextView) itemView.findViewById(R.id.good_item_name);
            tv_barCode = (TextView) itemView.findViewById(R.id.good_item_barcode);
            tv_num = (TextView) itemView.findViewById(R.id.good_item_num);
            tv_price = (TextView) itemView.findViewById(R.id.good_item_price);
            tv_tag = (TextView) itemView.findViewById(R.id.good_item_tag);
            tv_unit = (TextView) itemView.findViewById(R.id.good_item_unit);
            bt_plus = (ImageButton) itemView.findViewById(R.id.good_item_plus);
            bt_reduce = (ImageButton) itemView.findViewById(R.id.good_item_reduce);
            bt_remove = (ImageButton) itemView.findViewById(R.id.good_item_remove);
        }
    }

    class FooterViewHolder extends RecyclerView.ViewHolder{

        public Button bt_addGood;
        public FooterViewHolder(View itemView) {
            super(itemView);
            bt_addGood = (Button) itemView.findViewById(R.id.add_goods_button);
        }
    }

    public ArrayList<GOODS> getGoodses() {
        return goodses;
    }
}
