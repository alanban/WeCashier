package com.example.bansen.wecashier_2.bean.gen;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.example.bansen.wecashier_2.bean.entity.GOODS;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "GOODS".
*/
public class GOODSDao extends AbstractDao<GOODS, Long> {

    public static final String TABLENAME = "GOODS";

    /**
     * Properties of entity GOODS.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property GOODS_NO = new Property(0, long.class, "GOODS_NO", true, "_id");
        public final static Property MAIN_BARCODE = new Property(1, String.class, "MAIN_BARCODE", false, "MAIN__BARCODE");
        public final static Property GOODS_NAME = new Property(2, String.class, "GOODS_NAME", false, "GOODS__NAME");
        public final static Property TAG = new Property(3, String.class, "TAG", false, "TAG");
        public final static Property BRAND = new Property(4, String.class, "BRAND", false, "BRAND");
        public final static Property PROPERTY = new Property(5, String.class, "PROPERTY", false, "PROPERTY");
        public final static Property UNIT = new Property(6, String.class, "UNIT", false, "UNIT");
        public final static Property ACQUISITION_VALUE = new Property(7, double.class, "ACQUISITION_VALUE", false, "ACQUISITION__VALUE");
        public final static Property SELLING_VALUE = new Property(8, double.class, "SELLING_VALUE", false, "SELLING__VALUE");
        public final static Property ABSTRACT = new Property(9, String.class, "ABSTRACT", false, "ABSTRACT");
        public final static Property IS_OFF = new Property(10, int.class, "IS_OFF", false, "IS__OFF");
        public final static Property HOW_MUCH_OFF = new Property(11, Double.class, "HOW_MUCH_OFF", false, "HOW__MUCH__OFF");
        public final static Property INVENTORY = new Property(12, int.class, "INVENTORY", false, "INVENTORY");
        public final static Property OFF_START_DATE = new Property(13, java.util.Date.class, "OFF_START_DATE", false, "OFF__START__DATE");
        public final static Property OFF_END_DATE = new Property(14, java.util.Date.class, "OFF_END_DATE", false, "OFF__END__DATE");
    }


    public GOODSDao(DaoConfig config) {
        super(config);
    }
    
    public GOODSDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"GOODS\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL ," + // 0: GOODS_NO
                "\"MAIN__BARCODE\" TEXT NOT NULL ," + // 1: MAIN_BARCODE
                "\"GOODS__NAME\" TEXT NOT NULL ," + // 2: GOODS_NAME
                "\"TAG\" TEXT," + // 3: TAG
                "\"BRAND\" TEXT," + // 4: BRAND
                "\"PROPERTY\" TEXT," + // 5: PROPERTY
                "\"UNIT\" TEXT," + // 6: UNIT
                "\"ACQUISITION__VALUE\" REAL NOT NULL ," + // 7: ACQUISITION_VALUE
                "\"SELLING__VALUE\" REAL NOT NULL ," + // 8: SELLING_VALUE
                "\"ABSTRACT\" TEXT," + // 9: ABSTRACT
                "\"IS__OFF\" INTEGER NOT NULL ," + // 10: IS_OFF
                "\"HOW__MUCH__OFF\" REAL," + // 11: HOW_MUCH_OFF
                "\"INVENTORY\" INTEGER NOT NULL ," + // 12: INVENTORY
                "\"OFF__START__DATE\" INTEGER NOT NULL ," + // 13: OFF_START_DATE
                "\"OFF__END__DATE\" INTEGER NOT NULL );"); // 14: OFF_END_DATE
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"GOODS\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, GOODS entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getGOODS_NO());
        stmt.bindString(2, entity.getMAIN_BARCODE());
        stmt.bindString(3, entity.getGOODS_NAME());
 
        String TAG = entity.getTAG();
        if (TAG != null) {
            stmt.bindString(4, TAG);
        }
 
        String BRAND = entity.getBRAND();
        if (BRAND != null) {
            stmt.bindString(5, BRAND);
        }
 
        String PROPERTY = entity.getPROPERTY();
        if (PROPERTY != null) {
            stmt.bindString(6, PROPERTY);
        }
 
        String UNIT = entity.getUNIT();
        if (UNIT != null) {
            stmt.bindString(7, UNIT);
        }
        stmt.bindDouble(8, entity.getACQUISITION_VALUE());
        stmt.bindDouble(9, entity.getSELLING_VALUE());
 
        String ABSTRACT = entity.getABSTRACT();
        if (ABSTRACT != null) {
            stmt.bindString(10, ABSTRACT);
        }
        stmt.bindLong(11, entity.getIS_OFF());
 
        Double HOW_MUCH_OFF = entity.getHOW_MUCH_OFF();
        if (HOW_MUCH_OFF != null) {
            stmt.bindDouble(12, HOW_MUCH_OFF);
        }
        stmt.bindLong(13, entity.getINVENTORY());
        stmt.bindLong(14, entity.getOFF_START_DATE().getTime());
        stmt.bindLong(15, entity.getOFF_END_DATE().getTime());
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, GOODS entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getGOODS_NO());
        stmt.bindString(2, entity.getMAIN_BARCODE());
        stmt.bindString(3, entity.getGOODS_NAME());
 
        String TAG = entity.getTAG();
        if (TAG != null) {
            stmt.bindString(4, TAG);
        }
 
        String BRAND = entity.getBRAND();
        if (BRAND != null) {
            stmt.bindString(5, BRAND);
        }
 
        String PROPERTY = entity.getPROPERTY();
        if (PROPERTY != null) {
            stmt.bindString(6, PROPERTY);
        }
 
        String UNIT = entity.getUNIT();
        if (UNIT != null) {
            stmt.bindString(7, UNIT);
        }
        stmt.bindDouble(8, entity.getACQUISITION_VALUE());
        stmt.bindDouble(9, entity.getSELLING_VALUE());
 
        String ABSTRACT = entity.getABSTRACT();
        if (ABSTRACT != null) {
            stmt.bindString(10, ABSTRACT);
        }
        stmt.bindLong(11, entity.getIS_OFF());
 
        Double HOW_MUCH_OFF = entity.getHOW_MUCH_OFF();
        if (HOW_MUCH_OFF != null) {
            stmt.bindDouble(12, HOW_MUCH_OFF);
        }
        stmt.bindLong(13, entity.getINVENTORY());
        stmt.bindLong(14, entity.getOFF_START_DATE().getTime());
        stmt.bindLong(15, entity.getOFF_END_DATE().getTime());
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.getLong(offset + 0);
    }    

    @Override
    public GOODS readEntity(Cursor cursor, int offset) {
        GOODS entity = new GOODS( //
            cursor.getLong(offset + 0), // GOODS_NO
            cursor.getString(offset + 1), // MAIN_BARCODE
            cursor.getString(offset + 2), // GOODS_NAME
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // TAG
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // BRAND
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // PROPERTY
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // UNIT
            cursor.getDouble(offset + 7), // ACQUISITION_VALUE
            cursor.getDouble(offset + 8), // SELLING_VALUE
            cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9), // ABSTRACT
            cursor.getInt(offset + 10), // IS_OFF
            cursor.isNull(offset + 11) ? null : cursor.getDouble(offset + 11), // HOW_MUCH_OFF
            cursor.getInt(offset + 12), // INVENTORY
            new java.util.Date(cursor.getLong(offset + 13)), // OFF_START_DATE
            new java.util.Date(cursor.getLong(offset + 14)) // OFF_END_DATE
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, GOODS entity, int offset) {
        entity.setGOODS_NO(cursor.getLong(offset + 0));
        entity.setMAIN_BARCODE(cursor.getString(offset + 1));
        entity.setGOODS_NAME(cursor.getString(offset + 2));
        entity.setTAG(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setBRAND(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setPROPERTY(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setUNIT(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setACQUISITION_VALUE(cursor.getDouble(offset + 7));
        entity.setSELLING_VALUE(cursor.getDouble(offset + 8));
        entity.setABSTRACT(cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9));
        entity.setIS_OFF(cursor.getInt(offset + 10));
        entity.setHOW_MUCH_OFF(cursor.isNull(offset + 11) ? null : cursor.getDouble(offset + 11));
        entity.setINVENTORY(cursor.getInt(offset + 12));
        entity.setOFF_START_DATE(new java.util.Date(cursor.getLong(offset + 13)));
        entity.setOFF_END_DATE(new java.util.Date(cursor.getLong(offset + 14)));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(GOODS entity, long rowId) {
        entity.setGOODS_NO(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(GOODS entity) {
        if(entity != null) {
            return entity.getGOODS_NO();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(GOODS entity) {
        throw new UnsupportedOperationException("Unsupported for entities with a non-null key");
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
