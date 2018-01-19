package com.jaaaelu.gzw.clean_code.comments;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class C4_4 {
    //  4.4 坏注释

    //  通常，坏注释都是糟糕的代码的支撑或借口，或者对错误决策的修正，基本上等于成员自说自话

    //  4.4.1 喃喃自语

    //  如果只是因为你觉得应该或者因为过程需要就添加注释，那就是无畏之举。如果你觉得写注释，就要花必要的时间确保写出最好
    //  的注释

    //  例：

    class A {

        void load() {

        }
    }

    private A loadedProperties() {
        return new A();
    }

    public void loadProperties() {
        try {
            String propertiesPath = "xxx";
            FileInputStream propertiesStream = new FileInputStream(propertiesPath);
            loadedProperties().load();
        } catch (IOException e) {
            //  No properties files means all defaults are loaded
        }
    }

    //  作者认为这段代码中注释是坏注释呢？作者在看到代码时提出了一系列问题，书中原文（接下来的作者表示代码作者）：
    //  catch 代码块中的注释是什么意思呢？显然对于作者有其意义，不过并没有好到足够的程度。很明显，如果出现 IOException，
    //  就表示没有属性文件；在这种情况下，载入默认设置。但谁来装载默认设置呢？会在 loadedProperties().load(); 之前装载么？
    //  抑或 loadedProperties().load(); 捕获异常、装载默认设置、再向上传递异常？再或 loadedProperties().load(); 在尝试载
    //  入文件前句装载所有默认设置？要么作者只是在安慰自己别在意 catch 代码块里的留空？或者——这种可能最怕——作者实现告
    //  诉自己，将来再回头写默认设置的代码？

    //  4.4.2 多余的注释

    //  例：

    //  下面是一个非常简单的函数，该方法其头部未知的注释全数多余，读这段注释画的时间没准比读代码花的时间还要长


    private boolean closed = false;

    /**
     * Utility method that returns when this.closed is true.Throws an exception if the timeout is reached.
     *
     * @param timeoutMillis 超时时间
     * @throws Exception 异常
     */
    public synchronized void waitForClose(final long timeoutMillis) throws Exception {
        if (!closed) {
            wait(timeoutMillis);
            if (!closed) {
                throw new Exception("MockResponseSender could not be closed");
            }
        }
    }

    //  这段注释起了什么作用？它并不能比代码本身提供更多的信息。它没有证明代码的意义，也没有给出代码的意图和逻辑。

    //  4.4.3 误导性注释

    //  作者认为上面的这段代码其实注释就是在误导读者，如果 closed 为 true 那么方法并没有相应的返回值，也就没法完成想要的
    //  关闭操作。

    //  4.4.4 循规式注释

    //  所谓每个函数都要有 Javadoc 或每个变量都要有注释的规矩全然是愚蠢可笑的。反而可能会搞乱代码或误导读者

    //  4.4.5 日志式注释

    //  有人会在每次编辑代码时，在模块开始处添加一条注释。这类主食就像是一种记录每次修改的日志，但有了版本控制系统之后我
    //  们不需要这样做了

    //  4.4.6 废话注释

    //  例：

    /**
     * Default constructor
     */
    public C4_4() {
    }

    /**
     * The day of month
     */
    private int dayOfMonth;

    /**
     * Return the day of the month.
     *
     * @return the day of the month.
     */
    public int getDayOfMonth() {
        return dayOfMonth;
    }

    //  这类注释废话连篇，我们要学会了视而不见。但是当代码修改后，这类注释就变了谎言

    //  4.4.7 可怕的废话

    //  Javadoc 也可能是废话。

    //  例：

    /**
     * The name.
     */
    private String name;

    /**
     * The version.
     */
    private String version;

    /**
     * The version.
     */
    private String info;

    //  而且你注意到了没有，复制的过程汇总出了错误，忘记修改 info 上面的注释

    //  4.4.8 能用函数或变量时就别用注释

    //  例：

    class SModule {
        private ArrayList list = new ArrayList();

        public ArrayList getDependSubSystems() {
            return list;
        }
    }

    class SubSystem {

        public String getSubSystem() {
            return "";
        }
    }

    private void fun_4_4_8() {
        SModule sModule = new SModule();
        SubSystem subSystem = new SubSystem();

        //  片段一
        //  does the module from the global list <Mod> depend on the subsystem we are part of?
        if (sModule.getDependSubSystems().contains(subSystem.getSubSystem())) {
            System.out.println("xxx");
        }

        //  片段二
        ArrayList moduleDepends = sModule.getDependSubSystems();
        String ourSubSystem = subSystem.getSubSystem();
        if (moduleDepends.contains(ourSubSystem)) {
            System.out.println("xxx");
        }

        //  片段一不如使用片段二取而代之
    }

    //  4.4.9 位置标记

    //  比如这种：
    //  Action /////////////////////////////////////////////////////////////////////

    //  书中原话：这么说吧。如果标记不多，就会显而易见。所以，尽量少用这种标记，只有在特别有价值的时候用。如果滥用标记，
    //  就会沉没在背景噪声中，被忽略掉

    //  4.4.10 括号后面的注释

    //  有时，程序员会在括号后面放置特殊的注释，例：

    private void fun_4_4_10() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        int lineCount = 0;
        int charCount = 0;
        int wordCount = 0;
        try {
            while ((line = reader.readLine()) != null) {
                lineCount++;
                charCount += line.length();
                String[] words = line.split("\\w");
                wordCount += words.length;
            }   //  while
        }   //  try
        catch (Exception e) {
            e.printStackTrace();
        }   //  catch
    }

    //  4.4.11 归属与署名

    //  例：

    /* Added by Rick */

    //  作者认为版本控制器非常善用记住是谁在何时做添加了什么，所以也就没有必要写这些了。你也许会认为，这话总注释大概会有
    //  助于他人了解应该和谁讨论这段代码，不过，事实却是注释在那放了一年又一年，越来越不准确，越来越和原作者没关系

    //  4.4.12 注释掉的代码

    //  直接把代码注释掉是讨厌的做法！
    //  其他人不惯删除注释掉的代码。他们会想，代码依然放在那儿，一定尤其原因，这样会导致注释掉的代码堆积在一起
    //  尤其是在我们已经有了代码控制系统之后就更不需要这样做了，删掉即可，它们丢不了

    //  4.4.13 HTML 注释

    //  4.4.14 非本地信息

    //  假如你一i的那个要写注释，请确保它描述了离它最近的代码。别在本地注释的上下文环境中给出系统级的信息

    //  4.4.15 信息过多

    //  别再注释中添加有趣的历史性话题或者无关的细节描述

    //  4.4.16 不明显的联系

    //  注释及其描述的代码之间的联系应该显而易见。如果你不想麻烦写注释，至少让读者能看着注释和代码，并且理解注释所谈何物

    //   4.4.17 函数头

    //  短函数不需要太多描述。为只做一件事的短函数选一个好名字，通常比写函数头注释要好

    //  4.4.18 非公共代码的 Javadoc

    //  4.4.19 范例
}
