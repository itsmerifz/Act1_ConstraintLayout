package com.example.act1_constraintlayout;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collection;

public class HomeActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {
    private ListView list;
    private  ListViewAdapter adapter;
    String[] listNama;
    public static ArrayList<ClassNama> classNamaArrayList = new ArrayList<ClassNama>();
    Bundle b = new Bundle();
    Intent intent;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);

        listNama = new String[]{"Inayah","Ilham","Eris","Fikri",
                                "Maul","Intan","Vina","Gita","Vian","Luthfi"};
        list = findViewById(R.id.listKontak);
        classNamaArrayList = new ArrayList<>();

        for(int i = 0; i < listNama.length; i++){
            ClassNama classNama = new ClassNama(listNama[i]);
            classNamaArrayList.add(classNama);
        }
        adapter = new ListViewAdapter(this);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String nama = classNamaArrayList.get(position).getNama();
                b.putString("a",nama.trim());

                PopupMenu pm = new PopupMenu(getApplicationContext(),view);
                pm.setOnMenuItemClickListener(HomeActivity.this);
                pm.inflate(R.menu.popup_menu);
                pm.show();
            }
        });
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()){
            case R.id.mnView : intent = new Intent(getApplicationContext(),ActivityLihatData.class);
                               intent.putExtras(b);
                               startActivity(intent);
                               break;

            case R.id.mnEdit : Toast.makeText(getApplicationContext(), "Ini buat edit kontak", Toast.LENGTH_LONG).show();
                               break;
        }
        return false;
    }
}
