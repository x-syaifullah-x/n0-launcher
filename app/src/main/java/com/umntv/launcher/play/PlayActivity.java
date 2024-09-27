package com.umntv.launcher.play;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;
import net.n0ender.com.R;

public class PlayActivity extends FragmentActivity {

    private static final String NAME_URL = "NAME_URL";

    public static Intent createIntent(Context c, String url) {
        Intent i = new Intent(c, PlayActivity.class);
        i.putExtra(NAME_URL, url);
        return i;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_play);

        YouTubePlayerView mPlayerView = findViewById(R.id.youtube_player_view);
        getLifecycle().addObserver(mPlayerView);

        mPlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer player) {
                super.onReady(player);

                String id = getIntent().getStringExtra(NAME_URL);
                mPlayerView.getPlayerUiController().enableLiveVideoUi(true);
                player.loadVideo(id, 0);
            }
        });
    }
}