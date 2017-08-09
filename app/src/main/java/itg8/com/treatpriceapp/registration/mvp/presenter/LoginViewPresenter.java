package itg8.com.treatpriceapp.registration.mvp.presenter;

import itg8.com.treatpriceapp.common.common_interface.BasePresenterInterface;

/**
 * Created by Android itg 8 on 8/3/2017.
 */

public interface LoginViewPresenter  extends BasePresenterInterface {
     void onSendLoginInfoToServer(String name,String password, String type);
    void onSendSignUpInfoToServer(String name, String email, String mobile, String password);
    void onSendFogetEmailToServer(String email);


    interface  LoginPresenterListener
    {
        void onLoginSuccess(String msg);
        void onLoginFailed(String msg);
        void onNetworkAvailable();
        void onNetworkUnAvailable();
        void onSignUpSuccessfull(String msg);
        void onSignUpFailed(String msg);
         void onEmailResetSuccessfully(String msg);
         void onEmailNotReset(String msg);
    }
}
