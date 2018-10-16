package com.example.lenovo.travelalone;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.lenovo.travelalone.chat.Main2acti;
import com.example.lenovo.travelalone.news.Contact;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    android.support.v7.widget.Toolbar toolbar;
    ActionBarDrawerToggle actionBarDrawerToggle;
    NavigationView navigationView;
    RecyclerView recyclerView;
    public SwipeRefreshLayout swipeRefreshLayout;
    ProgressBar progressBar;
    ProgressBar p1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.postList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        setUpToolbar();
        swipeRefreshLayout=findViewById(R.id.swipup);
        p1=findViewById(R.id.progressbarp1);
        p1.setVisibility(View.VISIBLE);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getdata();
            }
        });

        swipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);


        navigationView=findViewById(R.id.main_nav);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.nav_android:
                        navigationView.setCheckedItem(R.id.nav_android);
                        navigationView.setItemIconTintList(ColorStateList.valueOf(R.id.dark));
                        Context context; // android.content.Context
                        Class cls;
                        Intent intent=new Intent(MainActivity.this,Main2acti.class);
                        startActivity(intent);
                        Toast.makeText(MainActivity.this, "Home", Toast.LENGTH_SHORT).show();

                        break;

                    case R.id.nav_home:
                        navigationView.setCheckedItem(R.id.nav_home);

                        Toast.makeText(MainActivity.this, "Home", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_settings:
                        navigationView.setCheckedItem(R.id.nav_news);
                        navigationView.setItemIconTintList(ColorStateList.valueOf(R.id.dark));

                        Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                        sharingIntent.setType("text/plain");
                        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, "hi there app is not publish yet,so you cant publish now sorry.");
                        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Blog APp :");
                        startActivity(Intent.createChooser(sharingIntent, "Share using"));
                        break;
                    case R.id.nav_news:
                        navigationView.setCheckedItem(R.id.nav_news);
                        navigationView.setItemIconTintList(ColorStateList.valueOf(R.id.dark));

                        Intent intent1=new Intent(MainActivity.this,Contact.class);
                        startActivity(intent1);
                        Toast.makeText(MainActivity.this, "Home", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_about:
                        navigationView.setCheckedItem(R.id.nav_news);
                        navigationView.setItemIconTintList(ColorStateList.valueOf(R.id.dark));

                        Intent intent13=new Intent(MainActivity.this,Profileofboth.class);
                        startActivity(intent13);
                        Toast.makeText(MainActivity.this, "Home", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_mail:
                        Intent email=new Intent(Intent.ACTION_SEND);
                        String mail="rohan.vachheta@yahoo.com";
                        email.putExtra(Intent.EXTRA_EMAIL,mail);
                        email.putExtra(Intent.CATEGORY_APP_EMAIL,mail);
                         email.putExtra(Intent.EXTRA_SUBJECT, "request for news Copy this address:"+mail);
                        email.putExtra(Intent.EXTRA_TEXT, "Write content here with your name ,Provide details like title=......,image=..... and description=...." +
                                ".");
                        email.setType("text/plain");
                        startActivity(Intent.createChooser(email,"select email"));
                        break;



                }
                drawerLayout.closeDrawers();
                 return false;
            }
        });

        View headerView = navigationView.getHeaderView(0);
        headerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(MainActivity.this,Admin.class);
                startActivity(intent);
                 }
        });
        getdata();


    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen((GravityCompat.START))){
            drawerLayout.closeDrawer(GravityCompat.START);

        }
        else {
            super.onBackPressed();
        }
    }

    public void setUpToolbar(){
        drawerLayout=findViewById(R.id.main_drawer);
        toolbar=findViewById(R.id.main_toolbar);
        toolbar.setTitle("Blogger Post");
        setSupportActionBar(toolbar);
        actionBarDrawerToggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.app_name,R.string.app_name);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();


    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    private void getdata(){

        Call<Postlist> postlist=BloggerAPI.getService().getPostList();
        postlist.enqueue(new Callback<Postlist>() {
            @Override
            public void onResponse(Call<Postlist> call, Response<Postlist> response) {
                p1.setVisibility(View.GONE);
                Postlist list=response.body();
                recyclerView.setAdapter(new PostAdapter(MainActivity.this,list.getItems()));
                swipeRefreshLayout.setRefreshing(false);

            }

            @Override
            public void onFailure(Call<Postlist> call, Throwable t) {
                p1.setVisibility(View.GONE);
                Toast.makeText(MainActivity.this, "error occure", Toast.LENGTH_SHORT).show();


            }
        });
    }
}
