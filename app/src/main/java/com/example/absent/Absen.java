package com.example.absent;

import java.io.Serializable;

public class Absen implements Serializable {
    private int id;
    private String id_sis;
    private String id_pengab;
    private String fto_srt;
    private String ket;
    private String tgl;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getId_sis() {
        return id_sis;
    }

    public void setId_sis(String id_sis) {
        this.id_sis = id_sis;
    }

    public String getId_pengab() {
        return id_pengab;
    }

    public void setId_pengab(String id_pengab) {
        this.id_pengab = id_pengab;
    }

    public String getFto_srt() {
        return fto_srt;
    }

    public void setFto_srt(String fto_srt) {
        this.fto_srt = fto_srt;
    }

    public String getKet() {
        return ket;
    }

    public void setKet(String ket) {
        this.ket = ket;
    }

    public String getTgl() {
        return tgl;
    }

    public void setTgl(String tgl) {
        this.tgl = tgl;
    }
}
