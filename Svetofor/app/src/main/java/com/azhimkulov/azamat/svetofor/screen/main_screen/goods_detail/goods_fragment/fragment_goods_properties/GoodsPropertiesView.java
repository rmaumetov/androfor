package com.azhimkulov.azamat.svetofor.screen.main_screen.goods_detail.goods_fragment.fragment_goods_properties;

import com.azhimkulov.azamat.svetofor.entity.LoadingView;
import com.azhimkulov.azamat.svetofor.entity.goods_detail.GoodsDetail;

/**
 * Created by azamat  on 07.05.18.
 */

public interface GoodsPropertiesView extends LoadingView {
    void setGoodsDescriptionResult(GoodsDetail goodsModelResponseModel);
}
