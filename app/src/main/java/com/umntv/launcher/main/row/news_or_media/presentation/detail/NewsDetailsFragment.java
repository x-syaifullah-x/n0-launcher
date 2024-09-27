package com.umntv.launcher.main.row.news_or_media.presentation.detail;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;

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
import com.umntv.launcher.base.CardVisitor;
import com.umntv.launcher.main.MainActivity;
import com.umntv.launcher.main.row.news_or_media.domain.model.NewsMediaModel;
import com.umntv.launcher.main.row.news_or_media.data.repository.NewsOrMediaRepository;
import com.umntv.launcher.play.PlayActivity;
import com.umntv.launcher.util.Convert;

import java.util.ArrayList;
import java.util.Collections;

import net.n0ender.com.R;

public class NewsDetailsFragment extends DetailsSupportFragment {
    private static final String TAG = "VideoDetailsFragment";

    private static final int DETAIL_THUMB_WIDTH = 274;
    private static final int DETAIL_THUMB_HEIGHT = 274;

    private NewsMediaModel mSelectedNewsMediaModel;

    private ArrayObjectAdapter mAdapter;
    private ClassPresenterSelector mPresenterSelector;

    private DetailsSupportFragmentBackgroundController mDetailsBackground;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mDetailsBackground = new DetailsSupportFragmentBackgroundController(this);

        mSelectedNewsMediaModel =
                (NewsMediaModel) requireActivity().getIntent().getSerializableExtra(NewsDetailsActivity.ITEM);
        if (mSelectedNewsMediaModel != null) {
            mPresenterSelector = new ClassPresenterSelector();
            mAdapter = new ArrayObjectAdapter(mPresenterSelector);
            setupDetailsOverviewRow();
            setupDetailsOverviewRowPresenter();
            setupRelatedListRow();
            setAdapter(mAdapter);
            initializeBackground(mSelectedNewsMediaModel);
        } else {
            Intent intent = new Intent(getActivity(), MainActivity.class);
            startActivity(intent);
        }
    }

    private void initializeBackground(NewsMediaModel data) {
        mDetailsBackground.enableParallax();
        Glide.with(requireActivity())
                .asBitmap()
                .centerCrop()
                .error(R.drawable.default_background)
                .load(data.getBackgroundStringUri())
                .into(new CustomTarget<Bitmap>() {
                    @Override
                    public void onResourceReady(@NonNull Bitmap bitmap, @Nullable Transition<? super Bitmap> transition) {
                        mDetailsBackground.setCoverBitmap(bitmap);
                        mAdapter.notifyArrayItemRangeChanged(0, mAdapter.size());
                    }

                    @Override
                    public void onLoadCleared(@Nullable Drawable placeholder) {

                    }
                });
    }

    private void setupDetailsOverviewRow() {
        Log.d(TAG, "doInBackground: " + mSelectedNewsMediaModel.toString());
        final DetailsOverviewRow row = new DetailsOverviewRow(mSelectedNewsMediaModel);
        row.setImageDrawable(
                ContextCompat.getDrawable(requireActivity(), R.drawable.default_background));
//        int width = Convert.dpToPixel(requireActivity().getApplicationContext(), DETAIL_THUMB_WIDTH);
//        int height = Convert.dpToPixel(requireActivity().getApplicationContext(), DETAIL_THUMB_HEIGHT);
//        Glide.with(requireActivity())
//                .load(mSelectedNewsMediaModel.getDetailImageStringUri())
//                .centerCrop()
//                .error(R.drawable.default_background)
//                .into(new CustomTarget<Drawable>(width, height) {
//                    @Override
//                    public void onResourceReady(@NonNull Drawable drawable, @Nullable Transition<? super Drawable> transition) {
//                        Log.d(TAG, "details overview card image url ready: " + drawable);
//                        row.setImageDrawable(drawable);
//                        mAdapter.notifyArrayItemRangeChanged(0, mAdapter.size());
//                    }
//
//                    @Override
//                    public void onLoadCleared(@Nullable Drawable placeholder) {
//
//                    }
//                });

        ArrayObjectAdapter actionAdapter = new ArrayObjectAdapter();

        actionAdapter.add(new Action(0, getResources().getString(R.string.play_video)));
        row.setActionsAdapter(actionAdapter);

        mAdapter.add(row);
    }

    private void setupDetailsOverviewRowPresenter() {
        // Set detail background.
        FullWidthDetailsOverviewRowPresenter detailsPresenter = new FullWidthDetailsOverviewRowPresenter(new NewsDetailsDescriptionPresenter());
        detailsPresenter.setBackgroundColor(ContextCompat.getColor(requireActivity(), R.color.selected_background));

        // Hook up transition element.
        FullWidthDetailsOverviewSharedElementHelper sharedElementHelper = new FullWidthDetailsOverviewSharedElementHelper();
        sharedElementHelper.setSharedElementEnterTransition(getActivity(), NewsDetailsActivity.SHARED_ELEMENT_NAME);
        detailsPresenter.setListener(sharedElementHelper);
        detailsPresenter.setParticipatingEntranceTransition(true);

        detailsPresenter.setOnActionClickedListener(action -> {
            startActivity(PlayActivity.createIntent(requireActivity(), mSelectedNewsMediaModel.getYoutubeId()));
        });
        mPresenterSelector.addClassPresenter(DetailsOverviewRow.class, detailsPresenter);
    }

    private void setupRelatedListRow() {
        String[] subcategories = {getString(R.string.related_news)};
        ArrayList<NewsMediaModel> list = new ArrayList<>();
        for (NewsMediaModel n : NewsOrMediaRepository.getItems()) {
            if (!n.getTitle().equals(mSelectedNewsMediaModel.getTitle())) {
                list.add(n);
            }
        }

        Collections.shuffle(list);
        ArrayObjectAdapter listRowAdapter = new ArrayObjectAdapter(new NewsDetailsRelatedPresenter());
        listRowAdapter.addAll(0, list);

        HeaderItem header = new HeaderItem(0, subcategories[0]);
        mAdapter.add(new ListRow(header, listRowAdapter));
        mPresenterSelector.addClassPresenter(ListRow.class, new ListRowPresenter());
        setOnItemViewClickedListener(new ItemViewClickedListener());
    }

    private final class ItemViewClickedListener implements OnItemViewClickedListener {
        @Override
        public void onItemClicked(Presenter.ViewHolder itemViewHolder, Object item, RowPresenter.ViewHolder rowViewHolder, Row row) {
            if (item instanceof NewsMediaModel) {
                NewsMediaModel newsCard = (NewsMediaModel) item;

                ((NewsMediaModel) item).onClicked(new CardVisitor(requireContext()));

                if (newsCard.getPackageName() == null) {
                    requireActivity().finishAfterTransition();
                }
            }
        }
    }
}