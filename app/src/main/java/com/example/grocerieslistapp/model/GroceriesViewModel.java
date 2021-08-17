package com.example.grocerieslistapp.model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.grocerieslistapp.data.GroceryRepository;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class GroceriesViewModel extends AndroidViewModel {

    //new variable for groceries repository
    public static GroceryRepository repository;

    //variable for live data where all groceries are present
    public final LiveData<List<Groceries>> allGroceries;

    //constructor for grocery view model
    public GroceriesViewModel(@NonNull @NotNull Application application) {
        super( application );
        repository = new GroceryRepository( application );
        allGroceries = repository.getAllGroceries();
    }

    //method to get all groceries in the list
    public LiveData<List<Groceries>> getAllGroceries() {
        return allGroceries;
    }

    //method used to insert groceries into the repository
    public static void insert(Groceries groceries) {
        repository.insert( groceries );
    }

    //method to get groceries id in the repository
    public LiveData<Groceries> get(long id) {
        return repository.get( id );
    }

    //method for updating data in the repository
    public static void update(Groceries groceries){
        repository.update( groceries );
    }

    //method that delete specific grocery in repository
    public static void delete(Groceries groceries) {
        repository.delete( groceries );
    }

    //method that delete all groceries from the list
    public static void deleteAll(){
        repository.deleteAll();
    }

//    public static void totalAmount(Groceries groceries) {repository.totalAmount(groceries);}




}
