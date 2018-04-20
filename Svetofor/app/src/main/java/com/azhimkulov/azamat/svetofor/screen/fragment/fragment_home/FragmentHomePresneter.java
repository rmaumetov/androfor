package com.azhimkulov.azamat.svetofor.screen.fragment.fragment_home;

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

/**
 * Created by azamat  on 18.04.18.
 */

public class FragmentHomePresneter {
    private Context context;
    private FragmentHomeView fragmentHomeView;
    private RecyclerAdapter<PhoneNumberModel> mAdapter;
    public static AlertDialog alertDialog;

    public FragmentHomePresneter(Context context, FragmentHomeView fragmentHomeView) {
        this.context = context;
        this.fragmentHomeView = fragmentHomeView;
    }

    void getPermission(List<PhoneNumberModel> numberArrayList)
    {
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
            showDialogView(numberArrayList);
        }
        else
        {
            int REQUEST_PERMISSION = 10;
            ActivityCompat.requestPermissions((Activity)context, new String[]{Manifest.permission.CALL_PHONE}, REQUEST_PERMISSION);
        }
    }

    void showDialogView(List<PhoneNumberModel> numberList)
    {
        View dialogView = View.inflate(context, R.layout.seleted_picker_item, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setCancelable(true);
        builder.setView(dialogView);

        alertDialog = builder.create();

        RecyclerView.LayoutManager mLayoutManager;
        RecyclerView mRecyclerView = dialogView.findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(context);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new RecyclerAdapter<>(numberList, context, R.layout.seleted_picker_item);
        mRecyclerView.setAdapter(mAdapter);
        alertDialog.show();
    }
}
