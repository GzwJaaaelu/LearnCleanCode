package com.jaaaelu.gzw.clean_code.fun;

public class F3_6 {
    //  3.6 函数参数

    //  作者认为：最理想的函数参数是零，其次是一，再次是而，应尽量避免三及以上
    //  如：includeSetupPage() 要比 includeSetupInto(newPageContent) 易于理解

    //  参数与函数名处在不同的抽象层级，它要求你了解目前并不特别重要的的细节

    //  输出参数比输入参数还要难以理解，读函数时，我们关于认为信息通过参数输入函数，通过返回值从函数中输出，我们不太期望
    //  信息通过通过参数输出

    //  3.6.1 一元函数的普遍形式

    //  作者认为，显函数传入单个参数有种极为普遍的理由
    //  1.询问关于那个参数的问题，如：boolean fileExists("xxx.txt")
    //  2.操作该参数，将其转换为其他什么东西并输出出来，如：InputStream fileOpen("xxx.txt")
    //  此外不那么普遍但极有用的单参数形式，就是事件（Event），这种情况下有入参无输出，如：void onClickListener(view)
    //  尽量避免编写不遵循这些形式的一元函数

    //  3.6.2 标识参数

    //  作者认为，标识参数丑陋不堪，向函数传入布尔值简直是骇人听闻的做法，这样做，方法签名立刻变得复杂起来，也就以为着
    //  true 将会这样做， false 则会那样做，最好还是将其一分为二

    //  3.6.3 二元函数

    //  作者认为，二元比一元难懂，例如，writeField(name) 比 writeFiled(outputStream, name) 好懂
    //  如果忽略掉第一个参数可能会更好懂一点，但是我么你不该忽略任何代码，忽略掉的部分就是缺陷藏身之地

    //  当然有些时候两个参数正好，如：Point point = new Point(0, 0)，如果这时你看到了 new Point(0) 可能会倍感惊讶
    //  new Point(0, 0) 本例中两个参数只是单个值的有序组成部分
    //  如 assertEquals(expected, actual) 这个函数的问题是参数顺序，谁在前谁在后只是一种需要学习的约定罢了

    //  我们应当尽量理由一些机制将二元函数转为一元函数

    //  3.6.4 三元函数

    //  作者依旧是认为三元比二元要难懂的多，如，排序、琢磨、忽略的问题都会加倍体现，所以建议你在写三元函数之前一定要想清楚

    //  3.6.5 参数对象

    //  如果函数看起来需要两个、三个甚至更多时，就说明其中一些参数应该封装为类了

    //  如：Circle makeCircle(double x, double y, double radius)
    //  修改后：Circle makeCircle(Point center, double radius)

    //  当一组参数被共同传递了，可以查看这些参数是否我某个概念的一部分，如果是的话我们将其提出创建对象

    //  3.6.6 参数列表

    //  可变参数是可取的，因为会被同样的对待，就像你传递一个 List 一样，如 String.format(...)

    //  当然我们可以使用可变参数，但是也还是需要我们遵守上面的参数个数规则

    //  3.6.7 动词与关键字

    //  给函数去个好名字，能较好地解释函数的意图，以及参数的顺序和意图

    //  对于一元函数，函数和参数应当形成一种非常良好的动词 / 名词对形式，如：write(name) 或 writeField(name)，后者还能告
    //  诉我们 name 是一个 field
    //  如：上面那个 assertEquals(expected, actual) 改为 assertExpectedEqualsActual(expected, actual) 会更好一些
}
