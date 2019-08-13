package com.xan.mvpapp;
//ondate 13/08/2019
//nim: 10116035
//nama:prabowo adi perwira
//kelas:AKB-1(IF-1)
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class MahasiswaModel extends RealmObject {

    @PrimaryKey
    private Integer id;
    private Integer nim;
    private Integer telepon;
    private String nama;
    private String kelas;
    private String email;
    private String sosmed;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setNim(Integer nim) {
        this.nim = nim;
    }

    public Integer getNim() {
        return nim;
    }

    public void settelepon(Integer telepon) {
        this.telepon = telepon;
    }

    public Integer gettelepon() {
        return telepon;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }

    public void setkelas(String kelas) {
        this.kelas = kelas;
    }

    public String getkelas() {
        return kelas;
    }

    public void setemail(String email) {
        this.email = email;
    }

    public String getemail() {
        return email;
    }

    public void setsosmed(String sosmed) {
        this.sosmed = sosmed;
    }

    public String getsosmed() {
        return sosmed;
    }
}
