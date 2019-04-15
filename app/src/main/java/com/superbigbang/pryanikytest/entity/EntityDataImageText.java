package com.superbigbang.pryanikytest.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EntityDataImageText extends ItemsForRecyclerView {
    private String dataText;
    private String imageUrl;

    public EntityDataImageText(int type, String name, String dataText, String imageUrl) {
        this.setType(type);
        this.setName(name);
        this.dataText = dataText;
        this.imageUrl = imageUrl;
    }
}
