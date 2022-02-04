package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {
    EditText txtNameLogin,txtPasswordLogin;
    ProgressBar progressBarLogin;
    Button btnLogin,btnRegister;
    FirebaseAuth fAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtNameLogin = findViewById(R.id.txtNameLogin);
        txtPasswordLogin = findViewById(R.id.txtPasswordLogin);
        progressBarLogin = findViewById(R.id.progressBarLogin);
        btnLogin = findViewById(R.id.btnLogin);
        btnRegister = findViewById(R.id.btnRegister);
        progressBarLogin.setVisibility(View.INVISIBLE);
        fAuth = FirebaseAuth.getInstance();
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = txtNameLogin.getText().toString();
                String password = txtPasswordLogin.getText().toString();

                progressBarLogin.setVisibility(View.VISIBLE);

                fAuth.signInWithEmailAndPassword(name, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {

                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(Login.this,"Logged in",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),MainActivity.class));
                            finish();
                        }
                        else{
                            Toast.makeText(Login.this,"Error"+task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                            progressBarLogin.setVisibility(View.INVISIBLE);
                        }
                    }
                });
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Register.class));
                finish();
            }
        });
    }
}