package com.example.grocerieslistapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.grocerieslistapp.model.Groceries;
import com.example.grocerieslistapp.model.GroceriesViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "ITEM";
    private GroceriesViewModel groceriesViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        groceriesViewModel = new ViewModelProvider.AndroidViewModelFactory(
                MainActivity.this.getApplication() )
                .create( GroceriesViewModel.class );

        groceriesViewModel.getAllGroceries().observe( this, groceries -> {
            for (Groceries groceries1: groceries) {
                Log.d( TAG, "onCreate: " + groceries1.getId() );
            }

        } );

        FloatingActionButton fab = findViewById(R.id.floataddbtn);
        fab.setOnClickListener( view -> {
            Groceries groceries = new Groceries( "chambo", 200.00, 20);
            GroceriesViewModel.insert( groceries );

        } );
    }
}