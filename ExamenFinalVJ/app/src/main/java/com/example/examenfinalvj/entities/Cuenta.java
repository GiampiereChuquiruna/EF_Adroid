package com.example.examenfinalvj.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "cuenta")
public class Cuenta {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String nombre;

}
