package com.azhimkulov.azamat.svetofor.screen.goods_list_activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.azhimkulov.azamat.svetofor.R;
import com.azhimkulov.azamat.svetofor.adapter.RecyclerAdapter;
import com.azhimkulov.azamat.svetofor.dialog.CustomProgressFragmentDialog;
import com.azhimkulov.azamat.svetofor.entity.categorie_model.CategoryModel;
import com.azhimkulov.azamat.svetofor.entity.goods_model.GoodsModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;

public class GoodsListActivity extends AppCompatActivity implements GoodsListView, View.OnClickListener {

    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.title_toolbar) TextView titleToolbar;
    @BindView(R.id.search_toolbar) ImageView searchToolbar;
    @BindView(R.id.search_return_back) ImageView searchReturnBack;
    @BindView(R.id.et_search_key) EditText etSearchKey;
    @BindView(R.id.clear_search_key) ImageView clearSearchKey;
    @BindView(R.id.toolbar_field) LinearLayout toolbarField;
    @BindView(R.id.search_field) LinearLayout searchField;

    private CategoryModel categoryModel;
    @BindView(R.id.rv_goods) RecyclerView recyclerView;
    private RecyclerAdapter<GoodsModel> recyclerAdapter;
    private GoodsListPresenter goodsListPresenter;
    private List<GoodsModel> list=new ArrayList<>();
    private CustomProgressFragmentDialog customProgressFragmentDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods_list);
        ButterKnife.bind(this);
        toolbar.setTitle("");
        categoryModel =(CategoryModel) getIntent().getSerializableExtra("categoryModel");
        titleToolbar.setText(categoryModel.getCategory());
        customProgressFragmentDialog = new CustomProgressFragmentDialog(this);
        goodsListPresenter = new GoodsListPresenter(this,this);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setNestedScrollingEnabled(false);
        goodsListPresenter.getGoodsByCategory(categoryModel.getCategory_id());

        etSearchKey.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (recyclerAdapter!=null){
                    Observable.fromIterable(list)
                            .filter(item -> item.getProduct().toUpperCase().contains(charSequence
                                    .toString().toUpperCase()))
                            .toList().subscribe(lists -> recyclerAdapter.setList(lists));
                    recyclerAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

        searchToolbar.setOnClickListener(this);
        searchReturnBack.setOnClickListener(this);
        etSearchKey.setOnClickListener(this);
        clearSearchKey.setOnClickListener(this);
    }

    @Override
    public void showLoading() {
        customProgressFragmentDialog.show();
    }

    @Override
    public void hideLoading() {
        customProgressFragmentDialog.dismiss();
    }

    @Override
    public void errorResponse(String s) {

    }

    @Override
    public void setResultGoods(List<GoodsModel> products) {
        list.addAll(products);
        recyclerAdapter = new RecyclerAdapter<GoodsModel>(products, this, R.layout.item_goods);
        recyclerView.setAdapter(recyclerAdapter);
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
