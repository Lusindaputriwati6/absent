package com.example.absent;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class KelasAdapter extends RecyclerView.Adapter<KelasAdapter.KelasHolder> {
    List<Kelas> kelasnya;
    Activity activity;


    public KelasAdapter(List<Kelas> kelasnya, Activity activity) {
        this.kelasnya = kelasnya;
        this.activity = activity;
    }

    @NonNull
    @Override
    public KelasHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_itemkelas,parent,false);
        return new KelasHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull KelasHolder holder, final int position) {
        holder.nama_kel.setText(kelasnya.get(position).getNama_kel());
        holder.nama_wali.setText(kelasnya.get(position).getWali_kel());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id=kelasnya.get(position).getId();
                Intent pindah=new Intent(activity,SiswaActivity.class);
                pindah.putExtra("idnya",id);
                v.getContext().startActivity(pindah);
            }
        });

    }

    @Override
    public int getItemCount() {
        return kelasnya.size();
    }

    static class KelasHolder extends RecyclerView.ViewHolder{
        TextView nama_kel,nama_wali;

        public KelasHolder(@NonNull View itemView) {
            super(itemView);
            nama_kel=(TextView)itemView.findViewById(R.id.nama_kel);
            nama_wali=(TextView)itemView.findViewById(R.id.wali_kel);

        }
    }

}
