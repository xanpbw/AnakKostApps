package com.xan.mvpapp;
//ondate 21/05/2019
//nim: 10116035
//nama:prabowo adi perwira
//kelas:AKB-1(IF-1)
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class KontakTeman extends Fragment implements View.OnClickListener{
    Button btnSimpan, btnTampil;
    EditText nim, nama, kelas, telepon, email, sosmed;
    String sNama,skelas,semail,ssosmed;
    Integer sNim,stelepon;
    Realm realm;
    RealmHelper realmHelper;
    MahasiswaModel mahasiswaModel;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_kontakteman, container, false);
        return view;
    }
    @Override
    public void onViewCreated(View views, @Nullable Bundle savedInstanceState) {
        //Inisialisasi
        btnSimpan = getView().findViewById(R.id.btnSimpan);
        btnTampil = getView().findViewById(R.id.btnTampil);
        nim = getView().findViewById(R.id.nim);
        nama = getView().findViewById(R.id.nama);
        kelas = getView().findViewById(R.id.kelas);
        telepon = getView().findViewById(R.id.telepon);
        email = getView().findViewById(R.id.email);
        sosmed = getView().findViewById(R.id.sosmed);

        //Set up Realm
        Realm.init(getActivity().getApplicationContext());
        RealmConfiguration configuration = new RealmConfiguration.Builder().build();
        realm = Realm.getInstance(configuration);
        btnSimpan.setOnClickListener(KontakTeman.this);
        btnTampil.setOnClickListener(KontakTeman.this);
    }

    public void onClick(View v) {
        if (v == btnSimpan){
            if (!nim.getText().toString().isEmpty() && !nama.getText().toString().isEmpty() && !kelas.getText().toString().isEmpty() && !telepon.getText().toString().isEmpty() && !email.getText().toString().isEmpty() && !sosmed.getText().toString().isEmpty()){
                sNim = Integer.parseInt(nim.getText().toString());
                sNama = nama.getText().toString();
                skelas = kelas.getText().toString();
                stelepon= Integer.parseInt(telepon.getText().toString());
                semail = email.getText().toString();
                ssosmed = sosmed.getText().toString();
                mahasiswaModel = new MahasiswaModel();
                mahasiswaModel.setNim(sNim);
                mahasiswaModel.setNama(sNama);
                mahasiswaModel.setkelas(skelas);
                mahasiswaModel.settelepon(stelepon);
                mahasiswaModel.setemail(semail);
                mahasiswaModel.setsosmed(ssosmed);
                realmHelper = new RealmHelper(realm);
                realmHelper.save(mahasiswaModel);

                Toast.makeText(getActivity(), "Berhasil Disimpan!", Toast.LENGTH_SHORT).show();

                nim.setText("");
                nama.setText("");
                kelas.setText("");
                telepon.setText("");
                email.setText("");
                sosmed.setText("");
            }else {
                Toast.makeText(getActivity(), "Terdapat inputan yang kosong", Toast.LENGTH_SHORT).show();
            }
        }else if (v == btnTampil){
            Intent intent = new Intent(getActivity(), MahasiswaActivity.class);
            startActivity(intent);
        }
    }
}
