package com.umntv.launcher.base;

import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.core.content.ContextCompat;
import androidx.leanback.widget.Presenter;

import com.bumptech.glide.Glide;

import net.n0ender.com.R;

public class CardPresenter extends Presenter {

//    private static int sSelectedBackgroundColor;
//    private static int sDefaultBackgroundColor;

//    private static void updateCardBackgroundColor(CardView view, boolean selected) {
//        int color = selected ? sSelectedBackgroundColor : sDefaultBackgroundColor;
//        // Both background colors should be set because the view"s background is temporarily visible
//        // during animations.
//        view.setBackgroundColor(color);
//        view.findViewById(R.id.info_field).setBackgroundColor(color);
//    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent) {
//        sDefaultBackgroundColor =
//                ContextCompat.getColor(parent.getContext(), R.color.default_background);
//        sSelectedBackgroundColor =
//                ContextCompat.getColor(parent.getContext(), R.color.detail_background);
//        CardView cardView = new CardView(parent.getContext()) {
//            @Override
//            public void setSelected(boolean selected) {
//                updateCardBackgroundColor(this, selected);
//                super.setSelected(selected);
//            }
//        };
//
//        cardView.setFocusable(true);
//        cardView.setFocusableInTouchMode(true);
//        updateCardBackgroundColor(cardView, false);

        CardView cardView = new CardView(parent.getContext());
        cardView.setBackgroundResource(R.color.default_background);
        cardView.setInfoAreaBackground(ContextCompat.getDrawable(parent.getContext(), R.drawable.selector_card));
        cardView.setFocusable(true);
        cardView.setFocusableInTouchMode(true);
        return new ViewHolder(cardView);
    }

    @Override
    public void onBindViewHolder(Presenter.ViewHolder viewHolder, Object item) {
        Card card = (Card) item;
        CardView cardView = (CardView) viewHolder.view;
        cardView.setTitleText(card.getTitle());

        if (card.getIconStringUri() != null) {
            Glide.with(viewHolder.view.getContext())
                    .load(card.getIconStringUri())
                    .error(R.drawable.default_card_imag)
                    .into(cardView.getMainImageView());
        } else if (card.getIconDrawable() != null) {
            cardView.getMainImageView().setImageDrawable(card.getIconDrawable());
            cardView.setMainImageScaleType(ImageView.ScaleType.FIT_CENTER);
        }
    }

    @Override
    public void onUnbindViewHolder(Presenter.ViewHolder viewHolder) {
        CardView cardView = (CardView) viewHolder.view;
        // Remove references to images so that the garbage collector can free up memory
        cardView.setBadgeImage(null);
        cardView.setMainImage(null);
    }
}
