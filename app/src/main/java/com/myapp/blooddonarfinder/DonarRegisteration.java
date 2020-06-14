package com.myapp.blooddonarfinder;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Calendar;

public class DonarRegisteration extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private Button button;
    private Spinner Ebloodgroup, Edate;
    ListView listviewDonar;
    private EditText Efullname, Eaddress, Econtactno, Eage;
    public static final String NAME_TEXT = "com.myapp.myactivity.NAME_TEXT";
    private DatePickerDialog.OnDateSetListener EdateSetListener;


    DatabaseReference databaseDonar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donar_registeration);
        databaseDonar = FirebaseDatabase.getInstance().getReference("Donars");
        listviewDonar=findViewById(R.id.listviewdonar);
        Efullname = findViewById(R.id.fullname);
        Eaddress = findViewById(R.id.address);
        Econtactno = findViewById(R.id.connumber);
        Eage = findViewById(R.id.age);
        Edate = findViewById(R.id.date);
        button = findViewById(R.id.done);
       Ebloodgroup = findViewById(R.id.BloodGroup);





                button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addDonar();
            }
        });


    }

    private void addDonar() {
        String fullname = Efullname.getText().toString().trim();
        String address = Eaddress.getText().toString().trim();
        String contactno = Econtactno.getText().toString().trim();
        String age = Eage.getText().toString().trim();
       String bloodgroup = Ebloodgroup.getSelectedItem().toString().trim();
        String date = Edate.getSelectedItem().toString().trim();





       if (TextUtils.isEmpty(fullname)) {
           Toast.makeText(this, "please fill all the information in the form", Toast.LENGTH_SHORT).show();
           return;
        }
        else {
           String id = databaseDonar.push().getKey();
           Donar donar = new Donar(id, fullname,address, contactno, age, bloodgroup,date);
           databaseDonar.child(id).setValue(donar);
           Toast.makeText(this, "Donar Added", Toast.LENGTH_SHORT).show();;


       }


        //String nameText=fullname.getText().toString().trim();
        // Intent intent=new Intent(this, DonarMessage.class);
       //  intent.putExtra(NAME_TEXT, nameText);
        // startActivity(intent);

    }


}




