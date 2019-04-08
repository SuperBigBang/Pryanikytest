package com.superbigbang.pryanikytest.entity;

public class EntityDataImageText extends ItemsForRecyclerView {
    public String dataText;
    public String imageUrl;

    public EntityDataImageText(int type) {
        this.type = type;
    }

    public EntityDataImageText(int type, String name, String dataText, String imageUrl) {
        this.type = type;
        this.name = name;
        this.dataText = dataText;
        this.imageUrl = imageUrl;
    }
}
