package com.azhimkulov.azamat.svetofor.screen.main_screen.goods_detail;

import android.content.Context;

import com.azhimkulov.azamat.svetofor.App;
import com.azhimkulov.azamat.svetofor.api.AsyncTransformer;
import com.azhimkulov.azamat.svetofor.entity.api_model.ResponseModel;
import com.azhimkulov.azamat.svetofor.entity.goods_detail.GoodsDetail;

/**
 * Created by azamat  on 29.04.18.
 */

public class GoodsDetailPresenter {
    private Context context;
    private GoodsDetailView goodsDetailView;

    public GoodsDetailPresenter(Context context, GoodsDetailView goodsDetailView) {
        this.context = context;
        this.goodsDetailView = goodsDetailView;
    }
}
