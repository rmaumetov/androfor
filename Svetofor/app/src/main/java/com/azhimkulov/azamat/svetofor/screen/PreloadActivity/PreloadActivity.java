package com.azhimkulov.azamat.svetofor.screen.PreloadActivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.azhimkulov.azamat.svetofor.GlobalVar;
import com.azhimkulov.azamat.svetofor.R;
import com.azhimkulov.azamat.svetofor.entity.categorie_model.CategorieModel;
import com.azhimkulov.azamat.svetofor.entity.goods_model.GoodsModel;
import com.azhimkulov.azamat.svetofor.screen.MainScreen.MainActivity;

import java.util.List;

public class PreloadActivity extends AppCompatActivity implements PreloadView {
    private PreloadPresenter preloadPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preloader);
        preloadPresenter = new PreloadPresenter(this,this);
        preloadPresenter.getCategories();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void errorResponse(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public void setResponseBestSellers(List<GoodsModel> products) {
        GlobalVar.bestSellers.clear();
        GlobalVar.bestSellers.addAll(products);
        preloadPresenter.getGoodsNew();
    }

    @Override
    public void setResponseCategorie(List<CategorieModel> categories) {
        GlobalVar.categorieModelList.clear();
        GlobalVar.categorieModelList.addAll(categories);
        for (CategorieModel categorieModel :categories) {
            if (!categorieModel.getId_path().contains("/"))
                GlobalVar.firstLevelCategories.add(categorieModel);
            else if (categorieModel.getId_path().split("/").length==2)
                GlobalVar.secondLevelCategories.add(categorieModel);
            else if (categorieModel.getId_path().split("/").length==3)
                GlobalVar.thirdLevelCategories.add(categorieModel);
        }
        preloadPresenter.getBestSellers();
    }

    @Override
    public void setResponseNewGoods(List<GoodsModel> products) {
        GlobalVar.newGoods.clear();
        GlobalVar.newGoods.addAll(products);
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
