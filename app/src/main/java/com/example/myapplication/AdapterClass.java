package com.example.myapplication;

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
import com.squareup.picasso.Picasso;
import java.util.List;

public class AdapterClass extends RecyclerView.Adapter<AdapterClass.MyViewHolder>{

    private final Context mContext;
    private List<Result> mData;

    public AdapterClass(Context mContext, List<Result> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @SuppressLint("NotifyDataSetChanged")
    public void setMovieList(List<Result> mData){
        this.mData = mData;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public AdapterClass.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        v = inflater.inflate(R.layout.movie_item,parent,false);
        return new MyViewHolder(v);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Result r = mData.get(position);
        int va = (int) ((mData.get(position).getVoteAverage())*10);
        holder.vote_cast.setText(r.getVoteCount().toString());
        holder.vote_percent.setText(Integer.toString(va).concat("%"));
        holder.name.setText(r.getTitle());
        holder.bar.setProgress(va);
        Picasso.get().load("https://image.tmdb.org/t/p/w200/"+r.getPosterPath()).into(holder.img);
        holder.heart.setVisibility(View.VISIBLE);
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
                if(db.favResultsDao().checkId(r.getId()).size() >= 1){
                    Toast.makeText(mContext.getApplicationContext(),r.getTitle()+" already exist", Toast.LENGTH_SHORT).show();
                }
                else {
                    FavResults Fav = new FavResults();
                    Fav.setId(r.getId());
                    Fav.setVoteAverage((double) va);
                    Fav.setVoteCount(r.getVoteCount());
                    Fav.setTitle(r.getTitle());
                    Fav.setPosterPath(r.getPosterPath());
                    db.favResultsDao().insertUser(Fav);
                    Toast.makeText(mContext.getApplicationContext(),r.getTitle()+"\nhas been added to your favorite list", Toast.LENGTH_SHORT).show();
                }
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
