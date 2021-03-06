package com.example.bansen.wecashier_2.bean.gen;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.example.bansen.wecashier_2.bean.entity.ORDER;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "ORDER".
*/
public class ORDERDao extends AbstractDao<ORDER, Long> {

    public static final String TABLENAME = "ORDER";

    /**
     * Properties of entity ORDER.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property ID = new Property(0, long.class, "ID", true, "_id");
        public final static Property OR_GOODS_LIST = new Property(1, String.class, "OR_GOODS_LIST", false, "OR__GOODS__LIST");
        public final static Property OR_SELL_DATE = new Property(2, java.util.Date.class, "OR_SELL_DATE", false, "OR__SELL__DATE");
        public final static Property OR_SUM_PRICE = new Property(3, Double.class, "OR_SUM_PRICE", false, "OR__SUM__PRICE");
        public final static Property OR_MONEY_RECVD = new Property(4, Double.class, "OR_MONEY_RECVD", false, "OR__MONEY__RECVD");
    }


    public ORDERDao(DaoConfig config) {
        super(config);
    }
    
    public ORDERDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"ORDER\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL ," + // 0: ID
                "\"OR__GOODS__LIST\" TEXT NOT NULL ," + // 1: OR_GOODS_LIST
                "\"OR__SELL__DATE\" INTEGER NOT NULL ," + // 2: OR_SELL_DATE
                "\"OR__SUM__PRICE\" REAL NOT NULL ," + // 3: OR_SUM_PRICE
                "\"OR__MONEY__RECVD\" REAL NOT NULL );"); // 4: OR_MONEY_RECVD
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"ORDER\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, ORDER entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getID());
        stmt.bindString(2, entity.getOR_GOODS_LIST());
        stmt.bindLong(3, entity.getOR_SELL_DATE().getTime());
        stmt.bindDouble(4, entity.getOR_SUM_PRICE());
        stmt.bindDouble(5, entity.getOR_MONEY_RECVD());
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, ORDER entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getID());
        stmt.bindString(2, entity.getOR_GOODS_LIST());
        stmt.bindLong(3, entity.getOR_SELL_DATE().getTime());
        stmt.bindDouble(4, entity.getOR_SUM_PRICE());
        stmt.bindDouble(5, entity.getOR_MONEY_RECVD());
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.getLong(offset + 0);
    }    

    @Override
    public ORDER readEntity(Cursor cursor, int offset) {
        ORDER entity = new ORDER( //
            cursor.getLong(offset + 0), // ID
            cursor.getString(offset + 1), // OR_GOODS_LIST
            new java.util.Date(cursor.getLong(offset + 2)), // OR_SELL_DATE
            cursor.getDouble(offset + 3), // OR_SUM_PRICE
            cursor.getDouble(offset + 4) // OR_MONEY_RECVD
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, ORDER entity, int offset) {
        entity.setID(cursor.getLong(offset + 0));
        entity.setOR_GOODS_LIST(cursor.getString(offset + 1));
        entity.setOR_SELL_DATE(new java.util.Date(cursor.getLong(offset + 2)));
        entity.setOR_SUM_PRICE(cursor.getDouble(offset + 3));
        entity.setOR_MONEY_RECVD(cursor.getDouble(offset + 4));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(ORDER entity, long rowId) {
        entity.setID(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(ORDER entity) {
        if(entity != null) {
            return entity.getID();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(ORDER entity) {
        throw new UnsupportedOperationException("Unsupported for entities with a non-null key");
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
