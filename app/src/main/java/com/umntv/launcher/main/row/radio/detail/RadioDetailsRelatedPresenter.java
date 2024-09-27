package com.umntv.launcher.main.row.radio.detail;

import com.umntv.launcher.base.CardPresenter;
import com.umntv.launcher.base.CardView;

public class RadioDetailsRelatedPresenter extends CardPresenter {
    private static final int CARD_WIDTH = 313;
    private static final int CARD_HEIGHT = 176;

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, Object item) {
        super.onBindViewHolder(viewHolder, item);

        CardView cardView = (CardView) viewHolder.view;
        cardView.setMainImageDimensions(CARD_WIDTH, CARD_HEIGHT);
    }
}
