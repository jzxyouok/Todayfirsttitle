package com.bwei.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.TextPaint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.bwei.Adapter.Myadapter;
import com.bwei.Adapter.Pageradapter;
import com.bwei.Bean.Bean;
import com.bwei.R;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

import me.maxwin.view.XListView;

/**
 * Created by 葛凯旋 on 2017/7/20.
 */
@ContentView(R.layout.homeitem)
public class Home extends Fragment {
    private PagerAdapter pagerAdapter;


    private List<Fragment> fragmentList = new ArrayList<>();
    @ViewInject(R.id.ttt)
    private TextView tt;
    @ViewInject(R.id.tab)
    private TabLayout tab;
    @ViewInject(R.id.mypager)
    private ViewPager pager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        return x.view().inject(this, inflater, null);


    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);



        //addtab();
        pagerAdapter = new Pageradapter(getFragmentManager());
        pager.setAdapter(pagerAdapter);
        tab.setupWithViewPager(pager);

    }





}
