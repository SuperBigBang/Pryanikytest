package com.superbigbang.pryanikytest.adapter.provider;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.superbigbang.pryanikytest.R;
import com.superbigbang.pryanikytest.adapter.ListItemRvAdapter;
import com.superbigbang.pryanikytest.adapter.NestAdapter;
import com.superbigbang.pryanikytest.entity.EntitySelector;
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
        return R.layout.item_nest_click;
    }

    @Override
    public void convert(BaseViewHolder helper, ItemsForRecyclerView data, int position) {
        helper.setNestView(R.id.item_click); // u can set nestview id
        helper.setText(R.id.name5, data.name);
        final RecyclerView recyclerView = helper.getView(R.id.nest_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(helper.itemView.getContext(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setHasFixedSize(true);

        NestAdapter nestAdapter = new NestAdapter(((EntitySelector)data).variants,((EntitySelector) data).selectedId);
        // nestAdapter.setOnItemClickListener(this);
        //nestAdapter.setOnItemChildClickListener(this);
        recyclerView.setAdapter(nestAdapter);

    }

    @Override
    public void onClick(BaseViewHolder helper, ItemsForRecyclerView data, int position) {
        Toast.makeText(mContext, "click", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onLongClick(BaseViewHolder helper, ItemsForRecyclerView data, int position) {
        Toast.makeText(mContext, "longClick", Toast.LENGTH_SHORT).show();
        return true;
    }
}
