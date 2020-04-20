package com.example.absent;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SiswaAdapter extends RecyclerView.Adapter<SiswaAdapter.SiswaHolder>{

    List<Siswa>siswanya;
    Activity activity;


    public SiswaAdapter(List<Siswa>siswa,Activity activity){
        this.siswanya=siswa;
        this.activity=activity;

    }



    @NonNull
    @Override
    public SiswaHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_itemsiswa,parent,false);
        View view1=LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_absen,parent,false);
        return new SiswaHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SiswaHolder holder, final int position) {
        holder.nisn.setText(siswanya.get(position).getNis());
        holder.nama.setText(siswanya.get(position).getNama());
        holder.absen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(activity,AbsenActivity.class);
                intent.putExtra("idpengab",getItemCount());
                v.getContext().startActivity(intent);
            }
        });
        holder.detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(activity,ProfilSiswa.class);
                intent.putExtra("idsis",siswanya.get(position).getId());
                v.getContext().startActivity(intent);


            }
        });


    }

    @Override
    public int getItemCount() {
        return siswanya.size();
    }


    static class SiswaHolder extends RecyclerView.ViewHolder {
        TextView  nisn, nama;
        Button detail,absen;


        public SiswaHolder(@NonNull View itemView) {
            super(itemView);
            nisn=(TextView)itemView.findViewById(R.id.nis);
            nama=(TextView)itemView.findViewById(R.id.nama_siswa);
            detail=(Button)itemView.findViewById(R.id.btn_detail);
            absen=(Button)itemView.findViewById(R.id.btn_absen);

        }
    }

}
