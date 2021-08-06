package com.example.grocerieslistapp.adapter;


import android.view.LayoutInflater;

import android.view.View;
import android.view.ViewGroup;


import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.grocerieslistapp.R;
import com.example.grocerieslistapp.model.Groceries;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class RecyclerViewApter  extends RecyclerView.Adapter<RecyclerViewApter.ViewHolder> {

    private final List<Groceries> groceriesList;



    public RecyclerViewApter(List<Groceries> groceriesList ) {
        this.groceriesList = groceriesList;

    }


    //called when view holder created
    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from( parent.getContext() )
                .inflate( R.layout.groceries_row, parent, false );
        return new ViewHolder( view );
    }

    //bind groceries or data to the view object
    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder holder, int position) {

        Groceries groceries = groceriesList.get(position);

        //holder.groceries.setText( (int) groceries.getId() );
        holder.groceries.setText( groceries.getItems() );
       //holder.price.setText( (int) groceries.getPrice() );
        //holder.quantity.setText( (int) groceries.getQuantity() );
    }

    @Override
    public int getItemCount() {

        return groceriesList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public AppCompatTextView id;
        public AppCompatTextView groceries;
        public AppCompatTextView price;
        public AppCompatTextView quantity;


        public ViewHolder(@NonNull @NotNull View itemView) {

            super( itemView );

            groceries = itemView.findViewById( R.id.grocery_name );
            price = itemView.findViewById( R.id.price );
            quantity = itemView.findViewById( R.id.quantity );
            id = itemView.findViewById( R.id.grocery_id );
        }
    }
}
