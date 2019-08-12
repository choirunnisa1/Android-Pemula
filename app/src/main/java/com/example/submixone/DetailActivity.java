package com.example.submixone;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {
    private ImageView ImgDetail;
    private TextView tvNama;
    private TextView tvIsi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        initView();

        Intent intent = getIntent();
        String image = intent.getStringExtra("IMAGE");
        String nama = intent.getStringExtra("NAME");
        String ttl = intent.getStringExtra("TTL");

        Glide.with(this).load(image).into(ImgDetail);

        tvNama.setText(nama);
        tvIsi.setText(ttl);


    }
    private void initView() {
        tvNama = findViewById(R.id.namamember);
        tvIsi = findViewById(R.id.biodata);
        ImgDetail = findViewById(R.id.imgmember);

    }

}
