package com.azhimkulov.azamat.svetofor.screen.search_screen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.azhimkulov.azamat.svetofor.R;
import com.azhimkulov.azamat.svetofor.adapter.RecyclerAdapter;
import com.azhimkulov.azamat.svetofor.entity.goods_model.GoodsModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;

public class SearchActivity extends AppCompatActivity implements View.OnClickListener, SearchView {

    @BindView(R.id.search_return_back) ImageView searchReturnBack;
    @BindView(R.id.et_search_key) EditText etSearchKey;
    @BindView(R.id.clear_search_key) ImageView clearSearchKey;
    @BindView(R.id.search_field) LinearLayout searchField;

    @BindView(R.id.list_search_tp)
    RecyclerView recyclerView;
    private List<GoodsModel> list = new ArrayList<>();
    private SearchPresenter searchPresenter;
    private RecyclerAdapter<GoodsModel> recyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);
        searchPresenter = new SearchPresenter(this,this);
        if (getSupportActionBar()!=null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerAdapter = new RecyclerAdapter<>(list, this, R.layout.item_goods);
        recyclerView.setAdapter(recyclerAdapter);
        recyclerView.setNestedScrollingEnabled(false);

        etSearchKey.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                searchPresenter.getGoodsBySearchKey(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        searchReturnBack.setOnClickListener(this);
        etSearchKey.setOnClickListener(this);
        clearSearchKey.setOnClickListener(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return true;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.search_toolbar:
                break;
            case R.id.search_return_back:
                finish();
                break;
            case R.id.clear_search_key:
                etSearchKey.setText("");
                break;
        }
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
    public void setResultSearch(List<GoodsModel> products) {
        recyclerAdapter.setList(products);
        recyclerAdapter.notifyDataSetChanged();
    }
}
