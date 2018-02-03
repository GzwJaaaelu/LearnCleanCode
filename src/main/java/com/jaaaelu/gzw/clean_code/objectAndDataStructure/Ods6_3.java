package com.jaaaelu.gzw.clean_code.objectAndDataStructure;

public class Ods6_3 {
    //  6.3 德墨忒尔定律

    //  该定律认为，模块不应了解他所操作对象的内部情况
    //  如上节所见，对象隐藏数据，暴露操作

    //  德墨忒尔定律认为，类 C 的 f 方法只有应该调用以下对象的方法：
    //  1.C
    //  2.由 f 创建的对象
    //  3.作为参数传递给 f 的对象
    //  4.由 C 的实体变量持有的对象
    //  方法不应调用由任何函数返回的对象的方法。换言之，只跟朋友谈话，不与陌生人谈话

    //  例：违反了德墨忒尔定律因为它调用了返回对象的方法
    //  final String outputDir = ctx.getOptions().getScratchDir().getAbsolutePath();

    //  6.3.1 火车失事

    //  final String outputDir = ctx.getOptions().getScratchDir().getAbsolutePath();
    //  这类代码常被称为火车失事，因为它看起来像是一列火车。最好做类似如下的切分：
    //  Options op = ctx.getOptions();
    //  File scratchDir = op.getScratchDir();
    //  final String outputDir = scratchDir.getAbsolutePath();

    //  这些代码是否违反了德墨忒尔定律，取决于 ctx、op 和 scratchDir 是对象还是数据结构。如果是对象，则他们的内部结构应当
    //  隐藏而不暴露，而有关其内部细节的知识就明显违反了德墨忒尔定律

    //  6.3.2 混杂

    //  这种混杂有时会步行导致结构混乱，一半是对象，一本是数据结构

    //  6.3.3 隐藏结构

    //  ctx.getOptions().getScratchDir().getAbsolutePath();也可以改为以下形式：
    //  ctx.getAbsolutePathOfScratchDirOption(); 或 ctx.getScratchDirOption().getAbsolutePath();

    //  第一种方案可能导致 ctx 对象中方法的暴露。第二种方案是在假设 getScratchDirOption() 返回一个数据结构而不是对象。两种
    //  方案感觉都不好

    //  后续作者发现，上面的代码取得临时目录绝对路径的初衷是为了创建自定名称的临时文件，那么可以直接让 ctx 来做这件事：
    //  Buffer额度OutputStream bos = ctx.createScratchFileStream(classFileName);
    //  这下看起来就像是个对象做的事了！ctx 隐藏了其内部结构，防止当前函数因浏览它不该知道的对象而违反德墨忒尔定律
}
