package com.example.examenfinalvj.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "movimiento")
public class Movimiento {
    @PrimaryKey(autoGenerate = true)
    public int idMov;
    public String tipoM;
    public double montoT;
    public String motivo;
    public String imagen;
    public String latitud;
    public String longitud;
}
