package com.superbigbang.pryanikytest.entity;

import com.superbigbang.pryanikytest.model.Variants;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EntitySelector extends ItemsForRecyclerView {
    private int selectedId;
    private List<Variants> variants;

    public EntitySelector(int type, String name, int selectedId, List<Variants> variants) {
        this.setType(type);
        this.setName(name);
        this.selectedId = selectedId;
        this.variants = variants;
    }
}
