package org.techtown.puppydiary;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.util.Calendar;

public class MypuppyFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView  = (ViewGroup) inflater.inflate(R.layout.fragment_mypuppy, container, false); //container 라는 뷰 안에 첫번째 인자를 넣어줘라, 메모리에 올려준 것

        TextView textView = rootView.findViewById(R.id.textView);
        SpannableString content = new SpannableString("우리 집 댕댕이는요");
        content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
        textView.setText(content);


        Calendar cal = Calendar.getInstance();
        final DatePickerDialog dialog = new DatePickerDialog(this, listner, 2020, 1, 1);

        EditText b_day = rootView.findViewById(R.id.bd_input);
        b_day.setText(cal.get(Calendar.YEAR)+ "-" + (cal.get(Calendar.MONTH)+1) + "-" + cal.get(Calendar.DATE));

        b_day.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.show();
            }
        });

        return rootView;
    }

    private DatePickerDialog.OnDateSetListener listner = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int yy, int mm, int dd) {
            EditText b_day = getView().findViewById(R.id.bd_input);
            b_day.setText(String.format("%d-%d-%d", yy,mm+1,dd));
        }
    };
}
