package com.example.livecricket;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class pageradapter extends FragmentPagerAdapter {


    int tabcount;


    public pageradapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        tabcount=behavior;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
     switch(position){
         case 0:
             return  new home();

         case 1:
             return  new technology();

         case 2:
             return  new sports();

         case 3:
             return  new science();

         case 4:
             return new health();

         default:
             return null;

     }
    }

    @Override
    public int getCount() {
        return tabcount;
    }
}
