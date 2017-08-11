package itg8.com.treatpriceapp.common;

import android.app.Application;



public class MyApplication extends Application {

    private static final String MY_PREF_NAME = "TreatProcePref";

     private static MyApplication mInstance;
    private boolean categoryDownloaded;

    public static synchronized MyApplication getInstance(){
        return mInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance=this;
        mInstance.initialisePeference();
    }

    private void initialisePeference() {
        new Prefs.Builder()
                .setContext(this)
                .setMode(MODE_PRIVATE)
                .setPrefsName(MY_PREF_NAME)
                .setUseDefaultSharedPreference(true)
                .build();
    }


    public void setCategoryDownloaded(boolean categoryDownloaded) {
        this.categoryDownloaded = categoryDownloaded;
    }

    public boolean isCategoryDownloaded() {
        return categoryDownloaded;
    }
}
