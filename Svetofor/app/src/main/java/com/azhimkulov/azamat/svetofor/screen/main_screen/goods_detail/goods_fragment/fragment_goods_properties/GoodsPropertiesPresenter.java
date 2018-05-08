package com.azhimkulov.azamat.svetofor.screen.main_screen.goods_detail.goods_fragment.fragment_goods_properties;

import android.content.Context;

import com.azhimkulov.azamat.svetofor.App;
import com.azhimkulov.azamat.svetofor.api.AsyncTransformer;
import com.azhimkulov.azamat.svetofor.entity.goods_detail.GoodsDetail;

/**
 * Created by azamat  on 07.05.18.
 */

public class GoodsPropertiesPresenter {
    Context context;
    GoodsPropertiesView goodsPropertiesView;

    public GoodsPropertiesPresenter(Context context, GoodsPropertiesView goodsPropertiesView) {
        this.context = context;
        this.goodsPropertiesView = goodsPropertiesView;
    }

    void getGoodsDescription(long goodsId, String lang)
    {
        App.getGoodsApi().getGoodsDescription(String.valueOf(goodsId), lang)
                .compose(new AsyncTransformer<>())
                .subscribe(this::responseGoodsDescription, this::error);
    }

    private void responseGoodsDescription(GoodsDetail goodsModelResponseModel) {
        if (goodsModelResponseModel!=null)
            goodsPropertiesView.setGoodsDescriptionResult(goodsModelResponseModel);
    }

    private void error(Throwable throwable) {
        goodsPropertiesView.errorResponse("Проблемы с интернетом");
    }
}
