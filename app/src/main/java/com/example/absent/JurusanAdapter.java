package com.example.absent;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

class JurusanAdapter extends RecyclerView.Adapter<JurusanAdapter.JurusanHolder> {

    List<Jurusan>jurusans;
    Activity activity;

    public JurusanAdapter(List<Jurusan>jurusans,Activity activity){
        this.jurusans=jurusans;
        this.activity=activity;
    }

    @NonNull
    @Override
    public JurusanHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from((parent.getContext())).inflate(R.layout.rv_item,parent,false);
        return new JurusanHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull JurusanHolder holder, final int position) {
        holder.nama_jur.setText(jurusans.get(position).getNama_jur());
        holder.kaprog.setText(jurusans.get(position).getKaprog());
        Picasso.with(activity).load(jurusans.get(position).getLogo_jur()).into(holder.logo_jur);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int jur=jurusans.get(position).getId();
                Intent pindah=new Intent(activity,KelasActivity.class);
                pindah.putExtra("idnya",jur);
                v.getContext().startActivity(pindah);
            }
        });

    }

    @Override
    public int getItemCount() {
        return jurusans.size();
    }

    static class JurusanHolder extends RecyclerView.ViewHolder{
        TextView nama_jur,kaprog;
        ImageView logo_jur;

        public JurusanHolder(@NonNull View itemView) {
            super(itemView);
            nama_jur=(TextView)itemView.findViewById(R.id.nama_jur);
            kaprog=(TextView)itemView.findViewById(R.id.kaprog);
            logo_jur=(ImageView)itemView.findViewById(R.id.logo_jur);
        }
    }

}
