package com.example.grocerieslistapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.grocerieslistapp.adapter.RecyclerViewApter;
import com.example.grocerieslistapp.model.Groceries;
import com.example.grocerieslistapp.model.GroceriesViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    private RecyclerViewApter recyclerViewApter;

    private List<Groceries> groceriesList;

    private static final String TAG = "ITEM";
    private GroceriesViewModel groceriesViewModel;
    private int counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        counter = 0;

        recyclerView = findViewById( R.id.recyclerview );
        recyclerView.setHasFixedSize( true );
        recyclerView.setLayoutManager( new LinearLayoutManager( this ) );


        groceriesViewModel = new ViewModelProvider.AndroidViewModelFactory(
                MainActivity.this.getApplication() )
                .create( GroceriesViewModel.class );

        groceriesViewModel.getAllGroceries().observe( this, groceries -> {

            recyclerViewApter = new RecyclerViewApter( groceries );
            recyclerView.setAdapter( recyclerViewApter );

        } );

        FloatingActionButton fab = findViewById(R.id.floataddbtn);
        fab.setOnClickListener( view -> {
            Groceries groceries = new Groceries( "Groceries" + counter++, 200.00, 20);
            GroceriesViewModel.insert( groceries);
            //GroceriesViewModel.delete( groceries );

        } );
    }
}