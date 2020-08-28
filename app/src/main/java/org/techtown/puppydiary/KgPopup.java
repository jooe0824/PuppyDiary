package org.techtown.puppydiary;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import org.techtown.puppydiary.KgTab;
import static org.techtown.puppydiary.KgTab.kg_month;

public class KgPopup extends AppCompatActivity {
    String monthname;
    private  static Context context;
    ActionBar actionBar;
    //public static double puppykg;
    public static double [] puppykg = new double[12];
    String kgStr;
    EditText weight;
    Button okay;
    Button close;
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
    }
*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //puppykg = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_kg_upload);

        // MoneyEdit.context = getApplicationContext();
        actionBar = getSupportActionBar();
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(0xffD6336B));
        getSupportActionBar().setTitle("댕댕이어리");
        actionBar.setIcon(R.drawable.white_puppy) ;
        actionBar.setDisplayUseLogoEnabled(true) ;
        actionBar.setDisplayShowHomeEnabled(true) ;


        monthname = kg_month;
        TextView Month = (TextView) findViewById(R.id.kgmonth);
        Month.setText(monthname);  //클릭한 달의 이름으로 setText



        okay = findViewById(R.id.kg_confirm);
        okay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //button.setBackground(R.drawable.button_pressed);
                okay.setBackgroundResource(R.drawable.button_pressed);
                Intent intent_kgconfirm = new Intent(getApplicationContext(), KgTab.class); //일단 바로 검색결과 띄음
                startActivity(intent_kgconfirm);

                weight = (EditText)findViewById(R.id.kg_weight); //weight edittext 가져오기
                kgStr = weight.getText().toString();

                if(monthname.equals("January")) {
                    puppykg[11] = Double.parseDouble(kgStr);
                }
                else if(monthname.equals("February")) {
                    puppykg[10] = Double.parseDouble(kgStr);
                }
                else if(monthname.equals("March")) {
                    puppykg[9] = Double.parseDouble(kgStr);
                }
                else if(monthname.equals("April")) {
                    puppykg[8] = Double.parseDouble(kgStr);
                }
                else if(monthname.equals("May")) {
                    puppykg[7] = Double.parseDouble(kgStr);
                }
                else if(monthname.equals("June")) {
                    puppykg[6] = Double.parseDouble(kgStr);
                }
                else if(monthname.equals("July")) {
                    puppykg[5] = Double.parseDouble(kgStr);
                }
                else if(monthname.equals("August")) {
                    puppykg[4] = Double.parseDouble(kgStr);
                }
                else if(monthname.equals("September")) {
                    puppykg[3] = Double.parseDouble(kgStr);
                }
                else if(monthname.equals("October")) {
                    puppykg[2] = Double.parseDouble(kgStr);
                }
                else if(monthname.equals("November")) {
                    puppykg[1] = Double.parseDouble(kgStr);
                }
                else if(monthname.equals("December")) {
                    puppykg[0] = Double.parseDouble(kgStr);
                }

                //Log.d("kg1", "kg1" + kgStr);
                //Log.d("kg2", "kg2" + ((EditText)findViewById(R.id.kg_weight)).getText().toString());
                //Log.d("kgpopup", "kgpopup ." + puppykg);
            }
        });

        close = findViewById(R.id.close);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent_kgclose = new Intent(getApplicationContext(), KgTab.class); //일단 바로 검색결과 띄음
                startActivity(intent_kgclose);
            }
        });
    }
}
