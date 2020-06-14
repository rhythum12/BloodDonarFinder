package com.myapp.blooddonarfinder;

import android.app.ProgressDialog;
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

public class MainActivity extends AppCompatActivity {
    private EditText email;
    private EditText password;
    private FirebaseAuth mAuth;
    private ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        mAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);
    }




    public void login(View view) {
        String e_mail = email.getText().toString().trim();
        String pass_word = password.getText().toString().trim();
        if (TextUtils.isEmpty(e_mail)) {
            Toast.makeText(this, "email is empty", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(pass_word)) {
            Toast.makeText(this, "password empty", Toast.LENGTH_SHORT).show();
            return;
        }
        progressDialog.setMessage("Processing...");
        progressDialog.show();

        mAuth.signInWithEmailAndPassword(e_mail, pass_word)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
//                            Log.d(TAG, "createUserWithEmail:success");
                            FirebaseUser registeruser = mAuth.getCurrentUser();

                            startActivity(new Intent(getApplicationContext(), Home.class));
                            progressDialog.dismiss();
                        } else {
                            // If sign in fails, display a message to the user.
//                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(MainActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
//                            updateUI(null);
                            progressDialog.dismiss();
                        }
                    }
                });

    }
    public void Register(View view) {
       startActivity(new Intent(getApplicationContext(), Register.class));
      //  Intent intent = new Intent(this,Register.class);
    }
}
