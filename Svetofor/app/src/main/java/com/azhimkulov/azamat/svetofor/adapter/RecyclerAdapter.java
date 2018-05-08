package com.azhimkulov.azamat.svetofor.adapter;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.azhimkulov.azamat.svetofor.R;
import com.azhimkulov.azamat.svetofor.adapter.holder.CategoryHolder;
import com.azhimkulov.azamat.svetofor.adapter.holder.FeaturesHolder;
import com.azhimkulov.azamat.svetofor.adapter.holder.GoodsHolder;
import com.azhimkulov.azamat.svetofor.adapter.holder.PhoneNumberHolder;
import com.azhimkulov.azamat.svetofor.entity.categorie_model.CategoryModel;
import com.azhimkulov.azamat.svetofor.entity.goods_model.GoodsModel;
import com.azhimkulov.azamat.svetofor.entity.phone_number_model.PhoneNumberModel;
import com.azhimkulov.azamat.svetofor.entity.product_features.ProductFeatures;
import com.azhimkulov.azamat.svetofor.screen.goods_list_activity.GoodsListActivity;
import com.azhimkulov.azamat.svetofor.screen.main_screen.goods_detail.GoodsDetailActivity;
import com.azhimkulov.azamat.svetofor.screen.main_screen.MainActivity;
import com.azhimkulov.azamat.svetofor.screen.fragment.fragment_category.FragmentCategoryView;
import com.azhimkulov.azamat.svetofor.screen.fragment.fragment_home.FragmentHomePresneter;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import java.util.List;
import java.util.Objects;


public class RecyclerAdapter<T> extends  RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private  List<T> list;
    private  Context context;
    private  int LAYOUT;
    private int categoryLevel;
    private FragmentCategoryView fragmentCategoryView;
    private String parentId;
    private CategoryModel parentCategory;

    public RecyclerAdapter(List<T> list, Context context, int LAYOUT) {
        this.list = list;
        this.context = context;
        this.LAYOUT = LAYOUT;
    }

    public RecyclerAdapter(List<T> list, Context context, int LAYOUT, FragmentCategoryView fragmentCategoryView) {
        this.list = list;
        this.context = context;
        this.LAYOUT = LAYOUT;
        this.fragmentCategoryView = fragmentCategoryView;
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
        else if (LAYOUT==R.layout.item_goods_features)
        {
            View view = LayoutInflater.from(context).inflate(R.layout.item_goods_features, parent, false);
            return new FeaturesHolder(view);
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
                    Picasso.with(context).load(goodsModel.getMain_pair().getDetailed().getHttp_image_path())
                            .resize(640,640).error(R.drawable.ic_close_grey_24dp)
                            .into(goodsHolder.goodsImage, new Callback() {
                                @Override
                                public void onSuccess() {
                                    goodsHolder.progressBar.setVisibility(View.GONE);
                                }

                                @Override
                                public void onError() {
                                    goodsHolder.progressBar.setVisibility(View.GONE);
                                }
                            });
                }

                goodsHolder.goodsNewCount.setText(String.format("$%s", splitPrice(goodsModel.getPrice())));
                goodsHolder.goodsOldCount.setText(String.format("(%s c)", goodsModel.getCurrency_price()));
                goodsHolder.goodsLinearL.setOnClickListener(view -> {
                    Intent intent = new Intent(context, GoodsDetailActivity.class);
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
            CategoryHolder categoryHolder = (CategoryHolder) holder;
            CategoryModel categorieModel = (CategoryModel) list.get(position);
            categoryHolder.categoryName.setText(categorieModel.getCategory());
            categoryHolder.categoryName.setOnClickListener(view -> {
                parentId = categorieModel.getParent_id();
                parentCategory = categorieModel;
                categoryLevel++;
                if (categoryLevel!=3)
                    fragmentCategoryView.showUnderCategory(categorieModel.getCategory_id(), categoryLevel);
                else
                {
                    categoryLevel--;
                    Intent intent = new Intent(context, GoodsListActivity.class);
                    intent.putExtra("categoryModel", categorieModel);
                    context.startActivity(intent);
                }
            });

        }
        else if (holder instanceof FeaturesHolder)
        {
            FeaturesHolder featuresHolder = (FeaturesHolder) holder;
            ProductFeatures productFeatures = (ProductFeatures) list.get(position);

//            if (productFeatures.getVariant() == null ||productFeatures.getVariant().equals(""))
//            {
//                featuresHolder.linearLayout.setVisibility(View.GONE);
//            }
//            else
//            {
                if (position%2==0)
                    featuresHolder.linearLayout.setBackgroundColor(context.getResources()
                            .getColor(R.color.white));
                else featuresHolder.linearLayout.setBackgroundColor(context.getResources()
                        .getColor(R.color.colorGreyF2));

                featuresHolder.descriptionName.setText(productFeatures.getDescription());
                featuresHolder.descriptionValue.setText(productFeatures.getVariant());
//            }
        }
    }

    private String splitPrice(String price)
    {
        int pos = price.indexOf(".")+3;
        if (price.length()>pos&&price.contains("."))
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

    public String getParentId() {
        return parentId;
    }

    public int getCategoryLevel() {
        return categoryLevel;
    }

    public void setCategoryLevel(int categoryLevel) {
        this.categoryLevel = categoryLevel;
    }

    public CategoryModel getParentCategory() {
        return parentCategory;
    }
}
