package com.umntv.launcher.main.row.news_or_media.presentation.detail;

import static com.umntv.launcher.main.row.news_or_media.presentation.detail.youtube_shorts.DataSource.YOUTUBE_SHORTS;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.DrawableRes;
import androidx.core.content.ContextCompat;
import androidx.leanback.app.DetailsSupportFragment;
import androidx.leanback.app.DetailsSupportFragmentBackgroundController;
import androidx.leanback.widget.Action;
import androidx.leanback.widget.ArrayObjectAdapter;
import androidx.leanback.widget.ClassPresenterSelector;
import androidx.leanback.widget.DetailsOverviewRow;
import androidx.leanback.widget.FullWidthDetailsOverviewRowPresenter;
import androidx.leanback.widget.FullWidthDetailsOverviewSharedElementHelper;

import com.umntv.launcher.main.base.ApkData;
import com.umntv.launcher.main.row.news_or_media.domain.model.NewsMediaModel;
import com.umntv.launcher.main.row.news_or_media.presentation.detail.youtube_shorts.DataSource;
import com.umntv.launcher.main.row.radio.detail.RadioDetailsFragment;
import com.umntv.launcher.play.PlayActivity;
import com.umntv.launcher.util.AndroidStore;
import com.umntv.launcher.util.view.dialog.ApkUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import net.n0ender.com.R;

public class BaseDetailFragment extends DetailsSupportFragment {
    private final List<OverviewItem> items;

    public BaseDetailFragment(List<OverviewItem> items) {
        this.items = items;
    }

    private DetailsSupportFragmentBackgroundController mDetailsBackground;

    private ClassPresenterSelector mPresenterSelector;

    private ArrayObjectAdapter mAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mDetailsBackground = new DetailsSupportFragmentBackgroundController(this);
        mPresenterSelector = new ClassPresenterSelector();
        mAdapter = new ArrayObjectAdapter(mPresenterSelector);

        setupDetailsOverviewRow();
        setupDetailsOverviewRowPresenter();

        setAdapter(mAdapter);
    }

    private void setupDetailsOverviewRow() {
        OverviewItem overviewItem = items.get(0);
        final DetailsOverviewRow row = new DetailsOverviewRow(overviewItem);
        row.setImageDrawable(ContextCompat.getDrawable(requireActivity(), R.drawable.default_background));
        row.setImageDrawable(ContextCompat.getDrawable(requireContext(), overviewItem.icon));
        initializeBackground(overviewItem.bg);

        ArrayObjectAdapter actionAdapter = new ArrayObjectAdapter();

        for (int index = 0; index < items.size(); index++) {
            String titleAction = items.get(index).titleAction;
            actionAdapter.add(new Action(index, titleAction));
        }
        row.setActionsAdapter(actionAdapter);
        mAdapter.add(row);
    }

    private void setupDetailsOverviewRowPresenter() {
        // Set detail background.
        FullWidthDetailsOverviewRowPresenter detailsPresenter = new FullWidthDetailsOverviewRowPresenter(
                new BaseDetailDescriptionPresenter()
        );
        detailsPresenter.setBackgroundColor(ContextCompat.getColor(requireActivity(), R.color.selected_background));

        // Hook up transition element.
        FullWidthDetailsOverviewSharedElementHelper sharedElementHelper = new FullWidthDetailsOverviewSharedElementHelper();
        sharedElementHelper.setSharedElementEnterTransition(getActivity(), "hero");
        detailsPresenter.setListener(sharedElementHelper);
        detailsPresenter.setParticipatingEntranceTransition(true);

        setOnItemViewSelectedListener((itemViewHolder, item, rowViewHolder, row) -> {
//            FullWidthDetailsOverviewRowPresenter.ViewHolder viewHolder = (FullWidthDetailsOverviewRowPresenter.ViewHolder) rowViewHolder;
            DetailsOverviewRow detailsOverviewRow = (DetailsOverviewRow) row;
            Action action = (Action) item;
            if (action != null) {
                int index = ((int) action.getId());
                OverviewItem data = items.get(index);
                detailsOverviewRow.setImageDrawable(ContextCompat.getDrawable(requireContext(), data.icon));
                changeBackground(data.bg);
                detailsOverviewRow.setItem(data);
            }
        });

        detailsPresenter.setOnActionClickedListener(action -> {
            int index = (int) action.getId();
            OverviewItem overviewItem = items.get(index);

            if (overviewItem.apkData != null) {
                openOrDownload(overviewItem.apkData);
                return;
            }

            for (OverviewItem item : com.umntv.launcher.main.row.news_or_media.data.repository.DataSource.items) {
                if (item.url.contains(overviewItem.url)) {
                    try {
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse(overviewItem.url));
                        intent.setPackage("com.jio.web.androidtv");
                        startActivity(intent);
                    } catch (Throwable t) {
                        Toast.makeText(getContext(), t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
                    }
                    return;
                }
            }

            for (OverviewItem item : DataSource.items) {
                if (item.url.contains(overviewItem.url)) {
                    try {
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse(overviewItem.url));
                        if (overviewItem.url.equals(YOUTUBE_SHORTS.url)) {
//                            error jio browser can't handle url youtube shorts
                            intent.setPackage("com.android.chrome");
                        } else {
                            intent.setPackage("com.jio.web.androidtv");
                        }
                        startActivity(intent);
                    } catch (Throwable t) {
                        Toast.makeText(getContext(), t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
                    }
                    return;
                }
            }

            if (overviewItem.url.contains("https://")) {
                String uriString = overviewItem.url;
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(uriString));
                if (DataSource.com_tcl_browser.contains(overviewItem.titleAction)) {
                    i.setPackage("com.jio.web.androidtv");
                }
                startActivity(i);
            } else {
                startActivity(PlayActivity.createIntent(requireActivity(), overviewItem.url));
            }
        });
        mPresenterSelector.addClassPresenter(DetailsOverviewRow.class, detailsPresenter);
    }

    private void openOrDownload(ApkData apkData) {
        if (apkData.url.isEmpty() || apkData.packageName.isEmpty()) {
            Toast.makeText(requireContext(), "Coming soon", Toast.LENGTH_SHORT).show();
        } else {
            Intent launchIntent = requireContext()
                    .getPackageManager()
                    .getLaunchIntentForPackage(apkData.packageName);
            try {
                if (launchIntent == null) {
                    launchIntent = new Intent();
                    launchIntent.setPackage(apkData.packageName);
                    launchIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                }
//                launchIntent.addCategory("android.intent.category.LEANBACK_LAUNCHER");
                requireContext().startActivity(launchIntent);
            } catch (Throwable e) {
                e.printStackTrace();
                if (apkData.url.contains("https://play.google.com/")) {
                    AndroidStore.open(requireContext(), apkData.packageName);
                } else {
                    ApkUtil.downloadToCacheDirAndInstall(requireContext(), apkData.url);
                }
            }
        }
    }

    private void initializeBackground(int id) {
        Bitmap b = BitmapFactory.decodeResource(getResources(), id);
        mDetailsBackground.setCoverBitmap(b);
    }

    private void changeBackground(@DrawableRes int drawable) {
        Bitmap b = BitmapFactory.decodeResource(getResources(), drawable);
        mDetailsBackground.setCoverBitmap(b);
        mDetailsBackground.enableParallax();
    }
}
