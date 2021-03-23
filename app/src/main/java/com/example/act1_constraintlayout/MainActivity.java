package com.example.act1_constraintlayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edMail,edPass;
    Button btnLogin;
    String email, pass;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
//        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.mnDaftar){
            Intent i = new Intent(getApplicationContext(),ActivityDaftar.class);
            startActivity(i);
        }
        return true;
//        return super.onOptionsItemSelected(item);
    }

    public int validasiData(){
        String emailActive = "azkklk@gmail.com";
        String passActive = "Arief1707";
        email = edMail.getText().toString();
        pass = edPass.getText().toString();

        if(emailActive.equals(email) && passActive.equals(pass)){ // BENAR SEMUA
            return 1;
        }
        else if(emailActive.equals(email) && !passActive.equals(pass)){ // SALAH PASS
            return 2;
        }
        else if(!emailActive.equals(email) && passActive.equals(pass)){ // SALAH EMAIL
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

                if(email.isEmpty() || pass.isEmpty()){
                    Toast t = Toast.makeText(getApplicationContext(),
                            "Email / Password tidak terisi !",
                            Toast.LENGTH_LONG);
                    t.show();
                }else{
                    if(validasiData() == 1){
                        Toast t = Toast.makeText(getApplicationContext(),
                                "Sukses !",
                                Toast.LENGTH_LONG);
                        t.show();
                        Bundle b = new Bundle();
                        b.putString("email",email.trim());
                        b.putString("pass",pass.trim());

                        Intent i = new Intent(getApplicationContext(),Page2.class);
                        i.putExtras(b);
                        startActivity(i);
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