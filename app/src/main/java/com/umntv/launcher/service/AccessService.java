package com.umntv.launcher.service;

import android.accessibilityservice.AccessibilityService;
import android.content.Intent;
import android.os.Bundle;
import android.view.accessibility.AccessibilityEvent;

public class AccessService extends AccessibilityService {
    @Override
    public void onAccessibilityEvent(AccessibilityEvent accessibilityEvent) {

    }

    @Override
    public void onInterrupt() {

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (intent != null) {
            try {
                Bundle extras = intent.getExtras();
                if (extras != null) {
                    String reqEvent = extras.getString("REQ_event");
                    if (reqEvent.indexOf("access_event_back") == 0) {
                        performGlobalAction(GLOBAL_ACTION_BACK);
                    } else if (reqEvent.indexOf("access_event_home") == 0) {
                        performGlobalAction(GLOBAL_ACTION_HOME);
                    } else if (reqEvent.indexOf("access_event_quick_settings") == 0) {
                        performGlobalAction(GLOBAL_ACTION_QUICK_SETTINGS);
                    } else if (reqEvent.indexOf("access_event_recents") == 0) {
                        performGlobalAction(GLOBAL_ACTION_RECENTS);
                    } else if (reqEvent.indexOf("access_event_notifications") == 0) {
                        performGlobalAction(GLOBAL_ACTION_NOTIFICATIONS);
                    } else if (reqEvent.indexOf("access_event_power_dialog") == 0) {
                        performGlobalAction(GLOBAL_ACTION_POWER_DIALOG);
                    }
                    stopSelf();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return super.onStartCommand(intent, flags, startId);
    }
}
