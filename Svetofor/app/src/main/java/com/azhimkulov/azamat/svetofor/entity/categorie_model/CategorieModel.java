package com.azhimkulov.azamat.svetofor.entity.categorie_model;

/**
 * Created by azamat  on 09.04.18.
 */

public class CategorieModel {
    private String category_id;
    private String parent_id;
    private String id_path;
    private String category;
    private String position;
    private String status;
    private String product_count;
    private String company_id;
    private String seo_name;
    private String seo_path;

    public String getCategory_id() {
        return category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    public String getParent_id() {
        return parent_id;
    }

    public void setParent_id(String parent_id) {
        this.parent_id = parent_id;
    }

    public String getId_path() {
        return id_path;
    }

    public void setId_path(String id_path) {
        this.id_path = id_path;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getProduct_count() {
        return product_count;
    }

    public void setProduct_count(String product_count) {
        this.product_count = product_count;
    }

    public String getCompany_id() {
        return company_id;
    }

    public void setCompany_id(String company_id) {
        this.company_id = company_id;
    }

    public String getSeo_name() {
        return seo_name;
    }

    public void setSeo_name(String seo_name) {
        this.seo_name = seo_name;
    }

    public String getSeo_path() {
        return seo_path;
    }

    public void setSeo_path(String seo_path) {
        this.seo_path = seo_path;
    }
}
