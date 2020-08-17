package org.techtown.puppydiary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener {


    public static String LOG_TAG = "MainActivity";

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);




        //막대 그래프

        Button btnBarChart =  (Button)findViewById(R.id.btnBarChart);

        btnBarChart.setOnClickListener(this);

    }


    @Override

    public void onClick(View v) {

        switch (v.getId()) {



            //막대 그래프(Bar Chart)

            case R.id.btnBarChart:

                Toast.makeText(MainActivity.this, "Bar Chart", Toast.LENGTH_LONG);

                Log.i(LOG_TAG, "Bar Chart Start...");

                startActivity(new Intent(this, KgActivity.class));

                break;

        }

    }

}