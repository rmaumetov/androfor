package com.azhimkulov.azamat.svetofor.screen.preload_activity;

import android.content.Context;

import com.azhimkulov.azamat.svetofor.App;
import com.azhimkulov.azamat.svetofor.api.AsyncTransformer;
import com.azhimkulov.azamat.svetofor.entity.api_model.ResponseModelCategorie;
import com.azhimkulov.azamat.svetofor.entity.categorie_model.CategoryModel;

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

    private void responseCategories(ResponseModelCategorie<List<CategoryModel>> listResponseModelCategorie) {
        if (listResponseModelCategorie.getMessage()==null&&listResponseModelCategorie.getCategories()!=null)
            preloadView.setResponseCategory(listResponseModelCategorie.getCategories());
        else preloadView.errorResponse(listResponseModelCategorie.getMessage());
    }

    private void error(Throwable throwable) {
        if (throwable.getMessage().equals("timeout"))
            preloadView.errorResponse("Сервер не отвечает");
        else
            preloadView.errorResponse(throwable.getMessage());
    }
}
