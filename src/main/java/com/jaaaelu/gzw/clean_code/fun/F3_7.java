package com.jaaaelu.gzw.clean_code.fun;

public class F3_7 {
    //  3.7 无副作用

    //  例：
    //  checkPassword(String name, String password) 是作者举的反例
    //  而下面其他的类都是辅助，并未实现内部

    //  除了这个例子之外，作者也建议避免使用输出参数

    private class Cryptographer {

        String decrypt(String codePhrase, String password) {
            return null;
        }
    }

    private static class User {
        static final User NULL = null;
        private String phraseEncodedByPassword;

        String getPhraseEncodedByPassword() {
            return phraseEncodedByPassword;
        }
    }

    private static class UserGateWay {

        static User findByName(String name) {
            return null;
        }
    }

    private static class Session {

        static void initialize() {

        }
    }

    public class UserValidator {
        private Cryptographer cryptographer;

        //  这个是作者举的反例
        //  checkPassword 函数名顾名思义是用来检查密码的，但是里面却做了会话初始化的操作，这一点并未在函数名中暗示
        //  这时候 checkPassword 这个函数就只能在特定的时候时刻调用的（比如在初始化会话是安全的时候）
        //  这里应该将名称改为 checkPasswordAndInitializeSession(...) 但这还是违反了“只做一件的事的原则”

        public boolean checkPassword(String name, String password) {
            User user = UserGateWay.findByName(name);
            if (user != User.NULL) {
                String codePhrase = user.getPhraseEncodedByPassword();
                String phrase = cryptographer.decrypt(codePhrase, password);
                if ("Valid Password".equals(phrase)) {
                    //  副作用
                    Session.initialize();
                    return true;
                }
            }
            return false;
        }
    }
}
