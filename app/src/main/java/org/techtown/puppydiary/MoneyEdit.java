package org.techtown.puppydiary;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class MoneyEdit extends AppCompatActivity {

    private  static Context context;
    ActionBar actionBar;

   /* public static MoneyEdit newInstance() {
        return new MoneyEdit();
    }

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
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_money_edit);

        MoneyEdit.context = getApplicationContext();
        actionBar = getSupportActionBar();
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(0xff006aff));
        getSupportActionBar().setTitle("댕댕이어리");

        Button button = findViewById(R.id.edit);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent_kg = new Intent(getApplicationContext(), MoneyTab.class); //일단 바로 검색결과 띄음
                startActivity(intent_kg);
                 Toast toastView = Toast.makeText(getApplicationContext(), "수정되었습니다" , Toast.LENGTH_LONG);

                                          toastView.setGravity( Gravity.TOP| Gravity.LEFT, 180, 700); //토스트 메시지 위치 x,y좌표로 바꿀 수 있다.
                                          toastView.show();
            }
        });
        Button button2 = findViewById(R.id.delete);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent_kg = new Intent(getApplicationContext(), MoneyTab.class); //일단 바로 검색결과 띄음
                startActivity(intent_kg);
            }
        });
    }
}
