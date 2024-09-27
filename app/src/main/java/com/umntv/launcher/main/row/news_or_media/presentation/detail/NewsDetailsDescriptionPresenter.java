package com.umntv.launcher.main.row.news_or_media.presentation.detail;

import androidx.leanback.widget.AbstractDetailsDescriptionPresenter;

import com.umntv.launcher.main.row.news_or_media.domain.model.NewsMediaModel;

public class NewsDetailsDescriptionPresenter extends AbstractDetailsDescriptionPresenter {

    @Override
    protected void onBindDescription(ViewHolder viewHolder, Object item) {
        NewsMediaModel newsCard = (NewsMediaModel) item;

        if (newsCard != null) {
            viewHolder.getTitle().setText(newsCard.getTitle());
//            viewHolder.getSubtitle().setText(video.getStudio());
            viewHolder.getBody().setText(newsCard.getDetailDescription());
        }
    }
}