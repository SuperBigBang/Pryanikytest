package com.superbigbang.pryanikytest.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.MultipleItemRvAdapter;
import com.superbigbang.pryanikytest.adapter.provider.ItemDataImageText;
import com.superbigbang.pryanikytest.adapter.provider.ItemDataSelectorList;
import com.superbigbang.pryanikytest.adapter.provider.ItemDataText;
import com.superbigbang.pryanikytest.entity.ItemsForRecyclerView;
import com.superbigbang.pryanikytest.model.Response;

import java.util.List;

public class ListItemRvAdapter extends MultipleItemRvAdapter<ItemsForRecyclerView, BaseViewHolder> {

    public static final int ITEM_DATA_TEXT = 1;
    public static final int ITEM_DATA_IMAGE_TEXT = 2;
    public static final int ITEM_DATA_SELECTOR_LIST = 3;

public ListItemRvAdapter(@Nullable List<ItemsForRecyclerView> data){
        super(data);
    finishInitialize();
        }

    @Override
    protected int getViewType(ItemsForRecyclerView entity) {
        if (entity.type == ItemsForRecyclerView.ITEM_DATA_TEXT) {
            return ITEM_DATA_TEXT;
        } else if (entity.type == ItemsForRecyclerView.ITEM_DATA_IMAGE_TEXT) {
            return ITEM_DATA_IMAGE_TEXT;
        } else if (entity.type == ItemsForRecyclerView.ITEM_DATA_SELECTOR_LIST) {
            return ITEM_DATA_SELECTOR_LIST;
        }
        return 0;
    }
/*
@Override
public void onItemChildClick(BaseQuickAdapter adapter, View view, int position){
        Toast.makeText(ExtendApplication.getBaseComponent().getContext(),"Click to child item: "+String.valueOf(view.getId())+" Pos: "+String.valueOf(position),Toast.LENGTH_SHORT).show();
        }

@Override
public void onItemClick(BaseQuickAdapter adapter,View view,int position){
    Toast.makeText(ExtendApplication.getBaseComponent().getContext(),"Click to item: "+String.valueOf(view.getId())+" Pos: "+String.valueOf(position),Toast.LENGTH_SHORT).show();
        }
*/
    @Override
    public void registerItemProvider() {
        mProviderDelegate.registerProvider(new ItemDataText());
        mProviderDelegate.registerProvider(new ItemDataImageText());
        mProviderDelegate.registerProvider(new ItemDataSelectorList());
    }
}