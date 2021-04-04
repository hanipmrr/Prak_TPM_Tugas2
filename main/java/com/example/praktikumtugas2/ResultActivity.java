package com.example.praktikumtugas2;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView txtNama      = findViewById(R.id.nama);
        TextView txtNIM       = findViewById(R.id.nim);
        TextView txtPredikat  = findViewById(R.id.predikat);

        Bundle extras   = getIntent().getExtras();

        String nama = extras.getString("NAMA");
        txtNama.setText(String.format(": %s", nama));

        String nim     = extras.getString("NIM");
        txtNIM.setText(String.format(": %s",nim));

        String hasil     = extras.getString("PREDIKAT");
        txtPredikat.setText(String.format(": %s",hasil));

    }
}
