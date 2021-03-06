package com.superbigbang.pryanikytest.adapter;

import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.MultipleItemRvAdapter;
import com.superbigbang.pryanikytest.adapter.provider.ItemDataImageText;
import com.superbigbang.pryanikytest.adapter.provider.ItemDataSelectorList;
import com.superbigbang.pryanikytest.adapter.provider.ItemDataText;
import com.superbigbang.pryanikytest.entity.ItemsForRecyclerView;

import java.util.List;

public class ListItemRvAdapter extends MultipleItemRvAdapter<ItemsForRecyclerView, BaseViewHolder> {

    public static final int ITEM_DATA_TEXT = 1;
    public static final int ITEM_DATA_IMAGE_TEXT = 2;
    public static final int ITEM_DATA_SELECTOR_LIST = 3;

    public ListItemRvAdapter(List<ItemsForRecyclerView> data) {
        super(data);
        finishInitialize();
    }

    @Override
    protected int getViewType(ItemsForRecyclerView entity) {
        if (entity.getType() == ItemsForRecyclerView.ITEM_DATA_TEXT) {
            return ITEM_DATA_TEXT;
        } else if (entity.getType() == ItemsForRecyclerView.ITEM_DATA_IMAGE_TEXT) {
            return ITEM_DATA_IMAGE_TEXT;
        } else if (entity.getType() == ItemsForRecyclerView.ITEM_DATA_SELECTOR_LIST) {
            return ITEM_DATA_SELECTOR_LIST;
        }
        return 0;
    }

    @Override
    public void registerItemProvider() {
        mProviderDelegate.registerProvider(new ItemDataText());
        mProviderDelegate.registerProvider(new ItemDataImageText());
        mProviderDelegate.registerProvider(new ItemDataSelectorList());
    }
}