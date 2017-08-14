package itg8.com.treatpriceapp.home.mvp;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import itg8.com.treatpriceapp.common.NetworkCall;
import itg8.com.treatpriceapp.home.model.tdaysDeals.ProductsModel;

/**
 * Created by itg_Android on 8/14/2017.
 */

public class DealsModelImp implements HomeMVP.DealsModel {
    @Override
    public void onDownloadStart(final HomeMVP.DealsListener listener, int page) {
        NetworkCall.downloadDeals(page).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ProductsModel>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ProductsModel productsModel) {
                            if(productsModel!=null)
                                listener.onDealsAvaiable(productsModel);
                    }

                    @Override
                    public void onError(Throwable e) {
                            listener.onError(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
