package com.jaaaelu.gzw.clean_code.fun;

public class F3_8__3_9 {
    //  3.8 分隔指令与询问

    //  函数要么做什么事，要么回答什么事，二者不可兼得

    //  例：作者认为这个函数就不是一个好的函数，一方面在设置，一方面在回答

    public boolean set(String attribute, String value) {
        //  TODO
        return false;
    }

    //  当我们在调用 if (set("userName", "Bob")) ... 的时候会产生歧义，到底是如果 userName 属性值之前已被设置为 Bob，
    //  还是设置 userName 属性值为 Bob，看看是可行呢？

    //  3.9 使用异常替代返回错误码

    //  作者认为使用指令式函数返回错误码轻微违反了指令与询问与分割的规则，而且还可能导致更深层次的嵌套解构

    //  例：
    //  上面全部铺垫 authSample 才是重点

    private static final int E_OK = 1;
    private static final int E_ERROR = -1;

    class Page {
        Name name;
    }

    private class Name {

        String makeKey() {
            return "";
        }
    }

    private class Registry {

        private int deleteReference(Page page) {
            return E_OK;
        }

        private void deleteReferenceModified(Page page) throws Exception {
        }
    }

    private class ConfigKeys {

        private int deleteKey(String key) {
            return E_OK;
        }

        private void deleteKeyModified(String key) throws Exception {
        }
    }

    class Logger {

        void log(String msg) {
            System.out.println(msg);
        }
    }

    private int deletePage() {
        return E_OK;
    }

    private void deletePageModified() throws Exception {
    }

    private Registry registry = new Registry();
    private ConfigKeys configKeys = new ConfigKeys();
    private Logger logger = new Logger();

    public int authSample(Page page) {
        //  这里如果替换层异常的形式会比这种错误码的形式会更好
        if (deletePage() == E_OK) {
            if (registry.deleteReference(page) == E_OK) {
                if (configKeys.deleteKey(page.name.makeKey()) == E_OK) {
                    logger.log("deleted");
                } else {
                    logger.log("configKeys not deleted");
                }
            } else {
                logger.log("deleteReference from registry failed");
            }
        } else {
            logger.log("delete failed");
            return E_ERROR;
        }
        return E_OK;
    }

    //  修改简化后

    public void authSampleSimplfy(Page page) {
        try {
            deletePageModified();
            registry.deleteReferenceModified(page);
            configKeys.deleteKeyModified(page.name.makeKey());
        } catch (Exception e) {
            logger.log(e.getMessage());
        }
    }

    //  3.9.1 抽离 Try/Catch 代码块

    //  最好把 try 和 catch 代码块的主体部分分离出来形成函数
    //  这时 delete 函数只与错误处理有关，deletePageAndAllReferences 只与完全删除一个 page 有关
    //  这样代码也更易于理解和修改了

    public void delete(Page page) {
        try {
            deletePageAndAllReferences(page);
        } catch (Exception e) {
            logError(e);
        }
    }

    private void deletePageAndAllReferences(Page page) throws Exception {
        deletePageModified();
        registry.deleteReferenceModified(page);
        configKeys.deleteKeyModified(page.name.makeKey());
    }

    private void logError(Exception e) {
        logger.log(e.getMessage());
    }

    //  3.9.2 错误处理就是一件事

    //  当我们说函数只做一件的时候，错误处理就是一件事
    //  因此，处理错误的函数不该做其他事

    //  3.9.3 Error.java 依赖磁铁

    // 返回错误码通过暗示某处有个类或者枚举，定义了所有错误码

    //  这样的类就是一块依赖磁铁，其他类都会使用和导入它

    //  使用异常替代错误码，新异常可以从异常类派生出来

    public enum Error {
        OK,
        INVALID,
        NO_SUCH,
        LOCKED,
        OUT_OF_RESOURCES,
        WAITING_FOR_EVENT;
    }
}
