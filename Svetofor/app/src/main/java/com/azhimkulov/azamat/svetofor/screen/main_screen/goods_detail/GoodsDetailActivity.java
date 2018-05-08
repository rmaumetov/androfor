package com.azhimkulov.azamat.svetofor.screen.main_screen.goods_detail;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.azhimkulov.azamat.svetofor.R;
import com.azhimkulov.azamat.svetofor.entity.goods_model.GoodsModel;
import com.azhimkulov.azamat.svetofor.screen.main_screen.goods_detail.goods_fragment.fragment_about_goods.AboutGoods;
import com.azhimkulov.azamat.svetofor.screen.main_screen.goods_detail.goods_fragment.fragment_goods_properties.GoodsProperties;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;

public class GoodsDetailActivity extends AppCompatActivity implements GoodsDetailView {

    private GoodsModel goodsModel;
    @BindView(R.id.general_layout)
    LinearLayout nestedScrollView;
    @BindView(R.id.tab_layout)
    TabLayout tabLayout;

    @BindString(R.string.old_price) String oldPrice;
    @BindString(R.string.new_price) String newPrice;
    @BindString(R.string.zip_code) String zipCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods_detail);
        ButterKnife.bind(this);
        goodsModel = (GoodsModel) getIntent().getSerializableExtra("goods");

        tabLayout.addTab(tabLayout.newTab().setText("ТОВАР"));
        tabLayout.addTab(tabLayout.newTab().setText("ХАРАКТЕРИСТИКИ"));

        replaceFragment(new AboutGoods(goodsModel));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition())
                {
                    case 0:
                        replaceFragment(new AboutGoods(goodsModel));
                        break;
                    case 1:
                        replaceFragment(new GoodsProperties(goodsModel));
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

//    private String splitPrice(String price) {
//        int pos = price.indexOf(".") + 3;
//        if (price.length() > pos && price.contains(".")) return price.substring(0, pos);
//        else return price;
//    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void errorResponse(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }


    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);

        transaction.commit();
    }
}
