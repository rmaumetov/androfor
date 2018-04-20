package com.azhimkulov.azamat.svetofor;

import android.content.Context;
import android.util.ArraySet;

import com.azhimkulov.azamat.svetofor.entity.categorie_model.CategorieModel;
import com.azhimkulov.azamat.svetofor.entity.goods_model.GoodsModel;
import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by azamat  on 04.04.18.
 */

public class GlobalVar {

    public static List<GoodsModel> bestSellers = new ArrayList<>();
    public static List<CategorieModel> categorieModelList = new ArrayList<>();
    public static List<CategorieModel> firstLevelCategories = new ArrayList<>();
    public static List<CategorieModel> secondLevelCategories = new ArrayList<>();
    public static List<CategorieModel> thirdLevelCategories = new ArrayList<>();
    public static List<GoodsModel> newGoods=new ArrayList<>();

    public static Picasso.Builder getPicasso (Context context)
    {
        okhttp3.OkHttpClient client = new okhttp3.OkHttpClient.Builder()
                .addNetworkInterceptor(chain -> {
                    okhttp3.Request newRequest = chain.request().newBuilder()
                            .addHeader("Authorization",
                                    "TOKEN")
                            .build();
                    return chain.proceed(newRequest);
                })
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build();

        return new Picasso.Builder(context)
                .downloader(new OkHttp3Downloader(client));
    }
}
