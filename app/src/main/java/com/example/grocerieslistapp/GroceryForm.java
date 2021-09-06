package com.example.grocerieslistapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;



import com.example.grocerieslistapp.data.UpdateViewModel;
import com.example.grocerieslistapp.model.Groceries;
import com.example.grocerieslistapp.model.GroceriesViewModel;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class GroceryForm extends BottomSheetDialogFragment {

    //variable

    private EditText enterItems;
    private Spinner selectCurrency;
    private EditText enterPrices;
    private EditText enterQuantity;
    private Spinner selectUnit;
    private Button savebtn;

    private UpdateViewModel updateViewModel;
    private boolean isEdit;


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

        selectCurrency = view.findViewById( R.id.currency_spinner );
        ArrayAdapter<String> currencyAdapter = new ArrayAdapter<>(requireActivity(),
                android.R.layout.simple_list_item_1,
                getResources().getStringArray( R.array.currency_spinners ));
        currencyAdapter.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item );
        selectCurrency.setAdapter( currencyAdapter );

        selectUnit = view.findViewById( R.id.unit_spinner );
        ArrayAdapter<String> unitAdapter = new ArrayAdapter<>(requireActivity(),
                android.R.layout.simple_list_item_1,
                getResources().getStringArray( R.array.unit_spinners ));
        unitAdapter.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item );
        selectUnit.setAdapter( unitAdapter );

        enterItems = view.findViewById( R.id.editItem );
        enterPrices = view.findViewById( R.id.editPrice );
        enterQuantity = view.findViewById( R.id.editQuantity );

       //enterUnit = view.findViewById( R.id.unit_spinner );
        //enterCurrency = view.findViewById( R.id.currency_spinner );
        savebtn = view.findViewById( R.id.savebtn );


        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (updateViewModel.getSelectedGrocery().getValue() != null) {
            isEdit = updateViewModel.getIsEdit();
            Groceries groceries = updateViewModel.getSelectedGrocery().getValue();
            enterItems.setText( groceries.getItems() );
           // enterPrices.setText(  groceries.Float.parseFloat() );
            //enterQuantity.setText(  groceries.getQuantity() );
            selectUnit.getSelectedItem();
            selectCurrency.getSelectedItem();
        }
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        updateViewModel = new ViewModelProvider( requireActivity() )
                .get( UpdateViewModel.class );


        savebtn.setOnClickListener( this::onClick );
    }

    private void onClick(View v) {

        //getting text value from edittext
        String grocery = enterItems.getText().toString().trim();
        String prices = enterPrices.getText().toString().trim();
        String quantity = enterQuantity.getText().toString().trim();
        String currency = selectCurrency.getSelectedItem().toString().trim();
        String unit = selectUnit.getSelectedItem().toString().trim();

        if (!grocery.equals( "" ) && !prices.equals( "" ) && !quantity.equals( "" )) {

            Groceries groceries = new Groceries( grocery, currency, Float.parseFloat( prices ),
                    Long.parseLong( quantity ), unit );

            if (isEdit) {
                Groceries updateGroceries = updateViewModel.getSelectedGrocery().getValue();
                assert updateGroceries != null;
                updateGroceries.setItems( grocery );
                updateGroceries.setCurrency( currency );
                updateGroceries.setPrice( Float.parseFloat( prices ) );
                updateGroceries.setQuantity( Long.parseLong( quantity ) );
                updateGroceries.setUnit( unit );

                GroceriesViewModel.updateGrocery( updateGroceries );

                enterItems.setText( "" );
                enterPrices.setText( "" );
                enterQuantity.setText( "" );

                dismiss();
                Toast.makeText( requireActivity(), "successfully updated", Toast.LENGTH_SHORT ).show();

                updateViewModel.setIsEdit( false );
            } else {
                GroceriesViewModel.insertGrocery( groceries );
                enterItems.setText( "" );
                enterPrices.setText( "" );
                enterQuantity.setText( "" );

                //dismiss();
                Toast.makeText( requireActivity(), "successfully saved", Toast.LENGTH_SHORT ).show();
            }

            enterItems.setText( "" );


        } else {
            Toast.makeText( requireActivity(), "Incomplete information", Toast.LENGTH_LONG ).show();
        }


    }
}