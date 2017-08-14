package itg8.com.treatpriceapp.common;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import itg8.com.treatpriceapp.category.model.Categories;
import itg8.com.treatpriceapp.category.model.CategoriesModel;
import itg8.com.treatpriceapp.home.model.tdaysDeals.ProductsModel;
import itg8.com.treatpriceapp.merchants.model.MerchantTypeModel;

/**
 * Created by itg_Android on 8/11/2017.
 */

public class NetworkCall{

    public static Observable<CategoriesModel> downloadCategories(){
        return RetrofitClass.getInstance().getRetrofit(CommonMethod.P_SHOP).getCategories(CommonMethod.APIA);
    }

    public static Observable<MerchantTypeModel> downloadMerchantType() {
        return RetrofitClass.getInstance().getRetrofit(CommonMethod.P_SHOP).getMerchantTypes(CommonMethod.APIA);
    }

    public static Observable<ProductsModel> downloadDeals(int page) {
        return RetrofitClass.getInstance().getRetrofit(CommonMethod.P_SHOP).getProducts(CommonMethod.APIA,CommonMethod.APIC, page);
    }
}
