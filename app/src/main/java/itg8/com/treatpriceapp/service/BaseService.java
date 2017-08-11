package itg8.com.treatpriceapp.service;

import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.j256.ormlite.android.apptools.OrmLiteBaseService;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.List;

import itg8.com.treatpriceapp.common.Logger;
import itg8.com.treatpriceapp.common.MyApplication;
import itg8.com.treatpriceapp.db.DBHelper;
import itg8.com.treatpriceapp.db.tbl.TblCategory;

/**
 * Created by itg_Android on 8/11/2017.
 */

public class BaseService extends OrmLiteBaseService<DBHelper> implements DownloadManager {

    private Dao<TblCategory, String> catDao;
    private DownloadManagerImp manager;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        try {
            catDao=getHelper().getCategoryDao();
            manager=new DownloadManagerImp(this);
            manager.downloadCategories();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCategoryDownloadComplete(List<TblCategory> tblCategories) {
//        MyApplication.getInstance().setCategoryDownloaded(true);
        for (TblCategory tblCategory:tblCategories){
            try {
                TblCategory id=catDao.createIfNotExists(tblCategory);
                Logger.i(String.valueOf(id.getOriginalId()));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onCategoryDownloadFail() {
        MyApplication.getInstance().setCategoryDownloaded(false);
    }

    @Override
    public void onMerchantListAvailable() {

    }
}
