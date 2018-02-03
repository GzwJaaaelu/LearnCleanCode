package com.jaaaelu.gzw.clean_code.objectAndDataStructure;

public class Ods6_2 {
    //  6.2 数据、对象的反对称性

    //  两段代码，例：

    //  过程式代码
    public class Square {
        public Ods6_0__6_1.Point topLeft;
        public double side;
    }

    public class Rectangle {
        public Ods6_0__6_1.Point topLeft;
        public double height;
        public double width;
    }

    public class Circle {
        public Ods6_0__6_1.Point center;
        public double radius;
    }

    public class Geometry {
        final double PI = 3.14;

        public double area(Object shape) throws Exception {
            if (shape instanceof Square) {
                return ((Square) shape).side * ((Square) shape).side;
            }
            if (shape instanceof Rectangle) {
                return ((Rectangle) shape).width * ((Rectangle) shape).height;
            }
            if (shape instanceof  Circle) {
                return PI * ((Circle) shape).radius * ((Circle) shape).radius;
            }
            throw new Exception("No such shape.");
        }
    }

    //  面向对象式代码
    public interface Shape {

        double area();
    }

    public class Square2 implements Shape {
        public Ods6_0__6_1.Point topLeft;
        double side;

        @Override
        public double area() {
            return side * side;
        }
    }

    public class Rectangle2 implements Shape {
        public Ods6_0__6_1.Point topLeft;
        double height;
        double width;

        @Override
        public double area() {
            return height * width;
        }
    }

    public class Circle2 implements Shape {
        final double PI = 3.14;
        public Ods6_0__6_1.Point center;
        double radius;

        @Override
        public double area() {
            return PI * radius * radius;
        }
    }

    public class Geometry2 {
        final double PI = 3.14;

        //  这时就可以改成这样了
        public double area(Shape shape) throws Exception {
            return shape.area();
        }
    }

    //  过程式代码（使用数据结构）便于在不改动既有数据结构的前提下添加新函数，面向对象代码比纳与在不改动既有函数的前提下
    //  添加新类
    //  反过来说：
    //  过程式代码难以添加新数据结构，因为必须要修改所有函数。面向对象代码难以添加新函数，因为必须修改所有类
}

