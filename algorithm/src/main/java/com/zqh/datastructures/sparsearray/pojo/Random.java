package com.zqh.datastructures.sparsearray.pojo;

import lombok.Data;

import java.util.Objects;

/**
 * @author zhuangqinghui
 * @version 1.0
 * @date 2020/12/19 13:30
 */
@Data
public class Random {
    int row;
    int col;

    public Random() {
    }

    public Random(int row, int col) {
        this.row = row;
        this.col = col;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Random random = (Random) o;
        return (random.getRow() + "-" + random.getCol()).equals(row + "-" + col);
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, col);
    }
}
