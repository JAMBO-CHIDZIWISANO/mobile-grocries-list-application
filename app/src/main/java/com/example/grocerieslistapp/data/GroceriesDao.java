package com.example.grocerieslistapp.data;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.grocerieslistapp.model.Groceries;

import java.util.List;

//annotation for Dao class
@Dao
public interface GroceriesDao {

    @Insert
    void insertGroceries(Groceries groceries);


    //get the list of all groceries from database


    @Update
    void updateGrocery(Groceries groceries);

    //get the list of all groceries from database
    @Query("SELECT * FROM groceries_table")
    LiveData<List<Groceries>> getGroceries();

    //get a specific grocery from database
    @Query( "SELECT * FROM groceries_table " +
            "WHERE groceries_table.Item_id ==:item_id" )

    LiveData<Groceries> get(long item_id);

    //delete all from grocery items table
    @Query( "DELETE FROM groceries_table" )
    void deleteAllGroceryItems();

    //delete specific grocery in database
    @Delete
    void delete(Groceries groceries);



    //@Query( "SELECT  SUM(Item_price * items_quantity) FROM groceries_table AS amount;" )
   // void totalAmount( float Item_price, int items_quantity);

}
