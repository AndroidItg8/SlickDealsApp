package itg8.com.treatpriceapp.home.mvp;

import itg8.com.treatpriceapp.common.common_interface.BaseWeakPresenter;

/**
 * Created by itg_Android on 8/14/2017.
 */

public class DealsPresenterImp extends BaseWeakPresenter implements HomeMVP.DealsPresenter, HomeMVP.DealsListener {
    HomeMVP.DealsModel model;
    public DealsPresenterImp(Object o) {
        super(o);
        model=new DealsModelImp();
    }

    @Override
    public void onStartDownloadingDeals(int page) {
        model.onDownloadStart(this,page);
    }

    @Override
    public void onDetached() {
        detactView();
    }

    @Override
    public void onDealsAvaiable(Object o) {
        if(hasView()){
            getDealView().onTopDealsAvaialable(o);
        }
    }

    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
        if(hasView()){
            getDealView().onError(e);
        }
    }

    private HomeMVP.DealsView getDealView(){
        return (HomeMVP.DealsView)getView();
    }
}
