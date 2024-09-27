package com.umntv.launcher.main.row.apps.app_drawer;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.leanback.app.DetailsSupportFragmentBackgroundController;
import androidx.leanback.app.VerticalGridSupportFragment;
import androidx.leanback.widget.ArrayObjectAdapter;
import androidx.leanback.widget.OnItemViewClickedListener;
import androidx.leanback.widget.Presenter;
import androidx.leanback.widget.Row;
import androidx.leanback.widget.RowPresenter;
import androidx.leanback.widget.VerticalGridPresenter;

import net.n0ender.com.R;
import com.umntv.launcher.base.Card;
import com.umntv.launcher.base.CardPresenter;
import com.umntv.launcher.main.row.apps.app_drawer.error.BrowseErrorActivity;

import java.util.List;

public class AppDrawerFragment extends VerticalGridSupportFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        setupFragment();

        loadItems();

        setupEventListeners();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    private void setupFragment() {
        VerticalGridPresenter gridPresenter = new AppDrawerPresenter();
        gridPresenter.setNumberOfColumns(6);
        setGridPresenter(gridPresenter);
    }

    private void loadItems() {
        ArrayObjectAdapter adapter = new ArrayObjectAdapter(new CardPresenter());

        List<Card> list = AppDataManage.getLaunchAppList(requireContext());
        adapter.addAll(0, list);

        setAdapter(adapter);
    }

    private void setupEventListeners() {
        setOnItemViewClickedListener(new AppDrawerFragment.ItemViewClickedListener());
    }

    private final class ItemViewClickedListener implements OnItemViewClickedListener {
        @Override
        public void onItemClicked(Presenter.ViewHolder itemViewHolder, Object item, RowPresenter.ViewHolder rowViewHolder, Row row) {
            if (item instanceof LaunchApp) {
                LaunchApp launchApp = (LaunchApp) item;
                Intent launchIntent = requireActivity().getPackageManager().getLaunchIntentForPackage(
                        launchApp.getPackageName());
                if (launchIntent != null) {
                    requireActivity().startActivity(launchIntent);
                }
            } else if (item instanceof String) {
                if (((String) item).contains(getString(R.string.error_fragment))) {
                    Intent intent = new Intent(getActivity(), BrowseErrorActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(getActivity(), ((String) item), Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}
