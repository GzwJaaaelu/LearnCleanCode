package com.jaaaelu.gzw.clean_code.meaningfulName;

public class Mn2_4 {
    //  2.4 做有意义的区分

    //  如果程序员只是为满足编译器或者解释器的需要而写代码，就会制造麻烦
    //  如：作用范围内不同的东西不能重名，你可能会随手改掉其中一个的名称，或者有时干脆以错误的拼写充数

    public static void copyChars(char[] a1, char[] a2) {
        for (int i = 0; i < a1.length; i++) {
            //  这样的名称纯属误导，完全没有提供正确信息
            a2[i] = a1[i];
        }
    }

    //  废话是另一种没有意义的区分，加入你有一个 Product 类。如果还有一个 ProductInfo 或 ProductData 类，那他们的名称虽
    //  然不同，意义却无区分。Info 和 Data 就像 a、an 和 the 一样是意义含混的废话

    //  当然如果你能体现出有意义的区分，使用 a 和 the 这样的前缀就没错

    //  废话就是荣誉。Variable 一词不应当出现在变量名中，Table 一词不应该出现在表名中，NameString 会比 Name 好么？
    //  难道 Name 还会是一个浮点数不成？如果这样，就触犯了关于误导的规则，摄像有一个名为 Customer 的类，还有一个名为
    //  CustomerObject 的类，区分在哪里呢？

    //  getActiveAccount(); getActiveAccounts(); getActiveAccountInfo(); 程序员怎么知道该调用哪个函数呢？

    //  如果缺少明确约定，变量 moneyAmount 和 money 没区别，customerInfo 与 customer 没区别，accountData 与 account
    //  没区别，theMessage 与 message 没区别。要区分名称，就要以读者能鉴别不同之处的方式来区分
}
