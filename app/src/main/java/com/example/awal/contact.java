package com.example.awal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.PackageManagerCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class contact extends AppCompatActivity {

    private static final int REQUEST_CALL = 1;

    private Button callbutton1,callbutton2,wa1;
    private TextView notelpp1,notelpp2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        notelpp1 = findViewById(R.id.notelp1);
        callbutton1 = findViewById(R.id.telp1);
        wa1 = findViewById(R.id.wa1);
        wa1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String waurl="https://wa.me/+6281522522092?text=Haloo CS Hayat TV";
                Intent intent= new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(waurl));
                startActivity(intent);
            }
        });
        callbutton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ambilcall1();
            }
        });
    }

    private void ambilcall1() {
        String number = notelpp1.getText().toString();
        if ((number.trim().length() > 0)) {
            if (ContextCompat.checkSelfPermission(contact.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(contact.this, new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);
            } else {
                String dial = "tel:" + number;
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_CALL) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                ambilcall1();

            } else {
                Toast.makeText(this, "Ijin Dibatalkan", Toast.LENGTH_SHORT).show();
            }
        }
    }


}