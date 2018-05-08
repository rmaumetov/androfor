package com.azhimkulov.azamat.svetofor.screen.search_screen;

import android.content.Context;

import com.azhimkulov.azamat.svetofor.App;
import com.azhimkulov.azamat.svetofor.api.AsyncTransformer;
import com.azhimkulov.azamat.svetofor.entity.api_model.ResponseModel;
import com.azhimkulov.azamat.svetofor.entity.goods_model.GoodsModel;

import java.util.List;

/**
 * Created by azamat  on 30.04.18.
 */

public class SearchPresenter {
    private Context context;
    private SearchView searchview;

    public SearchPresenter(Context context, SearchView searchview) {
        this.context = context;
        this.searchview = searchview;
    }

    void getGoodsBySearchKey(String searchKey)
    {
        App.getGoodsApi().getGoodsByKey(searchKey, 100)
                .compose(new AsyncTransformer<>())
                .subscribe(this::responseGoods, this::error);
    }

    private void responseGoods(ResponseModel<List<GoodsModel>> listResponseModel) {
        if (listResponseModel.getMessage()==null&&listResponseModel.getProducts()!=null)
            searchview.setResultSearch(listResponseModel.getProducts());
        else searchview.errorResponse(listResponseModel.getMessage());
    }

    private void error(Throwable throwable) {

    }
}
