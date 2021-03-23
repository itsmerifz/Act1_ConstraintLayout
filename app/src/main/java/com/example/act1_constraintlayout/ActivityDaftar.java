package com.example.act1_constraintlayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class ActivityDaftar extends AppCompatActivity {

    EditText edNama,edAlamat,edMail,edPass,edRPass;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitydaftar);

        edNama = findViewById(R.id.edNama);
        edAlamat = findViewById(R.id.edAlamat);
        edMail = findViewById(R.id.edMail);
        edPass = findViewById(R.id.edPass);
        edRPass = findViewById(R.id.edRePass);
        fab = findViewById(R.id.floatingActionButton);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edNama.getText().toString().isEmpty() || edAlamat.getText().toString().isEmpty() || edPass.getText().toString().isEmpty() || edMail.getText().toString().isEmpty() || edRPass.getText().toString().isEmpty()){
                    Snackbar.make(view ,"Wajib isi seluruh data !!",Snackbar.LENGTH_LONG).show();
                }else{
                    if(edPass.getText().toString().equals(edRPass.getText().toString())){
                        Toast.makeText(getApplicationContext(),"Pendaftaran Berhasil",Toast.LENGTH_LONG).show();
                        Intent i = new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(i);
                    }else{
                        Snackbar.make(view,"Password dan RePassword tidak sesuai !",Snackbar.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
}
