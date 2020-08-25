package org.techtown.puppydiary;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;


public class KgPopup extends AppCompatActivity {

    private  static Context context;
    ActionBar actionBar;

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
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_kg_upload);

        // MoneyEdit.context = getApplicationContext();
        actionBar = getSupportActionBar();
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(0xff006aff));
        getSupportActionBar().setTitle("댕댕이어리");

        Button button = findViewById(R.id.kg_confirm);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent_kgconfirm = new Intent(getApplicationContext(), KgTab.class); //일단 바로 검색결과 띄음
                startActivity(intent_kgconfirm);
            }
        });

        Button button2 = findViewById(R.id.close);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent_kgclose = new Intent(getApplicationContext(), KgTab.class); //일단 바로 검색결과 띄음
                startActivity(intent_kgclose);
            }
        });
    }
}
