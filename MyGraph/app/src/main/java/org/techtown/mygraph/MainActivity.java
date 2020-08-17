package org.techtown.mygraph;

import android.app.Activity;
import android.content.Intent;
//import android.support.v7.app.AppCompatActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import org.techtown.mygraph.R;

import java.util.ArrayList;
import java.util.List;

import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HorizontalBarChart chart = (HorizontalBarChart) findViewById(R.id.chart);

        chart.getXAxis().setDrawGridLines(false); //grid 선 없애주기
        XAxis x = chart.getXAxis(); //x라는 변수 만들어서 이용
        x.setPosition(XAxis.XAxisPosition.BOTTOM); //x축 왼쪽으로 옮기기
        x.setTextSize(0);
        x.setTextColor(0x00000000);

        ArrayList<BarEntry> entries = new ArrayList();
        entries.add(new BarEntry(1f, 4));
        entries.add(new BarEntry(2f, 4));
        entries.add(new BarEntry(3f, 4));
        entries.add(new BarEntry(4f, 3));
        entries.add(new BarEntry(5f, 3));
        entries.add(new BarEntry(6f, 0));
        entries.add(new BarEntry(7f, 5));
        entries.add(new BarEntry(8f, 4));
        entries.add(new BarEntry(9f, 4));
        entries.add(new BarEntry(10f, 3));
        entries.add(new BarEntry(11f, 4));
        entries.add(new BarEntry(12f, 5));

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

        ArrayList<BarEntry> entries = new ArrayList();
        entries.add(new BarEntry(1f, 4));
        entries.add(new BarEntry(2f, 4));
        entries.add(new BarEntry(3f, 4));
        entries.add(new BarEntry(4f, 3));
        entries.add(new BarEntry(5f, 3));
        entries.add(new BarEntry(6f, 0));
        entries.add(new BarEntry(7f, 5));
        entries.add(new BarEntry(8f, 4));
        entries.add(new BarEntry(9f, 4));
        entries.add(new BarEntry(10f, 3));
        entries.add(new BarEntry(11f, 4));
        entries.add(new BarEntry(12f, 5));

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