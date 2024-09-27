package com.umntv.launcher.main.row.news_or_media.presentation.detail;

import android.graphics.Typeface;
import android.text.Html;
import android.widget.TextView;

import androidx.leanback.widget.AbstractDetailsDescriptionPresenter;

public class BaseDetailDescriptionPresenter extends AbstractDetailsDescriptionPresenter {

    @Override
    protected void onBindDescription(ViewHolder viewHolder, Object item) {
        OverviewItem mediaCenterItem = (OverviewItem) item;

        viewHolder.getTitle().setTypeface(Typeface.DEFAULT_BOLD);
        viewHolder.getTitle().setTextSize(25);
        viewHolder.getTitle().setText(mediaCenterItem.title);

        viewHolder.getSubtitle().setTypeface(Typeface.DEFAULT_BOLD);
        viewHolder.getSubtitle().setTextSize(16);
        viewHolder.getSubtitle().setText(mediaCenterItem.subTitle);

        viewHolder.getBody().setTextSize(15);
        viewHolder.getBody().setText(Html.fromHtml(mediaCenterItem.body), TextView.BufferType.SPANNABLE);
    }
}