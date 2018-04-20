package com.azhimkulov.azamat.svetofor.screen.MainScreen;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.azhimkulov.azamat.svetofor.App;
import com.azhimkulov.azamat.svetofor.R;
import com.azhimkulov.azamat.svetofor.adapter.RecyclerAdapter;
import com.azhimkulov.azamat.svetofor.api.AsyncTransformer;
import com.azhimkulov.azamat.svetofor.entity.api_model.ResponseModel;
import com.azhimkulov.azamat.svetofor.entity.goods_model.GoodsModel;
import com.azhimkulov.azamat.svetofor.entity.phone_number_model.PhoneNumberModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by azamat  on 02.04.18.
 */

public class MainPresenter {
    private Context context;
    private MainView mainView;
    private RecyclerAdapter mAdapter;
    public static AlertDialog alertDialog;

    public MainPresenter(Context context, MainView mainView) {
        this.context = context;
        this.mainView = mainView;
    }

    private void error(Throwable throwable) {
        mainView.errorResponse(throwable.getMessage());
    }




}
