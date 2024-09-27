package com.umntv.launcher.main.row.apps;

import com.umntv.launcher.base.CardApp;
import com.umntv.launcher.base.CardVisitor;

public class AppsCard extends CardApp {

    private String classNameActivityDetail;

    public String getClassNameActivityDetail() {
        return classNameActivityDetail;
    }

    public void setClassNameActivityDetail(String classNameActivityDetail) {
        this.classNameActivityDetail = classNameActivityDetail;
    }

    @Override
    public void onClicked(CardVisitor visitor) {
        visitor.click(this);
    }
}
