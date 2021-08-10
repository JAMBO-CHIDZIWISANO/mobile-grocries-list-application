package com.example.grocerieslistapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;


import android.os.Bundle;

import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import android.widget.Toast;


import com.example.grocerieslistapp.adapter.OnClickItem;
import com.example.grocerieslistapp.adapter.RecyclerViewApter;

import com.example.grocerieslistapp.model.Groceries;
import com.example.grocerieslistapp.model.GroceriesViewModel;

import com.example.grocerieslistapp.model.SharedViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.jetbrains.annotations.NotNull;


import java.util.List;

public class MainActivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    private RecyclerViewApter recyclerViewApter;

    private List<Groceries> groceriesList;

    private static final String TAG = "ITEM";
    private GroceriesViewModel groceriesViewModel;


    AddGroceries addGroceries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );


        addGroceries = new AddGroceries();

        recyclerView = findViewById( R.id.recyclerview );
        recyclerView.setHasFixedSize( true );
        recyclerView.setLayoutManager( new LinearLayoutManager( this ) );


        groceriesViewModel = new ViewModelProvider.AndroidViewModelFactory(
                MainActivity.this.getApplication() )
                .create( GroceriesViewModel.class );


        groceriesViewModel.getAllGroceries().observe( this, groceries -> {

            recyclerViewApter = new RecyclerViewApter( groceries );
            recyclerView.setAdapter( recyclerViewApter );

            recyclerViewApter.notifyDataSetChanged();

        } );

        // delete items
        new ItemTouchHelper( new ItemTouchHelper.SimpleCallback( 0,
                ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT ) {
            @Override
            public boolean onMove(@NonNull @NotNull RecyclerView recyclerView, @NonNull @NotNull RecyclerView.ViewHolder viewHolder, @NonNull @NotNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull @NotNull RecyclerView.ViewHolder viewHolder, int direction) {
                GroceriesViewModel.delete( recyclerViewApter.getGroceriesAt( viewHolder.getAbsoluteAdapterPosition() ) );
                Toast.makeText( MainActivity.this, "item deleted", Toast.LENGTH_SHORT ).show();
            }
        } ).attachToRecyclerView( recyclerView );

        FloatingActionButton fab = findViewById( R.id.floataddbtn );
        fab.setOnClickListener( view -> {
//
            showBottomSheetDialog();

        } );
    }

    private void showBottomSheetDialog() {
        addGroceries.show( getSupportFragmentManager(), addGroceries.getTag() );

    }


    // menu for deleting all items
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate( R.menu.delete_menu, menu );
        return true;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.delete_all_groceries) {
            GroceriesViewModel.deleteAll();
            Toast.makeText( this, "all groceries deleted", Toast.LENGTH_SHORT ).show();
            return true;
        }
        return super.onOptionsItemSelected( item );

    }
}
