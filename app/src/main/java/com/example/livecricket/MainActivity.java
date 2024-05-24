package com.example.livecricket;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.os.Bundle;


import com.example.livecricket.R;
import com.example.livecricket.pageradapter;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {


    TabLayout tabLayout;
    TabItem home,tech,sports,health,science;
    PagerAdapter pagerAdapter;

    String api="4410e054669349bfbbd030ed546305c8";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        home=findViewById(R.id.home);
        tech=findViewById(R.id.tech);
        sports=findViewById(R.id.sports);
        health=findViewById(R.id.health);
        science=findViewById(R.id.science);

        tabLayout=findViewById(R.id.tab);
        ViewPager viewPager=findViewById(R.id.view);
        pagerAdapter=new pageradapter(getSupportFragmentManager(),5);
        viewPager.setAdapter(pagerAdapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if(tab.getPosition()==0|| tab.getPosition()==1|| tab.getPosition()==2||tab.getPosition()==3||tab.getPosition()==4){
                    pagerAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));


    }


}