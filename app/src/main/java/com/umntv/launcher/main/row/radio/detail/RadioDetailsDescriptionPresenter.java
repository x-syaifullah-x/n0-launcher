package com.umntv.launcher.main.row.radio.detail;

import androidx.leanback.widget.AbstractDetailsDescriptionPresenter;

import com.umntv.launcher.main.row.radio.RadioCard;

public class RadioDetailsDescriptionPresenter extends AbstractDetailsDescriptionPresenter {

    @Override
    protected void onBindDescription(ViewHolder viewHolder, Object item) {
        RadioCard radio = (RadioCard) item;

        if (radio != null) {
            viewHolder.getTitle().setText(radio.getTitle());
//            viewHolder.getSubtitle().setText(radio.getStudio());
            viewHolder.getBody().setText(radio.getDetailDescription());
        }
    }
}