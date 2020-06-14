package com.myapp.blooddonarfinder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void DonarRegistration(View view) {
        startActivity(new Intent(getApplicationContext(), DonarRegisteration.class));
    }

    public void Reciever(View view) {

        startActivity(new Intent(getApplicationContext(), Reciever.class));
    }

    public void myprofile(View view) {
    }
}
