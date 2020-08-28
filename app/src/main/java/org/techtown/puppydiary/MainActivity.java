package org.techtown.puppydiary;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{
    //BottomNavigationView bottonNavigationView;
    //ViewPager pager;
    //KgTab kgfragment;
    //KgPopup kgpopup;
    //MoneyTab moneyfragment;
    //MoneyEdit moneyedit;

    private  static Context context;
    ActionBar actionBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // MoneyEdit.context = getApplicationContext();
        actionBar = getSupportActionBar();
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(0xffD6336B));
        getSupportActionBar().setTitle("댕댕이어리");

        actionBar.setIcon(R.drawable.white_puppy) ;
        actionBar.setDisplayUseLogoEnabled(true) ;
        actionBar.setDisplayShowHomeEnabled(true) ;

        Button button = findViewById(R.id.splash);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

        Intent intent_main = new Intent(getApplicationContext(), CalendarTab.class); //일단 바로 검색결과 띄음
        startActivity(intent_main);

                                          /*Toast toastView = Toast.makeText(getApplicationContext(), "약 이름이 '"+((EditText)findViewById(R.id.edit)).getText().toString()+"'로 설정되었습니다" , Toast.LENGTH_LONG);

                                          toastView.setGravity( Gravity.TOP| Gravity.LEFT, 180, 700); //토스트 메시지 위치 x,y좌표로 바꿀 수 있다.
                                          toastView.show();*/
            }
        });



/*
        kgpopup = new KgPopup();
        kgfragment = new KgTab();
        moneyfragment = new MoneyTab();
        moneyedit = new MoneyEdit();

        pager = findViewById(R.id.viewPager);
        pager.setOffscreenPageLimit(4);

        MyPagerAdapter adapter = new MyPagerAdapter(getSupportFragmentManager());

        CalendarTab calendar = new CalendarTab();
        adapter.addItem(calendar);

        KgTab kg = new KgTab();
        adapter.addItem(kg);

        MoneyTab money = new MoneyTab();
        adapter.addItem(money);

        MypuppyTab my = new MypuppyTab();
        adapter.addItem(my);

        pager.setAdapter(adapter);

    }

    public void onChangeFragment(int index){
        if(index == 0){
            getSupportFragmentManager().beginTransaction().replace(R.id.container,kgfragment).commit();
        }else if(index ==1){
            getSupportFragmentManager().beginTransaction().replace(R.id.container,kgpopup).commit();
        }else if(index ==2){
            getSupportFragmentManager().beginTransaction().replace(R.id.container,moneyfragment).commit();
        }else if(index ==3){
            getSupportFragmentManager().beginTransaction().replace(R.id.container,moneyedit).commit();
        }*/
    }

    /*
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
*/
}
