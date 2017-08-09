package itg8.com.treatpriceapp.registration.mvp.module;

import itg8.com.treatpriceapp.common.RetroAPI;
import itg8.com.treatpriceapp.common.common_interface.BaseModuleInterface;

/**
 * Created by Android itg 8 on 8/3/2017.
 */

public interface LoginModule extends BaseModuleInterface {
    void onSendDataToServer(RetroAPI retroAPI, String email, String password, String type);


    void onSendSignUpInfoToServer(RetroAPI retroAPI, String name, String email, String mobile, String password);

    void onSendEmailToServer(RetroAPI retroAPI, String email);
}
