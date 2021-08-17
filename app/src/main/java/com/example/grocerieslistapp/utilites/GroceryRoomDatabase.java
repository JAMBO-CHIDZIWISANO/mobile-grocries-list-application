package com.example.grocerieslistapp.utilites;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.grocerieslistapp.data.GroceriesDao;
import com.example.grocerieslistapp.model.Groceries;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//annotation for database entities and version
@Database( entities = {Groceries.class}, version = 1, exportSchema = false)
public abstract class GroceryRoomDatabase extends RoomDatabase {

    public static final int NUMBER_OF_THREADS = 4;
    public static GroceryRoomDatabase getDatabase;

    //instance for the database class
    private static volatile GroceryRoomDatabase INSTANCE;

    // database name
    public static final String DATABASE_NAME = "groceries_database";
    public static final ExecutorService databaseWriterExecutor
            = Executors.newFixedThreadPool( NUMBER_OF_THREADS );

    //creating call back for room database
    public static final Callback sRoomDatabaseCallback =
            new Callback() {
                @Override
                public void onCreate(@NonNull @NotNull SupportSQLiteDatabase db) {
                    super.onCreate( db );
                    databaseWriterExecutor.execute( () -> {
                        //invoke Dao and write
                        GroceriesDao groceriesDao = INSTANCE.groceriesDao();
                        groceriesDao.deleteAll(); // clean state

                    } );
                }
            };

    //getting instance for the database
    public static GroceryRoomDatabase getDatabase (Context context){

        //check if instance is null or not
        if(INSTANCE==null) {
            synchronized (GroceryRoomDatabase.class) {
                if (INSTANCE==null) {

                    //if instance is null, create new database
                    INSTANCE = Room.databaseBuilder( context.getApplicationContext(),
                            GroceryRoomDatabase.class, DATABASE_NAME)
                            .addCallback( sRoomDatabaseCallback )
                            .build();
                }
            }
        }

        //return instance after creating it
        return INSTANCE;
    }

    //creating abstract variable for Dao
    public abstract GroceriesDao groceriesDao();
}
