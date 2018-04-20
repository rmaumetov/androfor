package com.azhimkulov.azamat.svetofor.screen.SearchScreen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;

import com.azhimkulov.azamat.svetofor.R;
import com.azhimkulov.azamat.svetofor.adapter.RecyclerAdapter;
import com.azhimkulov.azamat.svetofor.entity.goods_model.GoodsModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;

public class SearchActivity extends AppCompatActivity {

    @BindView(R.id.list_search_tp)
    RecyclerView recyclerView;
    @BindView(R.id.toolbar_search)
    Toolbar toolbar;
    @BindView(R.id.toolbar_search_edit)
    EditText editSearch;
    @BindView(R.id.clear_search_text)
    ImageView clearSearch;
    private List<GoodsModel> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        toolbar.setTitle("");

        if (getSupportActionBar()!=null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        list = (List<GoodsModel>) getIntent().getExtras().get("goods_list");

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerAdapter<GoodsModel> recyclerAdapter = new RecyclerAdapter<>(list, this, R.layout.item_goods);
        recyclerView.setAdapter(recyclerAdapter);
        recyclerView.setNestedScrollingEnabled(false);

        clearSearch.setOnClickListener(view -> {
            editSearch.setText("");
        });

        editSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                List<GoodsModel> result = Observable.fromIterable(list)
                        .filter(item -> item.getProduct().toUpperCase().contains(editSearch.getText().toString().toUpperCase())).toList().blockingGet();
                recyclerAdapter.setList(result);
                recyclerAdapter.notifyDataSetChanged();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
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
}
