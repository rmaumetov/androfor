package com.azhimkulov.azamat.svetofor.adapter.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.azhimkulov.azamat.svetofor.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by azamat  on 07.05.18.
 */

public class FeaturesHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.description_value) public TextView descriptionValue;
    @BindView(R.id.description_name) public TextView descriptionName;
    @BindView(R.id.general_layout) public LinearLayout linearLayout;

    public FeaturesHolder(View view) {
        super(view);
        ButterKnife.bind(this, view);
    }
}
