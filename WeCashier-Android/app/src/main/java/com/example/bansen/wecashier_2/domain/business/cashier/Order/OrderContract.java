package com.example.bansen.wecashier_2.domain.business.cashier.Order;

import com.example.bansen.wecashier_2.base.BaseMvpViewImp;
import com.example.bansen.wecashier_2.bean.entity.GOODS;

/**
 * Created by bansen on 16/12/20.
 */

public class OrderContract {
    interface OrderViewImp extends BaseMvpViewImp{
        void addGoodToList(GOODS goods);
    }
    interface OrderPresenterImp{
        void addGood();
    }
    interface OrderModelImp{

    }
    public static class AddItemEvent{
        int id;
        String name;
        public AddItemEvent(int position,String name) {
            this.id= position;
            this.name= name;
        }
        public int getId() {
            return id;
        }
        public String getName() {
            return name;
        }
    }

    public static class OrderItemEvent{
        public static enum type{
            TYPE_ADD,TYPE_REMOVE
        }
        private type mType;

        private int position;


        public OrderItemEvent(type mType, int position) {
            this.mType = mType;
            this.position = position;
        }


        public type getmType() {
            return mType;
        }

        public int getPosition() {
            return position;
        }
    }

}
