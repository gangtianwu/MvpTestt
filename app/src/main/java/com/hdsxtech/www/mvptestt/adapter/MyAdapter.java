package com.hdsxtech.www.mvptestt.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hdsxtech.www.mvptestt.R;
import com.hdsxtech.www.mvptestt.bean.TitleBean;

import java.util.List;

/**
 * 作者:丁文 on 2018/4/3.
 * copyright: www.hdsxtech.com
 */

public class MyAdapter extends BaseQuickAdapter<TitleBean.OthersBean,BaseViewHolder> {
    public MyAdapter(int layoutResId, @Nullable List<TitleBean.OthersBean> data) {
        super(layoutResId, data);
    }


    @Override
    protected void convert(BaseViewHolder helper, TitleBean.OthersBean item) {
        helper.setText(R.id.tv,item.getName());
    }
}
