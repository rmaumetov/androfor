package com.azhimkulov.azamat.svetofor.entity.goods_detail;

import com.azhimkulov.azamat.svetofor.entity.main_pair.MainPair;
import com.azhimkulov.azamat.svetofor.entity.product_features.ProductFeatures;

import java.util.List;

/**
 * Created by azamat  on 30.04.18.
 */

public class GoodsDetail {
    private String full_description;
    private List<ProductFeatures> product_features;
    private String product;
    private String availibility_status;
    private List<MainPair> image_pairs;

    public String getFull_description() {
        return full_description;
    }

    public void setFull_description(String full_description) {
        this.full_description = full_description;
    }

    public List<ProductFeatures> getProduct_features() {
        return product_features;
    }

    public void setProduct_features(List<ProductFeatures> product_features) {
        this.product_features = product_features;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getAvailibility_status() {
        return availibility_status;
    }

    public void setAvailibility_status(String availibility_status) {
        this.availibility_status = availibility_status;
    }

    public List<MainPair> getImage_pairs() {
        return image_pairs;
    }

    public void setImage_pairs(List<MainPair> image_pairs) {
        this.image_pairs = image_pairs;
    }
}
