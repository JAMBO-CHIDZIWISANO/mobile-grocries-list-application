package com.example.grocerieslistapp.model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.grocerieslistapp.data.GroceryRepository;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class GroceriesViewModel extends AndroidViewModel {

    public static GroceryRepository repository;
    public final LiveData<List<Groceries>> allGroceries;


    public GroceriesViewModel(@NonNull @NotNull Application application) {
        super( application );

        repository = new GroceryRepository( application );
        allGroceries = repository.getAllGroceries();


    }

    public LiveData<List<Groceries>> getAllGroceries() {

        return allGroceries;
    }

    public static void insert(Groceries groceries) {

        repository.insert( groceries );

    }

    public LiveData<Groceries> get(long id) {

        return repository.get( id );
    }

    public static void update(Groceries groceries){

        repository.update( groceries );
    }

    public static void delete(Groceries groceries) {

        repository.delete( groceries );
    }

    public static void deleteAll(){
        repository.deleteAll();
    }




}
