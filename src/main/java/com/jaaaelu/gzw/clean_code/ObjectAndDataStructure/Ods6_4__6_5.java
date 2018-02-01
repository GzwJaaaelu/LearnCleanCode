package com.jaaaelu.gzw.clean_code.ObjectAndDataStructure;

public class Ods6_4__6_5 {
    //  6.4 数据传送对象

    //  最为精炼的数据结构，是一个只有公共变量、没有函数的类。这种数据结构有时被称为数据传送对象，或 DTO

    //  "Bean" 结构也是非常常见的，如：

    public class Address {
        private String street;
        private String streetExtra;
        private String city;
        private String state;
        private String zip;

        public Address(String street, String streetExtra, String city, String state, String zip) {
            this.street = street;
            this.streetExtra = streetExtra;
            this.city = city;
            this.state = state;
            this.zip = zip;
        }

        public String getStreet() {
            return street;
        }

        public String getStreetExtra() {
            return streetExtra;
        }

        public String getCity() {
            return city;
        }

        public String getState() {
            return state;
        }

        public String getZip() {
            return zip;
        }
    }

    //  Active Record 是一种特殊的 DTO 形式。它们拥有公共变量（或可豆式访问的）的数据结构，但通常也有拥有类似 save 和 find
    //  这样的可浏览方法。Active Record 一般是对和数据库表或其他数据源的直接翻译
    //  但不幸的是开发者往往往这类数据结构中塞进业务规则方法，把这类数据结构当成对象来用。这是不智的行为，因为它导致了数
    //  据结构和对象的混合体

    //  6.5 小结

    //  对象暴露行为，隐藏数据。便于添加新对象类型而无需修改既有行为，同时也难以在既有对象中添加新行为。数据结构暴露数据，
    //  没有明显的行为，便于向既有数据结构添加新行为，同时也难以向既有函数添加新数据结构
}
