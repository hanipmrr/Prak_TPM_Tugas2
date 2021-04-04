package com.example.praktikumtugas2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnSubmit    = findViewById(R.id.btn_submit);
        EditText etNama     = findViewById(R.id.et_name);
        EditText etNIM      = findViewById(R.id.et_nim);
        EditText etSkor     = findViewById(R.id.et_skor);

        btnSubmit.setOnClickListener(v -> {
            try {
                String nama    = etNama.getText().toString();
                String nim     = etNIM.getText().toString();
                String score   = etSkor.getText().toString();
                Intent i = new Intent(MainActivity.this, ResultActivity.class);
                i.putExtra("NAMA", nama);
                i.putExtra("NIM", nim);
                double skor   = Double.parseDouble(score);

                if(skor <= 4.00){
                    if(skor > 3.66 && skor <= 4.00){
                        i.putExtra("PREDIKAT", "A");
                    }else if(skor > 3.33 && skor <= 3.66) {
                        i.putExtra("PREDIKAT", "A-");
                    }else if(skor > 3.00 && skor <= 3.33) {
                        i.putExtra("PREDIKAT", "B+");
                    }else if(skor > 2.66 && skor <= 3.00) {
                        i.putExtra("PREDIKAT", "B");
                    }else if(skor > 2.33 && skor <= 2.66) {
                        i.putExtra("PREDIKAT", "B-");
                    }else if(skor > 2.00 && skor <= 2.33) {
                        i.putExtra("PREDIKAT", "C+");
                    }else if(skor > 1.66 && skor <= 2.00) {
                        i.putExtra("PREDIKAT", "C");
                    }else if(skor > 1.33 && skor <= 1.66) {
                        i.putExtra("PREDIKAT", "C-");
                    }else if(skor > 1.00 && skor <= 1.33) {
                        i.putExtra("PREDIKAT", "D+");
                    }else {
                        i.putExtra("PREDIKAT", "D");
                    }
                    startActivity(i);
                }else {
                    Toast.makeText(getApplication(), "Nilai tidak boleh di atas 4.00!", Toast.LENGTH_SHORT).show();
                }
            }catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(getApplication(), "Field tidak boleh kosong!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}