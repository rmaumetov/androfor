package com.azhimkulov.azamat.svetofor;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.azhimkulov.azamat.svetofor.api.CategoriesApi;
import com.azhimkulov.azamat.svetofor.api.GoodsApi;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by azamat  on 02.04.18.
 */

public class App extends Application {
    private static GoodsApi goodsApi;
    private static CategoriesApi categoriesApi;
    private static Retrofit retrofit;

    Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(chain -> {
            Request original = chain.request();
            Request request = original.newBuilder()
                    .header("Authorization", context.getResources().getString(R.string.token))
                    .method(original.method(), original.body())
                    .build();
            return chain.proceed(request);
        });

        OkHttpClient client = httpClient.connectTimeout(30, TimeUnit.SECONDS).readTimeout(30, TimeUnit.SECONDS).build();

        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss")
                .create();

        retrofit = new Retrofit.Builder()
                .baseUrl(getString(R.string.base_url))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build();

        goodsApi = retrofit.create(GoodsApi.class);
        categoriesApi = retrofit.create(CategoriesApi.class);
    }

    public static GoodsApi getGoodsApi() {
        return goodsApi;
    }

    public static CategoriesApi getCategoriesApi() {
        return categoriesApi;
    }

    public static Retrofit getRetrofit() {
        return retrofit;
    }

    public Context getContext() {
        return context;
    }
}
