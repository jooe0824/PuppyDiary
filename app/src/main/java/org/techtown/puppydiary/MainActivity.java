package org.techtown.puppydiary;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{
    ViewPager pager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pager = findViewById(R.id.viewPager);
        pager.setOffscreenPageLimit(4);

        MyPagerAdapter adapter = new MyPagerAdapter(getSupportFragmentManager());

        CalendarFragment calendar = new CalendarFragment();
        adapter.addItem(calendar);

        KgFragment kg = new KgFragment();
        adapter.addItem(kg);

        MoneyFragment money = new MoneyFragment();
        adapter.addItem(money);

        pager.setAdapter(adapter);

    }




    class MyPagerAdapter extends FragmentStatePagerAdapter {
        ArrayList<Fragment> items = new ArrayList<Fragment>();
        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return items.get(position);
        }

        public void addItem(Fragment item){
            items.add(item);
        }

        @Override
        public int getCount() {
            return items.size();
        }

    }

}