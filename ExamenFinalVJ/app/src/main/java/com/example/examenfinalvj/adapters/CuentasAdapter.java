package com.example.examenfinalvj.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.examenfinalvj.R;
import com.example.examenfinalvj.entities.Cuenta;

import java.util.List;

public class CuentasAdapter extends RecyclerView.Adapter {

    List<Cuenta> data;

    public CuentasAdapter(List<Cuenta> data){
        this.data = data;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.item_cuenta, parent, false);
        return new cuentaViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        TextView tvNombre = holder.itemView.findViewById(R.id.tvNombre);
        tvNombre.setText(data.get(position).nombre);
    }

    @Override
    public int getItemCount() {
            return data.size();

    }

    class cuentaViewHolder extends RecyclerView.ViewHolder{

        public cuentaViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
