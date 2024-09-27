package com.umntv.launcher.main.row.radio.detail;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.DrawableRes;
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
import com.umntv.launcher.main.row.radio.Radio;
import com.umntv.launcher.main.row.radio.RadioCard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import net.n0ender.com.R;

public class RadioDetailsFragment extends DetailsSupportFragment {
    private static final String TAG = "RadioDetailsFragment";

//    private static final int DETAIL_THUMB_WIDTH = 274;
//    private static final int DETAIL_THUMB_HEIGHT = 274;

    private RadioCard mSelectedRadio;

    private ArrayObjectAdapter mAdapter;
    private ClassPresenterSelector mPresenterSelector;

    private DetailsSupportFragmentBackgroundController mDetailsBackground;

    private static class UmnPlayList {
        @DrawableRes
        final int bg;
        @DrawableRes
        final int icon;
        final String titleTab;
        final String title;
        final String link;

        final String description;

        public UmnPlayList(int bg, int icon, String titleTab, String title, String link, String description) {
            this.bg = bg;
            this.icon = icon;
            this.titleTab = titleTab;
            this.title = title;
            this.link = link;
            this.description = description;
        }
    }

    private final String umnPlayListDescription = "This content is provided by these sources via YouTube.\nTo watch with No commercials select view with the browser.";

    public static String CHILL_MUSIC_LAB_URL = "https://www.youtube.com/embed/W2ff_TIgZGg";
    public static String LIVE_WORK_MUSIC_URL = "https://www.youtube.com/results?search_query=LIVE+STUDY+MUSIC";

    private final UmnPlayList[] STUDY_MUSIC_PLAY_LIST = {new UmnPlayList(0, R.drawable.ic_chill_music_lab, "CHILL MUSIC LAB", "Iron Man Workshop Radio", CHILL_MUSIC_LAB_URL, umnPlayListDescription), new UmnPlayList(0, R.drawable.ic_radio_studio_music_detail, "LOFI HIP HOP", "Lofi Girl", "https://www.youtube.com/watch_popup?autoplay=1&v=jfKfPfyJRdk", umnPlayListDescription), new UmnPlayList(0, R.drawable.ic_chillhop, "CHILLHOP", "CHILLHOP", "https://www.youtube.com/watch_popup?autoplay=1&v=5yx6BWlEVcY", umnPlayListDescription), new UmnPlayList(0, R.drawable.ic_channels4_profile, "LIVE WORK MUSIC", "Live Work Music", LIVE_WORK_MUSIC_URL, umnPlayListDescription)};

    private final UmnPlayList[] TAI_LAO_KARAOKE_PLAY_LIST = {new UmnPlayList(0, R.drawable.ic_iconv_thanavorakit_ounthawatphinyo, "LAO POP", "Thanavorakit Kounthawatphinyo", "https://www.youtube.com/watch_popup?v=gz7RtAxOiQg&list=PL4283C063EB547564", umnPlayListDescription), new UmnPlayList(0, R.drawable.ic_lovi, "Thai Songs 2022", Radio.VLC_PLAYER, "https://www.youtube.com/watch_popup?v=XqQMisU5En8&list=PL5D7fjEEs5yfIBCACamjy0KpfKESoudtn", umnPlayListDescription), new UmnPlayList(0, R.drawable.ic_taispop, "Thai Pop 2022", "Illslick thelegandary", "https://www.youtube.com/watch_popup?v=jthza-s_NEg&list=PLFlUhB2ijJJMzGsf-N7LBEIsLltBAdfYb", umnPlayListDescription), new UmnPlayList(0, R.drawable.ic_genie_records_logo, "Thai songs 2019", "Genierock", "https://www.youtube.com/embed/wqJsZYibWcI?list=PLeQlgf5H84mfXRDGtaFiGOOef-szLM7Ov", umnPlayListDescription),};

    private final UmnPlayList[] HMONG_PLAY_LIST = {new UmnPlayList(0, R.drawable.ic_maiv_thoj_nkmvl, "HMONG 2021", "Maiv Thoj NKMVL", "https://www.youtube.com/embed/jvtv6rAZWMk?list=PLvoKM51-PIMXnUNXu4n1KzJGDqa_MXMo9", umnPlayListDescription), new UmnPlayList(0, R.drawable.ic_cheenou, "HMONG 2022", "Cheenou", "https://www.youtube.com/watch_popup?v=bKxGY5iLDRo&list=PLFmyqQIM32VjlsMYKWSWzlRfEv8enID4a", umnPlayListDescription), new UmnPlayList(0, R.drawable.ic_hmong_rapper_productions, "hmong rap", "Hmong rapper productions", "https://www.youtube.com/embed/qCuCgfRI65g?list=PLAOXhd6xBn72Fh23AOSDOw6GofGp__UDU", umnPlayListDescription), new UmnPlayList(0, R.drawable.ic_itsnikkithao, "Xav Kom Yog Koj", "ITSNIKKITHAO", "https://www.youtube.com/embed/__d8qhCYEl4?list=PLedROBSbMY4EISB8azcZ-r9otZX9vJ0QC", umnPlayListDescription),};

    public static String SOUL_MUSIC_URL = "https://www.youtube.com/results?search_query=live+soul";
    public static String LATINO_MUSIC_URL = "https://www.youtube.com/results?search_query=live+latin+music";
    public static String AFRICAN_MUSIC_URL = "https://www.youtube.com/channel/UCX8JKqM-aCwDQOIRs70mcJQ";
    public static String K_POP_MUSIC_URL = "https://www.youtube.com/results?search_query=LIVE+KPOP";

    private final UmnPlayList[] UMN_PLAY_LIST = {
//            new UmnPlayList(R.drawable.bg_umn_play_list_detail, R.drawable.ic_soul_deep_collection, "SOUL MATE", "Welcome to Soul Mate Channel", "https://www.youtube.com/watch_popup?v=cVrSZdPfq8U", "where promote the greatest and most famous Soul artist.\n\n" + umnPlayListDescription),
            new UmnPlayList(R.drawable.bg_umn_play_list_detail, R.drawable.ic_soul_deep_collection, "SOUL MUSIC", "SOUL MUSIC", SOUL_MUSIC_URL, "where promote the greatest and most famous Soul artist.\n\n" + umnPlayListDescription),
//            new UmnPlayList(R.drawable.bg_umn_play_list_detail, R.drawable.ic_black_magic, "Electro & House", "BLACKMAGIC", "https://www.youtube.com/watch_popup?v=9JF5sIMxJ_U", umnPlayListDescription),
            new UmnPlayList(R.drawable.bg_umn_play_list_detail, R.drawable.ic_black_magic, "Electro & House", "BLACKMAGIC", "https://www.youtube.com/embed/0tTO-JiGKw0?autoplay=1", umnPlayListDescription),
//            new UmnPlayList(R.drawable.bg_umn_play_list_detail, R.drawable.ic_radio_hits_music, "POP Music", "Radio Hits Music", "https://www.youtube.com/watch_popup?v=uNd5kvrGHjk", umnPlayListDescription),
            new UmnPlayList(R.drawable.bg_umn_play_list_detail, R.drawable.ic_radio_hits_music, "POP Music", "Radio Hits Music", "https://www.youtube.com/embed/uNd5kvrGHjk?autoplay=1", umnPlayListDescription),
//            new UmnPlayList(R.drawable.bg_umn_play_list_detail, R.drawable.ic_musica_bachata, "Latino Music", "Musica Bachata", "https://www.youtube.com/watch_popup?v=NZrpuGqvmHU", umnPlayListDescription),
            new UmnPlayList(R.drawable.bg_umn_play_list_detail, R.drawable.ic_musica_bachata, "Latino Music", "Musica Bachata", LATINO_MUSIC_URL, umnPlayListDescription), new UmnPlayList(R.drawable.bg_umn_play_list_detail, R.drawable.ic_af_music_box, "African Music", "Af Music Box", AFRICAN_MUSIC_URL, umnPlayListDescription), new UmnPlayList(R.drawable.bg_umn_play_list_detail, R.drawable.ic_the_k_pop, "K-POP", "K-POP", K_POP_MUSIC_URL, umnPlayListDescription), new UmnPlayList(R.drawable.bg_umn_play_list_detail, R.drawable.ic_chiraq_drill, "Chiraq Drill", "Chiraq Drill", "https://www.youtube.com/embed/0uSn98gkT1Y?index=5&list=PLbKsqaJ1iyOG7g8dFaSiDl-j_bJ_TF3Uz", umnPlayListDescription),
//            new UmnPlayList(R.drawable.bg_umn_play_list_detail, R.drawable.ic_rapm, "Gangsta Rap", "Rap Mafia", "https://www.youtube.com/watch_popup?v=0MOkLkTP-Jk", umnPlayListDescription),
            new UmnPlayList(R.drawable.bg_umn_play_list_detail, R.drawable.ic_rapm, "Gangsta Rap", "Rap Mafia", "https://www.youtube.com/embed/0MOkLkTP-Jk?autoplay=1", umnPlayListDescription),};

    private final UmnPlayList[] TRAP_BEATS_PLAY_LIST = {new UmnPlayList(0, R.drawable.ic_epidemic_trap_beats, "TRAP BEATS", "Trap Beats Playlist", "https://www.youtube.com/results?search_query=trap+instrumental+playlist", umnPlayListDescription), new UmnPlayList(R.drawable.radio_bg_umn_radio, R.drawable.ic_beatserad, "Beats Era", "beatzera.com", "https://www.youtube.com/embed/j3AhWUx7IqA?list=PLjk8Jdc9PVxuqIzqiST9h1bZQtLcJQFV3", umnPlayListDescription), new UmnPlayList(R.drawable.radio_bg_umn_radio, R.drawable.ic_beat_demons, "BeatDemons", "beatdemons.com", "https://www.youtube.com/watch_popup?v=gLaWoJwd5Sc&list=PLOnZNnCSt2kc8RVTBWifflSB0XTAz962p&index=1", umnPlayListDescription), new UmnPlayList(R.drawable.radio_bg_umn_radio, R.drawable.ic_t500x500, "NSM Beats", "Beat by @prodbyzawn5236", "https://www.youtube.com/embed/4tBz-4Dewak?list=PLuc-N0XOWpw8BZOdj2lCm6ABVNdNUyXTN", umnPlayListDescription),};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mDetailsBackground = new DetailsSupportFragmentBackgroundController(this);

        mSelectedRadio = (RadioCard) requireActivity().getIntent().getSerializableExtra(RadioDetailsActivity.ITEM);

        if (mSelectedRadio != null) {
            mPresenterSelector = new ClassPresenterSelector();
            mAdapter = new ArrayObjectAdapter(mPresenterSelector);
            setupDetailsOverviewRow();
            setupDetailsOverviewRowPresenter();
            setupRelatedListRow();
            setAdapter(mAdapter);
            initializeBackground(mSelectedRadio);
        } else {
            Intent intent = new Intent(getActivity(), MainActivity.class);
            startActivity(intent);
        }
    }

    private void initializeBackground(RadioCard data) {
        mDetailsBackground.enableParallax();
        Glide.with(requireActivity()).asBitmap().centerCrop().error(R.drawable.default_background).load(data.getBackgroundStringUri()).into(new CustomTarget<Bitmap>() {
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
        DetailsOverviewRow row = new DetailsOverviewRow(mSelectedRadio);
        row.setImageDrawable(ContextCompat.getDrawable(requireActivity(), R.drawable.default_background));
//        int width = Convert.dpToPixel(requireActivity().getApplicationContext(), DETAIL_THUMB_WIDTH);
//        int height = Convert.dpToPixel(requireActivity().getApplicationContext(), DETAIL_THUMB_HEIGHT);
//        Glide.with(requireActivity()).load(mSelectedRadio.getDetailImageStringUri()).centerCrop().error(R.drawable.default_background).into(new CustomTarget<Drawable>(width, height) {
//            @Override
//            public void onResourceReady(@NonNull Drawable drawable, @Nullable Transition<? super Drawable> transition) {
//                Log.d(TAG, "details overview card image url ready: " + drawable);
//                row.setImageDrawable(drawable);
//                mAdapter.notifyArrayItemRangeChanged(0, mAdapter.size());
//            }
//
//            @Override
//            public void onLoadCleared(@Nullable Drawable placeholder) {
//
//            }
//        });

        ArrayObjectAdapter actionAdapter = new ArrayObjectAdapter();

        switch (mSelectedRadio.getTitle()) {
            case Radio.TRAP_BEATS_NAME -> {
                for (int i = 0; i < TRAP_BEATS_PLAY_LIST.length; i++) {
                    actionAdapter.add(new Action(i, TRAP_BEATS_PLAY_LIST[i].titleTab));
                }
            }
            case Radio.RADIONLINE -> {
                for (int i = 0; i < HMONG_PLAY_LIST.length; i++) {
                    actionAdapter.add(new Action(i, HMONG_PLAY_LIST[i].titleTab));
                }
            }
            case Radio.UMN_PLAYLIST -> {
                for (int i = 0; i < UMN_PLAY_LIST.length; i++) {
                    actionAdapter.add(new Action(i, UMN_PLAY_LIST[i].titleTab));
                }
            }
            case Radio.STUDY_MUSIC -> {
                for (int i = 0; i < STUDY_MUSIC_PLAY_LIST.length; i++) {
                    actionAdapter.add(new Action(i, STUDY_MUSIC_PLAY_LIST[i].titleTab));
                }
            }
            case Radio.VLC_PLAYER -> {
                for (int i = 0; i < TAI_LAO_KARAOKE_PLAY_LIST.length; i++) {
                    actionAdapter.add(new Action(i, TAI_LAO_KARAOKE_PLAY_LIST[i].titleTab));
                }
            }
        }
        row.setActionsAdapter(actionAdapter);

        mAdapter.add(row);
    }

    private void setupDetailsOverviewRowPresenter() {
        // Set detail background.
        FullWidthDetailsOverviewRowPresenter detailsPresenter = new FullWidthDetailsOverviewRowPresenter(new RadioDetailsDescriptionPresenter());
        detailsPresenter.setBackgroundColor(ContextCompat.getColor(requireActivity(), R.color.selected_background));

        // Hook up transition element.
        FullWidthDetailsOverviewSharedElementHelper sharedElementHelper = new FullWidthDetailsOverviewSharedElementHelper();
        sharedElementHelper.setSharedElementEnterTransition(getActivity(), RadioDetailsActivity.SHARED_ELEMENT_NAME);
        detailsPresenter.setListener(sharedElementHelper);
        detailsPresenter.setParticipatingEntranceTransition(true);

        setOnItemViewSelectedListener((itemViewHolder, item, rowViewHolder, row) -> {
//            FullWidthDetailsOverviewRowPresenter.ViewHolder viewHolder = (FullWidthDetailsOverviewRowPresenter.ViewHolder) rowViewHolder;
//
            try {
                DetailsOverviewRow detailsOverviewRow = (DetailsOverviewRow) row;
                Action action = (Action) item;
                if (action != null) {
                    int index = ((int) action.getId());
                    switch (mSelectedRadio.getTitle()) {
                        case Radio.UMN_PLAYLIST -> {
                            UmnPlayList umnPlayList = UMN_PLAY_LIST[index];
                            String title = umnPlayList.title;
                            RadioCard radioCard = new RadioCard();
                            radioCard.setTitle(title);
                            radioCard.setDetailDescription(umnPlayList.description);
                            changeBackground(umnPlayList.bg);
                            detailsOverviewRow.setItem(radioCard);
                            detailsOverviewRow.setImageDrawable(ContextCompat.getDrawable(requireContext(), umnPlayList.icon));
                        }
                        case Radio.RADIONLINE -> {
                            UmnPlayList umnPlayList = HMONG_PLAY_LIST[index];
                            String title = umnPlayList.title;
                            RadioCard radioCard = new RadioCard();
                            radioCard.setTitle(title);
                            radioCard.setDetailDescription(umnPlayList.description);
                            if (umnPlayList.bg != 0) {
                                changeBackground(umnPlayList.bg);
                            }
                            detailsOverviewRow.setItem(radioCard);
                            detailsOverviewRow.setImageDrawable(ContextCompat.getDrawable(requireContext(), umnPlayList.icon));
                        }
                        case Radio.STUDY_MUSIC -> {
                            UmnPlayList umnPlayList = STUDY_MUSIC_PLAY_LIST[index];
                            String title = umnPlayList.title;
                            RadioCard radioCard = new RadioCard();
                            radioCard.setTitle(title);
                            radioCard.setDetailDescription(umnPlayList.description);
                            if (umnPlayList.bg != 0) {
                                changeBackground(umnPlayList.bg);
                            }
                            detailsOverviewRow.setItem(radioCard);
                            detailsOverviewRow.setImageDrawable(ContextCompat.getDrawable(requireContext(), umnPlayList.icon));
                        }
                        case Radio.TRAP_BEATS_NAME -> {
                            UmnPlayList umnPlayList = TRAP_BEATS_PLAY_LIST[index];
                            String title = umnPlayList.title;
                            RadioCard radioCard = new RadioCard();
                            radioCard.setTitle(title);
                            radioCard.setDetailDescription(umnPlayList.description);
                            if (umnPlayList.bg != 0) {
                                changeBackground(umnPlayList.bg);
                            }
                            detailsOverviewRow.setItem(radioCard);
                            detailsOverviewRow.setImageDrawable(ContextCompat.getDrawable(requireContext(), umnPlayList.icon));
                        }
                        case Radio.VLC_PLAYER -> {
                            UmnPlayList umnPlayList = TAI_LAO_KARAOKE_PLAY_LIST[index];
                            String title = umnPlayList.title;
                            RadioCard radioCard = new RadioCard();
                            radioCard.setTitle(title);
                            radioCard.setDetailDescription(umnPlayList.description);
                            if (umnPlayList.bg != 0) {
                                changeBackground(umnPlayList.bg);
                            }
                            detailsOverviewRow.setItem(radioCard);
                            detailsOverviewRow.setImageDrawable(ContextCompat.getDrawable(requireContext(), umnPlayList.icon));
                        }
                    }
                }
            } catch (Throwable t) {
                t.printStackTrace();
            }
        });

        detailsPresenter.setOnActionClickedListener(action -> {
            int index = (int) action.getId();
            switch (mSelectedRadio.getTitle()) {
                case Radio.TRAP_BEATS_NAME: {
                    UmnPlayList umnPlayList = TRAP_BEATS_PLAY_LIST[index];
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    try {
                        intent.setData(Uri.parse(umnPlayList.link));
                        intent.setPackage("com.jio.web.androidtv");
                        startActivity(intent);
                    } catch (Throwable t) {
                        Toast.makeText(getContext(), t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
                        String uriString = umnPlayList.link;
                        intent.setData(Uri.parse(uriString));
                        startActivity(intent);
                    }
                    break;
                }
                case Radio.RADIONLINE: {
                    UmnPlayList umnPlayList = HMONG_PLAY_LIST[index];
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    try {
                        intent.setData(Uri.parse(umnPlayList.link));
                        intent.setPackage("com.jio.web.androidtv");
                        startActivity(intent);
                    } catch (Throwable t) {
                        Toast.makeText(getContext(), t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
                        String uriString = umnPlayList.link;
                        intent.setData(Uri.parse(uriString));
                        startActivity(intent);
                    }
                    break;
                }
                case Radio.UMN_PLAYLIST: {
                    UmnPlayList umnPlayList = UMN_PLAY_LIST[index];
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    try {
                        intent.setData(Uri.parse(umnPlayList.link));
                        intent.setPackage("com.jio.web.androidtv");
                        startActivity(intent);
                    } catch (Throwable t) {
                        Toast.makeText(getContext(), t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
                        String uriString = umnPlayList.link;
                        intent.setData(Uri.parse(uriString));
                        startActivity(intent);
                    }
                    break;
                }
                case Radio.STUDY_MUSIC: {
                    UmnPlayList umnPlayList = STUDY_MUSIC_PLAY_LIST[index];
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    try {
                        intent.setData(Uri.parse(umnPlayList.link));
                        intent.setPackage("com.jio.web.androidtv");
                        startActivity(intent);
                    } catch (Throwable t) {
                        Toast.makeText(getContext(), t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
                        String uriString = umnPlayList.link;
                        intent.setData(Uri.parse(uriString));
                        startActivity(intent);
                    }
                    break;
                }
                case Radio.VLC_PLAYER: {
                    UmnPlayList umnPlayList = TAI_LAO_KARAOKE_PLAY_LIST[index];
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    try {
                        intent.setData(Uri.parse(umnPlayList.link));
                        intent.setPackage("com.jio.web.androidtv");
                        startActivity(intent);
                    } catch (Throwable t) {
                        Toast.makeText(getContext(), t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
                        String uriString = umnPlayList.link;
                        intent.setData(Uri.parse(uriString));
                        startActivity(intent);
                    }
                    break;
                }
            }
//            else {
//                if (mSelectedRadio.getLink() != null) {
//                    String[] url = mSelectedRadio.getLink().split(" ");
//                    Intent i = new Intent(Intent.ACTION_VIEW);
//                    i.setData(Uri.parse(url[(int) action.getId()]));
//                    startActivity(i);
//                }
//            }
        });

        mPresenterSelector.addClassPresenter(DetailsOverviewRow.class, detailsPresenter);
    }

    private void setupRelatedListRow() {
        String[] subcategories = {getString(R.string.related_radio)};

        List<RadioCard> list = new ArrayList<>();

        for (RadioCard n : Radio.setup()) {
            if (!n.getTitle().equals(mSelectedRadio.getTitle())) {
                list.add(n);
            }
        }

        Collections.shuffle(list);
        ArrayObjectAdapter listRowAdapter = new ArrayObjectAdapter(new RadioDetailsRelatedPresenter());
        listRowAdapter.addAll(0, list);

        HeaderItem header = new HeaderItem(0, subcategories[0]);
        mAdapter.add(new ListRow(header, listRowAdapter));
        mPresenterSelector.addClassPresenter(ListRow.class, new ListRowPresenter());
        setOnItemViewClickedListener(new ItemViewClickedListener());
    }

    private final class ItemViewClickedListener implements OnItemViewClickedListener {
        @Override
        public void onItemClicked(Presenter.ViewHolder itemViewHolder, Object item, RowPresenter.ViewHolder rowViewHolder, Row row) {
            if (item instanceof RadioCard) {
                RadioCard r = (RadioCard) item;
                ((RadioCard) item).onClicked(new CardVisitor(requireContext()));

                if (r.getPackageName() == null) {
                    requireActivity().finishAfterTransition();
                }
            }
        }
    }

    private void changeBackground(@DrawableRes int drawable) {
        Bitmap b = BitmapFactory.decodeResource(getResources(), drawable);
        mDetailsBackground.setCoverBitmap(b);
        mDetailsBackground.enableParallax();
    }
}