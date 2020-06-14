package com.myapp.blooddonarfinder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DonarMessage extends AppCompatActivity {
    private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donar_message);
        tv=findViewById(R.id.show);

        Intent intent=getIntent();
        String text=((Intent)intent).getStringExtra(DonarRegisteration.NAME_TEXT);
        tv.setText("Welcome" +" "  +text + " ."+" Thank you for your contribution");
    }
}
