package com.jaaaelu.gzw.clean_code.ObjectAndDataStructure;

public class Ods6_0__6_1 {
    //  6.0 对象与数据结构

    //  将变量设置为 private 有一个理由：我们不想其他人依赖这些变量。那么，为什么还是有那么多程序给对象自动添加 getter /
    //  setter，将私有变量公之于众，如同他们根本就是公共变量一般呢

    //  6.1 数据抽象

    //  例：

    //  具体的点
    public class Point {
        public double x;
        public double y;
    }

    //  抽象的点
    public interface PointAbstract {

        double x();

        double y();

        void setCartesian(double x, double y);

        double getR();

        double getTheta();

        void setPolar(double r, double theta);
    }

    //  作者认为 PointAbstract 漂亮之处在于，你不知道该实现是在举行坐标系中还是在极坐标系中，但也可能都不是。然而，该接口
    //  还是明白无误的呈现了一种数据结构
    //  不过它呈现的还不只是一个数据结构。那些方法固定了一套存取策略

    //  而 Point 则非常清除的实在矩形坐标系中实现，并要求我们单个操作那些坐标，这就暴露了实现

    //  隐藏实现并非只是在变量之间放上一个函数层那么简单。隐藏实现关乎抽象！类并不简单的用 getter / setter 将其变量推向外
    //  部，而是暴露抽象接口，以便用户无需了解数据的实现就能操作数据本体

    //  例：

    //  具体的车
    public interface Vehicle {

        //  获得油箱容量的加仑
        double getFuelTankCapacityInGallons();

        //  得到加仑汽油
        double getGallonsOfGasoline();
    }

    //  抽象的车
    public interface VehicleAbstract {

        //  得到燃料剩余百分比
        double getPercentFuelRemaining();
    }

    //  作者认为以上两段代码以后者为佳。我们不愿暴露数据细节，更愿意以抽象形态表述数据。这并不只是用 getter / setter 就万事
    //  大吉。要以更好的方式呈现某个对象包含的数据，需要做严肃的思考。傻乐着乱加  getter / setter，是最坏的选择
}
