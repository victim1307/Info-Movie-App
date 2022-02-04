package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.internal.NavigationMenu;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FavActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    List<FavResults> movieList;

    RecyclerView recyclerView;
    FavAdapterClass recyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fav);
        movieList = new ArrayList<>();
        recyclerView = findViewById(R.id.recycler);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerAdapter = new FavAdapterClass(this,movieList);
        recyclerView.setLayoutManager(layoutManager);

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setTitle("Favorite Movies");

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_bar);
        navigationView.setNavigationItemSelectedListener(this);

        AppDataBase db = AppDataBase.getInstanceDB(this);
        movieList = db.favResultsDao().getDetails();
        recyclerAdapter.setMovieList(movieList);
        recyclerView.setAdapter(recyclerAdapter);
        }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.nav_top_rated){
            startActivity(new Intent(this,MainActivity.class));
            Toast.makeText(this,"Top Rated List",Toast.LENGTH_SHORT).show();
        }
        else if(id == R.id.nav_popular){
            startActivity(new Intent(this,Popular.class));
            Toast.makeText(this,"Popular List",Toast.LENGTH_SHORT).show();
        }
        else if(id == R.id.nav_upcoming){
            startActivity(new Intent(this,Upcoming.class));
            Toast.makeText(this,"Upcoming List",Toast.LENGTH_SHORT).show();
        }
        else if(id == R.id.nav_fav){
            startActivity(new Intent(this,FavActivity.class));
            Toast.makeText(this,"Already in Favorite List",Toast.LENGTH_SHORT).show();
        }
        else if(id == R.id.nav_logout){
            FirebaseAuth.getInstance().signOut();
            startActivity(new Intent(getApplicationContext(), Login.class));
            finish();
            Toast.makeText(this,"Logged Out",Toast.LENGTH_SHORT).show();
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawerlayout);
        drawer.closeDrawer(GravityCompat.START);
        return false;
    }
}

