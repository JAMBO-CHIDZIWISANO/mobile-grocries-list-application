package com.example.grocerieslistapp.model;

import android.widget.EditText;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

@Entity(tableName = "groceries_table")
public class Groceries {

    @ColumnInfo(name = "Item_id")
    @PrimaryKey(autoGenerate = true)
    public long id;

    @ColumnInfo(name = "Item_name")
    public String items;

    @ColumnInfo(name = "Item_price")
    public double price;

    @ColumnInfo(name = "items_quantity")
    public long quantity;

    //constructor

    public Groceries(String items, double price, long quantity) {
        this.items = items;
        this.price = price;
        this.quantity = quantity;
    }



    //getters and setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getItems() {
        
        return items;
    }

    public void setItems(String items) {
        this.items = items;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    //override with toString

    @NotNull
    @Override
    public String toString() {
        return "Groceries{" +
                "id=" + id +
                ", items='" + items + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
