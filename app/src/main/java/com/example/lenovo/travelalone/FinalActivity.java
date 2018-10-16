package com.example.lenovo.travelalone;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.lenovo.travelalone.chat.Main2acti;
import com.example.lenovo.travelalone.news.Contact;
import com.example.lenovo.travelalone.news.Main3news;
import com.firebase.ui.auth.AuthUI;

import java.util.ArrayList;
import java.util.List;

public class FinalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }
    public void blogclik(View view){
        startActivity(new Intent(this,MainActivity.class));

    }
    public void newsclick(View view){
        startActivity(new Intent(this,Contact.class));

    }
    public void chatclick(View view){
        startActivity(new Intent(this,Main2acti.class));

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.admin, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.admin:
                startActivity(new Intent(FinalActivity.this,Admin.class));
                break;
            case R.id.about:
                startActivity(new Intent(FinalActivity.this,Profileofboth.class));
                break;

        }
        return super.onOptionsItemSelected(item);

    }

}
