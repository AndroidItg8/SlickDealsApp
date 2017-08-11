package itg8.com.treatpriceapp.service;

import java.util.List;

import itg8.com.treatpriceapp.db.tbl.TblCategory;

/**
 * Created by itg_Android on 8/11/2017.
 */

public interface DownloadManager {
    void onCategoryDownloadComplete(List<TblCategory> tblCategories);
    void onCategoryDownloadFail();
    void onMerchantListAvailable();
}
