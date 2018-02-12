package com.dfs.ace.domain;

public class Column {
    private String id;
    private String column_id;
    private String name;
    private String desc;
    private Boolean isAttribute;

    public Column(String id, String column_id, String name, String desc, Boolean isAttribute) {
        this.id = id;
        this.column_id = column_id;
        this.name = name;
        this.desc = desc;
        this.isAttribute = isAttribute;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getColumn_id() {
        return column_id;
    }

    public void setColumn_id(String column_id) {
        this.column_id = column_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Boolean getAttribute() {
        return isAttribute;
    }

    public void setAttribute(Boolean attribute) {
        isAttribute = attribute;
    }

    public Column() {
    }
}


