package com.example.absent;

import java.io.Serializable;

public class Jurusan implements Serializable {
    private int id;
    private String nama_jur;
    private String kaprog;
    private String logo_jur;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama_jur() {
        return nama_jur;
    }

    public void setNama_jur(String nama_jur) {
        this.nama_jur = nama_jur;
    }

    public String getKaprog() {
        return kaprog;
    }

    public void setKaprog(String kaprog) {
        this.kaprog = kaprog;
    }

    public String getLogo_jur() {
        return logo_jur;
    }

    public void setLogo_jur(String logo_jur) {
        this.logo_jur = logo_jur;
    }
}
