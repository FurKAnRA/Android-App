package com.example.yazlab2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Sorgu2 extends AppCompatActivity{
    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();

    List<String> list = new ArrayList<String>();
    int aracSayisi = 0 ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.sorgu2);
        lokasyonGetir();

        Button button = findViewById(R.id.hesaplaButton);
        TextView textView = findViewById(R.id.Sorgu2TextView);
        EditText baslangic = findViewById(R.id.baslangicEdit);
        EditText bitis = findViewById(R.id.bitisEdit);
        EditText lokasyon = findViewById(R.id.lokasyonEdit);

    button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            textView.setText("");
            aracSayisi = 0;


            DatabaseReference dbRef = firebaseDatabase.getReference("Yolculuklar");

            dbRef.addListenerForSingleValueEvent(new ValueEventListener() {

                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    for (DataSnapshot gelenler : snapshot.getChildren()) {
                        long tarih = (long) gelenler.child("tarih").getValue();

                        if (tarih >= Integer.parseInt(String.valueOf(baslangic.getText())) && tarih <= Integer.parseInt(String.valueOf(bitis.getText()))) {
                            long lokasyonId = (long) gelenler.child("lokasyon").getValue();
                            if(String.valueOf(list.get((int)lokasyonId - 1)).equalsIgnoreCase(String.valueOf(lokasyon.getText()))) {
                              //  textView.append(tarih + ".12.2020 tarihinde " + list.get((int) lokasyonId -1) + " dan kalkmıştır\n");
                                aracSayisi++;
                            }
                        }
                    }
                    textView.setText(String.valueOf(aracSayisi));
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        }
    });

    }

    public void lokasyonGetir() {

        DatabaseReference dbRef = firebaseDatabase.getReference("Lokasyonlar");

        dbRef.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot gelenLokasyon : snapshot.getChildren()) {
                    list.add(String.valueOf(gelenLokasyon.child("lokasyonBaslangic").getValue()));

                }

                list.add("Unknown");
                list.add("Unknown");
                list.add("Unknown");
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }







    }







