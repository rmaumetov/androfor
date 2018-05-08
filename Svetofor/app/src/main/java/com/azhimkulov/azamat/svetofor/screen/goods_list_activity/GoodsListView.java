package com.azhimkulov.azamat.svetofor.screen.goods_list_activity;

import com.azhimkulov.azamat.svetofor.entity.LoadingView;
import com.azhimkulov.azamat.svetofor.entity.goods_model.GoodsModel;

import java.util.List;

/**
 * Created by azamat  on 25.04.18.
 */

public interface GoodsListView extends LoadingView {
    void setResultGoods(List<GoodsModel> products);
}
