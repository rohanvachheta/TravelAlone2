package com.example.lenovo.travelalone.news;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.lenovo.travelalone.MainActivity;
import com.example.lenovo.travelalone.PostAdapter;
import com.example.lenovo.travelalone.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class Contact extends AppCompatActivity {
    String Base_url="https://limy-masks.000webhostapp.com";
    ListView listView;
    RecyclerView recyclerView;
    List<User> list=new ArrayList<>();
    Adaptationnews adaptationnews;
    DrawerLayout drawerLayout;
    android.support.v7.widget.Toolbar toolbar;
    ActionBarDrawerToggle actionBarDrawerToggle;
    NavigationView navigationView;

    public SwipeRefreshLayout swipeRefreshLayout;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_contact);
        swipeRefreshLayout=findViewById(R.id.swipup);
        progressBar=findViewById(R.id.progress12);
        progressBar.setVisibility(View.VISIBLE);


        //setUpToolbar();
        listView=findViewById(R.id.list_item);
        recyclerView=findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

       // adaptationnews =new Adaptationnews(Contact.this,list)
        Toolbar toolbar=findViewById(R.id.toolbar);
        toolbar.setTitle("News");
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        getHeroes();
        
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    private void setUpToolbar() {
        drawerLayout=findViewById(R.id.main_drawer);
        android.support.v7.widget.Toolbar toolbar=findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        actionBarDrawerToggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.app_name,R.string.app_name);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

    }

    private void getHeroes() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Base_url)
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();

        Json api = retrofit.create(Json.class);

        Call<List<User>> call = api.getuser();

        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                progressBar.setVisibility(View.GONE);
                swipeRefreshLayout.setVisibility(View.INVISIBLE);
                List<User> heroList = response.body();

                //Creating an String array for the ListView
                String[] heroes = new String[heroList.size()];

                String[] name = new String[heroList.size()];
                String[] link = new String[heroList.size()];
                List <User> mov=response.body();
                recyclerView.setAdapter(new Adaptationnews(Contact.this,mov));

                //looping through all the heroes and inserting the names inside the string array
                for (int i = 0; i < heroList.size(); i++) {
                    heroes[i] = heroList.get(i).getName();
                    name[i] =heroList.get(i).getName();
                    link[i] =heroList.get(i).getEmail();


                }


                //displaying the string array into listview
                //listView.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, heroes));

            }



            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.d("read", "onFailure: "+t.getMessage());
            }
        });
    }

}