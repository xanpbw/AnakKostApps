package com.xan.mvpapp;
//ondate 13/08/2019
//nim: 10116035
//nama:prabowo adi perwira
//kelas:AKB-1(IF-1)
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class DetailActivity extends AppCompatActivity implements View.OnClickListener {
    EditText etNim, etNama, etkelas, ettelepon, etemail, etsosmed;
    String nim, nama, kelas, telepon, sosmed, email;
    Integer id;
    Button btn_ubah, btn_hapus, btn_kembali;
    RealmHelper realmHelper;
    Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // Set up
        Realm.init(this);
        RealmConfiguration configuration = new RealmConfiguration.Builder().build();
        realm = Realm.getInstance(configuration);
        realmHelper = new RealmHelper(realm);

        // Inisialisasi
        etNim = findViewById(R.id.etNim);
        etNama = findViewById(R.id.etNama);
        etkelas = findViewById(R.id.etKelas);
        ettelepon = findViewById(R.id.etTelepon);
        etemail = findViewById(R.id.etEmail);
        etsosmed = findViewById(R.id.etSosmed);
        btn_ubah = findViewById(R.id.btnUpdate);
        btn_hapus = findViewById(R.id.btnHapus);
        btn_kembali = findViewById(R.id.btnCancel);

        id = Integer.parseInt(getIntent().getStringExtra("id"));
        nim = getIntent().getStringExtra("nim");
        nama = getIntent().getStringExtra("nama");
        kelas = getIntent().getStringExtra("kelas");
        telepon = getIntent().getStringExtra("telepon");
        email = getIntent().getStringExtra("email");
        sosmed = getIntent().getStringExtra("sosmed");

        etNim.setText(nim);
        etNama.setText(nama);
        etkelas.setText(kelas);
        ettelepon.setText(telepon);
        etemail.setText(email);
        etsosmed.setText(sosmed);

        btn_kembali.setOnClickListener(this);
        btn_hapus.setOnClickListener(this);
        btn_ubah.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == btn_ubah){
            realmHelper.update(id, Integer.parseInt(etNim.getText().toString()),etNama.getText().toString(),etkelas.getText().toString(), Integer.parseInt(ettelepon.getText().toString()),etemail.getText().toString(),etsosmed.getText().toString());
            Toast.makeText(DetailActivity.this, "Update Success", Toast.LENGTH_SHORT).show();
            etNim.setText("");
            etNama.setText("");
            etkelas.setText("");
            ettelepon.setText("");
            etemail.setText("");
            etsosmed.setText("");
            finish();
        }else if (v == btn_hapus) {
            realmHelper.delete(id);
            Toast.makeText(DetailActivity.this, "Delete Success", Toast.LENGTH_SHORT).show();
            finish();
        }else if (v == btn_kembali) {
            startActivity(new Intent(DetailActivity.this, MahasiswaActivity.class));
            finish();
        }
    }
}
