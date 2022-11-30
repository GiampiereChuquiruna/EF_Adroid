package com.example.examenfinalvj;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.examenfinalvj.database.DataCuenta;
import com.example.examenfinalvj.entities.Cuenta;
import com.example.examenfinalvj.services.CuentaService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FormActivity extends AppCompatActivity {

    private EditText edtNombre;
    private Button btnCreate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        edtNombre = findViewById(R.id.edtNombre);
        btnCreate = findViewById(R.id.btnCreate);

        Cuenta cuenta = new Cuenta();
        //DataCuenta data = DataCuenta.getInstance(this);


        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cuenta.nombre =edtNombre.getText().toString();
                //data.daoCuenta().createCuenta(cuenta);

                Retrofit retrofit = new Retrofit.Builder().baseUrl("https://636b1e7fc07d8f936dae4908.mockapi.io")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                CuentaService service = retrofit.create(CuentaService.class);
                service.crear(cuenta).enqueue(new Callback<Void>(){

                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        Log.i("MAIN_APP", "RESPONSE" + response.code());
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {

                    }
                });
            }
        });
    }
}