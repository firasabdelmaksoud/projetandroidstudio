package com.elgindy.loginandregisterwithroom.Data;

import com.elgindy.loginandregisterwithroom.Data.favoris;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.elgindy.loginandregisterwithroom.Data.favoris;

import java.util.List;

@Dao
public interface favorisDao {
    @Query("Select * from favoris")
    List<favoris> getAllfavorisList();

    @Insert
    void insertfavoris(favoris...f);

    @Update
    void updatefavoris(favoris f);

    @Delete
    void deletefavoris(favoris f);

}
