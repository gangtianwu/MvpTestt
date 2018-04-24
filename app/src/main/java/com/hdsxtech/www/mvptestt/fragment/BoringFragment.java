package com.hdsxtech.www.mvptestt.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hdsxtech.www.mvptestt.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 作者:丁文 on 2018/4/18.
 * copyright: www.hdsxtech.com
 */

public class BoringFragment extends Fragment {
    @BindView(R.id.vp_fragment_current)
    ViewPager vpFragmentCurrent;
    @BindView(R.id.tl_fragment_current)
    TabLayout tlFragmentCurrent;
    Unbinder unbinder;
    private ArrayList<Fragment> list;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getContext(), R.layout.fragment_boring, null);
        unbinder = ButterKnife.bind(this, view);

        initData();
        return view;
    }

    private void initData() {
        final String[] title = new String[]{"1", "2", "3", "4", "5", "6"};
        list = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            Fragment fragment = new XinxiFragment();
            if (i == 2) {
                fragment = new CeshiFragment();
            }
            list.add(fragment);

        }
        vpFragmentCurrent.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return list.get(position);
            }

            @Override
            public int getCount() {
                return title.length;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return title[position];
            }
        });
        tlFragmentCurrent.setupWithViewPager(vpFragmentCurrent);
        vpFragmentCurrent.setOffscreenPageLimit(2);//设置缓存view 的个数（实际有3个，缓存2个+正在显示的1个）
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
