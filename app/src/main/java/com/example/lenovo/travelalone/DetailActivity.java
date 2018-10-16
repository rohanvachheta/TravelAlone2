package com.example.lenovo.travelalone;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;
import android.widget.Toolbar;

public class DetailActivity extends AppCompatActivity {
    ProgressBar progressBar;
    android.support.v7.widget.Toolbar toolbar;

    WebView webView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        progressBar=findViewById(R.id.detail_progressbar);
        toolbar=findViewById(R.id.detail_toolbar);
        webView=findViewById(R.id.detailview);
        button=findViewById(R.id.share);


       // setSupportActionBar(toolbar);
        webView.setVisibility(View.INVISIBLE);
        button.setVisibility(View.GONE);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebChromeClient(new WebChromeClient());
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
               // Toast.makeText(DetailActivity.this, "page started loading", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                progressBar.setVisibility(View.GONE);
                webView.setVisibility(View.VISIBLE);
                button.setVisibility(View.VISIBLE);
                super.onPageFinished(view, url);
                //Toast.makeText(DetailActivity.this, "page loaded", Toast.LENGTH_SHORT).show();
                String javaScript ="javascript:(function(){var a=document.getElementsByTagName('header'); a[0].hidden='true'; a=document.getElementsByClassName('page_body'); a[0].style.padding='0px';})()";
                webView.loadUrl(javaScript);

            }
        });

        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setAppCacheEnabled(true);

        webView.getSettings().setAppCachePath(this.getCacheDir().getPath());

        webView.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);
        webView.loadUrl(getIntent().getStringExtra("url"));
        String url=getIntent().getStringExtra("url");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, url);
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Blog APp :");
                startActivity(Intent.createChooser(sharingIntent, "Share using"));
            }
        });

    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            switch (keyCode) {
                case KeyEvent.KEYCODE_BACK:
                    if (webView.canGoBack()) {
                        webView.goBack();
                    } else {
                        finish();
                    }
                    return true;
            }

        }
        return super.onKeyDown(keyCode, event);
    }


}
