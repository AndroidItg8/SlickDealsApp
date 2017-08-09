package itg8.com.treatpriceapp.common;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Android itg 8 on 8/4/2017.
 */

public class RetrofitClass {

    static RetrofitClass retrofitObj;

    public static RetrofitClass getInstance() {
        if (retrofitObj == null) {
            retrofitObj = new RetrofitClass();
        }
        return retrofitObj;

    }

    public Retrofit getRetrofit() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(5, TimeUnit.MINUTES)
                .addInterceptor(interceptor)
                .readTimeout(5, TimeUnit.MINUTES).build();

        Gson gson = new GsonBuilder().setLenient().create();

        Retrofit retrofit;

        retrofit = new Retrofit.Builder()
                .baseUrl(CommonMethod.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build();

        return retrofit;


    }
}
