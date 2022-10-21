package com.google.myapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Bundle bundle =getIntent().getExtras();
        if(bundle ==null){
            return;
        }
        MostViewedDomain mostViewedDomain = (MostViewedDomain) bundle.get("object_news");
        TextView tvNews =findViewById(R.id.tv_news);
        tvNews.setText(mostViewedDomain.getTitle());
    }
}