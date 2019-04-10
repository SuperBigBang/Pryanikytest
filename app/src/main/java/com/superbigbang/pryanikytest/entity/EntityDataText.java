package com.superbigbang.pryanikytest.entity;


public class EntityDataText extends ItemsForRecyclerView {
    public String dataText;

    public EntityDataText(int type, String name) {
        this.type = type;
        this.name = name;
    }

    public EntityDataText(String dataText) {
        this.dataText = dataText;
    }
}

