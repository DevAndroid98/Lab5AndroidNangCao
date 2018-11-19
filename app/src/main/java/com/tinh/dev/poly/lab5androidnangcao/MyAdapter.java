package com.tinh.dev.poly.lab5androidnangcao;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.Holder> {

    private MainActivity context;
    private ArrayList<Items> items;

    public MyAdapter(MainActivity context, ArrayList<Items> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        final Items item=items.get(position);
        holder.pubdate.setText(item.pubDate);
        holder.desc.setText(item.description);
        holder.title.setText(item.title);
        Picasso.get().load(item.link).into(holder.img);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.webview(item.linkx);
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class Holder extends RecyclerView.ViewHolder{
        public TextView pubdate;
        public ImageView img;
        public TextView title;
        public TextView desc;


        public Holder(View itemView) {
            super(itemView);
            pubdate = itemView.findViewById(R.id.pubdate);
            img = itemView.findViewById(R.id.img);
            title = itemView.findViewById(R.id.title);
            desc =  itemView.findViewById(R.id.desc);
        }
    }
}
