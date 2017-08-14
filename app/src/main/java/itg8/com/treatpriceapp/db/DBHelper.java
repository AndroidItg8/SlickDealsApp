package itg8.com.treatpriceapp.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.io.File;
import java.io.InputStream;
import java.sql.SQLException;

import itg8.com.treatpriceapp.db.tbl.TblCategory;
import itg8.com.treatpriceapp.db.tbl.TblMerchantType;

/**
 * Created by itg_Android on 8/11/2017.
 */

public class DBHelper extends OrmLiteSqliteOpenHelper {

    public static final String DB_NAME = "TreatPriceDb.db";
    private static final int DB_VERSION = 1;

    private Dao<TblCategory,String> categoryDao;
    private Dao<TblMerchantType,String> merchantTypeDao;

    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }



    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource,TblCategory.class);
            TableUtils.createTable(connectionSource,TblMerchantType.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {
            TableUtils.dropTable(connectionSource,TblCategory.class,true);
            TableUtils.dropTable(connectionSource,TblMerchantType.class,true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Dao<TblCategory, String> getCategoryDao() throws SQLException {
        if(categoryDao==null){
            categoryDao=getDao(TblCategory.class);
        }
        return categoryDao;
    }

    public Dao<TblMerchantType, String> getMerchantTypeDao()  throws SQLException{
        if(merchantTypeDao==null)
            merchantTypeDao=getDao(TblMerchantType.class);

        return merchantTypeDao;
    }
}
