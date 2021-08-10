package com.example.grocerieslistapp.model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SharedViewModel extends ViewModel {
    private final MutableLiveData<Groceries> selectedItem = new MutableLiveData<>();

    public void setSelectedItem(Groceries groceries) {
        selectedItem.setValue( groceries );
    }

    public LiveData<Groceries>getSelectedItem() {
        return selectedItem;
    }
}
