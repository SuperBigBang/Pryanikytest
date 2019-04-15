package com.superbigbang.pryanikytest.entity;

import lombok.Getter;
import lombok.Setter;

public abstract class ItemsForRecyclerView {
    public static final int ITEM_DATA_TEXT = 1;
    public static final int ITEM_DATA_IMAGE_TEXT = 2;
    public static final int ITEM_DATA_SELECTOR_LIST = 3;
    @Getter
    @Setter
    private int type;
    @Getter
    @Setter
    private String name;
}
