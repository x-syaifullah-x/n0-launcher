package com.umntv.launcher.main.row.support.detail;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.leanback.app.DetailsSupportFragment;
import androidx.leanback.app.DetailsSupportFragmentBackgroundController;
import androidx.leanback.widget.Action;
import androidx.leanback.widget.ArrayObjectAdapter;
import androidx.leanback.widget.ClassPresenterSelector;
import androidx.leanback.widget.DetailsOverviewRow;
import androidx.leanback.widget.FullWidthDetailsOverviewRowPresenter;
import androidx.leanback.widget.FullWidthDetailsOverviewSharedElementHelper;
import androidx.leanback.widget.HeaderItem;
import androidx.leanback.widget.ListRow;
import androidx.leanback.widget.ListRowPresenter;
import androidx.leanback.widget.OnItemViewClickedListener;
import androidx.leanback.widget.Presenter;
import androidx.leanback.widget.Row;
import androidx.leanback.widget.RowPresenter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import net.n0ender.com.R;
import com.umntv.launcher.base.CardVisitor;
import com.umntv.launcher.main.MainActivity;
import com.umntv.launcher.main.row.support.Ads;
import com.umntv.launcher.main.row.support.AdsCard;
import com.umntv.launcher.util.Admob;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;

public class AdsDetailsFragment extends DetailsSupportFragment {
    private static final String TAG = "ImageDetailsFragment";

    private static final int DETAIL_THUMB_WIDTH = 274;
    private static final int DETAIL_THUMB_HEIGHT = 274;

    private AdsCard mSelectedAds;

    private ArrayObjectAdapter mAdapter;
    private ClassPresenterSelector mPresenterSelector;

    private DetailsSupportFragmentBackgroundController mDetailsBackground;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mDetailsBackground = new DetailsSupportFragmentBackgroundController(this);

        mSelectedAds =
                (AdsCard) requireActivity().getIntent().getSerializableExtra(AdsDetailsActivity.ITEM);
        if (mSelectedAds != null) {
            mPresenterSelector = new ClassPresenterSelector();
            mAdapter = new ArrayObjectAdapter(mPresenterSelector);
            setupDetailsOverviewRow();
            setupDetailsOverviewRowPresenter();
            setupRelatedListRow();
            setAdapter(mAdapter);
            initializeBackground(mSelectedAds);
        } else {
            Intent intent = new Intent(getActivity(), MainActivity.class);
            startActivity(intent);
        }

        Admob.setup(requireActivity().findViewById(R.id.adView));
    }

    private void initializeBackground(AdsCard data) {
        mDetailsBackground.enableParallax();

        try {
            Uri uri = Uri.parse(data.getBackgroundStringUri());
            InputStream stream = requireContext().getContentResolver().openInputStream(uri);
            mDetailsBackground.setCoverBitmap(BitmapFactory.decodeStream(stream));
            mAdapter.notifyArrayItemRangeChanged(0, mAdapter.size());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void setupDetailsOverviewRow() {
        final DetailsOverviewRow row = new DetailsOverviewRow(mSelectedAds);
        row.setImageDrawable(ContextCompat.getDrawable(requireActivity(), R.drawable.default_background));
        int width = convertDpToPixel(requireActivity().getApplicationContext(), DETAIL_THUMB_WIDTH);
        int height = convertDpToPixel(requireActivity().getApplicationContext(), DETAIL_THUMB_HEIGHT);

        Glide.with(requireActivity())
                .load(mSelectedAds.getIcDetailsStringUri())
                .centerCrop()
                .error(R.drawable.default_background)
                .into(new CustomTarget<Drawable>(width, height) {
                    @Override
                    public void onResourceReady(@NonNull Drawable drawable,
                                                @Nullable Transition<? super Drawable> transition) {
                        Log.d(TAG, "details overview card image url ready: " + drawable);
                        row.setImageDrawable(drawable);
                        mAdapter.notifyArrayItemRangeChanged(0, mAdapter.size());
                    }

                    @Override
                    public void onLoadCleared(@Nullable Drawable placeholder) {

                    }
                });

        ArrayObjectAdapter actionAdapter = new ArrayObjectAdapter();

        if (mSelectedAds.getSite() != null) {
            int length = mSelectedAds.getSite().length;
            if (length == 1) {
                actionAdapter.add(new Action(0, "Play"));
            } else if (length == 2) {
                actionAdapter.add(new Action(0, "Play"));
                actionAdapter.add(new Action(1, "OPEN SITE"));
            } else if (mSelectedAds.getTitle().equals(Ads.TITLE_LEEWAY_ENDEAVORS)) {
                actionAdapter.add(new Action(0, "Leeway Endeavors Promo"));
                actionAdapter.add(new Action(1, "Tha Group Ent"));
                actionAdapter.add(new Action(2, "Leeway Motivation"));
                actionAdapter.add(new Action(3, "Leeway Edutainment Endeavors"));
            }
        }

        row.setActionsAdapter(actionAdapter);

        mAdapter.add(row);
    }

    private void setupDetailsOverviewRowPresenter() {
        // Set detail background.
        FullWidthDetailsOverviewRowPresenter detailsPresenter = new FullWidthDetailsOverviewRowPresenter(
                new AdsDetailsDescriptionPresenter()
        );

        detailsPresenter.setBackgroundColor(
                ContextCompat.getColor(requireActivity(), R.color.selected_background)
        );

        // Hook up transition element.
        FullWidthDetailsOverviewSharedElementHelper sharedElementHelper = new FullWidthDetailsOverviewSharedElementHelper();
        sharedElementHelper.setSharedElementEnterTransition(getActivity(), AdsDetailsActivity.SHARED_ELEMENT_NAME);
        detailsPresenter.setListener(sharedElementHelper);
        detailsPresenter.setParticipatingEntranceTransition(true);

        detailsPresenter.setOnActionClickedListener(action -> {
            try {
                Intent myIntent = new Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse(mSelectedAds.getSite()[(int) action.getId()])
                );
                requireContext().startActivity(myIntent);
            } catch (ActivityNotFoundException e) {
                Toast.makeText(getContext(), "No application can handle this request." + " Please install a webbrowser", Toast.LENGTH_LONG).show();
                e.printStackTrace();
            }
        });
        mPresenterSelector.addClassPresenter(DetailsOverviewRow.class, detailsPresenter);
    }

    private void setupRelatedListRow() {
        String[] subcategories = {getString(R.string.related_ads)};
        ArrayList<AdsCard> list = new ArrayList<>();

        for (AdsCard a : Ads.setupAds()) {
            if (!mSelectedAds.getTitle().equals(a.getTitle())) {
                list.add(a);
            }
        }

        Collections.shuffle(list);
        ArrayObjectAdapter listRowAdapter = new ArrayObjectAdapter(new AdsDetailsRelatedPresenter());
        listRowAdapter.addAll(0, list);

        HeaderItem header = new HeaderItem(0, subcategories[0]);
        mAdapter.add(new ListRow(header, listRowAdapter));
        mPresenterSelector.addClassPresenter(ListRow.class, new ListRowPresenter());
        setOnItemViewClickedListener(new AdsDetailsFragment.ItemViewClickedListener());
    }

    private int convertDpToPixel(Context context, int dp) {
        float density = context.getResources().getDisplayMetrics().density;
        return Math.round((float) dp * density);
    }

    private final class ItemViewClickedListener implements OnItemViewClickedListener {
        @Override
        public void onItemClicked(Presenter.ViewHolder itemViewHolder, Object item, RowPresenter.ViewHolder rowViewHolder, Row row) {
            if (item instanceof AdsCard) {
                requireActivity().finish();
                ((AdsCard) item).onClicked(new CardVisitor(requireContext()));
            }
        }
    }
}
