package itg8.com.treatpriceapp.common;

import android.app.Application;

import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.HashMap;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import itg8.com.treatpriceapp.db.DBHelper;
import itg8.com.treatpriceapp.db.tbl.TblCategory;
import itg8.com.treatpriceapp.home.model.tdaysDeals.Category_;
import itg8.com.treatpriceapp.home.model.tdaysDeals.Merchant;
import itg8.com.treatpriceapp.home.model.tdaysDeals.Resources;


public class MyApplication extends Application {

    private static final String MY_PREF_NAME = "TreatProcePref";

    private static MyApplication mInstance;
    private boolean categoryDownloaded;
    private HashMap<String, Category_> catMap;
    private HashMap<String, Merchant> merchantMap;

    public static synchronized MyApplication getInstance() {
        return mInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        mInstance.initialisePeference();
    }

    private void initialisePeference() {
        new Prefs.Builder()
                .setContext(this)
                .setMode(MODE_PRIVATE)
                .setPrefsName(MY_PREF_NAME)
                .setUseDefaultSharedPreference(true)
                .build();
    }




    public boolean isCategoryDownloaded() {
        return categoryDownloaded;
    }

    public void setCategoryDownloaded(boolean categoryDownloaded) {
        this.categoryDownloaded = categoryDownloaded;
    }

    public void storeAllResources(Resources resources) {

        Observable.just(resources)
                .map(new Function<Resources, HashMap<String, Category_>>() {
                    @Override
                    public HashMap<String, Category_> apply(@NonNull Resources resources) throws Exception {
                        if (catMap == null) {
                            catMap = new HashMap<>();
                        }
                        catMap.clear();
                        for (Category_ category_ : resources.getCategories().getMatches().getCategory()) {

                            catMap.put(String.valueOf(category_.getId()), category_);
                        }
                        return catMap;
                    }
                }).
                subscribeOn(Schedulers.computation())
                .subscribe(new Observer<HashMap<String, Category_>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(HashMap<String, Category_> stringCategory_hashMap) {
                            MyApplication.this.catMap=stringCategory_hashMap;
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onComplete() {

                    }
                });

        Observable.just(resources)
                .map(new Function<Resources, HashMap<String, Merchant>>() {
                    @Override
                    public HashMap<String, Merchant> apply(@NonNull Resources resources) throws Exception {
                        if (merchantMap == null) {
                            merchantMap = new HashMap<>();
                        }
                        merchantMap.clear();
                        for (Merchant merchant : resources.getMerchants().getMerchant()) {

                            merchantMap.put(String.valueOf(merchant.getId()), merchant);
                        }
                        return merchantMap;
                    }
                }).
                subscribeOn(Schedulers.computation())
                .subscribe(new Observer<HashMap<String, Merchant>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(HashMap<String, Merchant> stringMerchantHashMap) {
                        MyApplication.getInstance().merchantMap=stringMerchantHashMap;
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }




    public Merchant getMerchant(long id){
        return merchantMap.get(String.valueOf(id));
    }

}
