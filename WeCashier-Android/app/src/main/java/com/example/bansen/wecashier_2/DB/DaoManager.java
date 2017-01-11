package com.example.bansen.wecashier_2.DB;

import android.content.Context;

import com.example.bansen.wecashier_2.bean.gen.DaoMaster;
import com.example.bansen.wecashier_2.bean.gen.DaoSession;

import org.greenrobot.greendao.database.Database;

/**
 * Created by bansen on 16/12/19.
 */

public class DaoManager {

    private static volatile DaoManager daoManager;

    private Database db;
    private DaoSession session;
    private DaoMaster.DevOpenHelper helper;

    public static DaoManager getInstance() {
        if (daoManager == null) {
            synchronized (DaoManager.class) {
                if (daoManager == null)
                    daoManager = new DaoManager();
            }
        }
        return daoManager;
    }

    private DaoManager() {

    }

    public void init(Context context) {
        helper = new DaoMaster.DevOpenHelper(context, "weCashier-db", null);
        db = helper.getWritableDb();
        session = new DaoMaster(db).newSession();
    }

    public DaoSession getSession() {
        return session;
    }
}
