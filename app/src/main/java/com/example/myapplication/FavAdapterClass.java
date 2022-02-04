package com.example.myapplication;

import static androidx.core.content.ContextCompat.startActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.sql.SQLOutput;
import java.util.List;

public class FavAdapterClass extends RecyclerView.Adapter<FavAdapterClass.MyViewHolder>{

    private final Context mContext;
    private List<FavResults> mData;

    public FavAdapterClass(Context mContext, List<FavResults> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    public void setMovieList(List<FavResults> mData){
        this.mData = mData;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public FavAdapterClass.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        v = inflater.inflate(R.layout.movie_item,parent,false);
        return new MyViewHolder(v);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        FavResults r = mData.get(position);
        int va = (int) ((mData.get(position).getVoteAverage())*10);
//        holder.vote_cast.setText(r.getVoteCount());
        holder.vote_percent.setText((int) (va/10) + "%");
        holder.name.setText(r.getTitle());
        holder.bar.setProgress(va);
        holder.vote_cast.setVisibility(View.GONE);
        Picasso.get().load("https://image.tmdb.org/t/p/w200/"+r.getPosterPath()).into(holder.img);
        holder.heart.setVisibility(View.GONE);
        holder.constraint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle b = new Bundle();
                b.putString("id",r.getId().toString());
                Intent add = new Intent(mContext,Parsing.class);
                add.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                add.putExtras(b);
                mContext.startActivity(add);
            }
        });

        holder.constraint.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                AppDataBase db = AppDataBase.getInstanceDB(mContext);
                db.favResultsDao().deleteUser(r.getId());
                mData.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position,mData.size());
                Toast.makeText(mContext,"Removed " + r.getTitle(),Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView vote_percent,name,vote_cast;
        ImageView img,heart;
        ProgressBar bar;
        ConstraintLayout constraint;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            vote_cast = itemView.findViewById(R.id.vote_cast);
            vote_percent = itemView.findViewById(R.id.vote_percent);
            name = itemView.findViewById(R.id.name_txt);
            img = itemView.findViewById(R.id.imageView);
            bar = itemView.findViewById(R.id.progressBar);
            constraint = itemView.findViewById(R.id.movie);
            heart = itemView.findViewById(R.id.imageView2);
        }
    }
}
