package com.azhimkulov.azamat.svetofor.adapter.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.azhimkulov.azamat.svetofor.R;

import net.cachapa.expandablelayout.ExpandableLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by azamat  on 12.04.18.
 */

public class CategoryHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.tv_category_name)
    public TextView categoryName;
    @BindView(R.id.el_next_category_level)
    public ExpandableLayout expandableLayout;
    @BindView(R.id.rv_category_expandable)
    public RecyclerView recyclerView;

    @BindView(R.id.ll_category)
    public LinearLayout linearLayout;

    @BindView(R.id.iv_category_arrow)
    public ImageView arrow;

    public CategoryHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
