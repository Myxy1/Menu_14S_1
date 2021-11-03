package com.example.menu_14s_1;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    private Button buttonMentes;
    private EditText editTextNev;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        init();
        buttonMentes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editTextNev.getText().toString().equals(""))
                    Toast.makeText(MainActivity2.this, "Nincs beírva név", Toast.LENGTH_SHORT).show();
                else {
                    //belehelyeztük az értéket a Data.xml-be
                    //String nev = "Név"
                    editor.putString("nev", editTextNev.getText().toString());
                    //Véglegesítés commit == apply
                    //commit vissza ad egy boolean értéket, ha sikeres true, ha nem sikerült akkor false
                    //apply nem ad vissza semmit
                    //editor.commit();
                    editor.apply();
                    Toast.makeText(MainActivity2.this, "Sikeres adatfelvétel", Toast.LENGTH_SHORT).show();

                    //vissza lépés az előző Activity-re
                    Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                    startActivity(intent);
                    //BackStack !!!
                    finish();
                }
            }
        });
    }

    public void init() {
        buttonMentes = findViewById(R.id.buttonMentes);
        editTextNev = findViewById(R.id.editTextNev);
        sharedPreferences = getSharedPreferences("Data", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }
}