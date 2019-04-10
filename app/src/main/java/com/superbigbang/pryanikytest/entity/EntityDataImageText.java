package com.superbigbang.pryanikytest.entity;

public class EntityDataImageText extends ItemsForRecyclerView {
    public String dataText;
    public String imageUrl;

    public EntityDataImageText(int type, String name) {
        this.type = type;
        this.name = name;
    }

    public EntityDataImageText(String dataText, String imageUrl) {
        this.dataText = dataText;
        this.imageUrl = imageUrl;
    }
}
