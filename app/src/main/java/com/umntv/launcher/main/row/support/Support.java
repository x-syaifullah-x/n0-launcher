package com.umntv.launcher.main.row.support;

import com.umntv.launcher.util.ResourceHelpers;

import java.util.ArrayList;
import java.util.List;

import net.n0ender.com.R;

public final class Support {

    public static final String TITLE_LEEWAY_ENDEAVORS = "LEEWAY ENDEAVORS";
    public static final String VENDORS_SUPPORT = "VENDORS SUPPORT";
    public static final String GLOBAL_GIRLS_NET = "GLOBAL GIRLS NET";

    public static final String PLATINUM_STAFFING = "PLATINUM STAFFING";

    public static final String THE_DALE_STUDIOS = "THE DALE STUDIOS";


    private static final List<SupportCard> list = new ArrayList<>();

    public static List<SupportCard> setupAds() {
        if (list.isEmpty()) {
            String[] title = {
                    VENDORS_SUPPORT,
                    GLOBAL_GIRLS_NET,
                    PLATINUM_STAFFING,
                    THE_DALE_STUDIOS,
                    TITLE_LEEWAY_ENDEAVORS
            };
//            String[] description = {
////                    "Find info about your local vendor",
////                    "Grow your business by placing your ads on our platform for as little as $5 a month.\nUsers will have a direct link to your information or content.\nContact us support@umntv.com",
////                    "Create your own brands from your ideas, or assemble your brands from already created products.\nMobile phone application. Electronic device, software development, global Marketing\nconsulting and tools. Global girls inc is for businesses that`s ready to create their brands\nand or launch their products and services globally.\nglobalgirlsinc.net",
////                    "Platinum Staffing, Inc. is a full service, staffing agency that has trained and certified recruiters\nthat are specialists in their respective fields. We staff manufacturing machining. IT, medical,\nexecutive level, engineering, administration and more.\n\nPhone: 1(763) 560-8430 中国人 EXT. 300'",
////                    "The DALE fully meets the needs of creating professional images for individual and businesses:\n\t\t1.Book models to take pictures, record video reviews, promotional videos or attend events\n\t\t2.Multi-style photography and filming studio for rent\n\t\t3.Artistic photography, fashion photography, product photos,.\nthedalestudios.com | Phone: 0941051990",
////                    ""
//            };
            String[] cardImageUrl = {
                    ResourceHelpers.toStringUri(R.drawable.ic_ads_your_add_here),
                    ResourceHelpers.toStringUri(R.drawable.ic_ads_global_inc_card),
                    ResourceHelpers.toStringUri(R.drawable.ic_ads_plat_img),
                    ResourceHelpers.toStringUri(R.drawable.ic_ads_dale_studios),
                    ResourceHelpers.toStringUri(R.drawable.ic_ads_leeway_endeavors)
            };
            String[] detailImageUrl = {
                    ResourceHelpers.toStringUri(R.drawable.ic_ads_your_add_here_new),
                    ResourceHelpers.toStringUri(R.drawable.ic_ads_global_inc_bg),
                    ResourceHelpers.toStringUri(R.drawable.ic_ads_platinum),
                    ResourceHelpers.toStringUri(R.drawable.ic_ads_dale_studios),
                    ResourceHelpers.toStringUri(R.drawable.ic_ads_leeway_endeavors),
            };

            for (int index = 0; index < title.length; ++index) {
                SupportCard ads = new SupportCard();
                ads.setTitle(title[index]);
                ads.setIconStringUri(cardImageUrl[index]);
                ads.setBackgroundStringUri(detailImageUrl[index]);
                list.add(ads);
            }
        }
        return list;
    }
}
