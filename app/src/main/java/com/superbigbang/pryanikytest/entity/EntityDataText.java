package com.superbigbang.pryanikytest.entity;


import lombok.Getter;
import lombok.Setter;

public class EntityDataText extends ItemsForRecyclerView {
    @Getter
    @Setter
    private String dataText;

    public EntityDataText(int type, String name, String dataText) {
        this.setType(type);
        this.setName(name);
        this.dataText = dataText;
    }
}

