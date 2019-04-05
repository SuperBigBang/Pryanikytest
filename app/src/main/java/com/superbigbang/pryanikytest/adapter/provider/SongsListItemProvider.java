package com.superbigbang.pryanikytest.adapter.provider;

import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.superbigbang.pryanikytest.R;
import com.superbigbang.pryanikytest.model.Item;

public class SongsListItemProvider extends BaseItemProvider<Item, BaseViewHolder> {

    @Override
    public int viewType() {
        return 100;
    }

    @Override
    public int layout() {
        return R.layout.item_list;
    }

    @Override
    public void convert(BaseViewHolder helper, Item data, int position) {
       /* helper.setText(R.id., data.getText));
        helper.addOnClickListener(R.id.)*/
    }
}
