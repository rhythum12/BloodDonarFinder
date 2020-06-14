package com.myapp.blooddonarfinder;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Reciever extends AppCompatActivity {
ListView listviewDonar;
   DatabaseReference databaseDonar;
   List<Donar> donarList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reciever);
       databaseDonar = FirebaseDatabase.getInstance().getReference("Donars");
      listviewDonar=findViewById(R.id.listviewdonar);
      donarList=new ArrayList<>();
    }

    @Override
    protected void onStart() {
       super.onStart();
       databaseDonar.addValueEventListener(new ValueEventListener() {
           @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                donarList.clear();

                for (DataSnapshot donarSnapshot : dataSnapshot.getChildren()) {
                  Donar donar = donarSnapshot.getValue(Donar.class);
                    donarList.add(donar);
               }
               DonarLists adapter=new DonarLists(Reciever.this, donarList);
               listviewDonar.setAdapter(adapter);
           }

           @Override
           public void onCancelled(@NonNull DatabaseError databaseError) {

           }
        });

   }
}
