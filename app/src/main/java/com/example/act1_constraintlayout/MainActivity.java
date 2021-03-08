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

    public int validasiData(){
        String emailActive = "azkklk@gmail.com";
        String passActive = "Arief1707";

        if(emailActive.equals(edMail.getText().toString()) && passActive.equals(edPass.getText().toString())){ // BENAR SEMUA
            return 1;
        }
        else if(emailActive.equals(edMail.getText().toString()) && !passActive.equals(edPass.getText().toString())){ // SALAH PASS
            return 2;
        }
        else if(!emailActive.equals(edMail.getText().toString()) && passActive.equals(edPass.getText().toString())){ // SALAH EMAIL
            return 3;
        }
        return 0;
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

                if(edMail.getText().toString().equals("") || edPass.getText().toString().equals("")){
                    Toast t = Toast.makeText(getApplicationContext(),
                            "Email / Password tidak terisi !",
                            Toast.LENGTH_LONG);
                    t.show();
                }else{
                    if(validasiData() == 1){
                        Toast t = Toast.makeText(getApplicationContext(),
                                "Sukses !\n Email Anda : "+email+"\n Password Anda : "+pass,
                                Toast.LENGTH_LONG);
                        t.show();
                    }else if(validasiData() == 0){
                        Toast t = Toast.makeText(getApplicationContext(),
                                "Email dan Password anda Salah !\n Silahkan Coba lagi",
                                Toast.LENGTH_LONG);
                        t.show();
                    }else if(validasiData() == 2){
                        Toast t = Toast.makeText(getApplicationContext(),
                                "Password anda Salah !\n Silahkan Coba lagi",
                                Toast.LENGTH_LONG);
                        t.show();
                    }else if(validasiData() == 3) {
                        Toast t = Toast.makeText(getApplicationContext(),
                                "Email anda Salah !\n Silahkan Coba lagi",
                                Toast.LENGTH_LONG);
                        t.show();
                    }
                }

            }
        });
    }
}