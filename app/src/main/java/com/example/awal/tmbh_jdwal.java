package com.example.awal;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class tmbh_jdwal extends AppCompatActivity {
    EditText textnama, jam, kategori;
    Button simpan, kembali;

    private Uri filepath;
    private DatabaseReference DBkoneksi;
    private String JadwalMinggu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tmbh_jdwal);

    textnama = findViewById(R.id.nama);
    jam = findViewById(R.id.jam);
    kategori = findViewById(R.id.kategoriminggu);

    simpan = findViewById(R.id.inputt);
    kembali = findViewById(R.id.kembalii);

    DBkoneksi = FirebaseDatabase.getInstance().getReference("Jadwalminggu");
    JadwalMinggu = DBkoneksi.push().getKey();

    simpan.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            simpandata();
            finish();
        }
    });

    }

    private void simpandata() {
        Jadwal_minggu jadwal = new Jadwal_minggu(JadwalMinggu, textnama.getText().toString(),jam.getText().toString(), kategori.getText().toString());
        DBkoneksi.child(JadwalMinggu).setValue(jadwal);
    }
}