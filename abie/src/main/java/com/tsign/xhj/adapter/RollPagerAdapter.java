package com.tsign.xhj.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.tsign.xhj.R;

import java.util.ArrayList;
import java.util.List;

public class RollPagerAdapter extends StaticPagerAdapter {
    private Context context;
    private List<String> picUrls;
    LayoutInflater inflater;

    public RollPagerAdapter(Context context, ArrayList<String> picUrls) {
        this.context = context;
        this.picUrls = picUrls;
        this.inflater = LayoutInflater.from(context);
    }

    class ViewHolder {
        ImageView imageView;
    }

    @Override
    public View getView(ViewGroup container, int position) {
        View convertView = null;
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.roll_viewpager, null);
            holder.imageView = (ImageView) convertView
                    .findViewById(R.id.main_sdv);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        Uri uri = Uri.parse(picUrls.get(position));
        //加载动态图片
        holder.imageView.setImageURI(uri);
        return convertView;
    }

    @Override
    public int getCount() {
        return picUrls.size();
    }
}
