package com.umntv.launcher.main.row.n0_render.faq;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.umntv.launcher.main.base.ApkData;
import com.umntv.launcher.main.base.BaseDetailFragment;
import com.umntv.launcher.util.Admob;

import net.n0ender.com.R;

public class FaqDetailFragment extends BaseDetailFragment {

    public FaqDetailFragment() {
        super(DataSource.items);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Admob.setup(requireActivity().findViewById(R.id.adView));
    }

    @Override
    public void openOrDownload(ApkData apkData) {
        open(apkData.url);
    }

    private void open(String url) {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }
}
