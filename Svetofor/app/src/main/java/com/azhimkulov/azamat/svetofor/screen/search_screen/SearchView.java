package com.azhimkulov.azamat.svetofor.screen.search_screen;

import com.azhimkulov.azamat.svetofor.entity.LoadingView;
import com.azhimkulov.azamat.svetofor.entity.goods_model.GoodsModel;

import java.util.List;

/**
 * Created by azamat  on 30.04.18.
 */

interface SearchView extends LoadingView {
    void setResultSearch(List<GoodsModel> products);
}
