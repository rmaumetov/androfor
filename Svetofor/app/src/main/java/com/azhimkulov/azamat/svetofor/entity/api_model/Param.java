package com.azhimkulov.azamat.svetofor.entity.api_model;

import java.util.List;

/**
 * Created by azamat  on 02.04.18.
 */

class Param {
    private String area;
    private boolean use_caching;
    private List<String> extend;
    private List<String> custom_extend;
    private String pname;
    private String pshort;
    private String pfull;
    private String pkeywords;
//    private List<?> feature;
    private String type;
    private int page;
    private String action;
//    private List<?> filter_variants;
    private String features_hash;
    private int limit;
    private int bid;
    private String match;
//    private List<?> tracking;
    private boolean get_frontend_urls;
    private int items_per_page;
    private String apply_disabled_filters;
    private int ajax_custom;
    private String sort_by;
    private String sort_order;
    private String sort_order_rev;
    private long total_items;


    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public boolean isUse_caching() {
        return use_caching;
    }

    public void setUse_caching(boolean use_caching) {
        this.use_caching = use_caching;
    }

    public List<String> getExtend() {
        return extend;
    }

    public void setExtend(List<String> extend) {
        this.extend = extend;
    }

    public List<String> getCustom_extend() {
        return custom_extend;
    }

    public void setCustom_extend(List<String> custom_extend) {
        this.custom_extend = custom_extend;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPshort() {
        return pshort;
    }

    public void setPshort(String pshort) {
        this.pshort = pshort;
    }

    public String getPfull() {
        return pfull;
    }

    public void setPfull(String pfull) {
        this.pfull = pfull;
    }

    public String getPkeywords() {
        return pkeywords;
    }

    public void setPkeywords(String pkeywords) {
        this.pkeywords = pkeywords;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getFeatures_hash() {
        return features_hash;
    }

    public void setFeatures_hash(String features_hash) {
        this.features_hash = features_hash;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public String getMatch() {
        return match;
    }

    public void setMatch(String match) {
        this.match = match;
    }

    public boolean isGet_frontend_urls() {
        return get_frontend_urls;
    }

    public void setGet_frontend_urls(boolean get_frontend_urls) {
        this.get_frontend_urls = get_frontend_urls;
    }

    public int getItems_per_page() {
        return items_per_page;
    }

    public void setItems_per_page(int items_per_page) {
        this.items_per_page = items_per_page;
    }

    public String getApply_disabled_filters() {
        return apply_disabled_filters;
    }

    public void setApply_disabled_filters(String apply_disabled_filters) {
        this.apply_disabled_filters = apply_disabled_filters;
    }

    public int getAjax_custom() {
        return ajax_custom;
    }

    public void setAjax_custom(int ajax_custom) {
        this.ajax_custom = ajax_custom;
    }

    public String getSort_by() {
        return sort_by;
    }

    public void setSort_by(String sort_by) {
        this.sort_by = sort_by;
    }

    public String getSort_order() {
        return sort_order;
    }

    public void setSort_order(String sort_order) {
        this.sort_order = sort_order;
    }

    public String getSort_order_rev() {
        return sort_order_rev;
    }

    public void setSort_order_rev(String sort_order_rev) {
        this.sort_order_rev = sort_order_rev;
    }

    public long getTotal_items() {
        return total_items;
    }

    public void setTotal_items(long total_items) {
        this.total_items = total_items;
    }
}
