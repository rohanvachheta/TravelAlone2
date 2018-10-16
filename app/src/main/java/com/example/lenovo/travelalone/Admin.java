package com.example.lenovo.travelalone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.lenovo.travelalone.news.Main3news;

public class Admin extends AppCompatActivity {
    EditText editText,editText1;
    Button button;
    public static  int a=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_login);

        editText=findViewById(R.id.et_email);
        editText1=findViewById(R.id.et_password);
        button=findViewById(R.id.btn_login);
        if(a==3){
            button.setEnabled(false);
        }
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a++;
                String a=editText.getText().toString();
                String b=editText1.getText().toString();



                    if (a.equals("rohan") || a .equals("rohan.vachheta@yahoo.com") && b.equals( "rohan123")) {
                        Intent intent = new Intent(Admin.this, Main3news.class);
                        startActivity(intent);
                    } else {
                        TextView textView = findViewById(R.id.tv_register);
                        textView.setText("password is wrong");
                    }
                }


        });
    }
}
