package com.superbigbang.pryanikytest.entity;

import com.superbigbang.pryanikytest.model.Variants;

import java.util.List;

public class EntitySelector extends ItemsForRecyclerView {
    public int selectedId;
    public List<Variants> variants;

    public EntitySelector(int type) {
        this.type = type;
    }

    public EntitySelector(int type, String name, int selectedId, List<Variants> variants) {
        this.type = type;
        this.name = name;
        this.selectedId = selectedId;
        this.variants = variants;
    }
}
