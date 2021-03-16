package com.example.act1_constraintlayout;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Page2 extends AppCompatActivity {
    TextView txtHasil;

    String email;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page2);

        txtHasil = (TextView)findViewById(R.id.textViewHasil);
        Bundle b2 = this.getIntent().getExtras();

        email = b2.getString("email");

        txtHasil.setText("SELAMAT DATANG\n "+email);
    }
}
