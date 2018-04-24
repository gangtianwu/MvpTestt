package com.hdsxtech.www.mvptestt.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hdsxtech.www.mvptestt.R;
import com.hdsxtech.www.mvptestt.bean.XinwenBean;

import java.util.List;

/**
 * 作者:丁文 on 2018/4/17.
 * copyright: www.hdsxtech.com
 */

public class XinxiAdapter extends BaseQuickAdapter<XinwenBean, BaseViewHolder> {

    public XinxiAdapter(int layoutResId, @Nullable List<XinwenBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, XinwenBean item) {
        helper.setText(R.id.tv_content,item.getName());
        helper.setText(R.id.tv_date,item.getTime());
    }
}
