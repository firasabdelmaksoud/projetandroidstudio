package com.elgindy.loginandregisterwithroom.Data;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.elgindy.loginandregisterwithroom.Model.User;


@Database(entities = {User.class, favoris.class}, version = 1, exportSchema = false)
public abstract class UserDataBase extends RoomDatabase {

    public abstract favorisDao favorisListDao();

    public static UserDataBase INSTANCE;

    public abstract UserDao getUserDao();

    public static UserDataBase getDBINSTANCE(Context context){
        if (INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), UserDataBase.class, "AppDb")
                    .allowMainThreadQueries()
                    .build();
        }

    return INSTANCE;
    }

}

