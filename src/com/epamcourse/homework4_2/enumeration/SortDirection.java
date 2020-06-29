package com.epamcourse.homework4_2.enumeration;

public enum SortDirection {
    INCREASING(1),
    DECREASING(-1);

    private SortDirection(int flag) {
        this.flag = flag;
    }

    private int flag;

    public int getFlag() {
        return flag;
    }
}
