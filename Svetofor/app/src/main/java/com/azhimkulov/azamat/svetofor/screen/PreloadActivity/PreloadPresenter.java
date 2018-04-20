package com.azhimkulov.azamat.svetofor.screen.PreloadActivity;

import android.content.Context;

import com.azhimkulov.azamat.svetofor.App;
import com.azhimkulov.azamat.svetofor.api.AsyncTransformer;
import com.azhimkulov.azamat.svetofor.entity.api_model.ResponseModel;
import com.azhimkulov.azamat.svetofor.entity.api_model.ResponseModelCategorie;
import com.azhimkulov.azamat.svetofor.entity.categorie_model.CategorieModel;
import com.azhimkulov.azamat.svetofor.entity.goods_model.GoodsModel;

import java.util.List;

/**
 * Created by azamat  on 08.04.18.
 */

public class PreloadPresenter {
    private Context context;
    private PreloadView preloadView;
    PreloadPresenter(Context context, PreloadView preloadView) {
        this.context = context;
        this.preloadView = preloadView;
    }


    void getCategories()
    {
        App.getCategoriesApi().getCategorieModel(1, 10000)
                .compose(new AsyncTransformer<>())
                .subscribe(this::responseCategories, this::error);
    }

    private void responseCategories(ResponseModelCategorie<List<CategorieModel>> listResponseModelCategorie) {
        if (listResponseModelCategorie.getMessage()==null&&listResponseModelCategorie.getCategories()!=null)
            preloadView.setResponseCategorie(listResponseModelCategorie.getCategories());
        else preloadView.errorResponse(listResponseModelCategorie.getMessage());
    }


    void getBestSellers()
    {

        App.getGoodsApi().getBestSellers(1,12)
                .compose(new AsyncTransformer<>())
                .subscribe(this::responseBestSellers, this::error);
    }
    private void responseBestSellers(ResponseModel<List<GoodsModel>> listResponseModel) {
        if (listResponseModel.getMessage()==null&&listResponseModel.getProducts()!=null)
            preloadView.setResponseBestSellers(listResponseModel.getProducts());
        else preloadView.errorResponse(listResponseModel.getMessage());
    }

    void getGoodsNew()
    {
        App.getGoodsApi().getNewGoods(1,12)
                .compose(new AsyncTransformer<>())
                .subscribe(this::responseNewGoods, this::error);
    }

    private void responseNewGoods(ResponseModel<List<GoodsModel>> listResponseModel) {
        if (listResponseModel.getMessage()==null&&listResponseModel.getProducts()!=null)
            preloadView.setResponseNewGoods(listResponseModel.getProducts());
        else preloadView.errorResponse(listResponseModel.getMessage());
    }

    private void error(Throwable throwable) {
        if (throwable.getMessage().equals("timeout"))
            preloadView.errorResponse("Сервер не отвечает");
        else
            preloadView.errorResponse(throwable.getMessage());
    }
}
