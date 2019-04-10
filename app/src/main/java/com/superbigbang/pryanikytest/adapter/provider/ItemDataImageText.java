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

public class ItemDataImageText extends BaseItemProvider<ItemsForRecyclerView, BaseViewHolder> {
    @Override
    public int viewType() {
        return ListItemRvAdapter.ITEM_DATA_IMAGE_TEXT;
    }

    @Override
    public int layout() {
        return R.layout.item_data_image_text;
    }

    @Override
    public void convert(BaseViewHolder helper, ItemsForRecyclerView data, int position) {
        helper.setText(R.id.name, data.name);
        helper.addOnClickListener(R.id.name)
                .addOnClickListener(R.id.progressBar)
                .addOnClickListener(R.id.imageData)
                .addOnClickListener(R.id.textData);
    }
}
