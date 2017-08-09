package itg8.com.treatpriceapp.registration.mvp.presenter;

import itg8.com.treatpriceapp.common.RetroAPI;
import itg8.com.treatpriceapp.common.RetrofitClass;
import itg8.com.treatpriceapp.common.common_interface.BaseLoginView;
import itg8.com.treatpriceapp.registration.mvp.module.LoginModule;
import itg8.com.treatpriceapp.registration.mvp.module.LoginModuleImp;
import itg8.com.treatpriceapp.registration.mvp.view.LoginView;

/**
 * Created by Android itg 8 on 8/3/2017.
 */

public class LoginViewPresenterImp extends BaseLoginView implements LoginViewPresenter, LoginViewPresenter.LoginPresenterListener {

    private final LoginModule module;
    private LoginView view;

    public LoginViewPresenterImp(LoginView view) {
        this.view = view;
        module = new LoginModuleImp(this);
    }

    @Override
    public void onLoginSuccess(String msg) {
        if (view != null) {
            onProgressHide();
            view.onLoginSuccess(msg);
        }
    }

    @Override
    public void onLoginFailed(String msg) {
        if (view != null) {
            onProgressHide();
            view.onLoginFailed(msg);
        }


    }


    @Override
    public void onSendLoginInfoToServer(String email, String password, String type) {
        if (view != null) {
            onProgressShow();
            module.onSendDataToServer(RetrofitClass.getInstance().getRetrofit().create(RetroAPI.class), email, password, type);
        }


    }

    @Override
    public void onSendSignUpInfoToServer(String name, String email, String mobile, String password) {
        if (view != null) {
            onProgressShow();
            module.onSendSignUpInfoToServer(RetrofitClass.getInstance().getRetrofit().create(RetroAPI.class), name, email, mobile, password);
        }
    }

    @Override
    public void onSendFogetEmailToServer(String email) {
        if (view != null) {
            onProgressShow();
            module.onSendEmailToServer(RetrofitClass.getInstance().getRetrofit().create(RetroAPI.class), email);
        }
    }


    @Override
    public void onProgressHide() {
        if (view != null) {
            view.onProgressHide();
        }

    }

    @Override
    public void onProgressShow() {
        if (view != null) {
            view.onProgressShow();
        }

    }

    @Override
    public void onNetworkAvailable() {
        if (view != null) {
            view.onNetworkAvailable();
        }


    }

    @Override
    public void onNetworkUnAvailable() {
        if (view != null) {
            view.onNetworkUnAvailable();
        }


    }

    @Override
    public void onSignUpSuccessfull(String msg) {
        if (view != null) {
            onProgressHide();
            view.onSignUpSuccess(msg);
        }

    }

    @Override
    public void onSignUpFailed(String msg) {
        if (view != null) {
            onProgressHide();
            view.onSignUpFailed(msg);
        }


    }

    @Override
    public void onEmailResetSuccessfully(String msg) {
         if(view != null)
         {
             onProgressHide();
             view.onResetPassword(msg);
         }

    }

    @Override
    public void onEmailNotReset(String msg) {
        if(view != null)
        {
            onProgressHide();
            view.onNotResetPassword(msg);
        }


    }
}
