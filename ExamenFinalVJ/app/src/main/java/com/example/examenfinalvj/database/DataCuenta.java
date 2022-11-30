package com.example.examenfinalvj.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.examenfinalvj.dao.DaoCuenta;
import com.example.examenfinalvj.entities.Cuenta;

@Database(entities = {Cuenta.class}, version = 1)
public abstract class DataCuenta extends RoomDatabase {
    public abstract DaoCuenta daoCuenta();
    public static Database getInstance(Context context){
        return (Database) Room.databaseBuilder(context, DataCuenta.class, "com.example.examenfinalvj.data_base").allowMainThreadQueries().build();
    }

}
