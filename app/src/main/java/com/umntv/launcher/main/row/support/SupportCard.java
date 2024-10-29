package com.umntv.launcher.main.row.support;

import com.umntv.launcher.base.Card;
import com.umntv.launcher.base.CardVisitor;

public class SupportCard extends Card {
    @Override
    public void onClicked(CardVisitor visitor) {
        visitor.click(this);
    }
}
