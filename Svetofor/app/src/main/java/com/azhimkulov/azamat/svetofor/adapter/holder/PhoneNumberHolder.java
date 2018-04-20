package com.azhimkulov.azamat.svetofor.adapter.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.azhimkulov.azamat.svetofor.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by azamat  on 09.04.18.
 */

public class PhoneNumberHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.lineL) public LinearLayout linearLayout;
    @BindView(R.id.pointName) public TextView textRecyclerItem;
    @BindView(R.id.separator_view) public View separatorView;

    public PhoneNumberHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
