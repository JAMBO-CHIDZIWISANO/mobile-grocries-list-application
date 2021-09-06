package com.example.grocerieslistapp.adapter;


import android.view.LayoutInflater;

import android.view.View;
import android.view.ViewGroup;


import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.grocerieslistapp.R;
import com.example.grocerieslistapp.model.Groceries;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private final List<Groceries> groceriesList;

    private final OnRowClick rowClick;

    //constructor for recycler view adapter class
    public RecyclerViewAdapter(List<Groceries> groceriesList, OnRowClick onRowClick) {
        this.groceriesList = groceriesList;

        this.rowClick = onRowClick;
    }

    //called when view holder created
    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {

        //inflate the layout of our groceries row list
        View view = LayoutInflater.from( parent.getContext() )
                .inflate( R.layout.groceries_row, parent, false );

        return new ViewHolder( view );
    }

    //bind groceries or data to the view object
    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder holder, int position) {


        //set groceries to each item of the recycler view
        Groceries groceries = groceriesList.get( position );

        //this.position = position;
        holder.groceries.setText( groceries.getItems() );

        holder.currency.setText( groceries.getCurrency() );
        holder.currency2.setText( groceries.getCurrency() );

        holder.price.setText( String.valueOf( groceries.getPrice() ) );
        holder.quantity.setText( String.valueOf( groceries.getQuantity()) );

        holder.unit.setText( groceries.getUnit() );


        holder.totalItem.setText( String.valueOf( groceries.getPrice() * groceries.getQuantity() ) );

        float totalAmount = groceries.getPrice() * groceries.getQuantity();
        float sum = 0;
        for (int i=0; i < groceriesList.size(); i++) {

            sum = sum + totalAmount;

            return;
        }


    }

    @Override
    public int getItemCount() {
        return groceriesList.size();
    }

    // a method to get groceries for a specific position.
    public Groceries getGroceriesAt(int position) {
        return groceriesList.get( position );
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        // view holder class to create a variable for each view.
        public AppCompatTextView groceries;
        public AppCompatTextView currency;
        public AppCompatTextView price;
        public AppCompatTextView quantity;
        public AppCompatTextView unit;
        public AppCompatTextView totalItem;

        public AppCompatImageButton editbtn;

        public AppCompatTextView currency2;



        OnRowClick onRowClick;

        public ViewHolder(@NonNull @NotNull View itemView) {
            super( itemView );

            // initializing each view of the recycler view.
            groceries = itemView.findViewById( R.id.grocery_name );
            currency = itemView.findViewById( R.id.currency );
            price = itemView.findViewById( R.id.price );
            quantity = itemView.findViewById( R.id.quantity );
            unit = itemView.findViewById( R.id.unit_view );
            totalItem = itemView.findViewById( R.id.totals );

            editbtn = itemView.findViewById( R.id.edit_grocery);

            currency2 = itemView.findViewById( R.id.currency2 );


            this.onRowClick = rowClick;


            editbtn.setOnClickListener( this );

        }

        @Override
        public void onClick(View v) {

            int id = v.getId();
            if (id==R.id.edit_grocery) {
                Groceries currGrocery = groceriesList.get( getAbsoluteAdapterPosition() );
                onRowClick.editItem(  currGrocery );
            }
        }
    }


}



