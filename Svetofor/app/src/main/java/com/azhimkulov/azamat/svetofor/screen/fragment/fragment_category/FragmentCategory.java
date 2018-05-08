package com.azhimkulov.azamat.svetofor.screen.fragment.fragment_category;

import android.annotation.SuppressLint;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.azhimkulov.azamat.svetofor.GlobalVar;
import com.azhimkulov.azamat.svetofor.R;
import com.azhimkulov.azamat.svetofor.adapter.RecyclerAdapter;
import com.azhimkulov.azamat.svetofor.entity.categorie_model.CategoryModel;
import com.azhimkulov.azamat.svetofor.screen.main_screen.MainView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindColor;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by azamat  on 18.04.18.
 */

public class FragmentCategory extends Fragment implements FragmentCategoryView {

    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.title_toolbar) TextView titleToolbar;
    @BindView(R.id.rv_first_level_categoty) RecyclerView firstLevelCategory;
    @BindView(R.id.icon_in_toolbar) ImageView onBack;

    @BindColor(R.color.green_toolbar)
    int greenToolbar;
    @BindColor(R.color.white)
    int white;
    private RecyclerAdapter<CategoryModel> recyclerAdapter;
    private MainView mainView;
    private String categoryId;
    private int categoryLevel;

    public FragmentCategory() {
        categoryLevel=0;
    }

    @SuppressLint("ValidFragment")
    public FragmentCategory(MainView mainView) {
        this.mainView = mainView;
    }

    @SuppressLint("ValidFragment")
    public FragmentCategory(MainView mainView, String categoryId, int categoryLevel) {
        this.mainView = mainView;
        this.categoryId = categoryId;
        this.categoryLevel = categoryLevel;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_new_category, container, false);
        ButterKnife.bind(this, view);

        toolbar.setTitle("");
        titleToolbar.setText("КАТАЛОГ ТОВАРОВ");
        toolbar.setBackgroundColor(greenToolbar);
        titleToolbar.setTextColor(white);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        firstLevelCategory.setLayoutManager(layoutManager);
        firstLevelCategory.setHasFixedSize(true);
        firstLevelCategory.setNestedScrollingEnabled(false);
        recyclerAdapter = new RecyclerAdapter<>(GlobalVar.firstLevelCategories, getContext(), R.layout.item_category_first_level, this);
        firstLevelCategory.setAdapter(recyclerAdapter);
        if (categoryLevel==0)
        {
            onBack.setVisibility(View.INVISIBLE);
            titleToolbar.setText("КАТАЛОГ ТОВАРОВ");
            recyclerAdapter = new RecyclerAdapter<>(GlobalVar.firstLevelCategories, getContext(), R.layout.item_category_first_level, this);
            firstLevelCategory.setAdapter(recyclerAdapter);
        }
        else if(categoryLevel==1)
        {
            onBack.setVisibility(View.VISIBLE);
            List<CategoryModel> categorieModels = new ArrayList<>();
            for (CategoryModel categorieModel:GlobalVar.firstLevelCategories)
            {
                if (categorieModel.getCategory_id().equals(categoryId))
                {
                    titleToolbar.setText(categorieModel.getCategory());
                    break;
                }
            }
            for (CategoryModel categorieModel:GlobalVar.secondLevelCategories)
            {
                if (categorieModel.getParent_id().equals(categoryId))
                    categorieModels.add(categorieModel);
            }
            if (recyclerAdapter!=null)
            {
                recyclerAdapter.setList(categorieModels);
                recyclerAdapter.setCategoryLevel(categoryLevel);
                recyclerAdapter.notifyDataSetChanged();
            }
            else
            {
                recyclerAdapter = new RecyclerAdapter<>(categorieModels, getContext(), R.layout.item_category_first_level, this);
                recyclerAdapter.setCategoryLevel(categoryLevel);
                firstLevelCategory.setAdapter(recyclerAdapter);
            }
        }
        else if(categoryLevel==2)
        {
            onBack.setVisibility(View.VISIBLE);
            List<CategoryModel> categorieModels = new ArrayList<>();
            for (CategoryModel categorieModel:GlobalVar.secondLevelCategories)
            {
                if (categorieModel.getCategory_id().equals(categoryId))
                {
                    titleToolbar.setText(categorieModel.getCategory());
                    break;
                }
            }
            for (CategoryModel categorieModel:GlobalVar.thirdLevelCategories)
            {
                if (categorieModel.getParent_id().equals(categoryId))
                    categorieModels.add(categorieModel);
            }
            if (recyclerAdapter!=null)
            {
                recyclerAdapter.setList(categorieModels);
                recyclerAdapter.setCategoryLevel(categoryLevel);
                recyclerAdapter.notifyDataSetChanged();
            }
            else
            {
                recyclerAdapter = new RecyclerAdapter<>(categorieModels, getContext(), R.layout.item_category_first_level, this);
                recyclerAdapter.setCategoryLevel(categoryLevel);
                firstLevelCategory.setAdapter(recyclerAdapter);
            }
        }

        onBack.setOnClickListener(view1 -> {
            onBackPressed();
        });
        return view;
    }

    public void onBackPressed()
    {
//        int level = recyclerAdapter.getCategoryLevel();
//        categoryId = recyclerAdapter.getParentId();
//        CategorieModel parent = recyclerAdapter.getParentCategory();
//        if (level>0&&level<3)
//            level--;
//        if (level==0)
//        {
        onBack.setVisibility(View.INVISIBLE);
            titleToolbar.setText("КАТАЛОГ ТОВАРОВ");
            recyclerAdapter.setList(GlobalVar.firstLevelCategories);
            recyclerAdapter.setCategoryLevel(0);
            recyclerAdapter.notifyDataSetChanged();
//        }
//        else if (level==1)
//        {
//            for (CategorieModel categorieModel:GlobalVar.firstLevelCategories)
//                if (categorieModel.getCategory_id().equals(parent.getParent_id()))
//                    categoryId = categorieModel.getCategory_id();
//            List<CategorieModel> categorieModels = new ArrayList<>();
//            for (CategorieModel categorieModel:GlobalVar.secondLevelCategories)
//            {
//                if (categorieModel.getParent_id().equals(categoryId))
//                    categorieModels.add(categorieModel);
//            }
//            recyclerAdapter.setList(categorieModels);
//            recyclerAdapter.notifyDataSetChanged();
//        }
    }

    public Pair<Integer, String> getCategoryLevel() {
        categoryLevel = recyclerAdapter.getCategoryLevel();
        categoryId = recyclerAdapter.getParentId();
        return new Pair<>(categoryLevel, categoryId);
    }

    @Override
    public void showUnderCategory(String categoryId, int categoryLevel) {
        mainView.changeFragmentForChild(categoryId, categoryLevel);
    }
}
