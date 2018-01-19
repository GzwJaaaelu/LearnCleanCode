package com.jaaaelu.gzw.clean_code.meaningfulName;

public class Mn2_6 {
    //  2.6 使用可搜索的名称

    //  找到 MAX_CLASSES_PER_STUDENT 很容易，但是想找到数字 7 就麻烦了
    //  单字母名称和数字常量都有这样的问题，很难在一大篇文字中找出来
    //  比如 e 这个字母就是是一个不便于搜索的好变量命名，因为它是英文中常用的字母，可能在每段程序、每段代码中出现

    public int test() {
        //  下面两段代码功能相同，但是可读性还是下面的更好一些

        int[] t = new int[34];
        int s = 0;
        for (int j = 0; j < 34; j++) {
            s += (t[j] * 4) / 5;
        }

        int realDaysPerIdealDay = 4;
        final int WORK_DAYS_PRE_WEEK = 5;
        int[] taskEstimatie = new int[34];
        final int NUMBER_OF_TASKS = taskEstimatie.length;
        int sum = 0;
        for (int j = 0; j < NUMBER_OF_TASKS; j++) {
            int realTaskDays = taskEstimatie[j] * realDaysPerIdealDay;
            int realTaskWeeks = realTaskDays / WORK_DAYS_PRE_WEEK;
            sum += realTaskWeeks;
        }
        return sum;
    }
}
