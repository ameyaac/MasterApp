package com.example.masterapp;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class MyImageAdapter extends BaseAdapter {

    private Context mContext;

    public Integer[] images = {
              R.drawable.rajendra_prasad
            , R.drawable.sarvepalli_radhakrishnan
            , R.drawable.zakir_husain
    };

    public MyImageAdapter (Context c) {
        mContext = c;
    }

    public int getCount() {
        return images.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImageView imageView = new ImageView(mContext);
        imageView.setLayoutParams(new ViewGroup.LayoutParams(200, 200));
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setPadding(8, 8, 8, 8);
        imageView.setImageResource(images[i]);

        return imageView;
    }
}
