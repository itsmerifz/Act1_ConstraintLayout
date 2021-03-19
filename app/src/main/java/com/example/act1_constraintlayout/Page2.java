package com.example.act1_constraintlayout;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Page2 extends AppCompatActivity {
    TextView resultEmail,resultPass;

    String email,pass;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page2);
        resultEmail = findViewById(R.id.textResEmail);
        resultPass = findViewById(R.id.textResPass);

        Bundle b2 = this.getIntent().getExtras();

        email = b2.getString("email");
        pass = b2.getString("pass");

        resultEmail.setText(email);
        resultPass.setText(pass);


    }
}
