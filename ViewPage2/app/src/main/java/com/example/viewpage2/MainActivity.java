package com.example.viewpage2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import me.relex.circleindicator.CircleIndicator3;

public class MainActivity extends AppCompatActivity {

    private ViewPager2 viewPager2;
    private CircleIndicator3 circleIndicator3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        circleIndicator3 = findViewById(R.id.indicator);
        viewPager2 = findViewById(R.id.viewPage2);
        ViewPage2Adapter viewPage2Adapter = new ViewPage2Adapter(this);

        viewPager2.setAdapter(viewPage2Adapter);
        circleIndicator3.setViewPager(viewPager2);
    }
}