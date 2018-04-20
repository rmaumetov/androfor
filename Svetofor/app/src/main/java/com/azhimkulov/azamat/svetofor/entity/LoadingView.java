package com.azhimkulov.azamat.svetofor.entity;

/**
 * Created by azamat  on 02.04.18.
 */

public interface LoadingView {
    void showLoading();

    void hideLoading();

    void errorResponse(String s);
}
