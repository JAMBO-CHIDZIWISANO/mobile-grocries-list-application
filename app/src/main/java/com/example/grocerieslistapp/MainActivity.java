package com.example.grocerieslistapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;


import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import android.widget.Toast;


import com.example.grocerieslistapp.adapter.OnRowClick;
import com.example.grocerieslistapp.adapter.RecyclerViewApter;

import com.example.grocerieslistapp.model.Groceries;
import com.example.grocerieslistapp.model.GroceriesViewModel;


import com.example.grocerieslistapp.model.UpdateViewModel;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.jetbrains.annotations.NotNull;


import java.util.List;

public class MainActivity extends AppCompatActivity implements OnRowClick {

    //public static final int GROCERY_FORM_REQUEST = 1;
    //public static final int GROCERY_EDIT_FORM_REQUEST = 2;
    GroceryForm groceryForm;
    //
   private UpdateViewModel updateViewModel;

    private RecyclerView recyclerView;
    private RecyclerViewApter recyclerViewApter;

    private List<Groceries> groceriesList;

    private static final String TAG = "ITEM";
    private GroceriesViewModel groceriesViewModel;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        groceryForm = new GroceryForm();


        recyclerView = findViewById( R.id.recyclerview );
        recyclerView.setHasFixedSize( true );
        recyclerView.setLayoutManager( new LinearLayoutManager( this ) );


        groceriesViewModel = new ViewModelProvider.AndroidViewModelFactory(
                MainActivity.this.getApplication() )
                .create( GroceriesViewModel.class );

        //instatiate update class
        updateViewModel = new ViewModelProvider( this )
                .get( UpdateViewModel.class );


        groceriesViewModel.getAllGroceries().observe( this, groceries -> {

            recyclerViewApter = new RecyclerViewApter( groceries, this );
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

//        recyclerViewApter.setOnRowClickListener( groceries -> {
//            Intent intent = new Intent( MainActivity.this, UpdateGrocery.class);
//            intent.putExtra( "id",  groceries.getItems() );
//            intent.putExtra( "id", groceries.getPrice() );
//            intent.putExtra( "id", groceries.getQuantity() );
//            MainActivity.this.startActivity( intent );
//
//        } );

        FloatingActionButton fab = findViewById( R.id.floataddbtn );
        fab.setOnClickListener( view -> {

            showBottomSheetDialog();

        } );
    }

    private void showBottomSheetDialog() {
        groceryForm.showNow( getSupportFragmentManager(), groceryForm.getTag() );
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


    @Override
    public void editItem(Groceries groceries) {
       //Log.d( "my", "editItem: " + groceries.getId() );
        //GroceriesViewModel.delete( groceries );
        //recyclerViewApter.notifyDataSetChanged();
        updateViewModel.selectedRow(groceries);
        //updateViewModel.setIsEdit( true );
        //Intent intent = new Intent(this, UpdateGrocery.class);
       // startActivity( intent );

//        //Intent intent = new Intent( MainActivity.this, UpdateGrocery.class);
//        intent.putExtra( "id", groceries.getId() );
//        intent.putExtra( "items",  groceries.getItems() );
//        intent.putExtra( "price", groceries.getPrice() );
//        intent.putExtra( "quantity", groceries.getQuantity() );
//        MainActivity.this.startActivity( intent );



    }
}
