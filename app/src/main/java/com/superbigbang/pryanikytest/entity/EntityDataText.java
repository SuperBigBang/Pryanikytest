package com.superbigbang.pryanikytest.entity;


public class EntityDataText extends ItemsForRecyclerView {
    public String dataText;

    public EntityDataText(int type) {
        this.type = type;
    }

    public EntityDataText(int type, String name, String dataText) {
        this.type = type;
        this.name = name;
        this.dataText = dataText;
    }
}

