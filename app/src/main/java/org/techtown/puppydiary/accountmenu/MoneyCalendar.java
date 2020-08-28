package org.techtown.puppydiary.accountmenu;

        import android.content.Intent;
        import android.graphics.drawable.ColorDrawable;
        import android.os.Bundle;
        //import android.support.annotation.NonNull;
       // import android.support.annotation.Nullable;
       // import android.support.v7.app.AppCompatActivity;
        import android.util.Log;
        import android.widget.CalendarView;

        import androidx.annotation.NonNull;
        import androidx.annotation.Nullable;
        import androidx.appcompat.app.ActionBar;
        import androidx.appcompat.app.AppCompatActivity;

        import org.techtown.puppydiary.MainActivity;
        import org.techtown.puppydiary.R;


public class MoneyCalendar extends AppCompatActivity {

    ActionBar actionBar;

    private static final String TAG = "CalendarActivity";
    private CalendarView mCalendarView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_money_calendar);

        actionBar = getSupportActionBar();
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(0xffD6336B));
        getSupportActionBar().setTitle("댕댕이어리");

        actionBar.setIcon(R.drawable.white_puppy) ;
        actionBar.setDisplayUseLogoEnabled(true) ;
        actionBar.setDisplayShowHomeEnabled(true) ;

        mCalendarView = (CalendarView) findViewById(R.id.calendarView);

        mCalendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                String date = i + "/" + (i1+1) + "/" + i2;
                Log.d(TAG, "onSelectDayChange: date : "+date);

                Intent intent = new Intent(MoneyCalendar.this, MainActivity.class);
                intent.putExtra("date", date);
                startActivity(intent);
            }
        });
    }
}