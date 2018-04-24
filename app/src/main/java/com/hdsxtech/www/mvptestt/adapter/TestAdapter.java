package com.hdsxtech.www.mvptestt.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hdsxtech.www.mvptestt.R;
import com.hdsxtech.www.mvptestt.bean.TestNewsBean;

import java.util.List;

/**
 * 作者:丁文 on 2018/4/16.
 * copyright: www.hdsxtech.com
 */

public class TestAdapter extends BaseQuickAdapter<TestNewsBean, BaseViewHolder> {
    public TestAdapter(int layoutResId, @Nullable List data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, TestNewsBean item) {
        helper.setText(R.id.tv_item_mynews_content, item.getMescontent());
        helper.setText(R.id.tv_item_mynews_time, item.getCreatetime());
        helper.setText(R.id.tv_item_mynews_title, item.getMesname());
    }
}
