package com.azhimkulov.azamat.svetofor.screen.preload_activity;

import com.azhimkulov.azamat.svetofor.entity.LoadingView;
import com.azhimkulov.azamat.svetofor.entity.categorie_model.CategoryModel;

import java.util.List;

/**
 * Created by azamat  on 08.04.18.
 */

interface PreloadView extends LoadingView {
    void setResponseCategory(List<CategoryModel> categories);
}
