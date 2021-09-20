package com.example.yazlab2;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Arrays;

public class Sorgu1 extends  AppCompatActivity {
    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    int i  = 0 ;

    double mesafe [] = new double[1000];
    Long tarih [] = new Long[1000];


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sorgu1);

        TextView textView = findViewById(R.id.mesafeText);

        kayıtlarıGetir(textView);

    }

    public void kayıtlarıGetir(TextView textView){

        DatabaseReference dbRef = firebaseDatabase.getReference("Yolculuklar");

        dbRef.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot gelenler: snapshot.getChildren()) {

                  mesafe[i] = Float.parseFloat(String.valueOf(gelenler.child("mesafe").getValue())) ;
                  tarih[i] = (Long) gelenler.child("tarih").getValue();
                  i = i+1;
                }
                 double temp [] = new double[1000];
                for(int x = 0 ; x < 1000 ; x++){
                    temp[x] = mesafe[x];
                }
                Arrays.sort(temp);
                double[] top5 = Arrays.copyOfRange(temp, temp.length-5,temp.length);
                //System.out.println(Arrays.toString(top5));

                for(int x = 0 ; x < 1000 ; x++){
                    if(mesafe[x] == top5[0]){
                        top5[0]= Math.floor(top5[0]* 100) / 100;
                        textView.append("En uzun 5. mesafe  " +top5[0] + " km'dir. Bu seyahat " + tarih[x] + ".12.2020 tarihinde yapılmıştır.\n\n");

                    }
                     if (mesafe[x] == top5[1]){
                         top5[1]= Math.floor(top5[1]* 100) / 100;
                         textView.append("En uzun 4. mesafe  " +top5[1] + " km'dir. Bu seyahat " + tarih[x] + ".12.2020 tarihinde yapılmıştır\n\n");
                     }


                     if (mesafe[x] == top5[2]){
                         top5[2]= Math.floor(top5[2]* 100) / 100;
                         textView.append("En uzun 3. mesafe  " +top5[2] + " km'dir. Bu seyahat " + tarih[x] + ".12.2020 tarihinde yapılmıştır\n\n");

                     }

                     if (mesafe[x] == top5[3]){
                         top5[3]= Math.floor(top5[3]* 100) / 100;
                         textView.append("En uzun 2. mesafe  " +top5[3] + " km'dir. Bu seyahat " + tarih[x] + ".12.2020 tarihinde yapılmıştır\n\n");

                     }


                    if (mesafe[x] == top5[4]){
                        top5[4]= Math.floor(top5[4]* 100) / 100;
                        textView.append("En uzun  1. mesafe yani en uzun mesafe  " +top5[4] + " km'dir. Bu seyahat " + tarih[x] + ".12.2020 tarihinde yapılmıştır\n\n");

                    }
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });

    }


}
