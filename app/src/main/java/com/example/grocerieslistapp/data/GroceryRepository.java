package com.example.grocerieslistapp.data;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.grocerieslistapp.model.Groceries;
import com.example.grocerieslistapp.utilites.GroceryRoomDatabase;

import java.util.List;

public class GroceryRepository {
    private final GroceriesDao groceriesDao;
    private final LiveData<List<Groceries>> allGroceries;

    public GroceryRepository(Application application) {

        GroceryRoomDatabase database = GroceryRoomDatabase.getDatabase(application);
        groceriesDao = database.groceriesDao();
        allGroceries = groceriesDao.getGroceries();
    }

    public LiveData<List<Groceries>> getAllGroceries() {
        return allGroceries;
    }

    public void insert(Groceries groceries) {
        GroceryRoomDatabase.databaseWriterExecutor.execute(
                ()-> groceriesDao.insertGroceries( groceries ) );
    }

    public LiveData<Groceries> get(long id) {

        return groceriesDao.get( id );
    }

    public void update(Groceries groceries) {
        GroceryRoomDatabase.databaseWriterExecutor.execute(
                ()-> groceriesDao.update( groceries ) );
    }

    public void delete(Groceries groceries) {
        GroceryRoomDatabase.databaseWriterExecutor.execute(
                ()-> groceriesDao.delete( groceries ) );
    }
   public void deleteAll() {
        GroceryRoomDatabase.databaseWriterExecutor.execute(
                ()-> groceriesDao.deleteAll());

   }

}
