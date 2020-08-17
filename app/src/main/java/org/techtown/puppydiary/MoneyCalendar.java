package org.techtown.puppydiary;

        import android.content.Intent;
        import android.os.Bundle;
        import android.os.PersistableBundle;
        //import android.support.annotation.NonNull;
       // import android.support.annotation.Nullable;
       // import android.support.v7.app.AppCompatActivity;
        import android.util.Log;
        import android.widget.CalendarView;

        import androidx.annotation.NonNull;
        import androidx.annotation.Nullable;
        import androidx.appcompat.app.AppCompatActivity;


public class MoneyCalendar extends AppCompatActivity {

    private static final String TAG = "CalendarActivity";
    private CalendarView mCalendarView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_money_calendar);

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