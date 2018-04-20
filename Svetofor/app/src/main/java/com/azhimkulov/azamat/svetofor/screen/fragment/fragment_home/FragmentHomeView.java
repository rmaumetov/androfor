package com.azhimkulov.azamat.svetofor.screen.fragment.fragment_home;

import com.azhimkulov.azamat.svetofor.entity.LoadingView;
import com.azhimkulov.azamat.svetofor.entity.goods_model.GoodsModel;

import java.util.List;

/**
 * Created by azamat  on 18.04.18.
 */

interface FragmentHomeView extends LoadingView {
    void setResponseGoods(List<GoodsModel> products);
}
