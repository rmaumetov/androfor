package com.azhimkulov.azamat.svetofor.screen.CategoryScreen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.azhimkulov.azamat.svetofor.GlobalVar;
import com.azhimkulov.azamat.svetofor.R;
import com.azhimkulov.azamat.svetofor.adapter.RecyclerAdapter;
import com.azhimkulov.azamat.svetofor.entity.categorie_model.CategorieModel;

import butterknife.BindColor;
import butterknife.BindView;
import butterknife.ButterKnife;

public class CategoryActivity extends AppCompatActivity {

    @BindView(R.id.rv_first_level_categoty)
    RecyclerView firstLevelCategory;

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.title_toolbar)
    TextView titleToolbar;

    @BindColor(R.color.green_toolbar)
    int greenToolbar;
    @BindColor(R.color.white)
    int white;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        ButterKnife.bind(this);

        toolbar.setTitle("");
        titleToolbar.setText("КАТАЛОГ ТОВАРОВ");
        toolbar.setBackgroundColor(greenToolbar);
        titleToolbar.setTextColor(white);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        firstLevelCategory.setLayoutManager(layoutManager);
        firstLevelCategory.setHasFixedSize(true);
        firstLevelCategory.setNestedScrollingEnabled(false);
        RecyclerAdapter<CategorieModel> recyclerAdapter = new RecyclerAdapter<>(GlobalVar.firstLevelCategories, this, R.layout.item_category_first_level);
        firstLevelCategory.setAdapter(recyclerAdapter);
    }
}
