package com.azhimkulov.azamat.svetofor.screen.main_screen;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.azhimkulov.azamat.svetofor.R;
import com.azhimkulov.azamat.svetofor.dialog.CustomProgressFragmentDialog;
import com.azhimkulov.azamat.svetofor.screen.fragment.fragment_category.FragmentCategory;
import com.azhimkulov.azamat.svetofor.screen.fragment.fragment_home.FragmentHome;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainView, BottomNavigationView.OnNavigationItemSelectedListener {

    private MainPresenter mainPresenter;

    @BindString(R.string.app_name) String app_name;
    @BindView(R.id.bottom_nav) BottomNavigationViewEx bNavigationView;

    private CustomProgressFragmentDialog customProgressFragmentDialog;
    public static boolean buttonPressed;
    FragmentCategory fragmentCategory;
    private Integer level;

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
        fragmentCategory = new FragmentCategory(this);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        switch (item.getItemId()) {
            case R.id.bottom_nav_home:
                fragmentTransaction.replace(R.id.main_container, new FragmentHome());
                break;
            case R.id.bottom_nav_category:
                fragmentTransaction.replace(R.id.main_container, fragmentCategory);
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

    @Override
    public void onBackPressed() {
       AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Выход")
                .setMessage("Вы уверены хотите выйти?")
                .setIcon(R.drawable.ic_info_black_24dp)
                .setCancelable(true)
                .setNeutralButton("Нет", (dialog, which) -> dialog.dismiss())
                .setPositiveButton("Да", (dialog, which) -> finish());
        AlertDialog alert = builder.create();
        alert.show();
    }

    @Override
    public void changeFragmentForChild(String categoryId, int categoryLevel) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        FragmentCategory fragmentCategory1 = new FragmentCategory(this, categoryId, categoryLevel);
        fragmentTransaction.replace(R.id.main_container, fragmentCategory1);
        fragmentTransaction.commitAllowingStateLoss();
    }
}
