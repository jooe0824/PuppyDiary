package org.techtown.puppydiary;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import org.techtown.puppydiary.accountmenu.MoneyTab;

import java.util.Calendar;

public class MypuppyTab extends AppCompatActivity {
    ActionBar actionBar;
    //public static String ;
    // public static Context context;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypuppy);

        //MoneyEdit.context = getApplicationContext();
        actionBar = getSupportActionBar();
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(0xffD6336B));
        getSupportActionBar().setTitle("댕댕이어리");
        actionBar.setIcon(R.drawable.white_puppy) ;
        actionBar.setDisplayUseLogoEnabled(true) ;
        actionBar.setDisplayShowHomeEnabled(true) ;


        TextView textView = findViewById(R.id.textView);
        SpannableString content = new SpannableString("우리 집 댕댕이는요");
        content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
        textView.setText(content);

        Button calen = findViewById(R.id.calendar);
        calen.setOnClickListener(new View.OnClickListener() {
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

        ImageView set_button = findViewById(R.id.set_button);
        set_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SetPuppy.class);
                startActivity(intent);
            }
        });

        Calendar cal = Calendar.getInstance();
        final DatePickerDialog dialog = new DatePickerDialog( this ,listner, 2020, 1, 1);

        EditText b_day = findViewById(R.id.bd_input);
        b_day.setText(cal.get(Calendar.YEAR)+ "-" + (cal.get(Calendar.MONTH)+1) + "-" + cal.get(Calendar.DATE));

        b_day.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.show();
            }
        });
    }

    private DatePickerDialog.OnDateSetListener listner = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int yy, int mm, int dd) {
            EditText b_day = findViewById(R.id.bd_input);
            b_day.setText(String.format("%d-%d-%d", yy,mm+1,dd));
        }
    };
}
