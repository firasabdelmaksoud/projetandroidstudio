package com.elgindy.loginandregisterwithroom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.elgindy.loginandregisterwithroom.Model.User;
import com.elgindy.loginandregisterwithroom.entities.animaux;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {
    private TextView tvUser;

    private User user;

    RecyclerView recyclerView;
    AnimalAdapter adap;
    List<animaux> animauxx  = new ArrayList<>();
    Button home;
    Button search;
    Button find;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        setanimauxx ();

        home =findViewById(R.id.homebtn);
        search =findViewById(R.id.Serachbtn);
        find = findViewById(R.id.buttonbtn);

        recyclerView = findViewById(R.id.animalr);
        adap = new AnimalAdapter(animauxx,this);
        recyclerView.setAdapter(adap);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));
        search.setOnClickListener(view -> {

            Intent moveToLogin = new Intent(HomeActivity.this, SearchActivity.class);
            startActivity(moveToLogin);

        });
        home.setOnClickListener(view -> {
            Intent intent = new Intent(HomeActivity.this, MActivity.class);
            startActivity(intent);
        });

        find.setOnClickListener(view->{
            Intent moveToLogin = new Intent(HomeActivity.this, SearchActivity.class);
            startActivity(moveToLogin);
        });

        user = (User) getIntent().getSerializableExtra("User");

        //tvUser = findViewById(R.id.tvUser);

        //if (user != null) {
        //    tvUser.setText("WELCOME " + user.getUserName());
        //}
    }
    private void setanimauxx ()
    {
        animauxx.add(new animaux( "cat","action",1.0,R.drawable.cat ));
        animauxx.add(new animaux( "dog","drama",2.0,R.drawable.dog ));
        animauxx.add(new animaux( "dog1","action",1.0,R.drawable.dog1 ));
        animauxx.add(new animaux( "oiseaux","drama",2.0,R.drawable.oiseaux ));
        animauxx.add(new animaux( "parrot","action",1.0,R.drawable.parrot ));
        animauxx.add(new animaux( "rabbit","drama",2.0,R.drawable.rabbit));

    }
}
