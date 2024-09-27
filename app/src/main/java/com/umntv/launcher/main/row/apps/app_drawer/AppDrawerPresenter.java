package com.umntv.launcher.main.row.apps.app_drawer;

import androidx.leanback.widget.VerticalGridPresenter;
import androidx.leanback.widget.VerticalGridView;

public class AppDrawerPresenter extends VerticalGridPresenter {
    @Override
    protected void initializeGridViewHolder(ViewHolder vh) {
        super.initializeGridViewHolder(vh);

        VerticalGridView gridView = vh.getGridView();
        gridView.setHorizontalSpacing(24);
        gridView.setVerticalSpacing(24);
    }
}
