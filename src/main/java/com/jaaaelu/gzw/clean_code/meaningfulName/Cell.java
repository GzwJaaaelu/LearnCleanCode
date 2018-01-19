package com.jaaaelu.gzw.clean_code.meaningfulName;

import static com.jaaaelu.gzw.clean_code.meaningfulName.Mn2_2.FLAGGED;
import static com.jaaaelu.gzw.clean_code.meaningfulName.Mn2_2.STATUS_VALUE;

class Cell {

    private int[] cell = new int[5];

    boolean isFlagged() {
        return cell[STATUS_VALUE] == FLAGGED;
    }
}
