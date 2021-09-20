package com.example.yazlab2;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    FirebaseDatabase db = FirebaseDatabase.getInstance();
    ArrayList<String> list = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button Sorgu1Button = findViewById(R.id.Sorgu1Button);
        Button Sorgu2Button = findViewById(R.id.Sorgu2Button);



        Sorgu1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, Sorgu1.class);

                startActivity(intent);


            }
        });

        Sorgu2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, Sorgu2.class);
                startActivity(intent);

            }
        });


    }


    public void kaydet() {
        int i;

        for (i = 1; i < 264; i++) {

            DatabaseReference dbRef = db.getReference("Lokasyonlar");
            String key = dbRef.push().getKey();
            DatabaseReference dbRefYeni = db.getReference("Lokasyonlar/" + key);
        }
    }


}