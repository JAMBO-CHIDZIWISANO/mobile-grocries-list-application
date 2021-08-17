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
//import com.example.grocerieslistapp.model.Groceries;
//import com.example.grocerieslistapp.model.GroceriesViewModel;

import com.example.grocerieslistapp.model.Groceries;
import com.example.grocerieslistapp.model.GroceriesViewModel;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class GroceryForm extends BottomSheetDialogFragment {

    //variable
    private EditText enterItems;
    private EditText enterPrices;
    private EditText enterQuantity;
    private Button savebtn;


    public GroceryForm() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(
            LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate( R.layout.fragment_grocery_form, container, false );

        enterItems = view.findViewById( R.id.editItem );
        enterPrices = view.findViewById( R.id.editPrice );
        enterQuantity = view.findViewById( R.id.editQuantity );
        savebtn = view.findViewById( R.id.savebtn );

        return view;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);


        savebtn.setOnClickListener( v -> {

            //getting text value from edittext
            String grocery = enterItems.getText().toString().trim();
            String prices = enterPrices.getText().toString().trim();
            String quantity =  enterQuantity.getText().toString().trim();

            if (!grocery.equals( "" )&&!prices.equals( "" )&&!quantity.equals( "" )){

                Groceries groceries = new Groceries(grocery, Float.parseFloat( prices ),Long.parseLong( quantity ));

                GroceriesViewModel.insert( groceries );

                Toast.makeText( requireActivity(), "successfully saved", Toast.LENGTH_SHORT ).show();

            } else {
                Toast.makeText( requireActivity(), "Incomplete information", Toast.LENGTH_LONG ).show();
            }




        });
    }
}