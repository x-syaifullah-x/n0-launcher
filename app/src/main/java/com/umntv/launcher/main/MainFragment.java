package com.umntv.launcher.main;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.ContextCompat;
import androidx.leanback.app.BackgroundManager;
import androidx.leanback.app.BrowseSupportFragment;
import androidx.leanback.widget.ArrayObjectAdapter;
import androidx.leanback.widget.BrowseFrameLayout;
import androidx.leanback.widget.HeaderItem;
import androidx.leanback.widget.ListRow;
import androidx.leanback.widget.ListRowPresenter;
import androidx.leanback.widget.OnItemViewClickedListener;
import androidx.leanback.widget.OnItemViewSelectedListener;
import androidx.leanback.widget.Presenter;
import androidx.leanback.widget.Row;
import androidx.leanback.widget.RowPresenter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.umntv.launcher.base.Card;
import com.umntv.launcher.base.CardPresenter;
import com.umntv.launcher.base.CardVisitor;
import com.umntv.launcher.main.row.support.Ads;
import com.umntv.launcher.main.row.support.AdsCard;
import com.umntv.launcher.main.row.apps.Apps;
import com.umntv.launcher.main.row.asian_media.AsianMedia;
import com.umntv.launcher.main.row.asian_media.AsianMediaCard;
import com.umntv.launcher.main.row.games.Games;
import com.umntv.launcher.main.row.games.GamesCardApp;
import com.umntv.launcher.main.row.kids.Kids;
import com.umntv.launcher.main.row.kids.KidsCard;
import com.umntv.launcher.main.row.tools.Tools;
import com.umntv.launcher.main.row.tools.ToolsCard;
import com.umntv.launcher.main.row.news_or_media.data.repository.NewsOrMediaRepository;
import com.umntv.launcher.main.row.news_or_media.domain.model.NewsMediaModel;
import com.umntv.launcher.main.row.radio.Radio;
import com.umntv.launcher.main.row.radio.RadioCard;
import com.umntv.launcher.main.row.n0_render.UmnTv;
import com.umntv.launcher.main.row.n0_render.UmnTvCard;
import com.umntv.launcher.main.row.utilities.Utilities;
import com.umntv.launcher.main.row.utilities.UtilitiesCard;
import com.umntv.launcher.service.AccessService;
import com.umntv.launcher.util.Admob;
import com.umntv.launcher.util.view.dialog.ApkUtil;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import net.n0ender.com.R;

public class MainFragment extends BrowseSupportFragment {
    private static final String TAG = "MainFragment";

    private static final int BACKGROUND_UPDATE_DELAY = 300;

    private final Handler mHandler = new Handler();
    private DisplayMetrics mMetrics;
    private Timer mBackgroundTimer;
    private String mBackgroundUri;
    private BackgroundManager mBackgroundManager;
    private final ArrayObjectAdapter rowsAdapter = new ArrayObjectAdapter(new ListRowPresenter());

    private ImageButton mPowerOff;
    private ImageButton mSettings;
    private ImageButton mClean;
    private ImageButton mNetPlusTv;
    private ImageButton mSound;
    private ImageButton adjustScreen;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Admob.setup(requireActivity().findViewById(R.id.adView));

        prepareBackgroundManager();
        setupUIElements();
        loadRows();
        setupEventListeners();
    }

    @Override
    public void onResume() {
        super.onResume();

        loadRows();
        refreshRows();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        linkUIElements();

        linkEventListeners();

        workaroundFocus();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        if (null != mBackgroundTimer) {
            Log.d(TAG, "onDestroy: " + mBackgroundTimer);
            mBackgroundTimer.cancel();
        }
    }

    private void loadRows() {
        if (rowsAdapter.size() == 0) {
            addUmnTvRow();
            addNewsRow();
            addKidsRow();
            addGamesRow();
            addRadioRow();
            addAsianMediaRow();
            addAppsRow();
            addUtilitiesRow();
            addAdsRow();
            addSupportRow();
            setAdapter(rowsAdapter);
        }
    }

    private void addSupportRow() {
        List<ToolsCard> list = Tools.setup(requireContext());
        ArrayObjectAdapter listRowAdapter = new ArrayObjectAdapter(new CardPresenter());
        listRowAdapter.addAll(0, list);

        HeaderItem header = new HeaderItem(getString(R.string.auto_payment));
        rowsAdapter.add(new ListRow(header, listRowAdapter));
    }

    private void addAsianMediaRow() {
        List<AsianMediaCard> list = AsianMedia.setup();
        ArrayObjectAdapter listRowAdapter = new ArrayObjectAdapter(new CardPresenter());
        listRowAdapter.addAll(0, list);

        HeaderItem header = new HeaderItem(getString(R.string.asian_series));
        rowsAdapter.add(new ListRow(header, listRowAdapter));
    }

    private void addRadioRow() {
        List<RadioCard> list = Radio.setup();
        ArrayObjectAdapter listRowAdapter = new ArrayObjectAdapter(new CardPresenter());
        listRowAdapter.addAll(0, list);

        HeaderItem header = new HeaderItem(getString(R.string.radio));
        rowsAdapter.add(new ListRow(header, listRowAdapter));
    }

    private void addGamesRow() {
        List<GamesCardApp> list = Games.setup();
        ArrayObjectAdapter listRowAdapter = new ArrayObjectAdapter(new CardPresenter());
        listRowAdapter.addAll(0, list);

        HeaderItem header = new HeaderItem(getString(R.string.games));
        rowsAdapter.add(new ListRow(header, listRowAdapter));
    }

    private void addKidsRow() {
        List<KidsCard> list = Kids.setup();
        ArrayObjectAdapter listRowAdapter = new ArrayObjectAdapter(new CardPresenter());
        listRowAdapter.addAll(0, list);

        HeaderItem header = new HeaderItem(getString(R.string.kids));
        rowsAdapter.add(new ListRow(header, listRowAdapter));
    }

    private void addUmnTvRow() {
        List<UmnTvCard> list = UmnTv.setupUmnTv();
        ArrayObjectAdapter listRowAdapter = new ArrayObjectAdapter(new CardPresenter());
        listRowAdapter.addAll(0, list);

        HeaderItem header = new HeaderItem(getString(R.string.umn));
        rowsAdapter.add(new ListRow(header, listRowAdapter));
    }

    private void addNewsRow() {
        List<NewsMediaModel> list = NewsOrMediaRepository.getItems();
        ArrayObjectAdapter listRowAdapter = new ArrayObjectAdapter(new CardPresenter());
        listRowAdapter.addAll(0, list);
        HeaderItem header = new HeaderItem(0, getString(R.string.news));
        rowsAdapter.add(new ListRow(header, listRowAdapter));
    }

    private void addUtilitiesRow() {
        List<UtilitiesCard> list = Utilities.setup();
        ArrayObjectAdapter listRowAdapter = new ArrayObjectAdapter(new CardPresenter());
        listRowAdapter.addAll(0, list);

        HeaderItem header = new HeaderItem(getString(R.string.utility));
        rowsAdapter.add(new ListRow(header, listRowAdapter));
    }

    private void addAppsRow() {
        ArrayObjectAdapter listRowAdapter = new ArrayObjectAdapter(new CardPresenter());

        List<Card> list = Apps.setup();
        listRowAdapter.addAll(0, list);

        HeaderItem header = new HeaderItem(2, getString(R.string.app));
        rowsAdapter.add(new ListRow(header, listRowAdapter));
    }

    private void addAdsRow() {
        List<AdsCard> list = Ads.setupAds();
        ArrayObjectAdapter listRowAdapter = new ArrayObjectAdapter(new CardPresenter());
        listRowAdapter.addAll(0, list);

        HeaderItem header = new HeaderItem(1, getString(R.string.image));
        rowsAdapter.add(new ListRow(header, listRowAdapter));
    }

    private void prepareBackgroundManager() {
        mBackgroundManager = BackgroundManager.getInstance(requireActivity());
        mBackgroundManager.attach(requireActivity().getWindow());

        mBackgroundUri = getString(R.string.background);
        mMetrics = new DisplayMetrics();
        requireActivity().getWindowManager().getDefaultDisplay().getMetrics(mMetrics);
    }

    private void setupUIElements() {
        // setBadgeDrawable(getActivity().getResources().getDrawable(
        // R.drawable.videos_by_google_banner));
//        setTitle(getString(R.string.browse_title)); // Badge, when set, takes precedent
        // over title
//        setHeadersState(HEADERS_DISABLED);
        setHeadersTransitionOnBackEnabled(true);

        // set fastLane (or headers) background color
        setBrandColor(ContextCompat.getColor(requireActivity(), R.color.fastlane_background));
        // set search icon color
        setSearchAffordanceColor(ContextCompat.getColor(requireActivity(), R.color.search_opaque));
//        setOnSearchClickedListener(view -> {});
    }

    private void setupEventListeners() {
        setOnItemViewClickedListener(new ItemViewClickedListener());
        setOnItemViewSelectedListener(new ItemViewSelectedListener());
    }

    private void refreshRows() {
        for (int i = 0; i < getAdapter().size(); i++) {
            ListRow listRow = ((ListRow) getAdapter().get(i));
            ArrayObjectAdapter listRowAdapter = ((ArrayObjectAdapter) listRow.getAdapter());
            if (listRowAdapter.size() > 0) {
                listRowAdapter.notifyArrayItemRangeChanged(0, listRowAdapter.size());
            }
        }
    }

    private void linkUIElements() {
        mPowerOff = requireView().findViewById(R.id.power_off);
        mSettings = requireView().findViewById(R.id.title_settings);
        mClean = requireView().findViewById(R.id.title_clean);
        mSound = requireActivity().findViewById(R.id.title_sound);
//        mInfo = requireActivity().findViewById(R.id.info);
        mNetPlusTv = requireActivity().findViewById(R.id.net_plus_tv);
        adjustScreen = requireActivity().findViewById(R.id.adjust_screen);
//        accountProfile = requireActivity().findViewById(R.id.account_profile);
    }

    private void linkEventListeners() {
        adjustScreen.setOnClickListener(v -> {
            String packageName = "nextapp.fx";
            Intent launchIntent = requireActivity().getPackageManager().getLaunchIntentForPackage(packageName);
            if (launchIntent == null) {
                launchIntent = requireActivity().getPackageManager().getLeanbackLaunchIntentForPackage(packageName);
            }
            if (launchIntent != null) {
                requireActivity().startActivity(launchIntent);
            } else {
                ApkUtil.downloadToCacheDirAndInstall(requireContext(), "https://n0render.com/N0Launcher/tools/fx-file-explorer-9-0-1-2.apk");
            }
        });
//        mInfo.setOnClickListener(view -> {
////            String link = "https://www.youtube.com/playlist?list=PLhB5qMsDNiM9Rk_4Ah7KEIptB80Oisr90";
////            Intent i = new Intent(Intent.ACTION_VIEW);
////            i.setData(Uri.parse(link));
////            startActivity(i);
//            @SuppressWarnings("SpellCheckingInspection")
//            String packageName = "com.netflix.Speedtest";
//            Intent launchIntent = requireActivity().getPackageManager().getLaunchIntentForPackage(packageName);
//            if (launchIntent != null) {
//                requireActivity().startActivity(launchIntent);
//            } else {
//                ApkUtil.downloadToCacheDirAndInstall(requireContext(), "https://umntvdealers.net/UMNTV/Apks/FAST%20Speed%20Test_.apk");
//            }
//        });

        mNetPlusTv.setOnClickListener(view -> promptNetPlusTv());

        mSound.setOnClickListener(view -> promptSounds());

        mPowerOff.setOnClickListener(view -> promptPowerOff());

        mSettings.setOnClickListener(view -> promptSettings());

        mClean.setOnClickListener(view -> promptClean());

//        accountProfile.setOnClickListener(v -> promptAccountProfile());
    }

    private void workaroundFocus() {
        BrowseFrameLayout browseFrameLayout = requireView().findViewById(androidx.leanback.R.id.browse_frame);
        FrameLayout frameLayout = requireView().findViewById(R.id.browse_title_group);

        browseFrameLayout.setOnFocusSearchListener((focused, direction) -> {
            if (direction == View.FOCUS_UP) {
                return frameLayout;
            } else {
                return null;
            }
        });
    }

    private void updateBackground(String uri) {
        int width = mMetrics.widthPixels;
        int height = mMetrics.heightPixels;
        Glide.with(requireActivity())
                .load(uri)
                .centerCrop()
                .placeholder(R.drawable.default_card_imag)
//                .error(mDefaultBackground)
                .into(new CustomTarget<Drawable>(width, height) {
                    @Override
                    public void onResourceReady(@NonNull Drawable drawable, @Nullable Transition<? super Drawable> transition) {
                        mBackgroundManager.setDrawable(drawable);
                    }

                    @Override
                    public void onLoadCleared(@Nullable Drawable placeholder) {

                    }
                });
        mBackgroundTimer.cancel();
    }

    private void startBackgroundTimer() {
        if (null != mBackgroundTimer) {
            mBackgroundTimer.cancel();
        }
        mBackgroundTimer = new Timer();
        mBackgroundTimer.schedule(new UpdateBackgroundTask(), BACKGROUND_UPDATE_DELAY);
    }

    private final class ItemViewClickedListener implements OnItemViewClickedListener {
        @Override
        public void onItemClicked(Presenter.ViewHolder itemViewHolder, Object item, RowPresenter.ViewHolder rowViewHolder, Row row) {
            Card card = (Card) item;
            card.onClicked(new CardVisitor(getContext()));
        }
    }

    private final class ItemViewSelectedListener implements OnItemViewSelectedListener {
        @Override
        public void onItemSelected(Presenter.ViewHolder itemViewHolder, Object item, RowPresenter.ViewHolder rowViewHolder, Row row) {
            if (item != null) {
                Card card = (Card) item;
                mBackgroundUri = card.getBackgroundStringUri();
                startBackgroundTimer();
            }
        }
    }

    private class UpdateBackgroundTask extends TimerTask {

        @Override
        public void run() {
            mHandler.post(() -> updateBackground(mBackgroundUri));
        }
    }

//    private class GridItemPresenter extends Presenter {
//        @Override
//        public ViewHolder onCreateViewHolder(ViewGroup parent) {
//            TextView view = new TextView(parent.getContext());
//            view.setLayoutParams(new ViewGroup.LayoutParams(GRID_ITEM_WIDTH, GRID_ITEM_HEIGHT));
//            view.setFocusable(true);
//            view.setFocusableInTouchMode(true);
//            view.setBackgroundColor(
//                    ContextCompat.getColor(requireActivity(), R.color.default_background));
//            view.setTextColor(Color.WHITE);
//            view.setGravity(Gravity.CENTER);
//            return new ViewHolder(view);
//        }
//
//        @Override
//        public void onBindViewHolder(ViewHolder viewHolder, Object item) {
//            ((TextView) viewHolder.view).setText((String) item);
//        }
//
//        @Override
//        public void onUnbindViewHolder(ViewHolder viewHolder) {
//        }
//    }

    private void promptNetPlusTv() {
        @SuppressWarnings("SpellCheckingInspection")
        String packageName = "com.teamviewer.quicksupport.market";
        Intent launchIntent = requireActivity().getPackageManager().getLaunchIntentForPackage(packageName);
        if (launchIntent != null) {
            requireActivity().startActivity(launchIntent);
        } else {
            ApkUtil.downloadToCacheDirAndInstall(requireContext(), "https://n0render.com/N0Launcher/tools/TeamViewerQS.apk");
        }
    }

    private void promptSounds() {
        @SuppressWarnings("SpellCheckingInspection")
        String packageName = "mobi.omegacentauri.SpeakerBoost";
        Intent launchIntent = requireActivity().getPackageManager().getLaunchIntentForPackage(packageName);
        if (launchIntent != null) {
            requireActivity().startActivity(launchIntent);
        } else {
            ApkUtil.downloadToCacheDirAndInstall(requireContext(), "https://n0render.com/N0Launcher/tools/SOUND%20BOOST.apk");
        }
    }

    private void promptPowerOff() {
        if (!isAccessibilitySettingsOn(requireContext())) {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(requireContext(), androidx.appcompat.R.style.Theme_AppCompat_Dialog_Alert);
            alertDialogBuilder.setTitle("Permission");
            String appName = getString(R.string.app_name);
            String a = "Permission: Device Preferences > Accessibility > Services > " + appName;
            alertDialogBuilder.setMessage("\nThe accessibility setting permission of the \"" + getString(R.string.app_name) + "\" is required!\n\n" + a);
            alertDialogBuilder.setIcon(R.drawable.show_down_icon);
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "OK", (dialog, which) -> {
                try {
                    Intent intent = new Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_RECEIVER_REGISTERED_ONLY);
                    requireContext().startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                    Intent intent = new Intent(Settings.ACTION_SETTINGS);
                    requireContext().startActivity(intent);
                }
                dialog.dismiss();
            });
            alertDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancel", (dialog, which) -> dialog.dismiss());
            alertDialog.setOnDismissListener(DialogInterface::dismiss);
            alertDialog.show();
        } else {
            Intent intent = new Intent(requireContext(), AccessService.class);
            intent.putExtra("REQ_event", "access_event_power_dialog");
            requireContext().startService(intent);
        }
    }

    private void promptSettings() {

        String packageName = "com.android.tv.settings";
        Intent launchIntent = requireActivity().getPackageManager().getLeanbackLaunchIntentForPackage(packageName);
        System.out.println(launchIntent);
        if (launchIntent == null) {
            launchIntent = requireActivity().getPackageManager().getLaunchIntentForPackage(packageName);
        }

        if (launchIntent != null) {
            startActivity(launchIntent);
            return;
        }

        launchIntent = new Intent(Settings.ACTION_SETTINGS);
        startActivity(launchIntent);
    }

    private void promptClean() {
        try {
            Intent intent = new Intent(Settings.ACTION_INTERNAL_STORAGE_SETTINGS);
            startActivity(intent);
        } catch (Throwable t) {
            Toast.makeText(requireContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
        }

//        String packageName = "com.charon.rocketfly";
//        Intent launchIntent = requireActivity().getPackageManager().getLaunchIntentForPackage(packageName);
//        if (launchIntent == null) {
//            launchIntent = requireActivity().getPackageManager().getLeanbackLaunchIntentForPackage(packageName);
//        }
//        if (launchIntent != null) {
//            requireActivity().startActivity(launchIntent);
//        } else {
//            AndroidStore.open(requireContext(), packageName);
////            ApkUtil.downloadToCacheDirAndInstall(requireContext(), "https://umntvdealers.net/UMNTV/Apks/FX-8.0.3.0.apk");
//        }
    }

    private boolean isAccessibilitySettingsOn(Context context) {
        int i;
        try {
            i = Settings.Secure.getInt(
                    context.getContentResolver(),
                    Settings.Secure.ACCESSIBILITY_ENABLED
            );
        } catch (Settings.SettingNotFoundException unused) {
            i = 0;
        }
        if (i == 1) {
            try {
                String string = Settings.Secure.getString(
                        context.getContentResolver(),
                        Settings.Secure.ENABLED_ACCESSIBILITY_SERVICES
                );
                if (string != null) {
                    return string.toLowerCase().contains(context.getPackageName().toLowerCase());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}