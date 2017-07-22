package com.bwei.Adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.bwei.Fragment.Home;
import com.bwei.Fragment.HomeFragment;
import com.bwei.Fragment.ViedoFragment;
import com.bwei.Fragment.Weishenghuo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 葛凯旋 on 2017/7/20.
 */
public class Pageradapter  extends FragmentPagerAdapter {
    List<Fragment> fragmentList = new ArrayList<>();
    String[] titles = {"推荐","热点", "北京","视频","社会","图片","娱乐","游戏","科技","问答","科技","军事"};
     private   Context  context;

    public Pageradapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    public Pageradapter(FragmentManager fm) {
        super(fm);
        fragmentList.add(new HomeFragment());
        fragmentList.add(new ViedoFragment());
        fragmentList.add(new Weishenghuo());
        fragmentList.add(new HomeFragment());
        fragmentList.add(new ViedoFragment());
        fragmentList.add(new Weishenghuo());
        fragmentList.add(new HomeFragment());
        fragmentList.add(new ViedoFragment());
        fragmentList.add(new Weishenghuo());
        fragmentList.add(new HomeFragment());
        fragmentList.add(new ViedoFragment());
        fragmentList.add(new Weishenghuo());

    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }
}
