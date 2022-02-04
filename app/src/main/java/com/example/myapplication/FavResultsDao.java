package com.example.myapplication;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface FavResultsDao {
    @Query("SELECT * FROM FavList")
    List<FavResults> getDetails();

    @Insert
    void insertUser(FavResults user);

    @Query("SELECT * FROM FavList WHERE id = :Mid")
    List<FavResults> checkId(int Mid);

    @Query("DELETE FROM FavList WHERE id = :Mid")
    void deleteUser(int Mid);
}
