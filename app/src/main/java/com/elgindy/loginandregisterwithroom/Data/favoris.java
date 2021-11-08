package com.elgindy.loginandregisterwithroom.Data;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.elgindy.loginandregisterwithroom.Model.User;

@Entity
public class favoris {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name="favorisName")
    public String favorisName;

}
