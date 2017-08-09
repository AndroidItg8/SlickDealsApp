package itg8.com.treatpriceapp.registration.mvp.view;

import itg8.com.treatpriceapp.common.common_interface.BaseView;

/**
 * Created by Android itg 8 on 8/3/2017.
 */

public interface LoginView extends BaseView {
    void onLoginSuccess(String msg);
    void onLoginFailed(String msg);

    void onSignUpSuccess(String msg);
    void onSignUpFailed(String msg);
     void onResetPassword(String msg);
    void onNotResetPassword(String msg);
}

