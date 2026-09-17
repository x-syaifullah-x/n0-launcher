package com.umntv.launcher.base;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.umntv.launcher.main.DetailsActivity;
import com.umntv.launcher.main.row.news_or_media.presentation.detail.NewsDetailsFragment;
import com.umntv.launcher.main.row.radio_workout.detail.RadioDetailsFragment;
import com.umntv.launcher.main.row.support.Support;
import com.umntv.launcher.main.row.support.SupportCard;
import com.umntv.launcher.main.row.apps.AppsActivity;
import com.umntv.launcher.main.row.apps.AppsCard;
import com.umntv.launcher.main.row.apps.app_drawer.AppDrawerCard;
import com.umntv.launcher.main.row.apps.app_drawer.AppDrawerFragment;
import com.umntv.launcher.main.row.apps.app_drawer.LaunchApp;
import com.umntv.launcher.main.row.asian_media.AsianMediaCard;
import com.umntv.launcher.main.row.asian_media.detail.jade_cinema.DetailFragment;
import com.umntv.launcher.main.row.games.GamesCardApp;
import com.umntv.launcher.main.row.e_kids.KidsCard;
import com.umntv.launcher.main.row.support.detail.global_girl_net.GlobalGirlNetFragment;
import com.umntv.launcher.main.row.support.detail.leeway.LeewayFragment;
import com.umntv.launcher.main.row.support.detail.platinum_staffing.PlatinumStaffingFragment;
import com.umntv.launcher.main.row.support.detail.support.SupportFragment;
import com.umntv.launcher.main.row.support.detail.the_dale_studios.TheDaleStudiosFragment;
import com.umntv.launcher.main.row.tools.ToolsCard;
import com.umntv.launcher.main.row.news_or_media.data.repository.NewsOrMediaRepository;
import com.umntv.launcher.main.row.news_or_media.domain.model.NewsMediaModel;
import com.umntv.launcher.main.row.news_or_media.presentation.detail.IntNewsFragment;
import com.umntv.launcher.main.row.news_or_media.presentation.detail.youtube_shorts.YoutubeShortsFragment;
import com.umntv.launcher.main.row.radio_workout.RadioCard;
import com.umntv.launcher.main.row.n0_render.UmnTv;
import com.umntv.launcher.main.row.n0_render.UmnTvCard;
import com.umntv.launcher.main.row.n0_render.detail.download_center.DownloadCenterDetailFragment;
import com.umntv.launcher.main.row.n0_render.faq.FaqDetailFragment;
import com.umntv.launcher.main.row.n0_render.media_center.MediaCenterDetailFragment;
import com.umntv.launcher.main.row.n0_render.network.NetworkDetailFragment;
import com.umntv.launcher.main.row.utilities.Utilities;
import com.umntv.launcher.main.row.utilities.UtilitiesCard;
import com.umntv.launcher.main.row.utilities.details.preload_tv.DetailPreloadTvFragment;
import com.umntv.launcher.main.row.utilities.details.remote_support.DetailRemoteSupportTvFragment;
import com.umntv.launcher.util.AndroidStore;
import com.umntv.launcher.util.view.dialog.ApkUtil;

import net.n0ender.com.R;

import java.util.Objects;

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

    public void click(SupportCard supportCard) {
//        Intent intent = new Intent(getContext(), SupportDetailActivity.class);
//        intent.putExtra(SupportDetailActivity.ITEM, supportCard);
//        getContext().startActivity(intent);

        FragmentActivity fragmentActivity = (FragmentActivity) getContext();
        Fragment fragment = null;

//        Intent intent = new Intent(getContext(), DetailsActivity.class);
        if (supportCard.getTitle().equals(Support.VENDORS_SUPPORT)) {
//            intent.setAction(SupportFragment.class.getName());
            fragment = new SupportFragment();
        } else if (supportCard.getTitle().equals(Support.GLOBAL_GIRLS_NET)) {
//            intent.setAction(GlobalGirlNetFragment.class.getName());
            fragment = new GlobalGirlNetFragment();
        } else if (supportCard.getTitle().equals(Support.PLATINUM_STAFFING)) {
//            intent.setAction(PlatinumStaffingFragment.class.getName());
            fragment = new PlatinumStaffingFragment();
        } else if (supportCard.getTitle().equals(Support.THE_DALE_STUDIOS)) {
            fragment = new TheDaleStudiosFragment();
//            intent.setAction(TheDaleStudiosFragment.class.getName());
        } else if (supportCard.getTitle().equals(Support.TITLE_LEEWAY_ENDEAVORS)) {
            fragment = new LeewayFragment();
//            intent.setAction(LeewayFragment.class.getName());
        }

        if (fragment != null) {
            fragmentActivity.getSupportFragmentManager()
                    .beginTransaction()
                    .addToBackStack(null)
                    .add(R.id.main_browse_fragment, fragment, null)
                    .commit();
        }
//        getContext().startActivity(intent);
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
//                Intent intent = new Intent(getContext(), DetailsActivity.class);
//                intent.setAction(IntNewsFragment.class.getName());
//                getContext().startActivity(intent);

                FragmentActivity fragmentActivity = (FragmentActivity) getContext();
                fragmentActivity.getSupportFragmentManager()
                        .beginTransaction()
                        .addToBackStack(null)
                        .add(R.id.main_browse_fragment, new IntNewsFragment(), null)
                        .commit();

            } else if (newsMediaModel.getTitle().equals(NewsOrMediaRepository.YOUTUBE_ENJOYABLES)) {
//                Intent intent = new Intent(getContext(), DetailsActivity.class);
//                intent.setAction(YoutubeShortsFragment.class.getName());
//                getContext().startActivity(intent);

                FragmentActivity fragmentActivity = (FragmentActivity) getContext();
                fragmentActivity.getSupportFragmentManager()
                        .beginTransaction()
                        .addToBackStack(null)
                        .add(R.id.main_browse_fragment, new YoutubeShortsFragment(), null)
                        .commit();
            } else {
//                Intent intent = new Intent(getContext(), NewsDetailsActivity.class);
//                intent.putExtra(NewsDetailsActivity.ITEM, newsMediaModel);
//                getContext().startActivity(intent);

//                Intent intent = new Intent(getContext(), DetailsActivity.class);
//                intent.putExtra(NewsDetailsActivity.ITEM, newsMediaModel);
//                intent.setAction(NewsDetailsFragment.class.getName());
//                getContext().startActivity(intent);
                FragmentActivity fragmentActivity = (FragmentActivity) getContext();
                fragmentActivity.getSupportFragmentManager()
                        .beginTransaction()
                        .addToBackStack(null)
                        .add(R.id.main_browse_fragment, new NewsDetailsFragment(), null)
                        .commit();

            }
        }
    }


    public void click(RadioCard radioCard) {
        if (radioCard.getPackageName() != null) {
            Intent launchIntent = getContext().getPackageManager().getLaunchIntentForPackage(radioCard.getPackageName());
            if (launchIntent == null) {
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
//            Intent intent = new Intent(getContext(), RadioDetailsActivity.class);
//            intent.putExtra(RadioDetailsActivity.ITEM, radioCard);
//            getContext().startActivity(intent);

//            Intent intent = new Intent(getContext(), DetailsActivity.class);
//            intent.setAction(RadioDetailsFragment.class.getName());
//            getContext().startActivity(intent);

            FragmentActivity fragmentActivity = (FragmentActivity) getContext();
            fragmentActivity.getSupportFragmentManager()
                    .beginTransaction()
                    .addToBackStack(null)
                    .add(R.id.main_browse_fragment, new RadioDetailsFragment(), null)
                    .commit();
        }
    }

    public void click(UtilitiesCard utilitiesCard) {
        if (utilitiesCard.getDataExtra() != null) {
//            Intent i = new Intent(getContext(), UtilitiesDetailsActivity.class);
//            i.putExtra(utilitiesCard.getDataExtra(), true);

            FragmentActivity fragmentActivity = (FragmentActivity) getContext();
            Fragment fragment = null;


//            Intent i = new Intent(getContext(), DetailsActivity.class);
            if (Objects.equals(utilitiesCard.getDataExtra(), Utilities.DATA_EXTRA_REMOTE_SUPPORT)) {
                fragment = new DetailRemoteSupportTvFragment();
//                i.setAction(DetailRemoteSupportTvFragment.class.getName());
            } else if (Objects.equals(utilitiesCard.getDataExtra(), Utilities.DATA_EXTRA_PRELOAD_TV)) {
                fragment = new DetailPreloadTvFragment();
//                i.setAction(DetailPreloadTvFragment.class.getName());
            }

            if (fragment != null) {
                fragmentActivity.getSupportFragmentManager()
                        .beginTransaction()
                        .addToBackStack(null)
                        .add(R.id.main_browse_fragment, fragment, null)
                        .commit();
            }

//            getContext().startActivity(i);
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
            FragmentActivity fragmentActivity = (FragmentActivity) getContext();
            fragmentActivity.getSupportFragmentManager()
                    .beginTransaction()
                    .addToBackStack(null)
                    .add(R.id.main_browse_fragment, new com.umntv.launcher.main.row.e_kids.details.e_lerning.DetailFragment(), null)
                    .commit();

//            Intent intent = new Intent(getContext(), DetailsActivity.class);
//            intent.setAction(com.umntv.launcher.main.row.e_kids.details.e_lerning.DetailFragment.class.getName());
//            getContext().startActivity(intent);
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
                FragmentActivity fragmentActivity = (FragmentActivity) getContext();
                Fragment fragment = null;

                String title = umnTvCard.getTitle();

//                Intent intent = new Intent(getContext(), DetailsActivity.class);

                switch (title) {
                    case UmnTv.TITLE_NETWORK ->
//                            intent.setAction(NetworkDetailFragment.class.getName());
                            fragment = new NetworkDetailFragment();
                    case UmnTv.TITLE_DOWNLOAD_CENTER -> {
//                        Intent launchIntentForPackage = mContext.getPackageManager().getLaunchIntentForPackage("com.umn.n0.browser");
//                        if (launchIntentForPackage != null) {
//                            intent = launchIntentForPackage;
//                        } else {
//                            intent = new Intent(Intent.ACTION_VIEW);
//                            intent.setData(Uri.parse("https://n0render.com/dc"));
//                        }

//                        intent.setAction(DownloadCenterDetailFragment.class.getName());
                        fragment = new DownloadCenterDetailFragment();
                    }
                    case UmnTv.TITLE_MEDIA_CENTER -> {
//                        intent.setAction(MediaCenterDetailFragment.class.getName());
                        fragment = new MediaCenterDetailFragment();
                    }
                    case UmnTv.TITLE_FAQ ->
//                            intent.setAction(FaqDetailFragment.class.getName());
                            fragment = new FaqDetailFragment();
                    case UmnTv.TITLE_APP_DRAWER -> {
                        Intent intent = new Intent(getContext(), AppsActivity.class);
                        intent.setAction(AppDrawerFragment.class.getName());
                        getContext().startActivity(intent);
                        return;
                    }
                }

                if (fragment != null) {
                    fragmentActivity.getSupportFragmentManager()
                            .beginTransaction()
                            .addToBackStack(null)
                            .add(R.id.main_browse_fragment, fragment, null)
                            .commit();
                }

//                getContext().startActivity(intent);
            }
        }
    }

    public void click(GamesCardApp gamesCardApp) {
        if (gamesCardApp.getDetail() != null) {
//            Intent intent = new Intent(getContext(), DetailsActivity.class);
//            intent.setAction(gamesCardApp.getDetail().getName());
//            getContext().startActivity(intent);

            FragmentActivity fragmentActivity = (FragmentActivity) getContext();
            fragmentActivity.getSupportFragmentManager()
                    .beginTransaction()
                    .addToBackStack(null)
                    .add(R.id.main_browse_fragment, gamesCardApp.getDetail(), null)
                    .commit();
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
//            Intent intent = new Intent(getContext(), DetailsActivity.class);
//            intent.setAction(DetailFragment.class.getName());
//            getContext().startActivity(intent);

            FragmentActivity fragmentActivity = (FragmentActivity) getContext();
            fragmentActivity.getSupportFragmentManager()
                    .beginTransaction()
                    .addToBackStack(null)
                    .add(R.id.main_browse_fragment, new DetailFragment(), null)
                    .commit();
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
