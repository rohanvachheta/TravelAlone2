package com.example.lenovo.travelalone.news;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.lenovo.travelalone.R;

public class Main3news extends AppCompatActivity {

    Button b1,b2;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main3news);
        b1=findViewById(R.id.button);
        b2=findViewById(R.id.button2);
        textView=findViewById(R.id.textView);
        ConnectivityManager connectivityManager= (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo=connectivityManager.getActiveNetworkInfo();
        if(networkInfo == null){
            b1.setEnabled(false);
            b2.setEnabled(false);

        }
        else {
            textView.setVisibility(View.INVISIBLE);

        }
    }

    public  void  addContact(View view){
        startActivity(new Intent(this,AddByRetro.class));

    }
    public void showContact(View view){
        startActivity(new Intent(this,Contact.class));
    }



}
