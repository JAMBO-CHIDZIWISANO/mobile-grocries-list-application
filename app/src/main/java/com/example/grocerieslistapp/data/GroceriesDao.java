package com.example.grocerieslistapp.data;



import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.grocerieslistapp.model.Groceries;

import java.util.List;

@Dao
public interface GroceriesDao {

    //insert groceries
    @Insert
    void insertGroceries(Groceries groceries);

    //delete all groceries
    @Query( "DELETE FROM groceries_table" )
    void deleteAll();

    //get list of groceries
    @Query("SELECT * FROM groceries_table")
    LiveData<List<Groceries>> getGroceries();

    //get a grocery
    @Query( "SELECT * FROM groceries_table " +
            "WHERE groceries_table.Item_id ==:id" )
    LiveData<Groceries> get(long id);

    //update a grocery
    @Update
    void update(Groceries groceries);

    //delete a grocery
    @Delete
    void delete(Groceries groceries);
}
