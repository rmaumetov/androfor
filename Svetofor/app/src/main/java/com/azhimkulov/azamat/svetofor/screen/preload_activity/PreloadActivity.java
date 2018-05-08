package com.azhimkulov.azamat.svetofor.screen.preload_activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.azhimkulov.azamat.svetofor.GlobalVar;
import com.azhimkulov.azamat.svetofor.R;
import com.azhimkulov.azamat.svetofor.entity.categorie_model.CategoryModel;
import com.azhimkulov.azamat.svetofor.screen.main_screen.MainActivity;

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
    public void setResponseCategory(List<CategoryModel> categories) {
        GlobalVar.categorieModelList.clear();
        GlobalVar.categorieModelList.addAll(categories);
        for (CategoryModel categorieModel :categories) {
            if (!categorieModel.getId_path().contains("/"))
                GlobalVar.firstLevelCategories.add(categorieModel);
            else if (categorieModel.getId_path().split("/").length==2)
                GlobalVar.secondLevelCategories.add(categorieModel);
            else if (categorieModel.getId_path().split("/").length==3)
                GlobalVar.thirdLevelCategories.add(categorieModel);
        }
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
