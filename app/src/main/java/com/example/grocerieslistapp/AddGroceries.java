package com.example.grocerieslistapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.grocerieslistapp.data.GroceryRepository;
import com.example.grocerieslistapp.model.Groceries;
import com.example.grocerieslistapp.model.GroceriesViewModel;
import com.example.grocerieslistapp.model.SharedViewModel;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AddGroceries#} factory method to
 * create an instance of this fragment.
 */
public class AddGroceries extends BottomSheetDialogFragment {

    //variable
    private EditText enterItems;
    private EditText enterPrices;
    private EditText enterQuantity;
    private Button savebtn;

    private SharedViewModel sharedViewModel;

    public AddGroceries() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(
            LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate( R.layout.groceries_form, container, false );

        enterItems = view.findViewById( R.id.editItem );
        enterPrices = view.findViewById( R.id.editPrice );
        enterQuantity = view.findViewById( R.id.editQuantity );
        savebtn = view.findViewById( R.id.savebtn );

    return view;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        sharedViewModel = new ViewModelProvider( requireActivity() )
                .get( SharedViewModel.class );
        if (sharedViewModel.getSelectedItem().getValue()!=null) {
            Groceries groceries = sharedViewModel.getSelectedItem().getValue();
            Log.d( "MY", "onViewCreated: " + groceries.getItems() );
        }

        savebtn.setOnClickListener( v -> {



            String grocery = enterItems.getText().toString().trim();
            double prices = Double.parseDouble( enterPrices.getText().toString().trim() );
            long qty = Long.parseLong( enterQuantity.getText().toString().trim() );

            if (!TextUtils.isEmpty( grocery )){

                Groceries groceries = new Groceries(grocery, prices, qty);

                GroceriesViewModel.insert( groceries );
            }




        });
    }
}