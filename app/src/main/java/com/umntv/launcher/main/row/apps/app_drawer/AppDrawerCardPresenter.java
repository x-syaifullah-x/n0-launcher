package com.umntv.launcher.main.row.apps.app_drawer;

import com.umntv.launcher.base.CardPresenter;
import com.umntv.launcher.base.CardView;

public class AppDrawerCardPresenter extends CardPresenter {
    private int mWidth;
    private int mHeight;

    public AppDrawerCardPresenter(int width, int height) {
        mWidth = width;
        mHeight = height;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, Object item) {
        super.onBindViewHolder(viewHolder, item);

        CardView cardView = (CardView) viewHolder.view;
//        cardView.setMainImageDimensions(mWidth, mHeight);

    }
}
