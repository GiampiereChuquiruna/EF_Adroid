package com.example.examenfinalvj;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.examenfinalvj.adapters.CuentasAdapter;
import com.example.examenfinalvj.entities.Cuenta;
import com.example.examenfinalvj.services.CuentaService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListarActivity extends AppCompatActivity {

    public RecyclerView rvCuenta;
    public Button btnRM,btnVM, btnS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar);

//        btnRM = findViewById(R.layout.item_cuenta);
//        btnRM.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent =  new Intent(getApplicationContext(), FormMovActivity.class);
//                startActivity(intent);
//            }
//        });

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://636b1e7fc07d8f936dae4908.mockapi.io")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        CuentaService service = retrofit.create(CuentaService.class);
        service.getAll().enqueue(new Callback<List<Cuenta>>() {
            @Override
            public void onResponse(Call<List<Cuenta>> call, Response<List<Cuenta>> response) {
                List<Cuenta> data = response.body();
                rvCuenta = findViewById(R.id.rvCuentas);
                rvCuenta.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                rvCuenta.setAdapter(new CuentasAdapter(data));
                //Log.i("Main", "Response" + response.body().size());
                //Log.i("Main", new Gson().toJson(data));
            }

            @Override
            public void onFailure(Call<List<Cuenta>> call, Throwable t) {

            }
        });


    }
}