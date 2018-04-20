package com.azhimkulov.azamat.svetofor.screen.fragment.fragment_home;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.azhimkulov.azamat.svetofor.GlobalVar;
import com.azhimkulov.azamat.svetofor.R;
import com.azhimkulov.azamat.svetofor.adapter.RecyclerAdapter;
import com.azhimkulov.azamat.svetofor.dialog.CustomProgressFragmentDialog;
import com.azhimkulov.azamat.svetofor.entity.goods_model.GoodsModel;
import com.azhimkulov.azamat.svetofor.entity.phone_number_model.PhoneNumberModel;
import com.azhimkulov.azamat.svetofor.screen.CategoryScreen.CategoryActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

/**
 * Created by azamat  on 18.04.18.
 */

public class FragmentHome extends Fragment implements FragmentHomeView, View.OnClickListener {

    @BindView(R.id.toolbar_search_visible) Toolbar toolbar;
    @BindView(R.id.toolbar_subtitle_visible_title) TextView titleToolbar;
    @BindView(R.id.rv_good_item) RecyclerView recyclerView;
    @BindView(R.id.rv_new_good_item) RecyclerView recyclerViewNewGoods;
    @BindView(R.id.toolbar_subtitle_visible_close) ImageView close;
    @BindView(R.id.toolbar_subtitle_visible_iv_filter) ImageView openFilterDialog;
    @BindView(R.id.fab)
    FloatingActionButton makeCall;

    @BindView(R.id.toolbar_subtitle_visible_subtitle) TextView subtitleToolbar;
    @BindView(R.id.ll_toolbar_subtitle_visible) LinearLayout llToolbar;
    @BindView(R.id.ll_toolbar_subtitle_visible_for_search) LinearLayout llSearch;
    @BindView(R.id.toolbar_subtitle_visible_edit) TextView searchSalePoint;
    @BindView(R.id.catalog_of_goods)
    RelativeLayout catalogOfGoods;
    @BindView(R.id.catalog_of_goods_bottom)
    RelativeLayout catalogOfGoodsBottom;

    @BindString(R.string.app_name) String app_name;
    private List<PhoneNumberModel> numberArrayList = new ArrayList<>();

    private FragmentHomePresneter fragmentHomePresneter;
    private List<GoodsModel> goodsModels;
    private RecyclerView.LayoutManager layoutManager;

    private CustomProgressFragmentDialog customProgressFragmentDialog;
    private RecyclerAdapter<GoodsModel> recyclerAdapter;
    public static boolean buttonPressed;
    private RecyclerView.LayoutManager layoutManager2;
    private RecyclerAdapter<GoodsModel> recyclerAdapterNewGoods;
    private static final int REQUEST_PERMISSION = 10;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, view);

        toolbar.setTitle("");
        titleToolbar.setText(app_name);


        numberArrayList.add(new PhoneNumberModel("+996 (312) 97-69-97", 0, ""));
        numberArrayList.add(new PhoneNumberModel("+996 (555) 93-88-33", 1, ""));
        numberArrayList.add(new PhoneNumberModel("+996 (773) 93-88-33", 2, "Вотсап"));
        numberArrayList.add(new PhoneNumberModel("+996 (700) 93-88-33", 3, "Вотсап"));
        numberArrayList.add(new PhoneNumberModel("+996 (701) 99-44-57", 4, "Ош"));
        numberArrayList.add(new PhoneNumberModel("+996 (704) 93-88-33", 5, "Нарын"));

        layoutManager = new GridLayoutManager(getContext(), 2);
        layoutManager2 = new GridLayoutManager(getContext(), 2);
        fragmentHomePresneter = new FragmentHomePresneter(getContext(), this);
        goodsModels = new ArrayList<>();
        goodsModels.addAll(GlobalVar.bestSellers);
        recyclerView.setLayoutManager(layoutManager);
        recyclerAdapter = new RecyclerAdapter<>(GlobalVar.bestSellers, getContext(), R.layout.item_goods);
        recyclerAdapterNewGoods = new RecyclerAdapter<>(GlobalVar.newGoods, getContext(), R.layout.item_goods);
        recyclerView.setAdapter(recyclerAdapter);
        recyclerViewNewGoods.setLayoutManager(layoutManager2);
        recyclerViewNewGoods.setAdapter(recyclerAdapterNewGoods);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerViewNewGoods.setNestedScrollingEnabled(false);

        close.setOnClickListener(this);
        openFilterDialog.setOnClickListener(this);
        catalogOfGoods.setOnClickListener(this);
        catalogOfGoodsBottom.setOnClickListener(this);
        makeCall.setOnClickListener(this);

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
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.toolbar_subtitle_visible_close:
                llSearch.setVisibility(GONE);
                llToolbar.setVisibility(VISIBLE);
                openFilterDialog.setVisibility(VISIBLE);
                recyclerAdapter.setList(goodsModels);
                recyclerAdapter.notifyDataSetChanged();
                break;
            case R.id.toolbar_subtitle_visible_iv_filter:
//                Toast.makeText(this, "Функция на стадии разработки", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getContext(), CategoryActivity.class));
                break;
            case R.id.fab:
                fragmentHomePresneter.getPermission(numberArrayList);
                break;
            case R.id.catalog_of_goods:
                startActivity(new Intent(getContext(), CategoryActivity.class));
                break;
            case R.id.catalog_of_goods_bottom:
                startActivity(new Intent(getContext(), CategoryActivity.class));
                break;
        }
    }

    @Override
    public void setResponseGoods(List<GoodsModel> products) {

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case REQUEST_PERMISSION: {
                buttonPressed = grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED;
                break;
            }
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (buttonPressed)
            fragmentHomePresneter.showDialogView(numberArrayList);
    }

    //    @Override
//    protected void onResume() {
//        super.onResume();
//        if (buttonPressed)
//            fragmentHomePresneter.showDialogView(numberArrayList);
//    }
}
