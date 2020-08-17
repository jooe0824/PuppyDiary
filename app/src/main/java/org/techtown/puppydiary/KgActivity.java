package org.techtown.puppydiary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class KgActivity extends AppCompatActivity implements View.OnClickListener {

    ArrayList<Integer> jsonList = new ArrayList<>(); // ArrayList 선언
    ArrayList<String> labelList = new ArrayList<>(); // ArrayList 선언

    //두 개의 버튼 임시 추가 (해당코드엔 없어야맞음)
    Button backButton;
    Button homeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kg);

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

}