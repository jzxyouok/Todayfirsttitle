package com.bwei.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bwei.Bean.Bean;
import com.bwei.R;

import java.util.List;

/**
 * Created by 葛凯旋 on 2017/7/18.
 */
public class Myadapter extends BaseAdapter {
    private Context  context;
    private List<Bean.DataBean> list;

    public Myadapter(Context context, List<Bean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Viewholder  holder;
        if(convertView==null){
            holder=new Viewholder();
            convertView=View.inflate(context, R.layout.item,null);
            holder.title= (TextView) convertView.findViewById(R.id.title);
            holder.image= (ImageView) convertView.findViewById(R.id.image);
            convertView.setTag(holder);
        }else{
            holder= (Viewholder) convertView.getTag();
        }
        Bean.DataBean  bea=list.get(position);
        holder.title.setText(bea.getNews_title());
        Glide.with(context).load(bea.getPic_url()).into(holder.image);
        return convertView;
    }
    class   Viewholder{
        TextView  title;

        ImageView  image;
    }
}
