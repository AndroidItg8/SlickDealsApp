package itg8.com.treatpriceapp.common;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import itg8.com.treatpriceapp.category.model.Categories;
import itg8.com.treatpriceapp.category.model.CategoriesModel;

/**
 * Created by itg_Android on 8/11/2017.
 */

public class NetworkCall{

    public static Observable<CategoriesModel> downloadCategories(){
        return RetrofitClass.getInstance().getRetrofit(CommonMethod.P_SHOP).getCategories(CommonMethod.APIA);
    }

}
