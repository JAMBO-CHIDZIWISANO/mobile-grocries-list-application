package com.example.grocerieslistapp.data;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.grocerieslistapp.model.Groceries;

public class UpdateViewModel extends ViewModel {

    public boolean isEdit;
    public final MutableLiveData<Groceries> selectedGrocery = new MutableLiveData<>();
    public void selectedGrocery(Groceries grocery) {
        selectedGrocery.setValue( grocery );
    }
    public LiveData<Groceries> getSelectedGrocery() {
        return selectedGrocery;
    }
    public void setIsEdit(boolean isEdit){
        this.isEdit = isEdit;
    }
    public boolean getIsEdit(){
        return isEdit;
    }
}
