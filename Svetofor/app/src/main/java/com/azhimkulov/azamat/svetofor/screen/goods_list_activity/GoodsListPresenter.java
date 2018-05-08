package com.azhimkulov.azamat.svetofor.screen.goods_list_activity;

import android.content.Context;

import com.azhimkulov.azamat.svetofor.App;
import com.azhimkulov.azamat.svetofor.api.AsyncTransformer;
import com.azhimkulov.azamat.svetofor.entity.api_model.ResponseModel;
import com.azhimkulov.azamat.svetofor.entity.goods_model.GoodsModel;

import java.util.List;

/**
 * Created by azamat  on 25.04.18.
 */

public class GoodsListPresenter {
    private Context context;
    private GoodsListView goodsListView;

    public GoodsListPresenter(Context context, GoodsListView goodsListView) {
        this.context = context;
        this.goodsListView = goodsListView;
    }
    
    void getGoodsByCategory(String category)
    {
        App.getGoodsApi().getGoodsByCategory(category, 0, 100)
                .compose(new AsyncTransformer<>())
                .doOnSubscribe(__->goodsListView.showLoading())
                .doOnComplete(()->goodsListView.hideLoading())
                .subscribe(this::responseGoods, this::error);
    }

    private void error(Throwable throwable) {
    }

    private void responseGoods(ResponseModel<List<GoodsModel>> listResponseModel) {
        if (listResponseModel.getProducts()!=null&&listResponseModel.getProducts().size()!=0)
            goodsListView.setResultGoods(listResponseModel.getProducts());
        else goodsListView.errorResponse(listResponseModel.getMessage());
    }
}
