package com.hdsxtech.www.mvptestt;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hdsxtech.www.mvptestt.adapter.MyAdapter;
import com.hdsxtech.www.mvptestt.bean.TitleBean;
import com.hdsxtech.www.mvptestt.fragment.BoringFragment;
import com.hdsxtech.www.mvptestt.fragment.MyNewsFragment;
import com.hdsxtech.www.mvptestt.fragment.TestFragment;
import com.hdsxtech.www.mvptestt.fragment.ThemeFragment;
import com.hdsxtech.www.mvptestt.fragment.XinxiFragment;
import com.hdsxtech.www.mvptestt.presenter.MainPresenter;
import com.hdsxtech.www.mvptestt.view.MainActivityView;

import java.io.PrintWriter;
import java.net.Socket;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements MainActivityView {

    @BindView(R.id.about)
    ImageView about;
    @BindView(R.id.notify)
    ImageView notify;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.content_layout)
    FrameLayout contentLayout;
    @BindView(R.id.icon)
    ImageView icon;
    @BindView(R.id.rl_login)
    RelativeLayout rlLogin;
    @BindView(R.id.ll_collect)
    LinearLayout llCollect;
    @BindView(R.id.ll_down)
    LinearLayout llDown;
    @BindView(R.id.fp_icon)
    ImageView fpIcon;
    @BindView(R.id.tv_homepage)
    TextView tvHomepage;
    @BindView(R.id.rl_fg)
    RelativeLayout rlFg;
    @BindView(R.id.rv_left)
    RecyclerView rvLeft;
    @BindView(R.id.drawerlayout)
    DrawerLayout drawerlayout;
    private MainPresenter presenter;
    private View notDataView;
    private View errorView;
    private MyAdapter adapter;
    boolean isClick = false;
    private ThemeFragment themeFragment;
    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;
    private Socket mClientSocket;
    private PrintWriter printWriter;

    private Handler mHandler = new Handler();
    private int SOCKET_CONNECTED = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initToolBar();
        drawerlayout.openDrawer(Gravity.LEFT);
        initData();
        presenter = new MainPresenter(this);
//        presenter = new MainPresenter(this,adapter,rvLeft);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                TitleBean.OthersBean item = (TitleBean.OthersBean) adapter.getItem(position);
                switchFragment(item.getId(), item.getName());
            }
        });
    }

    private void switchFragment(int id, String name) {
        fragmentManager = getSupportFragmentManager();
        transaction = fragmentManager.beginTransaction();
        if (id == 13) {
            MyNewsFragment newsFragment = new MyNewsFragment();
            transaction.replace(R.id.content_layout, newsFragment);
            transaction.commit();
            toolbar.setTitle(name);
            return;
        }

        if (id == 12) {
            TestFragment testFragment = new TestFragment();
            transaction.replace(R.id.content_layout, testFragment);
            transaction.commit();
            toolbar.setTitle(name);
            return;
        }
        if (id == 3) {
            XinxiFragment testFragment = new XinxiFragment();
            transaction.replace(R.id.content_layout, testFragment);
            transaction.commit();
            toolbar.setTitle(name);
            return;
        }
        //不许无聊
        if (id == 11) {
            BoringFragment testFragment = new BoringFragment();
            transaction.replace(R.id.content_layout, testFragment);
            transaction.commit();
            toolbar.setTitle(name);
            return;
        }
        themeFragment = new ThemeFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("id", id);
        bundle.putString("theme", name);
        themeFragment.setArguments(bundle);
        transaction.replace(R.id.content_layout, themeFragment);
        transaction.commit();
        toolbar.setTitle(name);
    }

    private void initToolBar() {
        toolbar.setNavigationIcon(R.mipmap.ic_drawer_home);
        toolbar.setTitleTextAppearance(this, R.style.Theme_ToolBar_Base_Title);
        toolbar.setTitleTextColor(getResources().getColor(android.R.color.white));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isClick) {
                    drawerlayout.openDrawer(Gravity.LEFT);
                } else {
                    drawerlayout.closeDrawers();
                }
                isClick = !isClick;
            }
        });
    }

    private void initData() {
        rvLeft.setLayoutManager(new LinearLayoutManager(this));
        notDataView = getLayoutInflater().inflate(R.layout.empty_view, (ViewGroup) rvLeft.getParent(), false);
        notDataView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onrefresh();
            }
        });
        errorView = getLayoutInflater().inflate(R.layout.error_view, (ViewGroup) rvLeft.getParent(), false);
        errorView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onrefresh();
            }
        });
        adapter = new MyAdapter(R.layout.item_left, null);
        rvLeft.setAdapter(adapter);
        onrefresh();
    }

    private void onrefresh() {
        loading();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                presenter.getData();
            }
        }, 2000);
    }

    @Override
    public void getData(TitleBean titleBean) {
        adapter.setNewData(titleBean.getOthers());

    }

    @Override
    public void nodata(String nodata) {
        adapter.setEmptyView(notDataView);
    }

    @Override
    public void failed(String fail) {
        adapter.setEmptyView(errorView);
    }

    @Override
    public void loading() {
        adapter.setEmptyView(R.layout.loading_view, (ViewGroup) rvLeft.getParent());
    }

    @OnClick({R.id.about, R.id.notify, R.id.drawerlayout})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.about:
                break;
            case R.id.notify:
                break;
            case R.id.drawerlayout:
                break;
        }
    }
}
