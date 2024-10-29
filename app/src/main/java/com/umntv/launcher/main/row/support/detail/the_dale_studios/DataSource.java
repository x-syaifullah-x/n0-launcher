package com.umntv.launcher.main.row.support.detail.the_dale_studios;

import com.umntv.launcher.main.base.ApkData;
import com.umntv.launcher.main.base.OverviewItem;

import net.n0ender.com.R;

import java.util.List;

public class DataSource {
    private static final OverviewItem PLAY = new OverviewItem(
            R.drawable.ic_ads_global_inc_card,
            R.drawable.ic_ads_global_inc_bg,
            "PLAY",
            "THE DALE STUDIOS",
            "",
            "The DALE fully meets the needs of creating professional images for individual and businesses:<br/>\t\t1.Book models to take pictures, record video reviews, promotional videos or attend events<br/>\t\t2.Multi-style photography and filming studio for rent<br/>\t\t3.Artistic photography, fashion photography, product photos,.<br/>thedalestudios.com | Phone: 0941051990",
            new ApkData(
                    "https://www.youtube.com/playlist?list=PLhB5qMsDNiM_hPegyJe2YPu91YqaSsJAI",
                    "",
                    false
            )
    );

    private static final OverviewItem OPEN_SITE = new OverviewItem(
            R.drawable.ic_ads_global_inc_card,
            R.drawable.ic_ads_global_inc_bg,
            "OPEN SITE",
            "THE DALE STUDIOS",
            "",
            "The DALE fully meets the needs of creating professional images for individual and businesses:<br/>\t\t1.Book models to take pictures, record video reviews, promotional videos or attend events<br/>\t\t2.Multi-style photography and filming studio for rent<br/>\t\t3.Artistic photography, fashion photography, product photos,.<br/>thedalestudios.com | Phone: 0941051990",
            new ApkData(
                    "https://thedalestudios.com",
                    "",
                    false
            )
    );

    public static final List<OverviewItem> items = List.of(
            PLAY,
            OPEN_SITE
    );
}
