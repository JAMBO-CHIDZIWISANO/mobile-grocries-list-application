package com.example.grocerieslistapp.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

// below line is for setting table name.
@Entity(tableName = "groceries_table")
public class Groceries {

    //auto increment for each id
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "Item_id")
    public long id;

    //variable for grocery name
    @ColumnInfo(name = "Item_name")
    public String items;

    //variable for currency
    @ColumnInfo(name = "currency_name")
    public String currency;

    ////variable for grocery price
    @ColumnInfo(name = "Item_price")
    public float price;

    ////variable for grocery quantity
    @ColumnInfo(name = "items_quantity")
    public long quantity;

    //variable for quantity unit
    @ColumnInfo(name = "quantity_unit")
    public String unit;

    //foreign key for categories table



    //constructor of the class, id is auto-increment hence are not passed
    public Groceries(String items, String currency, float price, long quantity, String unit) {
        this.items = items;
        this.currency = currency;
        this.price = price;
        this.quantity = quantity;
        this.unit = unit;

    }

// --Commented out by Inspection START (27/08/2021 1:06 AM):
//    public long getId() {
//        return id;
//    }
// --Commented out by Inspection STOP (27/08/2021 1:06 AM)

    public void setId(long id) {
        this.id = id;
    }

    public String getItems() {
        return items;
    }

    public void setItems(String items) {
        this.items = items;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public float getPrice() {
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

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }




    //override with toString


    @NotNull
    @Override
    public String toString() {
        return "Groceries{" +
                "id=" + id +
                ", items='" + items + '\'' +
                ", currency='" + currency + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", unit='" + unit + '\'' +


                '}';
    }
}
