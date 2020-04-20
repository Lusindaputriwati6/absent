package com.example.absent;

import java.io.Serializable;

public class Kelas implements Serializable {
    private int id;
    private int id_jur;
    private String nama_kel;
    private String wali_kel;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_jur() {
        return id_jur;
    }

    public void setId_jur(int id_jur) {
        this.id_jur = id_jur;
    }

    public String getNama_kel() {
        return nama_kel;
    }

    public void setNama_kel(String nama_kel) {
        this.nama_kel = nama_kel;
    }

    public String getWali_kel() {
        return wali_kel;
    }

    public void setWali_kel(String wali_kel) {
        this.wali_kel = wali_kel;
    }
}



