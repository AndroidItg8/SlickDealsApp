package itg8.com.treatpriceapp.registration.mvp.module;


import android.util.Log;

import itg8.com.treatpriceapp.common.CommonMethod;
import itg8.com.treatpriceapp.common.RetroAPI;
import itg8.com.treatpriceapp.registration.loginmodel.LoginModel;
import itg8.com.treatpriceapp.registration.model.SignUpModel;
import itg8.com.treatpriceapp.registration.mvp.presenter.LoginViewPresenter;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Android itg 8 on 8/3/2017.
 */

public class LoginModuleImp implements LoginModule {
    private static final String TAG =LoginModuleImp.class.getSimpleName() ;
    private LoginViewPresenter.LoginPresenterListener listener;

    public LoginModuleImp(LoginViewPresenter.LoginPresenterListener listener) {
        this.listener = listener;
    }


    @Override
    public void onSendDataToServer(RetroAPI retroAPI, String email, String password, String type) {
        Log.i(TAG,"OnData:"+email+password+type);
        retroAPI.sendLoginInfoToServer(email, password, type).enqueue(new Callback<LoginModel>() {
            @Override
            public void onResponse(Call<LoginModel> call, Response<LoginModel> response) {
                if (response.isSuccessful()) {
                    if (response.body().getFlag() != null && response.body().getFlag().equalsIgnoreCase("1")) {
                        listener.onLoginSuccess(response.body().getMsg());
                        Log.i(TAG,"success:"+response.body().getMsg());

                    } else {
                        listener.onLoginFailed(response.body().getMsg());
                        Log.i(TAG,"onFailed:"+response.body().getMsg());

                    }
                } else {
                    listener.onLoginFailed(response.body().getMsg());
                    Log.i(TAG,"onFailed2:"+response.body().getMsg());

                }

            }

            @Override
            public void onFailure(Call<LoginModel> call, Throwable t) {
                listener.onLoginFailed(t.getMessage());
                Log.i(getClass().getSimpleName(),"onFailed3:"+t.getMessage());


            }
        });


    }

    @Override
    public void onNetworkAvailable() {
        if (CommonMethod.isInternetAvailable()) {
            listener.onNetworkAvailable();
        }

    }

    @Override
    public void onNetworkUnAvailable() {
        if (!CommonMethod.isInternetAvailable()) {
            listener.onNetworkUnAvailable();
        }

    }


    @Override
    public void onSendSignUpInfoToServer(RetroAPI retroAPI, String name, String email, String mobile, String password) {
        Log.i(TAG,"onData:"+name +email+password+mobile);

        retroAPI.sendUserInfoToServer(email, mobile, name, password, password).enqueue(new Callback<SignUpModel>() {

            @Override
            public void onResponse(Call<SignUpModel> call, Response<SignUpModel> response) {
                if (response.isSuccessful()) {
                    if (response.body().getFlag() != null && response.body().getFlag().equalsIgnoreCase("1")) {
                        Log.i(getClass().getSimpleName(), "OnSuccess" + response.body().getUserid());
                        listener.onSignUpSuccessfull(response.body().getMsg());

                    } else {
                        listener.onSignUpFailed(response.body().getMsg());
                        Log.i(TAG,"onFailed1:"+response.body().getMsg());

                    }
                } else {
                    listener.onSignUpFailed(response.body().getMsg());
                    Log.i(TAG,"onFailed2:"+response.body().getMsg());

                }
            }

            @Override
            public void onFailure(Call<SignUpModel> call, Throwable t) {
                listener.onSignUpFailed(t.getMessage());
                Log.i(TAG,"onFailedT:"+t.getMessage());



            }
        });
    }

    @Override
    public void onSendEmailToServer(RetroAPI retroAPI, String email) {
        retroAPI.sendEmailInfo(email).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if(response.isSuccessful())
                {
                     listener.onEmailResetSuccessfully("");

                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
           listener.onEmailNotReset(t.getMessage());

            }
        });



    }
}
