package com.example.tacademy.samplefragmentbuttontab1;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    Fragment fragment;
    private static final String TAB1_TAG = "tab1";
    private static final String TAB2_TAG = "tab2";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = (Button)findViewById(R.id.btn_tab1);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Fragment f = new Tab1Fragment();
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.container, f, TAB1_TAG); //이코드로 탭1, 탭2 구분
                ft.commit();
            }
        });

        if(savedInstanceState == null) {
            Fragment f = new Tab1Fragment();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.container, f, TAB1_TAG);
            ft.commit();
        } //처음에 액티비티 띄울때 나오는 탭 , 중간에 끄고 다시시작해서 savedInstanceState가 있으면 실행하지 않음

         btn = (Button)findViewById(R.id.btn_tab2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment f = new Tab2Fragment();
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.container, f, TAB2_TAG);
                ft.commit();
            }
        });


    }
}
