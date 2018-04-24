package com.hdsxtech.www.mvptestt.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hdsxtech.www.mvptestt.R;
import com.hdsxtech.www.mvptestt.bean.ThemesBean;

import java.util.List;

/**
 * 作者:丁文 on 2018/4/4.
 * copyright: www.hdsxtech.com
 */

public class ThemefgAdapter extends BaseQuickAdapter<ThemesBean.StoriesBean, BaseViewHolder> {
    Context mContext;

    public ThemefgAdapter(int layoutResId, @Nullable List<ThemesBean.StoriesBean> data, Context context) {
        super(layoutResId, data);
        this.mContext = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, ThemesBean.StoriesBean item) {
        helper.setText(R.id.tv_title, item.getTitle());
        if (item.getImages() != null) {
            Glide.with(mContext)
                    .load(item.getImages().get(0))
                    .error(R.mipmap.bg_about)
                    .into((ImageView) helper.getView(R.id.iv_zhizhu_item_image));
            helper.getView(R.id.iv_zhizhu_item_image).setVisibility(View.VISIBLE);
        } else {
            helper.getView(R.id.iv_zhizhu_item_image).setVisibility(View.GONE);
        }

    }
}
