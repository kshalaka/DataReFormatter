package com.dfs.ace.domain;

import java.util.List;

public class MetaData {
    private List<Column> column;

    public MetaData(List<Column> column) {
        this.column = column;
    }

    public List<Column> getColumn() {
        return column;
    }

    public void setColumn(List<Column> column) {
        this.column = column;
    }

    public MetaData() {
    }
}
