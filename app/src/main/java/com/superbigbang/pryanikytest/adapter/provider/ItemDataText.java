package com.superbigbang.pryanikytest.adapter.provider;

import android.widget.Toast;

import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.superbigbang.pryanikytest.R;
import com.superbigbang.pryanikytest.adapter.ListItemRvAdapter;
import com.superbigbang.pryanikytest.entity.EntityDataText;
import com.superbigbang.pryanikytest.entity.ItemsForRecyclerView;

/**
 * https://github.com/chaychan
 *
 * @author ChayChan
 * @description: Text ItemProvider
 * @date 2018/3/30  11:39
 */

public class ItemDataText extends BaseItemProvider<ItemsForRecyclerView, BaseViewHolder> {

    @Override
    public int viewType() {
        return ListItemRvAdapter.ITEM_DATA_TEXT;
    }

    @Override
    public int layout() {
        return R.layout.item_data_text;
    }

    @Override
    public void convert(BaseViewHolder helper, ItemsForRecyclerView data, int position) {
        helper.setText(R.id.name3, data.name);
        helper.setText(R.id.textData3, ((EntityDataText) data).dataText);
    }

    @Override
    public void onClick(BaseViewHolder helper, ItemsForRecyclerView data, int position) {
        Toast.makeText(mContext, "click", Toast.LENGTH_SHORT).show();
        helper.setText(R.id.textData3, ((EntityDataText) data).dataText);
    }

    @Override
    public boolean onLongClick(BaseViewHolder helper, ItemsForRecyclerView data, int position) {
        Toast.makeText(mContext, "longClick", Toast.LENGTH_SHORT).show();
        return true;
    }
}
