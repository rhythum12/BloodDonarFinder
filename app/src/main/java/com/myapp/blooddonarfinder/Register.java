package com.myapp.blooddonarfinder;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Register extends AppCompatActivity {
    private FirebaseAuth mAuth;
    //    public Context context = MainActivity.this;
    private EditText fullname, email, password, contactno, conpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        fullname = findViewById(R.id.fullname);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        contactno = findViewById(R.id.connumber);
        conpassword = findViewById(R.id.conpassword);
        mAuth = FirebaseAuth.getInstance();
    }

    public void save(View view) {
        String full_name = fullname.getText().toString().trim();
        String e_mail = email.getText().toString().trim();
//        String contact_number=contactno.getText().toString().trim();
        String pass_word = password.getText().toString().trim();
        String con_password = conpassword.getText().toString().trim();
//        if (TextUtils.isEmpty(full_name)) {
//            Toast.makeText(this, "enter your full name", Toast.LENGTH_SHORT).show();
//            return;
//        }

        if (TextUtils.isEmpty(e_mail)) {
            Toast.makeText(this, "Enter email", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(pass_word)) {
            Toast.makeText(this, "enter password", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(con_password)) {
            Toast.makeText(this, "enter confirm password", Toast.LENGTH_SHORT).show();
            return;
        }
//        if (TextUtils.isEmpty(contact_number)) {
//            Toast.makeText(this, "enter your contact number", Toast.LENGTH_SHORT).show();
//            return;
//        }


        if (pass_word.equals(con_password)) {
            registeruser(e_mail,pass_word);
        }

    }

    private void registeruser(String e_mail, String pass_word) {
        mAuth.createUserWithEmailAndPassword(e_mail, pass_word)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Toast.makeText(Register.this, "signup success", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),MainActivity.class));
                            FirebaseUser user = mAuth.getCurrentUser();
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(Register.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }

                        // ...
                    }
                });
    }

}
