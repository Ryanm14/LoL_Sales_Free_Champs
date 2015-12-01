package me.ryanmiles.salesfreechampionsforlol.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;

import me.ryanmiles.salesfreechampionsforlol.R;

/**
 * Created by Ryan on 12/1/2015.
 */
public class ImageGridAdapter extends ArrayAdapter {
    private Context mContext;
    private LayoutInflater mLayoutInflater;

    private List<String> mimageUrls;

    public ImageGridAdapter(Context context, List<String> imageUrls) {
        super(context, R.layout.imagegridview, imageUrls);

        mContext = context;
        mimageUrls = imageUrls;

        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (null == convertView) {
            convertView = mLayoutInflater.inflate(R.layout.imagegridview, parent, false);
        }

        Picasso
                .with(mContext)
                .load(mimageUrls.get(position))
                .fit() // will explain later
                .into((ImageView) convertView);

        return convertView;
    }
}
