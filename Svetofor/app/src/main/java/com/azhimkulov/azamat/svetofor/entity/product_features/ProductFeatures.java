package com.azhimkulov.azamat.svetofor.entity.product_features;

/**
 * Created by azamat  on 06.05.18.
 */

public class ProductFeatures {
    private String feature_id;
    private String description;
    private String variant;

    public String getFeature_id() {
        return feature_id;
    }

    public void setFeature_id(String feature_id) {
        this.feature_id = feature_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVariant() {
        return variant;
    }

    public void setVariant(String variant) {
        this.variant = variant;
    }
}
