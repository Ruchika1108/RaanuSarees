package com.ruchika.raanusarees;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Main5Activity extends AppCompatActivity {
    Button logbut;
    EditText logemail;
    EditText logpass;

    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        firebaseAuth =firebaseAuth.getInstance();
     /*   if(firebaseAuth.getCurrentUser() != null)
        {
            startActivity(new Intent(Main5Activity.this, MainActivity.class));
            finish();
        } */
            logbut =(Button)findViewById(R.id.logbut);
            logpass =(EditText)findViewById(R.id.logpass);
            logemail=(EditText)findViewById(R.id.logemail);

            logbut.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String email =logemail.getText().toString();
                    String password =logpass.getText().toString();

                    if(TextUtils.isEmpty(email))
                    {
                        Toast.makeText(getApplicationContext(),"Enter email Address",Toast.LENGTH_LONG).show();
                        return;
                    }
                    if(TextUtils.isEmpty(password))
                    {
                        Toast.makeText(getApplicationContext(),"Enter Password",Toast.LENGTH_LONG).show();
                        return;
                    }

                    firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(Main5Activity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(!task.isSuccessful())
                            {
                                Toast.makeText(Main5Activity.this,"Authentication failure",Toast.LENGTH_LONG).show();
                                Intent i = new Intent(Main5Activity.this,MainActivity.class);
                                startActivity(i);
                                finish();
                            }
                            else
                            {
                                Toast.makeText(Main5Activity.this,"Logged In",Toast.LENGTH_LONG).show();
                                Intent i = new Intent(Main5Activity.this,MainActivity.class);
                                startActivity(i);
                                finish();
                            }
                        }
                    });
                }
            });
        }
    }

