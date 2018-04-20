package com.azhimkulov.azamat.svetofor.screen.MainScreen;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.azhimkulov.azamat.svetofor.GlobalVar;
import com.azhimkulov.azamat.svetofor.R;
import com.azhimkulov.azamat.svetofor.adapter.RecyclerAdapter;
import com.azhimkulov.azamat.svetofor.dialog.CustomProgressFragmentDialog;
import com.azhimkulov.azamat.svetofor.entity.goods_model.GoodsModel;
import com.azhimkulov.azamat.svetofor.entity.phone_number_model.PhoneNumberModel;
import com.azhimkulov.azamat.svetofor.screen.CategoryScreen.CategoryActivity;
import com.azhimkulov.azamat.svetofor.screen.SearchScreen.SearchActivity;
import com.azhimkulov.azamat.svetofor.screen.fragment.fragment_category.FragmentCategory;
import com.azhimkulov.azamat.svetofor.screen.fragment.fragment_home.FragmentHome;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

public class MainActivity extends AppCompatActivity implements MainView, BottomNavigationView.OnNavigationItemSelectedListener {

    private MainPresenter mainPresenter;

    @BindString(R.string.app_name) String app_name;
    @BindView(R.id.bottom_nav) BottomNavigationViewEx bNavigationView;

    private CustomProgressFragmentDialog customProgressFragmentDialog;
    public static boolean buttonPressed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        customProgressFragmentDialog = new CustomProgressFragmentDialog(this);

        bNavigationView.enableAnimation(false);
        bNavigationView.enableShiftingMode(false);
        bNavigationView.enableItemShiftingMode(false);

        bNavigationView.setTextVisibility(false);

        bNavigationView.setPadding(0, 0, 0, 10);
        bNavigationView.setOnNavigationItemSelectedListener(this);
        bNavigationView.setSelectedItemId(R.id.bottom_nav_home);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        switch (item.getItemId()) {
            case R.id.bottom_nav_home:
                fragmentTransaction.replace(R.id.main_container, new FragmentHome());
                break;
            case R.id.bottom_nav_category:
                fragmentTransaction.replace(R.id.main_container, new FragmentCategory());
        }
        fragmentTransaction.commitAllowingStateLoss();
        return true;
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
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

}
