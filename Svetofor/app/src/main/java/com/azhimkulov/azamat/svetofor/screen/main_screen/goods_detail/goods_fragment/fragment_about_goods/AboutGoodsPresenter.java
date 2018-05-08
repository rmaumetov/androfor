package com.azhimkulov.azamat.svetofor.screen.main_screen.goods_detail.goods_fragment.fragment_about_goods;

import android.content.Context;

import com.azhimkulov.azamat.svetofor.App;
import com.azhimkulov.azamat.svetofor.api.AsyncTransformer;
import com.azhimkulov.azamat.svetofor.entity.goods_detail.GoodsDetail;

/**
 * Created by azamat  on 05.05.18.
 */

public class AboutGoodsPresenter {
    Context context;
    AboutGoodsView aboutGoodsView;

    public AboutGoodsPresenter(Context context, AboutGoodsView aboutGoodsView) {
        this.context = context;
        this.aboutGoodsView = aboutGoodsView;
    }

    void getGoodsDescription(long goodsId, String lang)
    {
        App.getGoodsApi().getGoodsDescription(String.valueOf(goodsId), lang)
                .compose(new AsyncTransformer<>())
                .subscribe(this::responseGoodsDescription, this::error);
    }

    private void responseGoodsDescription(GoodsDetail goodsModelResponseModel) {
        if (goodsModelResponseModel!=null)
            aboutGoodsView.setGoodsDescriptionResult(goodsModelResponseModel);
    }

    private void error(Throwable throwable) {
        aboutGoodsView.errorResponse("Проблемы с интернетом");
    }
}
