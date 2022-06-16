package com.example.awal;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PageAdapter extends FragmentPagerAdapter {
    int numCount;

    public PageAdapter(@NonNull FragmentManager fm, int numCount) {
        super(fm);
        this.numCount = numCount;
    }

    public PageAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new jming();

            case 1:
                jsen jsen=new jsen();
                return jsen;

            case 2:
                jsel jsel=new jsel();
                return jsel;

            case 3:
                jrab jrab=new jrab();
                return jrab;

            case 4:
                jkam jkam=new jkam();
                return jkam;

            case 5:
                jjum jjum=new jjum();
                return jjum;

            case 6:
                jsab jsab=new jsab();
                return jsab;


        }
        return null;
    }

    @Override
    public int getCount() {
        return numCount;
    }
}
