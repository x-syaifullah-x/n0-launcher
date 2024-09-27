package com.umntv.launcher.main.row.apps.app_drawer;

import com.umntv.launcher.base.Card;
import com.umntv.launcher.base.CardVisitor;

public class AppDrawerCard extends Card {

    private String dataDir;
    private boolean sysApp;

    public String getDataDir() {
        return this.dataDir;
    }

    public void setDataDir(String paramString) {
        this.dataDir = paramString;
    }

    public boolean isSysApp() {
        return sysApp;
    }

    public void setSysApp(boolean sysApp) {
        this.sysApp = sysApp;
    }

    @Override
    public void onClicked(CardVisitor visitor) {
        visitor.click(this);
    }
}
