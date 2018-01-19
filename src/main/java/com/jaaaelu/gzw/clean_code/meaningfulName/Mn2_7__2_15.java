package com.jaaaelu.gzw.clean_code.meaningfulName;

public class Mn2_7__2_15 {
    //  2.7 避免使用编码

    //  不必要使用 m_ 前缀来标明成员变量，应当把类和函数做的足够小，消除对成员前缀的需要

    //  这样就已经够了

    private String descripiton;

    public void setDescripiton(String descripiton) {
        this.descripiton = descripiton;
    }

    //  在接口与实现时，作者更喜欢 ShapeFactory 命名接口而不是 IShapeFactory，作者认为 I 这个前缀字母被滥用或者趋近于废话，
    //  实现的时候，可能会选择 ShapeFactoryImp 或者其实更好的命名

    //  2.8 避免视为映射

    //  不应当让读者把你的名称翻译为他们熟知的名称，可能会出现在选择是用问题领域术语哈市解决方案领域术语时
    //  明确是王道，应该编写其他人能理解的代码。

    //  2.9 类名

    //  类名不应当是动词
    //  类名和对象名应该是名词或者名词短语，如 Customer、WikiPage、Account 和 AddressParser。
    //  避免使用 Manager、Processor、Data 和 Info 这样名字

    //  2.10 方法名

    //  方法名应当是动词或者动词短语
    //  如 postPayment、deletePage 或 save。属性访问器、修改器和断言应该依据 JavaBean 标准添加 get、set 和 is 前缀

    //  一些例子
    //  String name = employee.getName();
    //  customer.setName("Mike");
    //  if (paycheck.isPosted()) ...
    //  Complex fulcrumPoint = Complex.FromRealNumber(23.0);
    //  上面的通常会好于会好用（使用描述参数的敬爱工厂方法） Complex fulcrumPoint = new Complex(23.0)

    //  2.11 别扮可爱

    //  比如 HolyHandGrenade（圣手手雷） 与 DeleteItems（删除条目）显然后者更易理解，也就是宁可明确，毋为好玩
    //  所以也就最好不用使用术语或者俚语，如别用 whack() 来表示 kill()

    //  2.12 每个概念对应一个词

    //  给每个抽象的概念选一个词，并且一以贯之

    //  2.13 别用双关语

    //  避免将同一档次用于不同目的
    //  不要为了保持一致而命名
    //  如，很多类中都有 add 方法，当然只要这些 add 方法的参数列表与返回值在语义上等价，就一切顺利，但可能有人觉得“保持一致”
    //  而使用 add 这个词来命名，可能有些地方也就并非真的合适了，比如之前 add 方法用于增加或者连接俩个值从而获得新的值，
    //  那么另一个类想要把某个参数太能加到集合中这时候就不太合适使用 add 了，在合适地方使用合适词，可能你需要根据语境和
    //  和目的来选择不同的词汇（put/insert/append）

    //  2.14 使用解决方案领域名称

    //  作者提到只有程序员才会读你的代码，所以，尽管用那些计算机科学术语、算法名、模式名、数学术语吧

    //  2.15 使用源自所涉问题领域的名称

    //  如果不能使用程序员熟悉的术语来个手头的工作命名，就采用从所涉及问题领域而来的名称吧
    //  优秀的程序员和设计师，其工作之一就是分离解决方案领域和问题领域的问题

}
