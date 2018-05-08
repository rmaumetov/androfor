package com.azhimkulov.azamat.svetofor.screen.main_screen.goods_detail.goods_fragment.fragment_about_goods;

import com.azhimkulov.azamat.svetofor.entity.LoadingView;
import com.azhimkulov.azamat.svetofor.entity.goods_detail.GoodsDetail;

/**
 * Created by azamat  on 05.05.18.
 */

interface AboutGoodsView extends LoadingView {
    void setGoodsDescriptionResult(GoodsDetail products);
}
