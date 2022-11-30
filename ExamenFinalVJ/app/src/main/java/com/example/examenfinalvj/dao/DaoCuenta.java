package com.example.examenfinalvj.dao;

import androidx.room.Dao;
import androidx.room.Insert;

import com.example.examenfinalvj.entities.Cuenta;

@Dao
public interface DaoCuenta {
    @Insert
    void createCuenta(Cuenta cuenta);


}
