package com.azhimkulov.azamat.svetofor.screen.main_screen;

import android.content.Context;
import android.support.v7.app.AlertDialog;

import com.azhimkulov.azamat.svetofor.adapter.RecyclerAdapter;

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
