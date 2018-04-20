package com.azhimkulov.azamat.svetofor.adapter.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.azhimkulov.azamat.svetofor.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by azamat  on 12.04.18.
 */

public class CategoryThirdHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.tv_category_name)
    public TextView categoryName;
    public CategoryThirdHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
