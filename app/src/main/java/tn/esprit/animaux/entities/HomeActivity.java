package tn.esprit.animaux.entities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import tn.esprit.animaux.R;

public class HomeActivity  extends AppCompatActivity {
    RecyclerView recyclerView;
    AnimalAdapter adap;
    List<animaux>animauxx  = new ArrayList<>();
    Button home;
    Button search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        setanimauxx ();
        home=findViewById(R.id.homebtn);
        search=findViewById(R.id.Serachbtn);

        recyclerView = findViewById(R.id.animalr);
        adap = new AnimalAdapter(animauxx,this);
        recyclerView.setAdapter(adap);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));
        search.setOnClickListener(view -> {


            Intent intent = new Intent(this, SearchActivity.class);
            startActivity(intent);

        });
        home.setOnClickListener(view -> {


            Intent intent = new Intent(this, HomeActivity.class);
            startActivity(intent);

        });
    }
    private void setanimauxx ()
    {
        animauxx.add(new animaux( "animaux1","action",1.0,R.drawable.pets));
        animauxx.add(new animaux( "animaux2","drama",2.0,R.drawable.pets));
        animauxx.add(new animaux( "animaux3","action",1.0,R.drawable.pets));
        animauxx.add(new animaux( "animaux4","drama",2.0,R.drawable.pets));
        animauxx.add(new animaux( "animaux5","action",1.0,R.drawable.pets ));
        animauxx.add(new animaux( "animaux6","drama",2.0,R.drawable.pets));
        animauxx.add(new animaux( "animaux1","action",1.0,R.drawable.pets ));
        animauxx.add(new animaux( "animaux2","drama",2.0,R.drawable.pets ));
        animauxx.add(new animaux( "animaux3","action",1.0,R.drawable.pets ));
        animauxx.add(new animaux( "animaux4","drama",2.0,R.drawable.pets ));
        animauxx.add(new animaux( "animaux5","action",1.0,R.drawable.pets));
        animauxx.add(new animaux( "animaux6","drama",2.0,R.drawable.pets));
    }
}
