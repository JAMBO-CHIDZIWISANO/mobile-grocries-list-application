package com.example.grocerieslistapp.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

// below line is for setting table name.
@Entity(tableName = "groceries_table")
public class Groceries {

    //auto increment for each id
    @PrimaryKey(autoGenerate = true)
    //id column name
    @ColumnInfo(name = "Item_id")
    public long id;

    //variable for grocery name
    @ColumnInfo(name = "Item_name")
    public String items;

    ////variable for grocery price
    @ColumnInfo(name = "Item_price")
    public float price;

    ////variable for grocery quantity
    @ColumnInfo(name = "items_quantity")
    public long quantity;

    //constructor of the class, id is auto-increment hence are not passed
    public Groceries(String items, float price, long quantity) {
        //passing the class variables

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

    public String getItems() { return items; }

    public void setItems(String items) {
        this.items = items;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(float price) {
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
