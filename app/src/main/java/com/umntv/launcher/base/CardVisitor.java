package com.umntv.launcher.base;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

import com.umntv.launcher.main.DetailsActivity;
import com.umntv.launcher.main.row.support.AdsCard;
import com.umntv.launcher.main.row.support.detail.AdsDetailsActivity;
import com.umntv.launcher.main.row.apps.AppsActivity;
import com.umntv.launcher.main.row.apps.AppsCard;
import com.umntv.launcher.main.row.apps.app_drawer.AppDrawerCard;
import com.umntv.launcher.main.row.apps.app_drawer.AppDrawerFragment;
import com.umntv.launcher.main.row.apps.app_drawer.LaunchApp;
import com.umntv.launcher.main.row.asian_media.AsianMediaCard;
import com.umntv.launcher.main.row.asian_media.detail.jade_cinema.DetailFragment;
import com.umntv.launcher.main.row.games.GamesCardApp;
import com.umntv.launcher.main.row.kids.KidsCard;
import com.umntv.launcher.main.row.tools.ToolsCard;
import com.umntv.launcher.main.row.news_or_media.data.repository.NewsOrMediaRepository;
import com.umntv.launcher.main.row.news_or_media.domain.model.NewsMediaModel;
import com.umntv.launcher.main.row.news_or_media.presentation.detail.IntNewsFragment;
import com.umntv.launcher.main.row.news_or_media.presentation.detail.NewsDetailsActivity;
import com.umntv.launcher.main.row.news_or_media.presentation.detail.youtube_shorts.YoutubeShortsFragment;
import com.umntv.launcher.main.row.radio.RadioCard;
import com.umntv.launcher.main.row.radio.detail.RadioDetailsActivity;
import com.umntv.launcher.main.row.n0_render.UmnTv;
import com.umntv.launcher.main.row.n0_render.UmnTvCard;
import com.umntv.launcher.main.row.n0_render.detail.download_center.DownloadCenterDetailFragment;
import com.umntv.launcher.main.row.n0_render.faq.FaqDetailFragment;
import com.umntv.launcher.main.row.n0_render.media_center.MediaCenterDetailFragment;
import com.umntv.launcher.main.row.n0_render.network.NetworkDetailFragment;
import com.umntv.launcher.main.row.utilities.UtilitiesCard;
import com.umntv.launcher.main.row.utilities.details.UtilitiesDetailsActivity;
import com.umntv.launcher.util.AndroidStore;
import com.umntv.launcher.util.view.dialog.ApkUtil;

public class CardVisitor extends CardVisitorKt {

    public CardVisitor(Context context) {
        super(context);
    }

    public void click(ToolsCard card) {
        String packageName = card.getPackageName();
        if (packageName != null) {
            Intent launchIntent = getContext().getPackageManager().getLaunchIntentForPackage(packageName);
            if (launchIntent != null) {
                getContext().startActivity(launchIntent);
            } else {
                String apkUrl = card.getApkUrl();
                if (apkUrl != null) {
                    ApkUtil.downloadToCacheDirAndInstall(getContext(), apkUrl);
                } else {
                    AndroidStore.open(getContext(), packageName);
                }
            }
        }
    }

    public void click(LaunchApp launchApp) {
        Intent launchIntent = getContext().getPackageManager().getLaunchIntentForPackage(launchApp.getPackageName());
        if (launchIntent != null) {
            getContext().startActivity(launchIntent);
        }
    }

    public void click(AppDrawerCard appDrawerCard) {
        Intent intent = new Intent(getContext(), AppsActivity.class);
        getContext().startActivity(intent);
    }

    public void click(AdsCard adsCard) {
        Intent intent = new Intent(getContext(), AdsDetailsActivity.class);
        intent.putExtra(AdsDetailsActivity.ITEM, adsCard);
        getContext().startActivity(intent);
    }

    public void click(NewsMediaModel newsMediaModel) {
        String packageName = newsMediaModel.getPackageName();
        if (packageName != null) {
            Intent launchIntent = getContext().getPackageManager().getLaunchIntentForPackage(packageName);
            if (launchIntent != null) {
                getContext().startActivity(launchIntent);
            } else {
                String apkUrl = newsMediaModel.getApkUrl();
                if (apkUrl != null) {
                    ApkUtil.downloadToCacheDirAndInstall(getContext(), apkUrl);
                } else {
                    AndroidStore.open(getContext(), packageName);
                }
            }
        } else {
            if (newsMediaModel.getTitle().equals(NewsOrMediaRepository.INT_NEWS)) {
                Intent intent = new Intent(getContext(), DetailsActivity.class);
                intent.setAction(IntNewsFragment.class.getName());
                getContext().startActivity(intent);
            } else if (newsMediaModel.getTitle().equals(NewsOrMediaRepository.YOUTUBE_ENJOYABLES)) {
                Intent intent = new Intent(getContext(), DetailsActivity.class);
                intent.setAction(YoutubeShortsFragment.class.getName());
                getContext().startActivity(intent);
            } else {
                Intent intent = new Intent(getContext(), NewsDetailsActivity.class);
                intent.putExtra(NewsDetailsActivity.ITEM, newsMediaModel);
                getContext().startActivity(intent);
            }
        }
    }


    public void click(RadioCard radioCard) {
        if (radioCard.getPackageName() != null) {
            Intent launchIntent = getContext().getPackageManager().getLaunchIntentForPackage(radioCard.getPackageName());
            if (launchIntent == null){
                launchIntent = getContext().getPackageManager().getLeanbackLaunchIntentForPackage(radioCard.getPackageName());
            }
//            Log.i("abc", launchIntent + "");
            if (launchIntent != null) {
                /* open application */
                getContext().startActivity(launchIntent);
            } else {
                if (radioCard.getLinkApkDownload() != null) {
                    /* download apk */
                    ApkUtil.downloadToCacheDirAndInstall(getContext(), radioCard.getLinkApkDownload());
                } else {
                    /* open play store */
                    AndroidStore.open(getContext(), radioCard.getPackageName());
                }
            }
        } else {
            Intent intent = new Intent(getContext(), RadioDetailsActivity.class);
            intent.putExtra(RadioDetailsActivity.ITEM, radioCard);
            getContext().startActivity(intent);
        }
    }

    public void click(UtilitiesCard utilitiesCard) {
        if (utilitiesCard.getDataExtra() != null) {
            Intent i = new Intent(getContext(), UtilitiesDetailsActivity.class);
            i.putExtra(utilitiesCard.getDataExtra(), true);
            getContext().startActivity(i);
        } else if (utilitiesCard.getPackageName() != null) {
            Intent launchIntent = getContext().getPackageManager().getLaunchIntentForPackage(utilitiesCard.getPackageName());
            if (launchIntent != null) {
                getContext().startActivity(launchIntent);
            } else {
                if (utilitiesCard.getLinkApkDownload() != null) {
                    ApkUtil.downloadToCacheDirAndInstall(getContext(), utilitiesCard.getLinkApkDownload());
                } else {
                    /* open play store */
                    AndroidStore.open(getContext(), utilitiesCard.getPackageName());
                }
            }
        }
    }


    public void click(KidsCard kidsCard) {
        if (kidsCard.getPackageName() != null) {
            Intent launchIntent = getContext().getPackageManager().getLaunchIntentForPackage(kidsCard.getPackageName());
            if (launchIntent != null) {
                getContext().startActivity(launchIntent);
            } else {
                if (kidsCard.getDownloadUrl() != null) {
                    ApkUtil.downloadToCacheDirAndInstall(getContext(), kidsCard.getDownloadUrl());
                    return;
                }
                AndroidStore.open(getContext(), kidsCard.getPackageName());
            }
        } else {
            Intent intent = new Intent(getContext(), DetailsActivity.class);
            intent.setAction(com.umntv.launcher.main.row.kids.details.e_lerning.DetailFragment.class.getName());
            getContext().startActivity(intent);
        }
    }

    public void click(UmnTvCard umnTvCard) {
        if (umnTvCard.getPackageName() != null) {
            /* open application or download apk */
            Intent launchIntent = getContext().getPackageManager().getLaunchIntentForPackage(umnTvCard.getPackageName());
            if (launchIntent != null) {
                /* open application */
                getContext().startActivity(launchIntent);
            } else {
                ApkUtil.downloadToCacheDirAndInstall(getContext(), umnTvCard.getLinkApkDownload());
            }
        } else {
            /* open browser or open detail */
            if (umnTvCard.getLink() != null) {
                /* open browser */
                try {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(umnTvCard.getLink()));
                    myIntent.setPackage("com.android.chrome");
                    getContext().startActivity(myIntent);
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(getContext(), "No application can handle this request." + " Please install a web browser", Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }
            } else {
                String title = umnTvCard.getTitle();
                Intent intent = new Intent(getContext(), DetailsActivity.class);
                switch (title) {
                    case UmnTv.TITLE_NETWORK ->
                            intent.setAction(NetworkDetailFragment.class.getName());
                    case UmnTv.TITLE_DOWNLOAD_CENTER -> {
//                        Intent launchIntentForPackage = mContext.getPackageManager().getLaunchIntentForPackage("com.umn.n0.browser");
//                        if (launchIntentForPackage != null) {
//                            intent = launchIntentForPackage;
//                        } else {
//                            intent = new Intent(Intent.ACTION_VIEW);
//                            intent.setData(Uri.parse("https://n0render.com/dc"));
//                        }
                        intent.setAction(DownloadCenterDetailFragment.class.getName());
                    }
                    case UmnTv.TITLE_MEDIA_CENTER ->
                            intent.setAction(MediaCenterDetailFragment.class.getName());
                    case UmnTv.TITLE_FAQ -> intent.setAction(FaqDetailFragment.class.getName());
                    case UmnTv.TITLE_APP_DRAWER -> {
                        intent = new Intent(getContext(), AppsActivity.class);
                        intent.setAction(AppDrawerFragment.class.getName());
                    }
                }
                getContext().startActivity(intent);
            }
        }
    }

    public void click(GamesCardApp gamesCardApp) {
        if (gamesCardApp.getDetail() != null) {
            Intent intent = new Intent(getContext(), DetailsActivity.class);
            intent.setAction(gamesCardApp.getDetail().getName());
            getContext().startActivity(intent);
            return;
        }

        Intent launchIntent = getContext().getPackageManager().getLaunchIntentForPackage(gamesCardApp.getPackageName());
        if (launchIntent != null) {
            getContext().startActivity(launchIntent);
        } else {
            if (gamesCardApp.getLinkApkDownload() != null) {
                ApkUtil.downloadToCacheDirAndInstall(getContext(), gamesCardApp.getLinkApkDownload());
            } else {
                AndroidStore.open(getContext(), gamesCardApp.getPackageName());
            }
        }
    }

    public void click(AsianMediaCard asianMediaCard) {
        if (asianMediaCard.getPackageName() == null) {
            Intent intent = new Intent(getContext(), DetailsActivity.class);
            intent.setAction(DetailFragment.class.getName());
            getContext().startActivity(intent);
            return;
        }

        Intent launchIntent = getContext().getPackageManager()
                .getLaunchIntentForPackage(asianMediaCard.getPackageName());
        if (launchIntent == null) {
            launchIntent = getContext().getPackageManager()
                    .getLeanbackLaunchIntentForPackage(asianMediaCard.getPackageName());
        }
        if (launchIntent != null) {
            getContext().startActivity(launchIntent);
        } else {
            if (asianMediaCard.getLinkApkDownload() != null) {
                ApkUtil.downloadToCacheDirAndInstall(getContext(), asianMediaCard.getLinkApkDownload());
            } else {
                AndroidStore.open(getContext(), asianMediaCard.getPackageName());
            }
        }
    }

    public void click(AppsCard appsCard) {
        if (appsCard.getPackageName() != null) {
            Intent launchIntent = getContext().getPackageManager().getLaunchIntentForPackage(appsCard.getPackageName());
            if (launchIntent != null) {
                getContext().startActivity(launchIntent);
            } else {
                AndroidStore.open(getContext(), appsCard.getPackageName());
            }
        } else {
            Intent intent = new Intent(getContext(), AppsActivity.class);
            intent.setAction(appsCard.getClassNameActivityDetail());
            getContext().startActivity(intent);
        }
    }
}
