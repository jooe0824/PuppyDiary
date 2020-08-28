package org.techtown.puppydiary;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class CalendarItem extends AppCompatActivity {
    ActionBar actionBar;
    private  static final int REQUEST_CODE = 0;

    ImageView image_upload;

    Button waterdrop_btn;
    Button waterdrop_btn2;
    Button injection_btn;
    Button injection_btn2;
    Button cancel_btn;
    Button save_btn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_calendar_detail);

        actionBar = getSupportActionBar();
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(0xffD6336B));
        getSupportActionBar().setTitle("댕댕이어리");
        actionBar.setIcon(R.drawable.white_puppy) ;
        actionBar.setDisplayUseLogoEnabled(true) ;
        actionBar.setDisplayShowHomeEnabled(true) ;


        image_upload = (ImageView) findViewById(R.id.image_upload);

        waterdrop_btn = findViewById(R.id.waterdrop_detail);
        waterdrop_btn2 = findViewById(R.id.waterdrop_color);
        injection_btn = findViewById(R.id.injection_detail);
        injection_btn2 = findViewById(R.id.injection_color);
        cancel_btn = findViewById(R.id.btn_canceldetail);
        save_btn = findViewById(R.id.btn_savedetail);

        //기본세팅 : 물방울, 주사기 색깔 없음
        waterdrop_btn2.setVisibility(View.INVISIBLE);
        injection_btn2.setVisibility(View.INVISIBLE);

        waterdrop_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                waterdrop_btn2.setVisibility(View.VISIBLE);
                waterdrop_btn.setVisibility(View.INVISIBLE);
            }
        });

        waterdrop_btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                waterdrop_btn.setVisibility(View.VISIBLE);
                waterdrop_btn2.setVisibility(View.INVISIBLE);
            }
        });

        injection_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                injection_btn2.setVisibility(View.VISIBLE);
                injection_btn.setVisibility(View.INVISIBLE);
            }
        });

        injection_btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                injection_btn.setVisibility(View.VISIBLE);
                injection_btn2.setVisibility(View.INVISIBLE);
            }
        });

        image_upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });

        cancel_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}
