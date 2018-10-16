package com.example.lenovo.travelalone.news;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.lenovo.travelalone.R;

import org.jsoup.select.Elements;

import java.util.List;

public class Adaptationnews extends RecyclerView.Adapter<Adaptationnews.MyviewHolder>{
    Context context;
    List<User> list;

    public Adaptationnews(Context context, List<User> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.newsitem,parent,false);
        return new MyviewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyviewHolder holder, int position) {
        holder.textView.setText(list.get(position).getName());
        holder.textView2.setText(list.get(position).getPhone());
        Glide.with(context)
                .load(list.get(position).getEmail())

                .into(holder.imageView);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context,Viewnews.class);
                intent.putExtra("title",list.get(position).getName());
                intent.putExtra("dec",list.get(position).getPhone());

                intent.putExtra("photo",list.get(position).getEmail());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return  list.size();
    }

    public class MyviewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        TextView textView2;
        ImageView imageView;

        public MyviewHolder(View itemView) {
            super(itemView);
            textView=(TextView)itemView.findViewById(R.id.post_text1);
            textView2=(TextView)itemView.findViewById(R.id.post_description1);
            imageView= (ImageView) itemView.findViewById(R.id.post_image1);

        }
    }

}
