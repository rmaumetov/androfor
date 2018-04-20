package com.azhimkulov.azamat.svetofor.entity.api_model;

/**
 * Created by azamat  on 09.04.18.
 */

public class ResponseModelCategorie<T> {
    private T categories;
    private Param params;
    private String message;
    private int status;

    public T getCategories() {
        return categories;
    }

    public void setCategories(T categories) {
        this.categories = categories;
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
