package com.azhimkulov.azamat.svetofor.screen.MainScreen.GoodsDetail;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.azhimkulov.azamat.svetofor.R;
import com.azhimkulov.azamat.svetofor.entity.goods_model.GoodsModel;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GoodsDetail extends AppCompatActivity {

    private GoodsModel goodsModel;
    @BindView(R.id.tv_goods_code)
    public TextView goodsCode;
    @BindView(R.id.tv_goods_name)
    public TextView goodsName;
    @BindView(R.id.tv_goods_new_count)
    public TextView goodsNewCount;
    @BindView(R.id.tv_goods_old_count)
    public TextView goodsOldCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods_detail);
        ButterKnife.bind(this);
        goodsModel =(GoodsModel) getIntent().getSerializableExtra("goods");
        goodsCode.setText(goodsModel.getProduct_code());
        goodsName.setText(goodsModel.getProduct());
        if (Double.parseDouble(goodsModel.getPrice()) != 0.0)
            goodsNewCount.setText(goodsModel.getPrice());
        else {
            goodsNewCount.setText(goodsModel.getList_price());
            goodsOldCount.setText(goodsModel.getPrice());
        }
    }
}
