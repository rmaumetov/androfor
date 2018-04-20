package com.azhimkulov.azamat.svetofor.entity.goods_model;

import com.azhimkulov.azamat.svetofor.entity.main_pair.MainPair;

import java.io.Serializable;
import java.util.List;

/**
 * Created by azamat  on 02.04.18.
 */

public class GoodsModel implements Serializable {
    private long product_id;
    private String product;
    private long supplier_id;
    private String product_code;
    private String product_type;
    private String status;
    private String company_id;
    private String list_price;
    private String amount;
    private String weight;
    private String length;
    private String width;
    private String shipping_freight;
    private String low_avail_limit;
    private String timestamp;
    private String updated_timestamp;
    private String usergroup_ids;
    private String is_edp;
    private String edp_shipping;
    private String unlimited_download;
    private String tracking;
    private String free_shipping;
    private String zero_price_action;
    private String is_pbp;
    private String is_op;
    private String is_oper;
    private String is_returnable;
    private String return_period;
    private String avail_since;
    private String out_of_stock_actions;
    private String localization;
    private String min_qty;
    private String max_qty;
    private String qty_step;
    private String list_qty_count;
    private String tax_ids;
    private String age_verification;
    private String age_limit;
    private String options_type;
    private String exceptions_type;
    private String details_layout;
    private String shipping_params;
    private String facebook_obj_type;
    private String show_yandex_rev;
    private String enable_market_xml;
    private String warranty;
//    "installation_details": null,
//    "addition_labels": null,
//            "color": null,
//            "related_with": null,
    private String enable_mailru_market_xml;
    private String cbid_mailru_market;
    private String price;
    private List<Integer> category_ids;
    private String seo_name;
    private String seo_path;
//    average_rating
    private String discussion_type;
    private String discussion_thread_id;
    private int main_category;
    private MainPair main_pair;
    private String base_price;


    public long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(long product_id) {
        this.product_id = product_id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public long getSupplier_id() {
        return supplier_id;
    }

    public void setSupplier_id(long supplier_id) {
        this.supplier_id = supplier_id;
    }

    public String getProduct_code() {
        return product_code;
    }

    public void setProduct_code(String product_code) {
        this.product_code = product_code;
    }

    public String getProduct_type() {
        return product_type;
    }

    public void setProduct_type(String product_type) {
        this.product_type = product_type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCompany_id() {
        return company_id;
    }

    public void setCompany_id(String company_id) {
        this.company_id = company_id;
    }

    public String getList_price() {
        return list_price;
    }

    public void setList_price(String list_price) {
        this.list_price = list_price;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getShipping_freight() {
        return shipping_freight;
    }

    public void setShipping_freight(String shipping_freight) {
        this.shipping_freight = shipping_freight;
    }

    public String getLow_avail_limit() {
        return low_avail_limit;
    }

    public void setLow_avail_limit(String low_avail_limit) {
        this.low_avail_limit = low_avail_limit;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getUpdated_timestamp() {
        return updated_timestamp;
    }

    public void setUpdated_timestamp(String updated_timestamp) {
        this.updated_timestamp = updated_timestamp;
    }

    public String getUsergroup_ids() {
        return usergroup_ids;
    }

    public void setUsergroup_ids(String usergroup_ids) {
        this.usergroup_ids = usergroup_ids;
    }

    public String getIs_edp() {
        return is_edp;
    }

    public void setIs_edp(String is_edp) {
        this.is_edp = is_edp;
    }

    public String getEdp_shipping() {
        return edp_shipping;
    }

    public void setEdp_shipping(String edp_shipping) {
        this.edp_shipping = edp_shipping;
    }

    public String getUnlimited_download() {
        return unlimited_download;
    }

    public void setUnlimited_download(String unlimited_download) {
        this.unlimited_download = unlimited_download;
    }

    public String getTracking() {
        return tracking;
    }

    public void setTracking(String tracking) {
        this.tracking = tracking;
    }

    public String getFree_shipping() {
        return free_shipping;
    }

    public void setFree_shipping(String free_shipping) {
        this.free_shipping = free_shipping;
    }

    public String getZero_price_action() {
        return zero_price_action;
    }

    public void setZero_price_action(String zero_price_action) {
        this.zero_price_action = zero_price_action;
    }

    public String getIs_pbp() {
        return is_pbp;
    }

    public void setIs_pbp(String is_pbp) {
        this.is_pbp = is_pbp;
    }

    public String getIs_op() {
        return is_op;
    }

    public void setIs_op(String is_op) {
        this.is_op = is_op;
    }

    public String getIs_oper() {
        return is_oper;
    }

    public void setIs_oper(String is_oper) {
        this.is_oper = is_oper;
    }

    public String getIs_returnable() {
        return is_returnable;
    }

    public void setIs_returnable(String is_returnable) {
        this.is_returnable = is_returnable;
    }

    public String getReturn_period() {
        return return_period;
    }

    public void setReturn_period(String return_period) {
        this.return_period = return_period;
    }

    public String getAvail_since() {
        return avail_since;
    }

    public void setAvail_since(String avail_since) {
        this.avail_since = avail_since;
    }

    public String getOut_of_stock_actions() {
        return out_of_stock_actions;
    }

    public void setOut_of_stock_actions(String out_of_stock_actions) {
        this.out_of_stock_actions = out_of_stock_actions;
    }

    public String getLocalization() {
        return localization;
    }

    public void setLocalization(String localization) {
        this.localization = localization;
    }

    public String getMin_qty() {
        return min_qty;
    }

    public void setMin_qty(String min_qty) {
        this.min_qty = min_qty;
    }

    public String getMax_qty() {
        return max_qty;
    }

    public void setMax_qty(String max_qty) {
        this.max_qty = max_qty;
    }

    public String getQty_step() {
        return qty_step;
    }

    public void setQty_step(String qty_step) {
        this.qty_step = qty_step;
    }

    public String getList_qty_count() {
        return list_qty_count;
    }

    public void setList_qty_count(String list_qty_count) {
        this.list_qty_count = list_qty_count;
    }

    public String getTax_ids() {
        return tax_ids;
    }

    public void setTax_ids(String tax_ids) {
        this.tax_ids = tax_ids;
    }

    public String getAge_verification() {
        return age_verification;
    }

    public void setAge_verification(String age_verification) {
        this.age_verification = age_verification;
    }

    public String getAge_limit() {
        return age_limit;
    }

    public void setAge_limit(String age_limit) {
        this.age_limit = age_limit;
    }

    public String getOptions_type() {
        return options_type;
    }

    public void setOptions_type(String options_type) {
        this.options_type = options_type;
    }

    public String getExceptions_type() {
        return exceptions_type;
    }

    public void setExceptions_type(String exceptions_type) {
        this.exceptions_type = exceptions_type;
    }

    public String getDetails_layout() {
        return details_layout;
    }

    public void setDetails_layout(String details_layout) {
        this.details_layout = details_layout;
    }

    public String getShipping_params() {
        return shipping_params;
    }

    public void setShipping_params(String shipping_params) {
        this.shipping_params = shipping_params;
    }

    public String getFacebook_obj_type() {
        return facebook_obj_type;
    }

    public void setFacebook_obj_type(String facebook_obj_type) {
        this.facebook_obj_type = facebook_obj_type;
    }

    public String getShow_yandex_rev() {
        return show_yandex_rev;
    }

    public void setShow_yandex_rev(String show_yandex_rev) {
        this.show_yandex_rev = show_yandex_rev;
    }

    public String getEnable_market_xml() {
        return enable_market_xml;
    }

    public void setEnable_market_xml(String enable_market_xml) {
        this.enable_market_xml = enable_market_xml;
    }

    public String getWarranty() {
        return warranty;
    }

    public void setWarranty(String warranty) {
        this.warranty = warranty;
    }

    public String getEnable_mailru_market_xml() {
        return enable_mailru_market_xml;
    }

    public void setEnable_mailru_market_xml(String enable_mailru_market_xml) {
        this.enable_mailru_market_xml = enable_mailru_market_xml;
    }

    public String getCbid_mailru_market() {
        return cbid_mailru_market;
    }

    public void setCbid_mailru_market(String cbid_mailru_market) {
        this.cbid_mailru_market = cbid_mailru_market;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public List<Integer> getCategory_ids() {
        return category_ids;
    }

    public void setCategory_ids(List<Integer> category_ids) {
        this.category_ids = category_ids;
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

    public String getDiscussion_type() {
        return discussion_type;
    }

    public void setDiscussion_type(String discussion_type) {
        this.discussion_type = discussion_type;
    }

    public String getDiscussion_thread_id() {
        return discussion_thread_id;
    }

    public void setDiscussion_thread_id(String discussion_thread_id) {
        this.discussion_thread_id = discussion_thread_id;
    }

    public int getMain_category() {
        return main_category;
    }

    public void setMain_category(int main_category) {
        this.main_category = main_category;
    }

    public String getBase_price() {
        return base_price;
    }

    public void setBase_price(String base_price) {
        this.base_price = base_price;
    }

    public MainPair getMain_pair() {
        return main_pair;
    }

    public void setMain_pair(MainPair main_pair) {
        this.main_pair = main_pair;
    }
}
