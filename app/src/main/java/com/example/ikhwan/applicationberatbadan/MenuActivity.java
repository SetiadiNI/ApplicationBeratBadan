package com.example.ikhwan.applicationberatbadan;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.preference.DialogPreference;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener {

    private Button bnMasuk;
    private EditText etNama;
    String varNama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        bnMasuk = (Button) findViewById(R.id.btnMasuk);
        etNama = (EditText) findViewById(R.id.etNama);

        bnMasuk.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (etNama.length() == 0 ) {
            Toast.makeText(this, "Masukkan nama", Toast.LENGTH_SHORT).show();

        } else{
            varNama = etNama.getText().toString();
            Intent intent = null;
            intent = new Intent(getApplicationContext(), IdealActivity.class);

            Bundle b = new Bundle();
            b.putString("parse_nama", varNama);
            intent.putExtras(b);
            startActivity(intent);
        }
    }

    public void onBackPressed(){
        final AlertDialog.Builder builder = new AlertDialog.Builder(MenuActivity.this);
        builder.setMessage("Apakah anda ingin keluar dari aplikasi berat badan?");
        builder.setCancelable(true);
        builder.setNegativeButton("Batal", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
