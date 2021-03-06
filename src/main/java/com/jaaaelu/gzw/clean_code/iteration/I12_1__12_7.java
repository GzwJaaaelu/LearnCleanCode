package com.jaaaelu.gzw.clean_code.iteration;

public class I12_1__12_7 {
    //  12.1 通过迭进设计达到简洁目的

    //  关于简单设计的四条规则：
    //  - 运行所有测试
    //  - 不可重复
    //  - 表达了程序员的意图
    //  - 尽可能减少类和方法的数量
    //  以上规则按其重要程度排列

    //  12.2 简单设计规则 1：运行所有测试

    //  设计必须制造出如预期一般工作的系统，这是首要音素
    //  全面测试并可持续通过所有测试的系统，就是可测试系统。不可测试系统同样不可验证。不可验证的系统，绝不应部署

    //  只要系统可测试，就会导向保持类短小且目的单一的设计方案。所以，确保系统安全可测试能帮助我们创建更好的设计

    //  紧耦合的代码难以编写测试。使用依赖注入、接口和抽象等工具可以帮助我们减少耦合

    //  12.3 简单设计规则 2 - 4：重构

    //  测试消除了对清理代码就会破坏代码的恐惧，随时修改随时运行

    //  提升内聚性，降低耦合度，切分关注面，模块化系统性关注面，缩短函数和类的尺寸，选用更好的名称，如此等等。这也是应用
    //  简单设计后三条规则的地方

    //  12.4 不可重复

    //  重复是拥有良好设计系统的大敌。它代表着额外的工作、额外的风险和额外的不必要的复杂度。重复有很多种。及其雷同的代码
    //  行当是重复。类似的代码往往可以调整得更相似，这样就能更容易的进行重构。重复也有实现上的重复等其他一些形态

    //  例如，在某个群集类中可能会有两个方法：int size() 和 boolean isEmpty() 这两个方法可以分别实现
    //  但也可以通过在 isEmpty 中使用 size 来消除重复

    int size() { return 0; }

    boolean isEmpty() { return  0 == size(); }

    //  当然作者书中还有一个例子，抽出共性，但是意识到违反了单一责权原则后进行了方法提取，将提取后的新方法分到另外的类中，
    //  从而提高其可见性

    //  模板方法模式是一种一处高层及中出的通用技巧

    //  12.5 表达力

    //  写出自己理解的代码很容易，因为在写这些代码时，我们正深入于要解决的问题。代码的其他维护者不会那么深入，也就不易理
    //  解代码

    //  软件项目的主要成本在于长期维护。当系统变得越来越复杂，开发者就需要越来越多的时间来理解它，而且也极有可能误解
    //  作者把代码写得越清晰，其他人花在理解代码上的时间也就越少，从而减少缺陷，缩短维护成本

    //  可以通过选用好的名称来表达
    //  也可以通过保持函数和类尺寸短小来表达
    //  还可以采用标准命名法来表达
    //  编写良好的单元测试也具有表达性

    //  不过，做到有表达力的重要方式确实尝试

    //  12.6 尽可能少的类和方法

    //  为了保持类和函数短小，我们可能会造出太多的细小类和方法。所以这条规则也和主张函数和类的数量要少

    //  我们的目标是在保持函数和类短小的同时，保持整个系统短小精悍。不过这是四条里面优先级最低的一条

    //  12.7 小结
}
