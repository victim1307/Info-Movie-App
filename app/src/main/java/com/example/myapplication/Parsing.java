package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Parsing extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parsing);

        Bundle b = getIntent().getExtras();
        String id = b.getString("id");
        int idint = Integer.parseInt(id);
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.themoviedb.org/")
                .addConverterFactory(GsonConverterFactory.create()).build();

        ApiInterface myAPICall =retrofit.create(ApiInterface.class);

        Call<MovieParsing> call = myAPICall.getData(idint);
        call.enqueue(new Callback<MovieParsing>() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onResponse(@NonNull Call<MovieParsing> call, @NonNull Response<MovieParsing> response) {
                String jsony = "";
                assert response.body() != null;
                MovieParsing res  = response.body();
                String img_url = "https://image.tmdb.org/t/p/original/";
                ImageView img = findViewById(R.id.imageView);
                Picasso.get().load(img_url+res.getPoster_path()).into(img);

                TextView txt_title = findViewById(R.id.txt_title);
                txt_title.setText(res.getTitle());
                //overview
                TextView txt_overview = findViewById(R.id.txt_overview);
                txt_overview.setText("Overview : \n"+res.getOverview());
                //vote percentage
                int vpercent = (int)(res.getVote_average()*10);
                TextView vote_percent = findViewById(R.id.vote_percent);
                vote_percent.setText(vpercent+"%");
                ProgressBar progressBar = findViewById(R.id.progressBar);
                progressBar.setProgress(vpercent);
                //vote count
                TextView txt_vote_count = findViewById(R.id.vote_cast);
                txt_vote_count.setText(res.getVote_count().toString());

                //budget
                TextView txt_budget = findViewById(R.id.txt_budget);
                int budget = (int) (res.getBudget()/1000000);
                txt_budget.setText("Budget: "+budget+"M");

                //date
                TextView txt_date = findViewById(R.id.txt_date);
                txt_date.setText("Date\n"+res.getRelease_date());

                // gerne
                TextView txt_genre = findViewById(R.id.txt_genre);
                MovieParsing R  = response.body();
                String gerne = "";
                for(int g=0; g < res.getGenres().size();g++){
                    gerne = gerne+res.getGenres().get(g).getName();
                    if(g<res.getGenres().size()-1){
                        gerne = gerne+", ";
                    }
                }
                txt_genre.setText("Gerne : "+gerne);
            }
            @Override
            public void onFailure(Call<MovieParsing> call, Throwable t) {
            }
        });
    }
}