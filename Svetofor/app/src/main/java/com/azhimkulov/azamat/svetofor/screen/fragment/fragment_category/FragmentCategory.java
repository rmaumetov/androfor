package com.azhimkulov.azamat.svetofor.screen.fragment.fragment_category;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.azhimkulov.azamat.svetofor.GlobalVar;
import com.azhimkulov.azamat.svetofor.R;
import com.azhimkulov.azamat.svetofor.adapter.RecyclerAdapter;
import com.azhimkulov.azamat.svetofor.entity.categorie_model.CategorieModel;

import butterknife.BindColor;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by azamat  on 18.04.18.
 */

public class FragmentCategory extends Fragment {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.title_toolbar)
    TextView titleToolbar;

    @BindView(R.id.rv_first_level_categoty)
    RecyclerView firstLevelCategory;

    @BindColor(R.color.green_toolbar)
    int greenToolbar;
    @BindColor(R.color.white)
    int white;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_category, container, false);
        ButterKnife.bind(this, view);

        toolbar.setTitle("");
        titleToolbar.setText("КАТАЛОГ ТОВАРОВ");
        toolbar.setBackgroundColor(greenToolbar);
        titleToolbar.setTextColor(white);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        firstLevelCategory.setLayoutManager(layoutManager);
        firstLevelCategory.setHasFixedSize(true);
        firstLevelCategory.setNestedScrollingEnabled(false);
        RecyclerAdapter<CategorieModel> recyclerAdapter = new RecyclerAdapter<>(GlobalVar.firstLevelCategories, getContext(), R.layout.item_category_first_level);
        firstLevelCategory.setAdapter(recyclerAdapter);

        return view;
    }
}
