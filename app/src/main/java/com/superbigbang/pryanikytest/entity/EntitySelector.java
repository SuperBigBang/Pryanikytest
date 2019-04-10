package com.superbigbang.pryanikytest.entity;

import com.superbigbang.pryanikytest.model.Variants;

import java.util.List;

public class EntitySelector extends ItemsForRecyclerView {
    public int selectedId;
    public List<Variants> variants;

    public EntitySelector(int type, String name) {
        this.type = type;
        this.name = name;
    }

    public EntitySelector(int selectedId, List<Variants> variants) {
        this.selectedId = selectedId;
        this.variants = variants;
    }
}
