package com.example.act1_constraintlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edMail,edPass;
    Button btnLogin;
    String email, pass;

    public boolean validasiData(){
        String emailActive = "azkklk@gmail.com";
        String passActive = "Arief1707";

        if(emailActive.equals(edMail.getText().toString()) && passActive.equals(edPass.getText().toString())){
            return true;
        }
        return false;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edMail = findViewById(R.id.editEmail);
        edPass = findViewById(R.id.editPass);
        btnLogin = findViewById(R.id.buttonLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = edMail.getText().toString();
                pass = edPass.getText().toString();

                if(validasiData() == true){
                    Toast t = Toast.makeText(getApplicationContext(),
                            "Sukses !\n Email Anda : "+email+"\n Password Anda : "+pass,
                            Toast.LENGTH_LONG);
                    t.show();
                }else{
                    Toast t = Toast.makeText(getApplicationContext(),
                            "Email / Password anda Salah !\n Silahkan Coba lagi",
                            Toast.LENGTH_LONG);
                    t.show();
                }

            }
        });
    }
}