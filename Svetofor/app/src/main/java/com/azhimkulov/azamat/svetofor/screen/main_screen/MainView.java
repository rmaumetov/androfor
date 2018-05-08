package com.azhimkulov.azamat.svetofor.screen.main_screen;

import com.azhimkulov.azamat.svetofor.entity.LoadingView;

/**
 * Created by azamat  on 02.04.18.
 */

public interface MainView extends LoadingView {
    public void changeFragmentForChild(String categoryId, int categoryLevel);
}
