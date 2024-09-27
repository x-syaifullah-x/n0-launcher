package com.umntv.launcher.main.row.news_or_media.presentation.detail.youtube_shorts;

import android.os.Bundle;

import com.umntv.launcher.main.row.news_or_media.presentation.detail.BaseDetailFragment;
import com.umntv.launcher.util.Admob;

import net.n0ender.com.R;

public class YoutubeShortsFragment extends BaseDetailFragment {
    public YoutubeShortsFragment() {
        super(DataSource.items);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Admob.setup(requireActivity().findViewById(R.id.adView));
    }
}
