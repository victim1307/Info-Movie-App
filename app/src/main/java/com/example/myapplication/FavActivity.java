package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import java.util.ArrayList;
import java.util.List;

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
        recyclerAdapter = new FavAdapterClass(this, movieList);
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
        if (id == R.id.nav_top_rated) {
            startActivity(new Intent(this, MainActivity.class));
            Toast.makeText(this, "Top Rated List", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_popular) {
            startActivity(new Intent(this, Popular.class));
            Toast.makeText(this, "Popular List", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_upcoming) {
            startActivity(new Intent(this, Upcoming.class));
            Toast.makeText(this, "Upcoming List", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_fav) {
            startActivity(new Intent(this, FavActivity.class));
            Toast.makeText(this, "Already in Favorite List", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_logout) {
            FirebaseAuth.getInstance().signOut();
            startActivity(new Intent(getApplicationContext(), Login.class));
            finish();
            Toast.makeText(this, "Logged Out", Toast.LENGTH_SHORT).show();
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawerlayout);
        drawer.closeDrawer(GravityCompat.START);
        return false;
    }
}

