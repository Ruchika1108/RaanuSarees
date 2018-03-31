package com.ruchika.raanusarees;

import android.app.ProgressDialog;
import android.content.Intent;
import android.nfc.Tag;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import org.w3c.dom.Text;

public class Main4Activity extends AppCompatActivity implements View.OnClickListener {
Button buttonRegister;
EditText emailid;
EditText pass;
TextView tv;
private ProgressDialog pd;
private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        buttonRegister =(Button)findViewById(R.id.register);
        emailid =(EditText)findViewById(R.id.email);
        pass =(EditText)findViewById(R.id.pass);
        tv =(TextView)findViewById(R.id.loginuser);
       buttonRegister.setOnClickListener(this);
       tv.setOnClickListener(this);
       pd= new ProgressDialog(this);
       firebaseAuth =firebaseAuth.getInstance();
    }
    public void registerUser()
    {
        String e= emailid.getText().toString().trim();
        String p =pass.getText().toString().trim();

        if (TextUtils.isEmpty(e))             //empty email id
        {
            Toast.makeText(this,"Email is empty",Toast.LENGTH_LONG).show();
            return;
        }

        if(TextUtils.isEmpty(p))
        {
            Toast.makeText(this,"Password is empty",Toast.LENGTH_LONG).show();
            return;

        }
        pd.setMessage("Registering User!!");
        pd.show();
        Task<AuthResult> authResultTask = firebaseAuth.createUserWithEmailAndPassword(e, p).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(Main4Activity.this,"Registered Successfully",Toast.LENGTH_LONG).show();
                    pd.dismiss();
                    Intent i =new Intent(Main4Activity.this, MainActivity.class);
                    startActivity(i);
                    finish();
                }
                else
                {
                    Toast.makeText(Main4Activity.this,"Could not create user, please try again",Toast.LENGTH_LONG).show();
                }



            }
        });


    }

    @Override
    public void onClick(View view) {
        if(view==buttonRegister)
        {
            registerUser();
        }
        if(view==tv)
        {
            //start login activity
            Intent i = new Intent(this, Main5Activity.class);
            startActivity(i);
        }

    }
}
