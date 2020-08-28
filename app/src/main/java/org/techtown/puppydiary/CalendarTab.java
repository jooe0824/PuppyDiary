package org.techtown.puppydiary;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import org.techtown.puppydiary.accountmenu.MoneyTab;

import java.util.ArrayList;
import java.util.Calendar;

public class CalendarTab extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    ActionBar actionBar;
    public static String realmediname;
    // public static Context context;

    public static int SUNDAY = 1;
    public static int MONDAY = 2;
    public static int TUESDAY = 3;
    public static int WEDNSESDAY = 4;
    public static int THURSDAY = 5;
    public static int FRIDAY = 6;
    public static int SATURDAY = 7;

    //연 월 텍스트뷰
    private TextView tvDate;
    //그리드뷰
    private GridView gridView;
    //그리드뷰 어댑터
    private GridAdapter gridAdapter;
    //day 저장 리스트
    private ArrayList<DayInfo> dayList;

    Calendar mLastMonthCalendar;
    Calendar mCal;
    Calendar mNextMonthCalendar;

    Button pvs_button;
    Button nxt_button;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

       // MoneyEdit.context = getApplicationContext();
        actionBar = getSupportActionBar();
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(0xffD6336B));
        getSupportActionBar().setTitle("댕댕이어리");
        actionBar.setIcon(R.drawable.white_puppy) ;
        actionBar.setDisplayUseLogoEnabled(true) ;
        actionBar.setDisplayShowHomeEnabled(true) ;


        Button cal = findViewById(R.id.calendar);
        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent_calendar = new Intent(getApplicationContext(), CalendarTab.class);
                startActivity(intent_calendar);
            }
        });

        Button kg = findViewById(R.id.kg);
        kg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent_kg = new Intent(getApplicationContext(), KgTab.class);
                startActivity(intent_kg);
            }
        });

        Button money = findViewById(R.id.account1);
        money.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent_money = new Intent(getApplicationContext(), MoneyTab.class);
                startActivity(intent_money);
            }
        });

        Button puppy = findViewById(R.id.puppy);
        puppy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent_puppy = new Intent(getApplicationContext(), MypuppyTab.class);
                startActivity(intent_puppy);
            }
        });

        tvDate = findViewById(R.id.tv_date);
        gridView = findViewById(R.id.gridview);

        pvs_button = findViewById(R.id.previous);
        nxt_button = findViewById(R.id.next);

        pvs_button.setOnClickListener(this);
        nxt_button.setOnClickListener(this);

        gridView.setOnItemClickListener(this);

        dayList = new ArrayList<DayInfo>();

        mCal = Calendar.getInstance();
        mCal.set(Calendar.DAY_OF_MONTH, 1);
        getCalendar(mCal);
    }

    //캘린더 구현
    private void getCalendar(Calendar mCal) {

        int lastMonthStartDay;
        int dayOfMonth;
        int thisMonthLastDay;

        dayList.clear();

        // 이번달 시작일의 요일을 구한다. 시작일이 일요일인 경우 인덱스를 1(일요일)에서 8(다음주 일요일)로 바꾼다.)
        dayOfMonth = mCal.get(Calendar.DAY_OF_WEEK);
        thisMonthLastDay = mCal.getActualMaximum(Calendar.DAY_OF_MONTH);

        mCal.add(Calendar.MONTH, -1);

        // 지난달의 마지막 일자를 구한다.
        lastMonthStartDay = mCal.getActualMaximum(Calendar.DAY_OF_MONTH);

        mCal.add(Calendar.MONTH, 1);

        if (dayOfMonth == SUNDAY) {
            dayOfMonth += 7;
        }

        lastMonthStartDay -= (dayOfMonth - 1) - 1;

        // 캘린더 타이틀(년월 표시)을 세팅한다.
        tvDate.setText((mCal.get(Calendar.MONTH) + 1) + "월");

        DayInfo day;

        for (int i = 0; i < dayOfMonth - 1; i++) {
            int date = lastMonthStartDay + i;
            day = new DayInfo();
            day.setDay(Integer.toString(date));
            day.setInMonth(false);

            dayList.add(day);
        }
        for (int i = 1; i <= thisMonthLastDay; i++) {
            day = new DayInfo();
            day.setDay(Integer.toString(i));
            day.setInMonth(true);

            dayList.add(day);
        }
        for (int i = 1; i < 42 - (thisMonthLastDay + dayOfMonth - 1) + 1; i++) {
            day = new DayInfo();
            day.setDay(Integer.toString(i));
            day.setInMonth(false);
            dayList.add(day);
        }

        gridAdapter = new GridAdapter(this, R.layout.item_calendar, dayList);
        gridView.setAdapter(gridAdapter);

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

        DayInfo day = dayList.get(position);

        //해당 월에 해당하는 날짜일 때
        if(day.isInMonth()) {
            //Toast.makeText(getApplicationContext(),""+position, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(CalendarTab.this, CalendarDetail.class);
            intent.putExtra("pos", position);
            startActivity(intent);
        }

    }

    //지난달, 다음달 구현
    public void onClick(View v) {
        if (v.getId()== R.id.previous){
            mCal.set(mCal.get(Calendar.YEAR), mCal.get(Calendar.MONTH), 1);
            mCal.add(Calendar.MONTH, -1);
            tvDate.setText((mCal.get(Calendar.MONTH) + 1) + "월");
            getCalendar(mCal);
        } else if (v.getId()== R.id.next) {
            mCal.set(mCal.get(Calendar.YEAR), mCal.get(Calendar.MONTH), 1);
            mCal.add(Calendar.MONTH, +1);
            tvDate.setText((mCal.get(Calendar.MONTH) + 1) + "월");
            getCalendar(mCal);
        }
    }


    // 그리드뷰 어댑터
    public class GridAdapter extends BaseAdapter {

        private ArrayList<DayInfo> mdayList;
        private Context mcontext;
        private int mresource;
        private LayoutInflater minflater;

        public GridAdapter(Context context, int textResource, ArrayList<DayInfo> dayList) {
            this.mcontext = context;
            this.mdayList = dayList;
            this.mresource = textResource;
            this.minflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return mdayList.size();
        }

        @Override
        public Object getItem(int position) {
            return mdayList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            DayInfo day = dayList.get(position);
            ViewHolder holder = null;
            if (convertView == null) {
                convertView = minflater.inflate(mresource, null);
                convertView.setLayoutParams(new GridView.LayoutParams(1080 / 7 + 1080 % 7, 180));
                holder = new ViewHolder();
                holder.tvItem = (TextView) convertView.findViewById(R.id.tv_item_gridview);
               // holder.waterdrop = (ImageView) convertView.findViewById(R.id.waterdrop);
                //holder.injection = (ImageView) convertView.findViewById(R.id.injection);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            if (day != null) {
                holder.tvItem.setText(day.getDay());
                if (day.isInMonth()) {
                    if (position % 7 == 0) {
                        holder.tvItem.setTextColor(Color.RED);
                    } else {
                        holder.tvItem.setTextColor(Color.GRAY);
                    }
                } else {
                    holder.tvItem.setTextColor(Color.TRANSPARENT);
//                    holder.waterdrop.setVisibility(View.INVISIBLE);
 //                   holder.injection.setVisibility(View.INVISIBLE);
                }
            }

            /*convertView.setId(position);
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    DayInfo day = mdayList.get(position);

                    //해당 월에 해당하는 날짜일 때
                    if(day.isInMonth()) {
                        Intent intent = new Intent(CalendarTab.this, CalendarDetail.class);
                        startActivity(intent);
                    }
                }
            });*/

            return convertView;
        }


        public class ViewHolder {
            public ImageView waterdrop;
            public ImageView injection;
            public TextView tvItem;

        }

    }

    //하루 정보 확인하고 저장
    public class DayInfo {
        private String day;
        private boolean inMonth;

        public String getDay()
        {
            return day;
        }

        public void setDay(String day)
        {
            this.day = day;
        } //날짜저장

        public boolean isInMonth()
        {
            return inMonth;
        } //이번 달 날짜인지 확인

        public void setInMonth(boolean inMonth)
        {
            this.inMonth = inMonth;
        } //정보저장
    }
}
