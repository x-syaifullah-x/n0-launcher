package com.umntv.launcher.main.row.kids.details.e_lerning;

import com.umntv.launcher.main.base.ApkData;
import com.umntv.launcher.main.base.OverviewItem;

import java.util.List;

import net.n0ender.com.R;

public class DataSource {

    private static final OverviewItem PRESCHOOL = new OverviewItem(
            R.drawable.kids_ic_e_learning,
            R.drawable.kids_ic_e_learning_bg,
            "PRESCHOOL",
            "WELCOME TO E-LEARNING PRESCHOOL",
            OverviewItem.SUBTITLE_DEFAULT,
            "Teach or learn with your child/children! E-learning videos, classes, and lessons are available on YouTube.<br/><br/><b>Learning with Ms. Houston<b>",
            new ApkData(
                    "https://www.youtube.com/embed/U9e3rX-kQSY?list=PL9fYuDY46BTNyT6uKGKAMwWqFQP-XMoWk",
                    null,
                    false
            )
    );

    private static final OverviewItem SIGHT_WORDS = new OverviewItem(
            R.drawable.kids_ic_e_learning,
            R.drawable.kids_ic_e_learning_bg,
            "SIGHT WORDS",
            "WELCOME TO E-LEARNING SIGHT WORDS",
            OverviewItem.SUBTITLE_DEFAULT,
            "Teach or learn with your child/children! E-learning videos, classes, and lessons are available on YouTube<br/><br/>.<b>Learning Time Fun",
            new ApkData(
                    "https://www.youtube.com/embed/xBzH7gAztaI?list=PL8CyQ6qMY4V6E_0EeHg8qtYqlEMEoA1WO",
                    null,
                    false
            )
    );

    private static final OverviewItem MATHEMATICS = new OverviewItem(
            R.drawable.kids_ic_e_learning,
            R.drawable.kids_ic_e_learning_bg,
            "MATHEMATICS",
            "WELCOME TO E-LEARNING MATHEMATICS",
            OverviewItem.SUBTITLE_DEFAULT,
            "Teach or learn with your child/children! E-learning videos, classes, and lessons are available on YouTube.<br/><br/>.<b>Professor Dave Explains",
            new ApkData(
                    "https://www.youtube.com/embed/JbhBdOfMEPs?list=PLybg94GvOJ9FoGQeUMFZ4SWZsr30jlUYK",
                    null,
                    false
            )
    );

    private static final OverviewItem CODING = new OverviewItem(
            R.drawable.kids_ic_e_learning,
            R.drawable.kids_ic_e_learning_bg,
            "CODING",
            "WELCOME TO E-LEARNING CODING",
            OverviewItem.SUBTITLE_DEFAULT,
            "Teach or learn with your child/children! E-learning videos, classes, and lessons are available on YouTube.<br/>Kids for Code.<br/>kids4code.org.<br/><b>Online coding classes, 100% free.",
            new ApkData(
                    "https://www.youtube.com/embed/kxSU9jP85H8?list=PL_S_MAIn05n66k5lCb3joz_fcQehF1pIe",
                    null,
                    false
            )
    );

    private static final OverviewItem GRAMMAR = new OverviewItem(
            R.drawable.kids_ic_e_learning,
            R.drawable.kids_ic_e_learning_bg,
            "GRAMMAR",
            "WELCOME TO E-LEARNING GRAMMAR",
            OverviewItem.SUBTITLE_DEFAULT,
            "Teach or learn with your child/children! E-learning videos, classes, and lessons are available on YouTube<br/><br/><b>LucyMax English",
            new ApkData(
                    "https://www.youtube.com/embed/Bwf1vJGdHxg?list=PL0HMo9RIVkoxyScPHjfleUL7q8Z3hOxqn",
                    null,
                    false
            )
    );

    private static final OverviewItem ENGLISH = new OverviewItem(
            R.drawable.kids_ic_e_learning,
            R.drawable.kids_ic_e_learning_bg,
            "ENGLISH",
            "WELCOME TO E-LEARNING ENGLISH",
            OverviewItem.SUBTITLE_DEFAULT,
            "Teach or learn with your child/children! E-learning videos, classes, and lessons are available on YouTube.<br><br/><b>Daily English Conversation",
            new ApkData(
                    "https://www.youtube.com/embed/nfcIc_PhLoo?list=PLTyvAtj9OYb00pBe-pnqIB18qXchcvLii",
                    null,
                    false
            )
    );

    private static final OverviewItem MANDARIN = new OverviewItem(
            R.drawable.kids_ic_e_learning,
            R.drawable.kids_ic_e_learning_bg,
            "MANDARIN",
            "WELCOME TO E-LEARNING MANDARIN",
            OverviewItem.SUBTITLE_DEFAULT,
            "Teach or learn with your child/children! E-learning videos, classes, and lessons are available on YouTube.<br/><br/><b>ChineseFor.Us - Learn Mandarin Chinese Online<br/>chinesefor.us/AllCourses",
            new ApkData(
                    "https://www.youtube.com/embed/McZW0iDsZns?list=PLWXyZU_NJb_chvMZ13hgOPB3Vcz7xhW3q",
                    null,
                    false
            )
    );

    public static final List<OverviewItem> items = List.of(
            PRESCHOOL,
            SIGHT_WORDS,
            MATHEMATICS,
            CODING,
            GRAMMAR,
            ENGLISH,
            MANDARIN
    );
}
