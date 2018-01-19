package com.jaaaelu.gzw.clean_code.meaningfulName;

public class Mn2_3 {
    //  2.3 避免误导

    //  避免使用专有名词，则可能会提供错误信息
    //  如：别用 accountList 来指定一组账号，除非它真的是 List 类型，因为 List 一词对程序员有特殊意义
    //  这是可以用 accountGroup 或 bunchOfAccounts，甚至直接用 accounts 都会好一些

    //  同时踢翻使用不同之处较小的名称
    //  如 XYZControllerForEfficientHandlingOfStrings 与 XYZControllerForEfficientStorageOfStrings

    //  使用 l（小写 L） 与 O（大写 o） 时区分 1（数字 1） 与 0（数字 0）
}
