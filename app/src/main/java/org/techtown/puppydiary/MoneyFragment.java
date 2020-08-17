package org.techtown.puppydiary;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

public class MoneyFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView  = (ViewGroup) inflater.inflate(R.layout.fragment_money, container, false); //container 라는 뷰 안에 첫번째 인자를 넣어줘라, 메모리에 올려준 것

        return rootView;
    }
}
