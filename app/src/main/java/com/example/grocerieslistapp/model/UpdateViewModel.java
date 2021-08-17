package com.example.grocerieslistapp.model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.grocerieslistapp.R;

public class UpdateViewModel extends ViewModel {

    private final MutableLiveData<Groceries>
            selectedRow = new MutableLiveData<>();

    private boolean isEdit;

    public void selectedRow(Groceries groceries) {

        selectedRow.setValue( groceries );
    }

    public LiveData<Groceries> getSelectedRow() {

        return selectedRow;
    }

    public void setIsEdit(boolean isEdit) {
        this.isEdit = isEdit;
    }

    public boolean getIsEdit(){
        return isEdit;
    }


}
