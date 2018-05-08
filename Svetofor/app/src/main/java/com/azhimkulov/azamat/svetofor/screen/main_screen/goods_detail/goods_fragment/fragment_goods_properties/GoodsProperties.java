package com.azhimkulov.azamat.svetofor.screen.main_screen.goods_detail.goods_fragment.fragment_goods_properties;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.azhimkulov.azamat.svetofor.R;
import com.azhimkulov.azamat.svetofor.adapter.RecyclerAdapter;
import com.azhimkulov.azamat.svetofor.entity.goods_detail.GoodsDetail;
import com.azhimkulov.azamat.svetofor.entity.goods_model.GoodsModel;
import com.azhimkulov.azamat.svetofor.entity.main_pair.MainPair;
import com.azhimkulov.azamat.svetofor.entity.product_features.ProductFeatures;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by azamat  on 05.05.18.
 */

public class GoodsProperties extends Fragment implements  GoodsPropertiesView {

    private GoodsModel goodsModel;
    private GoodsPropertiesPresenter goodsPropertiesPresenter;
    private String lang;
    private RecyclerAdapter<ProductFeatures> recyclerAdapter;

    @BindView(R.id.slider_image_goods) SliderLayout sliderLayout;
    @BindView(R.id.recycler_view) RecyclerView recyclerView;

    public GoodsProperties() {
    }

    @SuppressLint("ValidFragment")
    public GoodsProperties(GoodsModel goodsModel) {
        this.goodsModel = goodsModel;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_goods_properties, container, false);
        ButterKnife.bind(this, view);
        lang = "ru";
        goodsPropertiesPresenter = new GoodsPropertiesPresenter(getContext(), this);
        goodsPropertiesPresenter.getGoodsDescription(goodsModel.getProduct_id(), lang);

        return view;
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void errorResponse(String s) {

    }

    @Override
    public void setGoodsDescriptionResult(GoodsDetail goodsModelResponseModel) {
        if (!goodsModelResponseModel.getImage_pairs().isEmpty())
        {
            for(MainPair mainPair: goodsModelResponseModel.getImage_pairs()){
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

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);
        recyclerAdapter = new RecyclerAdapter<ProductFeatures>(goodsModelResponseModel.getProduct_features(),getContext(), R.layout.item_goods_features);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setAdapter(recyclerAdapter);
    }
}
