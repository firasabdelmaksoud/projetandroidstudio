package com.elgindy.loginandregisterwithroom;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.elgindy.loginandregisterwithroom.Data.favoris;

import java.util.List;

public class MActivity extends AppCompatActivity implements favorisListAdapter.HandlefavorisClick {
    private MActivityViewModel viewModel;
    private TextView noResulttextView;
    private RecyclerView recyclerView;
    private favorisListAdapter favorisListAdapter ;
    private favoris favorisForEdit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mactivity);
        
        noResulttextView = findViewById(R.id.noResult);
        recyclerView = findViewById(R.id.recyclerView);

        ImageView addNew = findViewById(R.id.addNewCategoryImageView);
        addNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAddCategoryDialog(false);
            }
        });
        initViewModel();
        initRecyclerView();
    }
    private void initRecyclerView(){
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        favorisListAdapter= new favorisListAdapter(this,this);
        recyclerView.setAdapter(favorisListAdapter);
    }


    private void initViewModel()
    {
        viewModel = new ViewModelProvider(this).get(MActivityViewModel.class);

        viewModel.getfavorisListObserver().observe(this, new Observer<List<favoris>>() {
            @Override
            public void onChanged(List<favoris> favorises) {
                if(favorises == null){
                    noResulttextView.setVisibility(View.VISIBLE);
                    recyclerView.setVisibility(View.GONE);
                }
                else{
                    favorisListAdapter.setFavorisList(favorises);
                    recyclerView.setVisibility(View.VISIBLE);
                    noResulttextView.setVisibility(View.GONE);
                }
            }
        });
    }
    private void showAddCategoryDialog(boolean isForEdit){
        AlertDialog dialogBuilder = new AlertDialog.Builder(this).create();
        View dialogView = getLayoutInflater().inflate(R.layout.add_categorylayout, null);
        EditText enterfavorisInput =dialogView.findViewById(R.id.enterfavorisInput);
        TextView create_button =dialogView.findViewById(R.id.create_button);
        TextView cancel_button =dialogView.findViewById(R.id.cancel_button);


        if(isForEdit){
            create_button.setText("Update");
            enterfavorisInput.setText(favorisForEdit.favorisName);
        }


        cancel_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogBuilder.dismiss();
            }
        });

        create_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = enterfavorisInput.getText().toString();

                if(TextUtils.isEmpty(name)){
                    Toast.makeText(MActivity.this, "Enter category name", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(isForEdit){
                    favorisForEdit.favorisName=name;
                    viewModel.updatefavoris(favorisForEdit);

                }
                else {
                    viewModel.insertfavoris(name);
                }

                dialogBuilder.dismiss();
            }
        });

        dialogBuilder.setView(dialogView);
        dialogBuilder.show();


    }

    @Override
    public void itemClick(favoris f) {

    }

    @Override
    public void removeItem(favoris f) {
        viewModel.deletefavoris(f);
    }

    @Override
    public void editItem(favoris f) {
        this.favorisForEdit = f;
        showAddCategoryDialog(true);
    }
}