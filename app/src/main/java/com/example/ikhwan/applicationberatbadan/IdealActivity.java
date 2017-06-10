package com.example.ikhwan.applicationberatbadan;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class IdealActivity extends AppCompatActivity {

    private EditText etBerat;
    private EditText etTinggi;
    private TextView etnama;
    private Button btnKalkulasi;
    private Button btnKembali;
    String get_nama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ideal);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        etnama = (TextView) findViewById(R.id.nama);
        etBerat = (EditText) findViewById(R.id.etBerat);
        etTinggi = (EditText) findViewById(R.id.etTinggi);
        btnKalkulasi = (Button) findViewById(R.id.btnKalkulasi);
        btnKembali = (Button) findViewById(R.id.btnKembali);

        Bundle b = getIntent().getExtras();

        get_nama = b.getString("parse_nama");
        etnama.setText("Haii " +get_nama+ " ,Masukkan berat badan dan tinggi anda.");

        btnKembali.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(IdealActivity.this, MenuActivity.class));
                finish();
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void doKalkulasi(View v) {
        if (etBerat.length() == 0 || etTinggi.length() == 0 ) {
            Toast.makeText(this, "Masukkan Berat Badan/Tinggi Anda", Toast.LENGTH_SHORT).show();
        }else{
                float Berat = Float.parseFloat(etBerat.getText().toString());
                float Tinggi = Float.parseFloat(etTinggi.getText().toString());
                String rt = "Ideal";
                float ideal = (float)(Tinggi - 100) - ((float)0.1 * (Tinggi - 100));
                if (Berat > ideal) {
                    float Persen = ((float)Berat / ideal * 100)-100;
                    if (Persen>9 && Persen<21) {
                        rt = "Kelebihan Berat Badan";
                    }
                    else if (Persen > 20) {
                        rt = "Kegemukan";
                    }
                }
                else if (Berat < ideal) {
                    float Persen = ((float)ideal/Berat*100) - 100;
                    if (Persen>9) {
                        rt = "Kurus";
                    }
                }
                Toast.makeText(this, "Anda : " + rt, Toast.LENGTH_LONG).show();
        }
    }


    public void BackMainMenu(View view){
        finish();
    }
}


