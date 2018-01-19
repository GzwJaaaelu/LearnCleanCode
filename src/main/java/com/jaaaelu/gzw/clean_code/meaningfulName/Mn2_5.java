package com.jaaaelu.gzw.clean_code.meaningfulName;

import java.util.Date;

public class Mn2_5 {
    //  2.5 使用读得出来的名称

    class DtaRcrd102 {
        private Date genymdhms;
        private Date modymdhms;
        private final String paszqintt = "102";

        //  省略其他
    }

    //  or

    class Customer {
        //  明显是这样更清晰命名更好

        private Date generationTimestamp;
        private Date modificationTimetamp;
        private final String recordId = "102";

        //  省略其他
    }
}
