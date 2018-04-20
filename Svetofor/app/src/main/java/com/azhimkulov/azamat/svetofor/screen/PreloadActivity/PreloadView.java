package com.azhimkulov.azamat.svetofor.screen.PreloadActivity;

import com.azhimkulov.azamat.svetofor.entity.LoadingView;
import com.azhimkulov.azamat.svetofor.entity.categorie_model.CategorieModel;
import com.azhimkulov.azamat.svetofor.entity.goods_model.GoodsModel;

import java.util.List;

/**
 * Created by azamat  on 08.04.18.
 */

interface PreloadView extends LoadingView {
    void setResponseBestSellers(List<GoodsModel> products);

    void setResponseCategorie(List<CategorieModel> categories);

    void setResponseNewGoods(List<GoodsModel> products);
}
