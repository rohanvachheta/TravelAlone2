package com.example.lenovo.travelalone.news;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lenovo.travelalone.R;

public class Viewnews extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewnews);
        ImageView imageView=findViewById(R.id.img);
        TextView textView=findViewById(R.id.text1);
        TextView textView1=findViewById(R.id.text2);
        Intent  intent=getIntent();
        String a=intent.getStringExtra("title");
        String b=intent.getStringExtra("dec");
        String c=intent.getStringExtra("photo");
        textView.setText(a);
        textView1.setText(b);
        Glide.with(Viewnews.this)
                .load(c)

                .into(imageView);

    }
}
