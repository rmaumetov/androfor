package com.azhimkulov.azamat.svetofor.api;

import com.azhimkulov.azamat.svetofor.entity.api_model.ResponseModel;
import com.azhimkulov.azamat.svetofor.entity.goods_model.GoodsModel;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by azamat  on 02.04.18.
 */

public interface GoodsApi {
    @GET("blocks/1139")
    Observable<ResponseModel<List<GoodsModel>>> getBestSellers(@Query("page")int page,@Query("items_per_page")int itemsCount);

    @GET("blocks/1140")
    Observable<ResponseModel<List<GoodsModel>>> getNewGoods(@Query("page")int page,@Query("items_per_page")int itemsCount);
}
