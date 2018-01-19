package com.jaaaelu.gzw.clean_code.meaningfulName;

public class Mn2_16 {
    //  2.16 添加有意义的语境

    //  很少有名称是能自我说明的，反之，你需要有良好命名的类、函数或名称空间来放置名称，给读者提供语境

    //  假设你有名为 firstName、lastName、street、houseNumber、city、state 和 zipCode 的变量，当它们放在一起的时候，可以
    //  很明确的构成地址，不过你要是在某个地方孤零零的看到 state 你还能推断的出它是属于地址的一部分么

    //  这时候你选择选择添加前缀以此来提供一些语境，如 addrFirstName、addrLastName、addrState 等等
    //  当然，更好的方案是创建名为 Address 类来存放，这样，即使是编译器也会知道这些变量隶属于某个更大的概念了

    //  一个代码例子

    //  语境不明确的变量

    private static void printGuessStatistics(char candidate, int count) {
        String number;
        String verb;
        String pluralModifier;

        if (count == 0) {
            number = "no";
            verb = "are";
            pluralModifier = "s";
        } else if (count == 1) {
            number = "1";
            verb = "is";
            pluralModifier = "";
        } else {
            number = Integer.toString(count);
            verb = "are";
            pluralModifier = "s";
        }

        String guessMessage = String.format("There %s %s %s%s", verb, number, candidate, pluralModifier);
        System.out.println(guessMessage);
    }

    //  修改后，改为有语境的变量

    public class GuessStatisticsMeeage {
        String number;
        String verb;
        String pluralModifier;

        public String make(char candidate, int count) {
            createPluralDependentMessage(count);
            return String.format("There %s %s %s%s", verb, number, candidate, pluralModifier);
        }

        private void createPluralDependentMessage(int count) {
            if (count == 0) {
                thereAreNoLetters();
            } else if (count == 1) {
                thereIsOneLetter();
            } else {
                thereManyLetters(count);
            }
        }

        private void thereManyLetters(int count) {
            number = Integer.toString(count);
            verb = "are";
            pluralModifier = "s";
        }

        private void thereIsOneLetter() {
            number = "1";
            verb = "is";
            pluralModifier = "";
        }

        private void thereAreNoLetters() {
            number = "no";
            verb = "are";
            pluralModifier = "s";
        }
    }

    public static void main(String[] args) {
        printGuessStatistics('A', 2);
        printGuessStatistics('Z', 1);
    }

}
