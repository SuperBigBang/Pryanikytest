package com.superbigbang.pryanikytest.adapter;

import android.support.annotation.Nullable;
import android.support.v7.widget.SwitchCompat;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.superbigbang.pryanikytest.R;
import com.superbigbang.pryanikytest.model.Variants;

import java.util.List;

/**
 * 文 件 名: AnimationAdapter
 * 创 建 人: Allen
 * 创建日期: 16/12/24 15:33
 * 邮   箱: AllenCoder@126.com
 * 修改时间：
 * 修改备注：
 */
public class NestAdapter extends BaseQuickAdapter<Variants, BaseViewHolder> {
    private int selectedID;
    public int savedPositionOfSelectedID;
    public NestAdapter(@Nullable List<Variants> data, int selectedID) {
        super(R.layout.layout_nest_item_on_selector, data);
        this.selectedID=selectedID;
    }

    @Override
    protected void convert(BaseViewHolder helper, Variants variant) {
        //Variants variant = item;
        helper.addOnClickListener(R.id.switch4)
                .addOnClickListener(R.id.id4)
                .addOnClickListener(R.id.name4);
        helper.setText(R.id.id4, String.valueOf(variant.getId()));
        helper.setText(R.id.name4, variant.getText());
        if (variant.getId() == selectedID) {
            ((SwitchCompat) helper.getView(R.id.switch4)).setChecked(true);
            this.savedPositionOfSelectedID = helper.getLayoutPosition();
        }
    }
}

