package com.example.lenovo.travelalone;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

import com.example.lenovo.travelalone.chat.Main2acti;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Handler handler=new Handler();
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.blink);
        final ImageView splash = (ImageView) findViewById(R.id.main_image);
        splash.startAnimation(animation);
        animation.setInterpolator(new LinearInterpolator());
        animation.setRepeatCount(Animation.INFINITE);
        animation.setDuration(700);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //code
                Intent intent=new Intent(SplashActivity.this,FinalActivity.class);
                startActivity(intent);
                finish();


            }
        },2500);
    }
}
