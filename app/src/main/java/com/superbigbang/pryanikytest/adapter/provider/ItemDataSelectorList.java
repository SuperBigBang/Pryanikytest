package com.superbigbang.pryanikytest.adapter.provider;

import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.superbigbang.pryanikytest.R;
import com.superbigbang.pryanikytest.adapter.ListItemRvAdapter;
import com.superbigbang.pryanikytest.entity.ItemsForRecyclerView;

/**
 * https://github.com/chaychan
 *
 * @author ChayChan
 * @description: Text ItemProvider
 * @date 2018/3/30  11:39
 */

public class ItemDataSelectorList extends BaseItemProvider<ItemsForRecyclerView, BaseViewHolder> {

    @Override
    public int viewType() {
        return ListItemRvAdapter.ITEM_DATA_SELECTOR_LIST;
    }

    @Override
    public int layout() {
        return R.layout.item_data_with_nest_selector;
    }

    @Override
    public void convert(BaseViewHolder helper, ItemsForRecyclerView data, int position) {
        helper.setNestView(R.id.nest_selector_list); // u can set nestview id
        helper.setText(R.id.name5, data.name);
        helper.addOnClickListener(R.id.name5)
                .addOnClickListener(R.id.progressBar5);
    }
}
