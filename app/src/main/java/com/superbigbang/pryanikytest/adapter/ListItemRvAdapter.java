package com.superbigbang.pryanikytest.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.MultipleItemRvAdapter;
import com.superbigbang.pryanikytest.adapter.provider.ListItemProvider;
import com.superbigbang.pryanikytest.model.Item;

import java.util.List;

public class ListItemRvAdapter extends MultipleItemRvAdapter<Item, BaseViewHolder> {

    public static final int TYPE_LIST = 100;

    public ListItemRvAdapter(@Nullable List<Item> data) {
        super(data);
    }


    @Override
    protected int getViewType(Item entity) {
        return TYPE_LIST;
    }

    @Override
    public void registerItemProvider() {
        mProviderDelegate.registerProvider(new ListItemProvider());
    }

}