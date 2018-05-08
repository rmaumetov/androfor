package com.azhimkulov.azamat.svetofor.screen.category_screen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.azhimkulov.azamat.svetofor.GlobalVar;
import com.azhimkulov.azamat.svetofor.R;
import com.azhimkulov.azamat.svetofor.adapter.RecyclerAdapter;
import com.azhimkulov.azamat.svetofor.entity.categorie_model.CategoryModel;

import butterknife.BindColor;
import butterknife.BindView;
import butterknife.ButterKnife;

public class CategoryActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.rv_first_level_categoty) RecyclerView firstLevelCategory;
    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.title_toolbar) TextView titleToolbar;
    @BindView(R.id.search_toolbar) ImageView searchToolbar;
    @BindView(R.id.search_return_back) ImageView searchReturnBack;
    @BindView(R.id.et_search_key) EditText etSearchKey;
    @BindView(R.id.clear_search_key) ImageView clearSearchKey;
    @BindView(R.id.toolbar_field) LinearLayout toolbarField;
    @BindView(R.id.search_field) LinearLayout searchField;
    @BindColor(R.color.green_toolbar) int greenToolbar;
    @BindColor(R.color.white) int white;

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
        RecyclerAdapter<CategoryModel> recyclerAdapter = new RecyclerAdapter<>(GlobalVar.firstLevelCategories, this, R.layout.item_category_first_level);
        firstLevelCategory.setAdapter(recyclerAdapter);

        searchToolbar.setOnClickListener(this);
        searchReturnBack.setOnClickListener(this);
        etSearchKey.setOnClickListener(this);
        clearSearchKey.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.search_toolbar:
                searchField.setVisibility(View.VISIBLE);
                toolbarField.setVisibility(View.GONE);
                break;
            case R.id.search_return_back:
                searchField.setVisibility(View.GONE);
                toolbarField.setVisibility(View.VISIBLE);
                break;
            case R.id.clear_search_key:
                etSearchKey.setText("");
                break;
        }
    }
}
