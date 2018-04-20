package com.azhimkulov.azamat.svetofor.entity.api_model;

import java.util.List;

/**
 * Created by azamat  on 02.04.18.
 */

public class ResponseModel<T> {
    private T products;
    private Param params;
    private String message;
    private int status;

    public T getProducts() {
        return products;
    }

    public void setProducts(T products) {
        this.products = products;
    }

    public Param getParams() {
        return params;
    }

    public void setParams(Param params) {
        this.params = params;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
