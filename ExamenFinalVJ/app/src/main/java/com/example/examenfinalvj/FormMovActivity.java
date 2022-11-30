package com.example.examenfinalvj;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.examenfinalvj.entities.Cuenta;
import com.example.examenfinalvj.entities.Movimiento;
import com.example.examenfinalvj.services.CuentaService;
import com.example.examenfinalvj.services.MovimientoService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FormMovActivity extends AppCompatActivity {

    private Spinner sp;
    private EditText edtMonto, edtMotivo, edtLat, edtLong, edtUrl;
    private Button btnGuardar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_movimiento);

        sp = findViewById(R.id.spTipo);
        edtMonto = findViewById(R.id.edtMonto);
        edtMotivo = findViewById(R.id.edtMotivo);
        edtLat = findViewById(R.id.edtLat);
        edtLong = findViewById(R.id.edtLong);
        edtUrl = findViewById(R.id.edtUrl);
        btnGuardar = findViewById(R.id.btnGuardar);

        Spinner spinner=findViewById(R.id.spTipo);
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this, R.array.Tipos, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);

        Movimiento movimiento = new Movimiento();

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // movimiento.tipoM = sp.getItemAtPosition().toString();
                movimiento.montoT = Double.parseDouble(edtMonto.getText().toString());
                movimiento.motivo = edtMotivo.getText().toString();
                movimiento.latitud = edtLat.getText().toString();
                movimiento.longitud = edtLong.getText().toString();
                //data.daoCuenta().createCuenta(cuenta);

                Retrofit retrofit = new Retrofit.Builder().baseUrl("https://636b1e7fc07d8f936dae4908.mockapi.io")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                MovimientoService service = retrofit.create(MovimientoService.class);
                service.create(movimiento).enqueue(new Callback<Void>(){

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