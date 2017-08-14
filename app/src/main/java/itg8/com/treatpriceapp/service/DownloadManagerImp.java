package itg8.com.treatpriceapp.service;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import itg8.com.treatpriceapp.category.model.CategoriesModel;
import itg8.com.treatpriceapp.category.model.Category;
import itg8.com.treatpriceapp.category.model.Category_;
import itg8.com.treatpriceapp.category.model.Category__;
import itg8.com.treatpriceapp.common.NetworkCall;
import itg8.com.treatpriceapp.db.tbl.TblCategory;
import itg8.com.treatpriceapp.db.tbl.TblMerchantType;
import itg8.com.treatpriceapp.merchants.model.MerchantType;
import itg8.com.treatpriceapp.merchants.model.MerchantTypeModel;

/**
 * Created by itg_Android on 8/11/2017.
 */

public class DownloadManagerImp {

    private DownloadManager listener;
    private Observable<CategoriesModel> b;

    public DownloadManagerImp(DownloadManager listener) {
        this.listener = listener;
    }

    public void downloadCategories() {
        b = NetworkCall.downloadCategories();
        b.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Function<CategoriesModel, List<TblCategory>>() {
                    @Override
                    public List<TblCategory> apply(@NonNull CategoriesModel categoriesModel) throws Exception {
                        return collectAllCategories(categoriesModel);
                    }
                }).subscribe(subscribeForCategories());
    }

    private Observer<List<TblCategory>> subscribeForCategories() {
        return new Observer<List<TblCategory>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(List<TblCategory> tblCategories) {
                listener.onCategoryDownloadComplete(tblCategories);
            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
            }

            @Override
            public void onComplete() {

            }
        };

    }


    private List<TblCategory> collectAllCategories(CategoriesModel categoriesModel) {
        List<TblCategory> categoriesToRetrurn = new ArrayList<>();
        TblCategory tempCat;
        String pId1;
        String pId2;
        for (Category cat1 : categoriesModel.getResults().getCategories().getCategory()) {
            tempCat = new TblCategory();
            tempCat.setOriginalId(cat1.getId());
            tempCat.setName(cat1.getName());
            tempCat.setParentCatId(null);
            pId1 = cat1.getId();
            categoriesToRetrurn.add(tempCat);
            if (cat1.getCategories() != null)
                for (Category_ cat2 : cat1.getCategories().getCategory()) {
                    tempCat = new TblCategory();
                    tempCat.setOriginalId(cat2.getId());
                    tempCat.setName(cat2.getName());
                    tempCat.setParentCatId(pId1);
                    pId2 = cat2.getId();
                    categoriesToRetrurn.add(tempCat);
                    if (cat2.getCategories() != null)
                        for (Category__ cat3 : cat2.getCategories().getCategory()) {
                            tempCat = new TblCategory();
                            tempCat.setName(cat3.getName());
                            tempCat.setParentCatId(pId2);
                            tempCat.setOriginalId(cat3.getId());
                            categoriesToRetrurn.add(tempCat);
                        }
                }
        }
        return categoriesToRetrurn;
    }

    public void onDestroy() {

    }

    public void downloadMerchantType() {
            NetworkCall.downloadMerchantType().subscribeOn(Schedulers.newThread()).map(new Function<MerchantTypeModel, List<TblMerchantType>>() {
                @Override
                public List<TblMerchantType> apply(@NonNull MerchantTypeModel merchantTypeModel) throws Exception {
                    return generateMerchantTypeTable(merchantTypeModel);
                }
            }).observeOn(Schedulers.newThread())
                    .subscribe(new Observer<List<TblMerchantType>>() {
                        @Override
                        public void onSubscribe(Disposable d) {

                        }

                        @Override
                        public void onNext(List<TblMerchantType> tblMerchantTypes) {
                                listener.onMerchantTypeListAvailable(tblMerchantTypes);
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

    private List<TblMerchantType> generateMerchantTypeTable(MerchantTypeModel merchantTypeModel) {
        List<TblMerchantType> tblMerchantTypes=new ArrayList<>();
        for(MerchantType mt:merchantTypeModel.getResults().getMerchantTypes().getMerchantType())
        {
            TblMerchantType type=new TblMerchantType();
            type.setName(mt.getName());
            type.setpId(mt.getId());
            tblMerchantTypes.add(type);
        }
        return tblMerchantTypes;
    }
}
