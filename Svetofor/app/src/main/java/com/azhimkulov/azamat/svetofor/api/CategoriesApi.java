package com.azhimkulov.azamat.svetofor.api;

import com.azhimkulov.azamat.svetofor.entity.api_model.ResponseModelCategorie;
import com.azhimkulov.azamat.svetofor.entity.categorie_model.CategoryModel;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by azamat  on 09.04.18.
 */

public interface CategoriesApi {
    @GET("categories")
    Observable<ResponseModelCategorie<List<CategoryModel>>> getCategorieModel(@Query("page") int page, @Query("items_per_page") int items_per_page);
}
