package com.umntv.launcher;

import android.app.Application;
import android.util.Log;

import com.flurry.android.FlurryAgent;
import com.flurry.android.FlurryPerformance;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        new FlurryAgent.Builder()
                .withLogEnabled(true)
                .withLogLevel(Log.VERBOSE)
                .withReportLocation(true)
                .withCaptureUncaughtExceptions(true)
                .withContinueSessionMillis(10000)
                .withSessionForceStart(true)
                .withPerformanceMetrics(FlurryPerformance.ALL)
                .withIncludeBackgroundSessionsInMetrics(true)
                .build(this, "68Y5VWW6XTGYSXHFTFYZ");

//        Thread.setDefaultUncaughtExceptionHandler((t, e) -> {
//            Executors.newSingleThreadExecutor().execute(new Runnable() {
//                @Override
//                public void run() {
//                    StringWriter stringWriter = new StringWriter();
//                    PrintWriter printWriter = new PrintWriter(stringWriter);
//                    e.printStackTrace(printWriter);
//
//                    System.out.println(stringWriter);
//
//                    Intent intent = new Intent(getBaseContext(), ExceptionActivity.class);
//                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                    getBaseContext().startActivity(intent);
//                    System.;
//                }
//            });
//        });
    }
}
