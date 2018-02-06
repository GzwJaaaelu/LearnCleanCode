package com.jaaaelu.gzw.clean_code.Class;

public class C10_3 {
    //  10.3 为了修改而组织

    //  对于多数系统，修改将一直持续。每处修改都让我们冒着系统部分不能如期望般工作的风险。在整洁的系统中，我们对加以组织，
    //  以降低修改的风险

    //  例：
    //  作者在书中举了一个例子

    //  我们如果想为 Sql 添加一个 update 功能的话，我们就需要修改这个类
    public class Sql {

        public Sql(String table, Column[] columns) {}

        public String create() {
            return null;
        }

        public String insert(Object[] fields) {
            return null;
        }

        public String selectAll() {
            return null;
        }

        //  ...下面还有很多方法，但是没有 update
    }

    //  修改后
    //  作者认为上面的代码修改过程中存在一个以上的修改理由，所以改为下面这个版本更符合单一原则权责
    //  此时再增加 update 就无需做任何做任何修改。只需要在 Sql 类新增子类 UpdateSql，从而不会因为这个修改而破坏其他代码
    //  作者认为重构后的 Sql 逻辑百利而无一弊，它是支持单一原则职责，它也支持其他面向对象设计的关键原则，如开放-闭合原则：
    //  类应当对扩展开房，对修改封闭
    //  通过子类化手段，重新架构的 Sql 类对添加新功能是开放的，而且可以同时不触及其他类。只要就爱那个 Update 类放置到位就
    //  行了。在理想系统中，我们可以通过扩展系统二位修改现有代码来添加新特性（隔离修改）

    abstract class ModifySql {

        public ModifySql(String table, Column[] columns) {}

        abstract public String generate();

        public class CreateSql extends ModifySql {

            public CreateSql(String table, Column[] columns) {
                super(table, columns);
            }

            @Override
            public String generate() {
                return null;
            }
        }

        public class SelectSql extends ModifySql {

            public SelectSql(String table, Column[] columns) {
                super(table, columns);
            }

            @Override
            public String generate() {
                return null;
            }
        }

        public class InsertSql extends ModifySql {

            public InsertSql(String table, Column[] columns) {
                super(table, columns);
            }

            @Override
            public String generate() {
                return null;
            }
        }

        //  ...省略若干类与方法
    }

    class Column {}

    //  需求会改变，所以代码也会改变

    //  具体类包含实现细节（代码），而抽象类则只呈现概念。依赖于具体细节的客户端，当细节改变时，就会有风险。我们可以借助
    //  接口和抽象类隔离这些细节带来的影响（依赖抽象）

    //  部件之间的解耦代表着系统中的元素互相隔离的很好。隔离也让对系统每个元素的理解变得更加容易

    //  通过降低连接度，我们的类就遵循了另一条类设置原则，依赖倒置原则。本质而言，类应当依赖于抽象而不是依赖于具体细节

}
