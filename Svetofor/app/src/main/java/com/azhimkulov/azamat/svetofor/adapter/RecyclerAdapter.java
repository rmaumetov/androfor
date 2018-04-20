package com.azhimkulov.azamat.svetofor.adapter;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.azhimkulov.azamat.svetofor.GlobalVar;
import com.azhimkulov.azamat.svetofor.R;
import com.azhimkulov.azamat.svetofor.adapter.holder.CategoryHolder;
import com.azhimkulov.azamat.svetofor.adapter.holder.CategorySecondHolder;
import com.azhimkulov.azamat.svetofor.adapter.holder.CategoryThirdHolder;
import com.azhimkulov.azamat.svetofor.adapter.holder.GoodsHolder;
import com.azhimkulov.azamat.svetofor.adapter.holder.PhoneNumberHolder;
import com.azhimkulov.azamat.svetofor.entity.categorie_model.CategorieModel;
import com.azhimkulov.azamat.svetofor.entity.goods_model.GoodsModel;
import com.azhimkulov.azamat.svetofor.entity.phone_number_model.PhoneNumberModel;
import com.azhimkulov.azamat.svetofor.screen.MainScreen.GoodsDetail.GoodsDetail;
import com.azhimkulov.azamat.svetofor.screen.MainScreen.MainActivity;
import com.azhimkulov.azamat.svetofor.screen.MainScreen.MainPresenter;
import com.azhimkulov.azamat.svetofor.screen.fragment.fragment_home.FragmentHomePresneter;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by azamat  on 03.04.18.
 */

public class RecyclerAdapter<T> extends  RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private  List<T> list;
    private  Context context;
    private  int LAYOUT;

    public RecyclerAdapter(List<T> list, Context context, int LAYOUT) {
        this.list = list;
        this.context = context;
        this.LAYOUT = LAYOUT;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (LAYOUT == R.layout.item_goods) {
            View view = LayoutInflater.from(context).inflate(R.layout.item_goods, parent, false);
            return new GoodsHolder(view);
        }
        else if (LAYOUT == R.layout.seleted_picker_item)
        {
            View view = LayoutInflater.from(context).inflate(R.layout.item_phone_number, parent,false);
            return new PhoneNumberHolder(view);
        }
        else if (LAYOUT==R.layout.item_category_first_level)
        {
            View view = LayoutInflater.from(context).inflate(R.layout.item_category_first_level, parent, false);
            return new CategoryHolder(view);
        }
        else if (LAYOUT==R.layout.item_category_second_level)
        {
            View view = LayoutInflater.from(context).inflate(R.layout.item_category_second_level, parent,false);
            return new CategorySecondHolder(view);
        }
        else if (LAYOUT==R.layout.item_category)
        {
            View view=LayoutInflater.from(context).inflate(R.layout.item_category,parent,false);
            return new CategoryThirdHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof GoodsHolder) {
            GoodsHolder goodsHolder = (GoodsHolder) holder;
            GoodsModel goodsModel = (GoodsModel) list.get(position);
            if (goodsModel != null) {
                goodsHolder.goodsCode.setText(goodsModel.getProduct_code());
                goodsHolder.goodsName.setText(goodsModel.getProduct());
                if (goodsModel.getMain_pair()!=null&&goodsModel.getMain_pair().getDetailed()!=null
                        &&goodsModel.getMain_pair().getDetailed().getHttp_image_path()!=null)
                {
                    Picasso.with(context).load(goodsModel.getMain_pair().getDetailed().getHttp_image_path()).resize(640,640).error(R.drawable.ic_close_grey_24dp).placeholder(R.drawable.ic_search_black_24dp).into(goodsHolder.goodsImage);
                }

                goodsHolder.goodsNewCount.setText(String.format("$%s", splitPrice(goodsModel.getPrice())));
                double somValue = Double.parseDouble(goodsModel.getPrice())*69.9;
                goodsHolder.goodsOldCount.setText(String.format("(%s c)", splitPrice(String.valueOf(somValue))));
                goodsHolder.goodsLinearL.setOnClickListener(view -> {
                    Intent intent = new Intent(context, GoodsDetail.class);
                    intent.putExtra("goods", goodsModel);
                    context.startActivity(intent);
                });
            }
        }
        else if (holder instanceof PhoneNumberHolder)
        {
            PhoneNumberHolder phoneNumberHolder = (PhoneNumberHolder) holder;
            PhoneNumberModel phoneNumberModel = (PhoneNumberModel) list.get(position);

            phoneNumberHolder.textRecyclerItem.setText(phoneNumberModel.getNumber());

            phoneNumberHolder.linearLayout.setOnClickListener(view -> {
                Intent intent = new Intent(Intent.ACTION_CALL);
                if (ActivityCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                    intent.setData(Uri.parse("tel:"+phoneNumberModel.getNumber()));
                    context.startActivity(intent);
                    MainActivity.buttonPressed=false;
                }
                else
                {
                    int REQUEST_PERMISSION = 10;
                    ActivityCompat.requestPermissions((Activity)context, new String[]{Manifest.permission.CALL_PHONE}, REQUEST_PERMISSION);
                }
                FragmentHomePresneter.alertDialog.dismiss();
            });

            if (position==list.size()-1)
                phoneNumberHolder.separatorView.setVisibility(View.GONE);
        }
        else if (holder instanceof CategoryHolder)
        {
            List<CategorieModel> categorieModels = new ArrayList<>();
            CategoryHolder categoryHolder = (CategoryHolder) holder;
            CategorieModel categorieModel = (CategorieModel) list.get(position);
            String currentCategoryId = categorieModel.getId_path();

            categoryHolder.categoryName.setText(categorieModel.getCategory());
            for (CategorieModel categorieModel1:GlobalVar.secondLevelCategories)
            {
                String categoryId=categorieModel1.getId_path().split("/")[0];
                if (currentCategoryId.equals(categoryId))
                    categorieModels.add(categorieModel1);
            }
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
            categoryHolder.recyclerView.setLayoutManager(layoutManager);
            categoryHolder.recyclerView.setNestedScrollingEnabled(false);
            RecyclerAdapter<CategorieModel> categorieModelRecyclerAdapter = new RecyclerAdapter<>(categorieModels,context,R.layout.item_category_second_level);
            categoryHolder.linearLayout.setOnClickListener(view -> {
                if (!categoryHolder.expandableLayout.isExpanded())
                {
                    categoryHolder.recyclerView.setAdapter(categorieModelRecyclerAdapter);
                    categoryHolder.arrow.setImageDrawable(context.getDrawable(R.drawable.ic_keyboard_arrow_up_black_24dp));
                    categoryHolder.expandableLayout.expand();
                }
                else
                {
                    categoryHolder.expandableLayout.collapse();
                    categoryHolder.arrow.setImageDrawable(context.getDrawable(R.drawable.ic_keyboard_arrow_down_grey_24dp));
                }
            });
        }
        else if (holder instanceof CategorySecondHolder)
        {
            List<CategorieModel> categorieModels = new ArrayList<>();
            CategorySecondHolder categoryHolder = (CategorySecondHolder) holder;
            CategorieModel categorieModel = (CategorieModel) list.get(position);
            String currentCategoryId = categorieModel.getId_path().split("/")[1];

            categoryHolder.categoryName.setText(categorieModel.getCategory());
            for (CategorieModel categorieModel1:GlobalVar.thirdLevelCategories)
            {
                String categoryId=categorieModel1.getId_path().split("/")[1];
                if (currentCategoryId.equals(categoryId))
                    categorieModels.add(categorieModel1);
            }
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
            categoryHolder.recyclerView.setLayoutManager(layoutManager);
            categoryHolder.recyclerView.setNestedScrollingEnabled(false);
            RecyclerAdapter<CategorieModel> categorieModelRecyclerAdapter = new RecyclerAdapter<>(categorieModels,context,R.layout.item_category);
            categoryHolder.recyclerView.setAdapter(categorieModelRecyclerAdapter);
            categoryHolder.linearLayout.setOnClickListener(view -> {
                if (!categoryHolder.expandableLayout.isExpanded())
                {
                    categoryHolder.arrow.setImageDrawable(context.getDrawable(R.drawable.ic_keyboard_arrow_up_black_24dp));
                    categoryHolder.linearLayout.setBackgroundColor(context.getResources().getColor(R.color.colorLightGrey));
                    categoryHolder.expandableLayout.expand();
                }
                else
                {
                    categoryHolder.expandableLayout.collapse();
                    categoryHolder.linearLayout.setBackgroundColor(context.getResources().getColor(R.color.colorDarkGreyF7));
                    categoryHolder.arrow.setImageDrawable(context.getDrawable(R.drawable.ic_keyboard_arrow_down_grey_24dp));
                }
            });
        }
        else if (holder instanceof CategoryThirdHolder)
        {
            CategoryThirdHolder categoryThirdHolder = (CategoryThirdHolder) holder;
            CategorieModel categorieModel =(CategorieModel) list.get(position);
            categoryThirdHolder.categoryName.setText(categorieModel.getCategory());
        }
    }

    private String splitPrice(String price)
    {
        int pos = price.indexOf(".")+3;
        if (price.length()>pos)
            return price.substring(0, pos);
        else return price;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
