package itg8.com.treatpriceapp.common;

import itg8.com.treatpriceapp.registration.loginmodel.LoginModel;
import itg8.com.treatpriceapp.registration.model.SignUpModel;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Android itg 8 on 8/4/2017.
 */

public interface RetroAPI {

    /** for SignUp   Registration  **/
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
}
