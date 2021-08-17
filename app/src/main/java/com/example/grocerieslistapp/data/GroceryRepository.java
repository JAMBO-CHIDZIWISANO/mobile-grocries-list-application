package com.example.grocerieslistapp.data;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.grocerieslistapp.model.Groceries;
import com.example.grocerieslistapp.utilites.GroceryRoomDatabase;

import java.util.List;

public class GroceryRepository {

    //create a variable for Dao and list all groceries
    private final GroceriesDao groceriesDao;
    private final LiveData<List<Groceries>> allGroceries;

    //create constructor for Dao variable and pass list if groceries
    public GroceryRepository(Application application) {

        GroceryRoomDatabase database = GroceryRoomDatabase.getDatabase(application);
        groceriesDao = database.groceriesDao();
        allGroceries = groceriesDao.getGroceries();
    }

    //method to read  all groceries
    public LiveData<List<Groceries>> getAllGroceries() {
        return allGroceries;
    }

    //method that insert groceries into database
    public void insert(Groceries groceries) {
        GroceryRoomDatabase.databaseWriterExecutor.execute(
                ()-> groceriesDao.insertGroceries( groceries ) );
    }

    //
    public LiveData<Groceries> get(long id) {
        return groceriesDao.get( id );
    }

    //method to update groceries into database
    public void update(Groceries groceries) {
        GroceryRoomDatabase.databaseWriterExecutor.execute(
                ()-> groceriesDao.update( groceries ) );
    }

    //method that delete a specific grocery
    public void delete(Groceries groceries) {
        GroceryRoomDatabase.databaseWriterExecutor.execute(
                ()-> groceriesDao.delete( groceries ) );
    }

    //method that delete all groceries from database
    public void deleteAll() {
        GroceryRoomDatabase.databaseWriterExecutor.execute(
                ()-> groceriesDao.deleteAll());

    }

//    public void totalAmount(Groceries groceries) {
//        GroceryRoomDatabase.databaseWriterExecutor.execute(
//                () -> groceriesDao.totalAmount(groceries));
//    }


}
