package com.bwei.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bwei.Adapter.Myadapter;
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
@ContentView(R.layout.homelist)
public class HomeFragment extends Fragment implements XListView.IXListViewListener {
    private String path = "http://api.expoon.com/AppNews/getNewsList/type/1/p/1";
    List<Bean.DataBean> list = new ArrayList<>();
    private int Stnum = 0;
    private Myadapter adapter;
    private Context  context;
    @ViewInject(R.id.mylist)
    private XListView lv;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        context=getActivity();
        x.view().inject(getActivity());
//        View view = inflater.inflate(R.layout.homelist, container, false);
//        lv = (XListView) view.findViewById(R.id.mylist);
        return x.view().inject(this,inflater,null);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        adddata();
        adapter = new Myadapter(context, list);
        lv.setAdapter(adapter);
        lv.setXListViewListener(this);
        lv.setPullLoadEnable(true);
        lv.setPullRefreshEnable(true);
    }

    private void adddata() {
        RequestParams params = new RequestParams(path);
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Bean bean = new Gson().fromJson(result, Bean.class);
                list.addAll(bean.getData());
                adapter.notifyDataSetChanged();
                stop();
            }

            private void stop() {

                lv.setRefreshTime("刚刚");
                lv.stopRefresh();
                lv.stopLoadMore();

            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }

    @Override
    public void onRefresh() {
        list.clear();
        adddata();
    }

    @Override
    public void onLoadMore() {
        Stnum++;
        Stnum = list.size();
        adddata();
    }
}
