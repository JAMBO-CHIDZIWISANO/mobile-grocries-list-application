package com.example.grocerieslistapp.adapter;


import android.content.Intent;
import android.view.LayoutInflater;

import android.view.View;
import android.view.ViewGroup;


import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.grocerieslistapp.MainActivity;
import com.example.grocerieslistapp.R;
//import com.example.grocerieslistapp.UpdateGrocery;
import com.example.grocerieslistapp.model.Groceries;
import com.example.grocerieslistapp.model.GroceriesViewModel;

import org.jetbrains.annotations.NotNull;

import java.util.List;

//@SuppressWarnings("ALL")
public class RecyclerViewApter extends RecyclerView.Adapter<RecyclerViewApter.ViewHolder> {

    private final List<Groceries> groceriesList;
    private final OnRowClick rowClick;

    //4
    //int position;

    //constructor for recycler view adapter class
    public RecyclerViewApter(List<Groceries> groceriesList, OnRowClick onRowClick) {
        this.groceriesList = groceriesList;

        //this.listener = onRowClick;
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
        holder.price.setText( String.valueOf( groceries.getPrice() ) );
        holder.quantity.setText( String.valueOf( groceries.getQuantity() ) );
        holder.totalItem.setText( String.valueOf( groceries.getPrice() * groceries.getQuantity() ) );


        //if (position == groceriesList.size()-1){
        //    float totalCost = 0;
         //   for(int i=0; i<groceriesList.size(); i++){
                //totalCost = totalCost + groceries.getPrice();
            //}

//        holder.amount.setText(  String.valueOf( totalCost ));
       //}


        //edit
        //3
//        holder.main_layout.setOnClickListener( new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Intent intent = new Intent( MainActivity.class,UpdateGrocery.class);
//                intent.putExtra( "id",  groceries.getItems() );
//                intent.putExtra( "id", groceries.getPrice() );
//                intent.putExtra( "id", groceries.getQuantity() );
//                MainActivity.
//
//            }
//        } );


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
        public AppCompatTextView price;
        public AppCompatTextView quantity;
        public AppCompatTextView totalItem;

        public AppCompatImageButton editbtn;


        public AppCompatTextView totalAmount;

        public AppCompatTextView amount;

        OnRowClick onRowClick;

        public ViewHolder(@NonNull @NotNull View itemView) {
            super( itemView );

            // initializing each view of the recycler view.
            groceries = itemView.findViewById( R.id.grocery_name );
            price = itemView.findViewById( R.id.price );
            quantity = itemView.findViewById( R.id.quantity );
            totalItem = itemView.findViewById( R.id.totals );
            editbtn = itemView.findViewById( R.id.edit_grocery);

            amount = itemView.findViewById( R.id.textView3 );

            this.onRowClick = rowClick;



            //editbtn.setOnClickListener( this );
            //2
//            main_layout = itemView.findViewById( R.id.row );
//
//            itemView.setOnClickListener( new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    int position = getAdapterPosition();
//                    if (listener != null && position != RecyclerView.NO_POSITION) {
//                        listener.editItem( getGroceriesAt( position ) );
//                    }
//                }
//            } );
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


