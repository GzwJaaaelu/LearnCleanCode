package com.jaaaelu.gzw.clean_code.meaningfulName;

import java.util.ArrayList;
import java.util.List;

public class Mn2_2 {
    //  2.2 名副其实

    /**
     * 流逝的时间，以日计
     */
    int d;
    /**
     * 更好命名
     */
    int daysSinceModification;
    int elapsedTimeInDays;

    private List<int[]> theList = new ArrayList<>();

    /**
     * 不易理解的方法
     * 疑问如下：
     * 1.theList 是什么类型的东西？
     * 2.theList 零下表条目的意义是什么？
     * 3.值 4 的意义是什么？
     * 4.我怎么使用返回的列表？
     *
     * @return 一个集合
     */
    public List<int[]> getThem() {
        List<int[]> list1 = new ArrayList<>();
        for (int[] x : theList) {
            if (x[0] == 4) {
                list1.add(x);
            }
        }
        return list1;
    }

    public static final int STATUS_VALUE = 0;
    public static final int FLAGGED = 4;
    private List<int[]> gameBoard = new ArrayList<>();
    private List<Cell> gameBoardForCell = new ArrayList<>();

    /**
     * 优化后的方法
     * <p>
     * 这是就变成一种扫雷游戏，盘面是 gameBoard，盘面上每个单元格都用一个简单的数组表示
     * 零下表条目是一种状态值，而状态值 4 表示“已标记”
     */
    public List<int[]> getFlaggedCells() {
        List<int[]> flaggedCells = new ArrayList<>();
        for (int[] cell : gameBoard) {
            if (cell[STATUS_VALUE] == FLAGGED) {
                flaggedCells.add(cell);
            }
        }
        return flaggedCells;
    }

    /**
     * 再继续简化优化后的方法
     * <p>
     * 不用 int 数组表示单元格，而是另写一个类
     * <p>
     * 这是就变成一种扫雷游戏，盘面是 gameBoard，盘面上每个单元格都用一个简单的数组表示
     * 零下表条目是一种状态值，而状态值 4 表示“已标记”
     */
    public List<Cell> getFlaggedCellsSimpleAgain() {
        List<Cell> flaggedCells = new ArrayList<>();
        for (Cell cell : gameBoardForCell) {
            if (cell.isFlagged()) {
                flaggedCells.add(cell);
            }
        }
        return flaggedCells;
    }
}
