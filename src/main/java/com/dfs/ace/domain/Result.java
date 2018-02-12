package com.dfs.ace.domain;

import java.util.List;

public class Result {

    private List<String> values;

    public List<String> getValues() {
        return values;
    }

    public void setValues(List<String> values) {
        this.values = values;
    }

    public Result(List<String> values) {
        this.values = values;
    }

    public Result() {
    }
}
