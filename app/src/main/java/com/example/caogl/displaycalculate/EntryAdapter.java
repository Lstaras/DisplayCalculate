package com.example.caogl.displaycalculate;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by caogl on 2017-10-24.
 */

public class EntryAdapter extends RecyclerView.Adapter<EntryAdapter.ViewHolder> {//适配器

    private List<Entry> mEntryList;//把Entry这个类当作List的类型，使得mEntryList中存放Entry对象

    public EntryAdapter(List<Entry> entryList){
        mEntryList = entryList;
    }//适配器的构造方法就是读入一个指定类型的List

    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView entryImage;
        TextView entrytext1;
        TextView entrytext2;

        public ViewHolder(View view){
            super(view);
            entryImage = (ImageView) view.findViewById(R.id.entry_image);
            entrytext1 = (TextView) view.findViewById(R.id.entry_text1);
            entrytext2 = (TextView) view.findViewById(R.id.entry_text2);
        }
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.entry_item,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    public void onBindViewHolder(ViewHolder holder, int position) {
        Entry entry = mEntryList.get(position);
        holder.entryImage.setImageResource(entry.getImageId());
        holder.entrytext1.setText(entry.getText1());
        holder.entrytext2.setText(entry.getText2());
    }

    public int getItemCount() {
        return mEntryList.size();
    }
}
