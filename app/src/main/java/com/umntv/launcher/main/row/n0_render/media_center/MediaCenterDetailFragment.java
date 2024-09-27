package com.umntv.launcher.main.row.n0_render.media_center;

import android.os.Bundle;

import com.umntv.launcher.main.base.BaseDetailFragment;
import com.umntv.launcher.util.Admob;

import net.n0ender.com.R;

public class MediaCenterDetailFragment extends BaseDetailFragment {
    public MediaCenterDetailFragment() {
        super(DataSource.items);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Admob.setup(requireActivity().findViewById(R.id.adView));
    }
}
