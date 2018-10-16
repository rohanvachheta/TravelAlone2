package com.example.lenovo.travelalone;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.lenovo.travelalone.MainActivity;
import com.example.lenovo.travelalone.ProfileView;
import com.example.lenovo.travelalone.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class Profileofboth extends AppCompatActivity {
    private static final String TAG ="Profileofboth";
    Intent intent;
    Context context;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.index);

        Toolbar toolbar=findViewById(R.id.main_toolbar123);
        setTitle("Profile Activity");
        setSupportActionBar(toolbar);
        CircleImageView circleImageView1=findViewById(R.id.firstcircle);
        circleImageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Profileofboth.this,ProfileView.class);
                ActivityOptionsCompat activityOptionsCompat=ActivityOptionsCompat.makeSceneTransitionAnimation(Profileofboth.this,findViewById(R.id.firstcircle),"");

                startActivity(i,activityOptionsCompat.toBundle());
            }
        });
        CircleImageView circleImageView2=findViewById(R.id.secoundcircle);
        circleImageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Profileofboth.this,Dhruvactivity.class);
                ActivityOptionsCompat activityOptionsCompat=ActivityOptionsCompat.makeSceneTransitionAnimation(Profileofboth.this,findViewById(R.id.secoundcircle),"");

                startActivity(i,activityOptionsCompat.toBundle());
            }
        });
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }




    } @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }


}
