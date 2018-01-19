package com.jaaaelu.gzw.clean_code.comments;

import java.util.regex.Pattern;

public abstract class C4_3 {
    //  4.3 好注释

    //  既然作者认为坏的注释会破坏代码的可读性，那么什么才是作者认为的好注释呢？
    //  唯一真的好的注释是你想办法不去写的注释

    //  4.3.1 法律信息

    //  可以指向一份标准许可或其他外部文档，而不要把所有条款放到注释中

    //  4.3.2 提供信息的注释

    //  例：

    private class Responder {
    }

    //  这个时候注释解释了某个抽象方法的返回值

    /**
     * Return an instance of the Responder being tested
     */
    protected abstract Responder responderInstance();

    //  当然如果给上面的抽象方法换一个方法名，这行注释也就是多余的了

    protected abstract Responder responderBeingTested();

    //  这个例子中，注释说明这个正则表达式在匹配一个什么样特定格式的字符串
    /**
     * format matched kk:mm:ss EEE, MMM dd, yyyy
     */
    Pattern timeMatcher = Pattern.compile("\\d*:\\d*:\\d \\w*, \\w* \\d*, \\d*");

    //  4.3.3 对意图的解释

    //  有时，注释不仅提供了有关实现的有用信息，而且还提供了某个决定后面的意图
    //  这时候你可能会不同意的对方的解决方案，但至少你知道对方在做什么

    //  4.3.4 阐释

    //  有时，注释把某些晦涩难明的参数或返回值的意义翻译为某种可读形式，也会是有用的

    //  例：

    public void exmple() {
        String a = "a";
        String b = "b";

        //  a == b
        System.out.println(a.compareTo(b) == 0);
        //  a != b
        System.out.println(a.compareTo(b) != 0);
        //  a > b
        System.out.println(a.compareTo(b) > 0);
        //  a < b
        System.out.println(a.compareTo(b) < 0);
    }

    //  不过这时候，如果你能把晦涩难懂的部分解决掉其实也就不需要做出阐释了，所以才写之前你可以在想想是否还有更好的办法

    //  4.3.5 警示

    //  有时，用于警告其他程序员会出现某种后果的注释也是有用的

    //  4.3.6 TODO注释

    //  有时，有理由用 //TODO 形式在源代码中放置要做的工作列表

    //  TODO 是一种程序员认为应该做，但由于某些原因目前还没做的工作

    //  但作者认为，它可能由于各种理由存在，但是无论 TODO 的目的如何，它都不是在系统中留下糟糕代码的借口

    //  4.3.7 放大

    //  注释可以用来放大某种看来不合理之物的重要性？？？（啥意思）

    //  4.3.8 公共 API 中的 Javadoc

    //  没有什么比被良好描述的公共 API 更有用和令人满意的了。标准 Java 库中的 Javadoc 就是一例
}
