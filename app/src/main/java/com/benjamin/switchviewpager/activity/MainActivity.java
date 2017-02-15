package com.benjamin.switchviewpager.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;

import com.benjamin.switchviewpager.R;
import com.benjamin.switchviewpager.adapter.FragmentTabAdapter;
import com.benjamin.switchviewpager.fragment.ProductFragment;
import com.benjamin.switchviewpager.fragment.ShopFragment;
import com.benjamin.switchviewpager.widget.SwitchViewPager;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TabLayout mTabLayout;
    SwitchViewPager mPager;
    FragmentTabAdapter mFragmentAdapter;
    ArrayList<Fragment> mFragmentList = new ArrayList<>();
    ArrayList<String> mTitleList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button).setOnClickListener(this);
        mTabLayout = (TabLayout) findViewById(R.id.shop_tab);
        mPager = (SwitchViewPager) findViewById(R.id.shop_pager);
        mFragmentList.add(new ProductFragment());
        mFragmentList.add(new ShopFragment());
        mTitleList.add("商品");
        mTitleList.add("店铺");
        mFragmentAdapter = new FragmentTabAdapter(MainActivity.this.getSupportFragmentManager(), mFragmentList, mTitleList);
        mPager.setAdapter(mFragmentAdapter);
        mTabLayout.setupWithViewPager(mPager, true);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button:
                if (mPager.isScrollable() == true) {
                    mPager.setScrollable(false);
                    mFragmentAdapter.notifyDataSetChanged();
                } else {
                    mPager.setScrollable(true);
                    mFragmentAdapter.notifyDataSetChanged();
                }
                break;
        }
    }


}
