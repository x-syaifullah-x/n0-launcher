package com.umntv.launcher.main.row.news_or_media.presentation.detail;

import android.os.Bundle;

import com.umntv.launcher.main.row.news_or_media.data.repository.DataSource;
import com.umntv.launcher.util.Admob;

import net.n0ender.com.R;

public class IntNewsFragment extends BaseDetailFragment {
    public IntNewsFragment() {
        super(DataSource.items);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Admob.setup(requireActivity().findViewById(R.id.adView));
    }
}
