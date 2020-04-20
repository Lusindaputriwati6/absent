package com.example.absent;

import java.io.Serializable;

public class Siswa implements Serializable {
    private int id;
    private int id_kel;
    private String nis;
    private String nama;
    private String alamat;
    private String jen_kel;
    private String ttl;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_kel() {
        return id_kel;
    }

    public void setId_kel(int id_kel) {
        this.id_kel = id_kel;
    }

    public String getNis() {
        return nis;
    }

    public void setNis(String nis) {
        this.nis = nis;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getJen_kel() {
        return jen_kel;
    }

    public void setJen_kel(String jen_kel) {
        this.jen_kel = jen_kel;
    }

    public String getTtl() {
        return ttl;
    }

    public void setTtl(String ttl) {
        this.ttl = ttl;
    }
}
