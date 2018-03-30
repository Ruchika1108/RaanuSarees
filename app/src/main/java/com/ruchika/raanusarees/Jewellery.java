package com.ruchika.raanusarees;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Jewellery extends AppCompatActivity implements View.OnClickListener{
Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jewellery);
        b1=(Button)findViewById(R.id.button2);
        b1.setOnClickListener((View.OnClickListener) this);
    }

    @Override
    public void onClick(View view) {
        if(view==b1)
        {
            Intent intent= new Intent(this,MainActivity.class);
            startActivity(intent);
        }
    }
}
