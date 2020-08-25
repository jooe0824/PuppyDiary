package org.techtown.puppydiary;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class MoneyTab extends AppCompatActivity {
    // ActionBar actionBar;
    // public static Context context;

    //@Override
    //public boolean onCreateOptionsMenu(Menu menu) {
    //    getMenuInflater().inflate(R.menu.menu, menu);
    //    return true;
    //}
    /*MainActivity mainActivity;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mainActivity = (MainActivity)getActivity();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mainActivity = null;
    }*/


    // @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_money);

        /*actionBar = getSupportActionBar();
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(R.color.Mycolor));
        getSupportActionBar().setTitle("댕댕이어리");
*/
        Button calendar = findViewById(R.id.calendar);
        calendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent_calendar = new Intent(getApplicationContext(), CalendarTab.class); //일단 바로 검색결과 띄음
                startActivity(intent_calendar);
            }
        });

        Button kg = findViewById(R.id.kg);
        kg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent_kg = new Intent(getApplicationContext(), KgTab.class); //일단 바로 검색결과 띄음
                startActivity(intent_kg);
            }
        });

        Button money = findViewById(R.id.account);
        money.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent_money = new Intent(getApplicationContext(), MoneyTab.class); //일단 바로 검색결과 띄음
                startActivity(intent_money);
            }
        });

        Button puppy = findViewById(R.id.puppy);
        puppy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent_puppy = new Intent(getApplicationContext(), MypuppyTab.class); //일단 바로 검색결과 띄음
                startActivity(intent_puppy);
            }
        });

        Button edit = findViewById(R.id.edit);
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //realmediname = Alarmname.getText().toString();
                Intent intent_edit = new Intent(getApplicationContext(), MoneyEdit.class); //일단 바로 검색결과 띄음
                startActivity(intent_edit);
            }
        });
    }
}