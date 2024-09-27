package com.umntv.launcher.main.row.news_or_media.presentation.detail;

import androidx.leanback.widget.Presenter;

import com.umntv.launcher.base.CardPresenter;
import com.umntv.launcher.base.CardView;

public class NewsDetailsRelatedPresenter extends CardPresenter {
    private static final int CARD_WIDTH = 313;
    private static final int CARD_HEIGHT = 176;

    @Override
    public void onBindViewHolder(Presenter.ViewHolder viewHolder, Object item) {
        super.onBindViewHolder(viewHolder, item);

        CardView cardView = (CardView) viewHolder.view;
        cardView.setMainImageDimensions(CARD_WIDTH, CARD_HEIGHT);
    }
}
