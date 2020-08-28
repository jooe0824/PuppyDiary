package org.techtown.puppydiary;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
//import android.support.v7.app.AppCompatActivity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.utils.ColorTemplate;

import org.techtown.puppydiary.accountmenu.MoneyTab;
import static org.techtown.puppydiary.KgPopup.puppykg;

import java.util.ArrayList;
import java.util.Calendar;

import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

public class KgTab extends AppCompatActivity {
    private TextView tvDate;
    private  static Context context;
    ActionBar actionBar;
    Calendar mCal;

    public static String kg_month;
    //double puppyjan = 0;
    double [] kgpuppy = new double[12];
    //double [] kgpuppy = {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};

    Button jan;
    Button feb;
    Button mar;
    Button apr;
    Button may;
    Button jun;
    Button jul;
    Button aug;
    Button sep;
    Button oct;
    Button nov;
    Button dec;

    static boolean jan_pr = false;

/*
    MainActivity mainActivity;

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

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kg);

        tvDate = (TextView) findViewById(R.id.tv_date);
        mCal = Calendar.getInstance();

        // MoneyEdit.context = getApplicationContext();
        actionBar = getSupportActionBar();
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(0xffD6336B));
        getSupportActionBar().setTitle("댕댕이어리");
        actionBar.setIcon(R.drawable.white_puppy) ;
        actionBar.setDisplayUseLogoEnabled(true) ;
        actionBar.setDisplayShowHomeEnabled(true) ;

        //getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        //getSupportActionBar().setCustomView(R.layout.custom_bar);


        // 캘린더 타이틀(년월 표시)을 세팅한다.
        tvDate.setText((mCal.get(Calendar.YEAR)) + "년");

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

        Button money = findViewById(R.id.account);
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

        // Monthly KG upload BUTTON
       // puppyjan = puppykg;
        jan = findViewById(R.id.jan);
        jan.setOnClickListener(new View.OnClickListener() {
               //int jan = 0;
               @Override
               public void onClick(View v) {
                    //jan.setSelected(true);
                    jan.setBackgroundResource(R.drawable.button_pressed);
                    Intent intent_kgjan = new Intent(getApplicationContext(), KgPopup.class);
                    startActivity(intent_kgjan);
                    kg_month = "January";
                }
        });
        feb = findViewById(R.id.feb);
        feb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                feb.setBackgroundResource(R.drawable.button_pressed);
                Intent intent_kgfeb = new Intent(getApplicationContext(), KgPopup.class);
                startActivity(intent_kgfeb);
                kg_month = "February";
            }
        });
        mar = findViewById(R.id.mar);
        mar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mar.setBackgroundResource(R.drawable.button_pressed);
                Intent intent_kgmar = new Intent(getApplicationContext(), KgPopup.class);
                startActivity(intent_kgmar);
                kg_month = "March";
            }
        });
        apr = findViewById(R.id.apr);
        apr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                apr.setBackgroundResource(R.drawable.button_pressed);
                Intent intent_kgapr = new Intent(getApplicationContext(), KgPopup.class);
                startActivity(intent_kgapr);
                kg_month = "April";
            }
        });
        may = findViewById(R.id.may);
        may.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                may.setBackgroundResource(R.drawable.button_pressed);
                Intent intent_kgmay = new Intent(getApplicationContext(), KgPopup.class);
                startActivity(intent_kgmay);
                kg_month = "May";
            }
        });
        jun = findViewById(R.id.jun);
        jun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jun.setBackgroundResource(R.drawable.button_pressed);
                Intent intent_kgjun = new Intent(getApplicationContext(), KgPopup.class);
                startActivity(intent_kgjun);
                kg_month = "June";
            }
        });
        jul = findViewById(R.id.jul);
        jul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jul.setBackgroundResource(R.drawable.button_pressed);
                Intent intent_kgjun = new Intent(getApplicationContext(), KgPopup.class);
                startActivity(intent_kgjun);
                kg_month = "July";
            }
        });
        aug= findViewById(R.id.aug);
        aug.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aug.setBackgroundResource(R.drawable.button_pressed);
                Intent intent_kgjun = new Intent(getApplicationContext(), KgPopup.class);
                startActivity(intent_kgjun);
                kg_month = "August";
            }
        });
        sep = findViewById(R.id.sep);
        sep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sep.setBackgroundResource(R.drawable.button_pressed);
                Intent intent_kgjun = new Intent(getApplicationContext(), KgPopup.class);
                startActivity(intent_kgjun);
                kg_month = "September";
            }
        });
        oct = findViewById(R.id.oct);
        oct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                oct.setBackgroundResource(R.drawable.button_pressed);
                Intent intent_kgjun = new Intent(getApplicationContext(), KgPopup.class);
                startActivity(intent_kgjun);
                kg_month = "October";
            }
        });
        nov = findViewById(R.id.nov);
        nov.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nov.setBackgroundResource(R.drawable.button_pressed);
                Intent intent_kgjun = new Intent(getApplicationContext(), KgPopup.class);
                startActivity(intent_kgjun);
                kg_month = "November";
            }
        });
        dec = findViewById(R.id.dec);
        dec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dec.setBackgroundResource(R.drawable.button_pressed);
                Intent intent_kgjun = new Intent(getApplicationContext(), KgPopup.class);
                startActivity(intent_kgjun);
                kg_month = "December";
            }
        });





        Button pvs_button = findViewById(R.id.previous);
        Button nxt_button = findViewById(R.id.next);

        pvs_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                        mCal.add(Calendar.YEAR, -1);
                        tvDate.setText((mCal.get(Calendar.YEAR)) + "년");
                }
        });
        nxt_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCal.add(Calendar.YEAR, +1);
                tvDate.setText((mCal.get(Calendar.YEAR)) + "년");
            }
        });


        HorizontalBarChart chart = (HorizontalBarChart) findViewById(R.id.chart);

        chart.getXAxis().setDrawGridLines(false); //grid 선 없애주기
        XAxis x = chart.getXAxis(); //x라는 변수 만들어서 이용
        x.setPosition(XAxis.XAxisPosition.BOTTOM); //x축 왼쪽으로 옮기기
        x.setTextSize(0);
        x.setTextColor(0x00000000);


        ArrayList<BarEntry> entries = new ArrayList();
        /*entries.add(new BarEntry(1f, puppyjan));
        entries.add(new BarEntry(2f, 4));
        entries.add(new BarEntry(3f, 0));
        entries.add(new BarEntry(4f, 0));
        entries.add(new BarEntry(5f, 0));
        entries.add(new BarEntry(6f, 0));
        entries.add(new BarEntry(7f, 5));
        entries.add(new BarEntry(8f, 0));
        entries.add(new BarEntry(9f, 0));
        entries.add(new BarEntry(10f, 0));
        entries.add(new BarEntry(11f, 0));
        entries.add(new BarEntry(12f, 0));*/

        BarDataSet dataset = new BarDataSet(entries,"체중(kg)");//속성값
        dataset.setColors(ColorTemplate.COLORFUL_COLORS);//color random

        BarData data = new BarData(getDataSet());

        final ArrayList<String> labels = new ArrayList<>();
        labels.add("Jan");
        labels.add("Feb");
        labels.add("Mar");
        labels.add("Apr");
        labels.add("May");
        labels.add("Jun");
        labels.add("Jul");
        labels.add("Aug");
        labels.add("Sep");
        labels.add("Oct");
        labels.add("Nov");
        labels.add("Dec");

        // chart.setDescription();
        chart.getXAxis().setDrawAxisLine(false);
        chart.setData(data);
        chart.setFitBars(true);
        chart.animateXY(2000, 2000); //애니메이션 기능 추가
        chart.invalidate(); //invalidate 해줘야 함

    }



    private ArrayList<String> getXAxisValues() { //x축 라벨 추가
        ArrayList<String> labels = new ArrayList();
        labels.add("Jan");
        labels.add("Feb");
        labels.add("Mar");
        labels.add("Apr");
        labels.add("May");
        labels.add("Jun");
        labels.add("Jul");
        labels.add("Aug");
        labels.add("Sep");
        labels.add("Oct");
        labels.add("Nov");
        labels.add("Dec");

        return labels;

    }

    private BarDataSet getDataSet() { //표시할 데이터 추가


        for(int i =0; i<12 ; i++) {
            kgpuppy[i] = puppykg[i];
        }
        //Log.d("kg", "kg ." + puppyjan);

        ArrayList<BarEntry> entries = new ArrayList();
        entries.add(new BarEntry(1f, (float) kgpuppy[0]));
        entries.add(new BarEntry(2f, (float) kgpuppy[1]));
        entries.add(new BarEntry(3f, (float) kgpuppy[2]));
        entries.add(new BarEntry(4f, (float) kgpuppy[3]));
        entries.add(new BarEntry(5f, (float) kgpuppy[4]));
        entries.add(new BarEntry(6f, (float) kgpuppy[5]));
        entries.add(new BarEntry(7f, (float) kgpuppy[6]));
        entries.add(new BarEntry(8f, (float) kgpuppy[7]));
        entries.add(new BarEntry(9f, (float) kgpuppy[8]));
        entries.add(new BarEntry(10f, (float) kgpuppy[9]));
        entries.add(new BarEntry(11f, (float) kgpuppy[10]));
        entries.add(new BarEntry(12f, (float) kgpuppy[11]));

        BarDataSet dataset = new BarDataSet(entries,"체중(kg)");//속성값
        dataset.setColors(ColorTemplate.VORDIPLOM_COLORS);//color random


        return dataset;
    }


}

/*
public class MainActivity extends Activity{

    private LineChart lineChart;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lineChart = (LineChart)findViewById(R.id.chart);

        List<Entry> entries = new ArrayList<>();
        entries.add(new Entry(1, 4));
        entries.add(new Entry(2, 4));
        entries.add(new Entry(3, 4));
        entries.add(new Entry(4, 5));
        entries.add(new Entry(5, 3));
        entries.add(new Entry(6, 0));
        entries.add(new Entry(7, 3));
        entries.add(new Entry(8, 3));
        entries.add(new Entry(9, 3));
        entries.add(new Entry(10, 3));
        entries.add(new Entry(11, 3));
        entries.add(new Entry(12, 3));

        LineDataSet lineDataSet = new LineDataSet(entries, "체중(kg)");
        lineDataSet.setLineWidth(2);
        lineDataSet.setCircleRadius(10);
        lineDataSet.setCircleColor(Color.parseColor("#FFA1B4DC"));
        lineDataSet.setCircleColorHole(Color.BLUE);
        lineDataSet.setColor(Color.parseColor("#FFA1B4DC"));
        lineDataSet.setDrawCircleHole(true);
        lineDataSet.setDrawCircles(true);
        lineDataSet.setDrawHorizontalHighlightIndicator(false);
        lineDataSet.setDrawHighlightIndicators(false);
        lineDataSet.setDrawValues(false);

        LineData lineData = new LineData(lineDataSet);
        lineChart.setData(lineData);

        XAxis xAxis = lineChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.TOP);
        xAxis.setTextColor(Color.BLACK);
        xAxis.enableGridDashedLine(8, 24, 0);

        YAxis yLAxis = lineChart.getAxisLeft();
        yLAxis.setTextColor(Color.BLACK);

        YAxis yRAxis = lineChart.getAxisRight();
        yRAxis.setDrawLabels(false);
        yRAxis.setDrawAxisLine(false);
        yRAxis.setDrawGridLines(false);

        Description description = new Description();
        description.setText("");

        lineChart.setDoubleTapToZoomEnabled(false);
        lineChart.setDrawGridBackground(false);
        lineChart.setDescription(description);
        lineChart.animateY(2000, Easing.EasingOption.EaseInCubic);
        lineChart.invalidate();

    }
}



public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ArrayList<Integer> jsonList = new ArrayList<>(); // ArrayList 선언
    ArrayList<String> labelList = new ArrayList<>(); // ArrayList 선언

    //두 개의 버튼 임시 추가 (해당코드엔 없어야맞음)
    Button backButton;
    Button homeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        LineChartGraph(labelList, jsonList);


    }

    public void init(){

        backButton =(Button) findViewById(R.id.home_btn);
        homeButton =(Button) findViewById(R.id.back_btn);

        backButton.setOnClickListener(this);
        homeButton.setOnClickListener(this);


        jsonList.add(10);
        jsonList.add(3);
        jsonList.add(1);
        jsonList.add(2);

        labelList.add("1");
        labelList.add("2");
        labelList.add("3");
        labelList.add("4");

    }


    private void LineChartGraph(ArrayList labelList, ArrayList valList){

        // LineChart 메소드

        LineChart lineChart = (LineChart) findViewById(R.id.chart);



        ArrayList<Entry> entries = new ArrayList<>();

        for(int i=0; i < valList.size();i++){

            entries.add(new Entry((Integer) valList.get(i), i));

        }



        LineDataSet depenses = new LineDataSet(entries, "# of Calls");

        depenses.setAxisDependency(YAxis.AxisDependency.LEFT);



        ArrayList<String> labels = new ArrayList<String>();

        for(int i=0; i < labelList.size(); i++){

            labels.add((String) labelList.get(i));

        }



        ArrayList<ILineDataSet> dataSets = new ArrayList<>();

        dataSets.add((ILineDataSet)depenses);

        LineData data = new LineData(labels,dataSets); // 라이브러리 v3.x 사용하면 에러 발생함

        depenses.setColors(ColorTemplate.COLORFUL_COLORS); //

        //depenses.setDrawCubic(true); //선 둥글게 만들기

        //depenses.setDrawFilled(true); //그래프 밑부분 색칠



        lineChart.setData(data);

        lineChart.animateXY(1000,1000);

        lineChart.invalidate();

    }



    private String DateChange(String sysdate){

        String year = sysdate.split("-")[0];

        String month = sysdate.split("-")[1];

        String day = sysdate.split("-")[2];



        StringBuilder finalString = new StringBuilder();

        finalString.append(year.substring(2,4));

        finalString.append(".");

        finalString.append(month);

        //finalString.append(".");

        //finalString.append(day);

        return finalString.toString();

    }



    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.back_btn:

                finish();

                // overridePendingTransition(R.anim.rightin, R.anim.rightout);

                break;

            case R.id.home_btn:

                Intent intent = new Intent(this, MainActivity.class);

                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);

                startActivity(intent);

                break;

            default:

                break;

        }

    }

}*/