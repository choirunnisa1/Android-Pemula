package com.example.submixone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.profil,menu);
        return true;
    }
    private RecyclerView rv_1;
    private ArrayList<IdolName> listIdol = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("NCT Member");

        rv_1 = findViewById(R.id.rv1);
        rv_1.setHasFixedSize(true);
        listIdol.addAll(DataIdol.getListData());
        showRecyclerList();
    }

    private void showRecyclerList() {
        rv_1.setLayoutManager(new LinearLayoutManager(this));
        IdolAdapter idolAdapter = new IdolAdapter(listIdol);
        rv_1.setAdapter(idolAdapter);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.profil) {
            Intent moveIntent = new Intent(MainActivity.this, ProfilkuActivity.class);
            startActivity(moveIntent);
            return true;
        }

        return super.onOptionsItemSelected(item);

    }
}
