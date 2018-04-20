package com.azhimkulov.azamat.svetofor.adapter.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.azhimkulov.azamat.svetofor.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by azamat  on 03.04.18.
 */

public class GoodsHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.tv_goods_code)
    public TextView goodsCode;
    @BindView(R.id.tv_goods_name)
    public TextView goodsName;
    @BindView(R.id.tv_goods_new_count)
    public TextView goodsNewCount;
    @BindView(R.id.tv_goods_old_count)
    public TextView goodsOldCount;
    @BindView(R.id.item_goods_linearL)
    public LinearLayout goodsLinearL;
    @BindView(R.id.iv_photo)
    public ImageView goodsImage;

    public GoodsHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
