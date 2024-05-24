package com.example.livecricket;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class adapter extends  RecyclerView.Adapter<adapter.viewholder>{

    Context context;
    ArrayList<model> modelArrayList;

    public adapter(Context context, ArrayList<model> modelArrayList) {
        this.context = context;
        this.modelArrayList = modelArrayList;
    }

    @NonNull
    @Override
    public adapter.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
         View view= LayoutInflater.from(context).inflate(R.layout.layout_item,parent,false);
         return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull adapter.viewholder holder, @SuppressLint("RecyclerView") int position) {
        setanimation(holder.itemView,position);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context,Web.class);
                intent.putExtra("url",modelArrayList.get(position).getUrl());

                //intent.putExtra("url",modelArrayList.get(position).getUrl());
                context.startActivity(intent);
            }
        });
        holder.published.setText(modelArrayList.get(position).getPublishedAt());
        holder.author.setText(modelArrayList.get(position).getAuthor());
        holder.heading.setText(modelArrayList.get(position).getTitle());
        holder.content.setText(modelArrayList.get(position).getDescription());
        Glide.with(context).load(modelArrayList.get(position).getUrlToImage()).into(holder.image);
        setanimation(holder.itemView,position);


    }

    @Override
    public int getItemCount() {
        return modelArrayList.size();
    }

    public class viewholder  extends RecyclerView.ViewHolder{
        TextView heading,content,published,author;
        CardView cardView;
        ImageView image;


        public viewholder(@NonNull View itemView) {
            super(itemView);
            heading=itemView.findViewById(R.id.heading);
            content=itemView.findViewById(R.id.content);
            published=itemView.findViewById(R.id.published);
            author=itemView.findViewById(R.id.author);
            cardView=itemView.findViewById(R.id.cardview);
            image=itemView.findViewById(R.id.imageview);
        }
    }
    private void setanimation(View animateview,int position){
        Animation slide= AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
        animateview.startAnimation(slide);
    }
}
