package com.jaaaelu.gzw.clean_code.system;

public class S11_1__11_2 {
    //  11.1 如何建造一个城市

    //  作者举了城市的例子，即便是管理一个既存的城市，也是一个人无法做到的。不过城市还是在运转。因为每个城市都是一组组人
    //  管理不同的部分，供水系统、供电系统、交通、执法，诸如此类。有些人负责全局，其他人负责细节

    //  城市能运转，还因为它演化出恰当的抽象等级和模块，好让个人和他们所管理的“组件”即便在不了解全局时也能有效的运转

    //  整洁的代码帮助我们在较低层的抽象层级上达成这个目标

    //  本章将讨论如何在较高抽象层级——系统层级——上保持整洁

    //  11.2 将系统的构造与使用分开

    //  首先，构造和使用是非常不一样的过程。

    //  软件系统应将启始过程与启始过程之后的运行时逻辑分离开，在启始过程中构建应用对象，也会存在相互缠结的依赖过程
    //  每个应用程序都该留意启始过程。将关注的方面分离开，是软件技艺中最古老也最重要的设计技巧

    //  不幸的是，多数应用程序都没有做分离处理

    //  例：

    private Service service;

    public Service getService() {
        if (service == null) {
            service = new MyServiceImpl();
        }
        return service;
    }

    interface Service{}

    private class MyServiceImpl implements Service {}

    //  这就是所谓的延迟初始化/赋值，也有一些好处。在真正用到对象之前，无需操心这种架空构造，启动时间也会更短，而且还能保
    //  证运行不会返回 null 值

    //  作者认为如果 MyServiceImpl 如果是个重型对象，则测试也会是个问题，由于构造逻辑与运行过程相混杂，我们必须测试所有的
    //  执行路径。有了这些责权，说明方法做了不止一件事，这样就略微违反了单一权责原则

    //  如果我们勤于打造有良好格式并且强固的系统，就不该让这类就手（就手是指随手、顺便的意思）小技巧破坏模块组织性。对象
    //  构造的启始和设置过程也不例外。应当将这个过程从正常的运行时逻辑中分离出来，确保拥有解决主要依赖问题的全局性一贯策略

    //  11.2.1 分解 main

    //  将构造与使用分开的方法之一是将全部构造过程搬迁到 main 或者被称为 main 的模块中，设计系统的其余部分时，假设所有对
    //  象都以正确构造和设置

    //  11.2.2 工厂

    //  使用抽象工厂模式让应用程序自行控制何时创建对象

    //  11.2.3 依赖注入

    //  有一种强大的机制可以实现分离构造与使用，那就是依赖注入，控制反转（IoC）在依赖管理中的一种应用手段。控制反转将第二
    //  权责从对象中拿出来，转移到另一个专注于此的对象中，从而遵循了单一权责原则

    //
}
