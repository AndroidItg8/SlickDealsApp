package itg8.com.treatpriceapp.common;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import itg8.com.treatpriceapp.BuildConfig;
import itg8.com.treatpriceapp.category.model.CategoriesModel;
import itg8.com.treatpriceapp.home.model.tdaysDeals.ProductsModel;
import itg8.com.treatpriceapp.merchants.model.MerchantTypeModel;
import itg8.com.treatpriceapp.registration.loginmodel.LoginModel;
import itg8.com.treatpriceapp.registration.model.SignUpModel;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Android itg 8 on 8/4/2017.
 */

public interface RetroAPI {


    /**
     * for SignUp   Registration
     **/
    @FormUrlEncoded
    @POST("appregister")
    Call<SignUpModel> sendUserInfoToServer(@Field("User[email]") String email,
                                           @Field("User[mobile_number]") String mobile,
                                           @Field("User[name]") String name,
                                           @Field("User[password]") String password,
                                           @Field("User[cpassword]") String cPassword);

    @FormUrlEncoded
    @POST("JsonsLogin")
    Call<LoginModel> sendLoginInfoToServer(@Field("Appuser[logindata]") String password,
                                           @Field("Appuser[password]") String type,
                                           @Field("Appuser[type]") String email);

    @FormUrlEncoded
    @POST("")
    Call<ResponseBody> sendEmailInfo(String email);

    @GET("categories.json")
        Observable<CategoriesModel> getCategories(@Query("account") String acc);

    @GET("merchant_types.json")
    Observable<MerchantTypeModel> getMerchantTypes(@Query("account") String acc);

    @GET("products.json")
    Observable<ProductsModel> getProducts(@Query("account") String apia, @Query("catalog") String apic,@Query("page") int page);
}
