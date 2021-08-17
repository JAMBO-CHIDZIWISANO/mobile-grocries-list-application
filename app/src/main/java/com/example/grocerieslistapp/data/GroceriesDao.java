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


    //insert groceries into database
    @Insert
    void insertGroceries(Groceries groceries);

    //delete all groceries in database
    @Query( "DELETE FROM groceries_table" )
    void deleteAll();

    //get the list of all groceries from database
    @Query("SELECT * FROM groceries_table")
    LiveData<List<Groceries>> getGroceries();

    //get a specific grocery from database
    @Query( "SELECT * FROM groceries_table " +
            "WHERE groceries_table.Item_id ==:id" )
    LiveData<Groceries> get(long id);

    //update groceries in database
    @Update
    void update(Groceries groceries);

    //delete specific grocery in database
    @Delete
    void delete(Groceries groceries);


    //@Query( "SELECT  SUM(Item_price * items_quantity) FROM groceries_table AS amount;" )
    //void totalAmount( Groceries groceries);

}
