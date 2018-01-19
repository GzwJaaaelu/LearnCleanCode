package com.jaaaelu.gzw.clean_code.comments;

import static com.jaaaelu.gzw.clean_code.comments.C4_1__4_2.Employee.HOURLY_FLAG;

public class C4_1__4_2 {
    //  4.1 注释不能梅花糟糕的代码

    //  写注释的最常见动机之一是糟糕的代码的存在

    //  带有少量代码注释的整洁而有表达力的代码，要比带有大量注释的零碎而复杂的代码像样的多
    //  所以作者认为，与其花时间编写解释你搞出的找好的代码的注释，不如花时间清洁那堆糟糕的代码

    //  4.2 用代码来阐述

    //  有时，代码本身不足以解释其行为

    //  例：

    static class Employee {
        static boolean HOURLY_FLAG = true;
        boolean flag;
        int age;

        boolean isEligibleForFullBenefits() {
            return ((flag & HOURLY_FLAG) && (age > 65));
        }
    }

    public void example(Employee employee) {
        //  以下两种第二种可以不用通过注释就可以理解其意思，相比较第一种效果更好

        //  Check to see if the employee is eligible for full benefits
        if ((employee.flag & HOURLY_FLAG) && (employee.age > 65)) {
            System.out.println();
        }

        if (employee.isEligibleForFullBenefits()) {
            System.out.println();
        }
    }
}
