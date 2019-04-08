
package com.superbigbang.pryanikytest.entity;

public class EntitySelector extends ItemsForRecyclerView {
    public int selectedId;
   public String[] variants;

    public EntitySelector(int type) {
        this.type = type;
    }

    public EntitySelector(int type, String name, int selectedId, String[] variants) {
        this.type = type;
        this.name = name;
        this.selectedId = selectedId;
        this.variants=variants;
    }
}
