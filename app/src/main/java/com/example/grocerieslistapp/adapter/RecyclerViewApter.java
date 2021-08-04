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

    public RecyclerViewApter(List<Groceries> groceriesList) {
        this.groceriesList = groceriesList;
    }


    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from( parent.getContext() )
                .inflate( R.layout.groceriese_row, parent, false );
        return new ViewHolder( view );
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public AppCompatTextView groceries;


        public ViewHolder(@NonNull @NotNull View itemView) {
            super( itemView );
        }
    }
}
