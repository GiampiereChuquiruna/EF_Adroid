package com.example.examenfinalvj.services;

import com.example.examenfinalvj.entities.Cuenta;
import com.example.examenfinalvj.entities.Movimiento;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface MovimientoService {
    @POST("/Movimiento")
    Call<Void> create(@Body Movimiento movimiento);

    @GET("/Movimiento")
    Call<List<Cuenta>> getAll();
}
