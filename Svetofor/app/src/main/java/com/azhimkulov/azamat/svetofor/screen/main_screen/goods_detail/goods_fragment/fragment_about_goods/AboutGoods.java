package com.azhimkulov.azamat.svetofor.screen.main_screen.goods_detail.goods_fragment.fragment_about_goods;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toast;

import com.azhimkulov.azamat.svetofor.R;
import com.azhimkulov.azamat.svetofor.entity.goods_detail.GoodsDetail;
import com.azhimkulov.azamat.svetofor.entity.goods_model.GoodsModel;
import com.azhimkulov.azamat.svetofor.entity.main_pair.MainPair;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by azamat  on 05.05.18.
 */

public class AboutGoods extends Fragment implements AboutGoodsView {

    @BindView(R.id.tv_goods_code) TextView goodsCode;
    @BindView(R.id.tv_goods_name) TextView goodsName;
    @BindView(R.id.tv_goods_description) TextView goodsDescription;
    @BindView(R.id.tv_goods_new_count) TextView goodsNewCount;
    @BindView(R.id.tv_goods_old_count) TextView goodsOldCount;
    @BindView(R.id.tv_garant) TextView warranty;
    @BindView(R.id.tv_goods_availibility_status) TextView goodsAvailibility;
    @BindView(R.id.html_description) WebView htmlDescription;
    @BindView(R.id.slider_image_goods) SliderLayout sliderLayout;
    @BindString(R.string.old_price) String oldPrice;
    @BindString(R.string.new_price) String newPrice;
    @BindString(R.string.zip_code) String zipCode;

    private GoodsModel goodsModel;
    private AboutGoodsPresenter aboutGoodsPresenter;
    private String lang;

    public AboutGoods() {
    }

    @SuppressLint("ValidFragment")
    public AboutGoods(GoodsModel goodsModel) {
        this.goodsModel = goodsModel;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_about_goods, container, false);
        ButterKnife.bind(this, view);
        lang = "ru";
        aboutGoodsPresenter = new AboutGoodsPresenter(getContext(), this);
        goodsCode.setText(String.format("%s %s", zipCode, goodsModel.getProduct_code()));
        goodsName.setText(goodsModel.getProduct());
        warranty.setText(goodsModel.getWarranty());
        goodsNewCount.setText(new StringBuilder().append("$").append(goodsModel.getList_price()).append(" (").append(goodsModel.getCurrency_list_price()).append(" c)").toString());
        goodsOldCount.setText(new StringBuilder().append(oldPrice).append(" $").append(splitPrice(goodsModel.getPrice())).append(" (").append(goodsModel.getCurrency_price()).append(" c)").toString());

        aboutGoodsPresenter.getGoodsDescription(goodsModel.getProduct_id(), lang);

        return view;
    }

        private String splitPrice(String price) {
        int pos = price.indexOf(".") + 3;
        if (price.length() > pos && price.contains(".")) return price.substring(0, pos);
        else return price;
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void errorResponse(String s) {
        Toast.makeText(getContext(), s, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setGoodsDescriptionResult(GoodsDetail products) {
        htmlDescription.loadDataWithBaseURL(null,"<style>img{display: inline;height: auto;max-width: 100%;}</style>"+ products.getFull_description(),
                "text/html", "UTF-8", null);
        goodsDescription.setText(products.getProduct());
        goodsAvailibility.setText(products.getAvailibility_status());

        if (!products.getImage_pairs().isEmpty())
        {
            for(MainPair mainPair: products.getImage_pairs()){
                TextSliderView textSliderView = new TextSliderView(getContext());
                textSliderView
                        .image(mainPair.getDetailed().getHttp_image_path())
                        .setScaleType(BaseSliderView.ScaleType.CenterInside);
                sliderLayout.addSlider(textSliderView);
            }
        }
        else {
            TextSliderView textSliderView = new TextSliderView(getContext());
            textSliderView
                    .image(goodsModel.getMain_pair().getDetailed().getHttp_image_path());
            sliderLayout.addSlider(textSliderView);
        }
        sliderLayout.setVisibility(View.VISIBLE);
    }
}
