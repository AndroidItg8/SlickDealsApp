package itg8.com.treatpriceapp.home.mvp;

/**
 * Created by itg_Android on 8/10/2017.
 */

public interface HomeMVP {
    public interface DealsView{
        void onTopDealsAvaialable(Object o);
        void onError(Throwable t);
    }

    public interface DealsPresenter{
        void onStartDownloadingDeals(int page);

        void onDetached();
    }

    public interface DealsModel{
        void onDownloadStart(DealsListener listener,int page);
    }

    public interface DealsListener{
        void onDealsAvaiable(Object o);

        void onError(Throwable e);
    }



}
