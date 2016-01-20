package com.example.tacademy.samplefragmentbuttontab1;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button selectButton;

    Fragment fragment;
    private static final String TAB1_TAG = "tab1";
    private static final String TAB2_TAG = "tab2";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = (Button) findViewById(R.id.btn_tab1);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment old = getSupportFragmentManager().findFragmentByTag(TAB1_TAG);  // 이미 생성되어 있으면 태그를 읽어서 다시 생성하지 않도록한다.
                if(old == null) {
                    Fragment f = new Tab1Fragment();
                    FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.container, f, TAB1_TAG); //이코드로 탭1, 탭2 구분
                    ft.commit();
                    setSelectButton((Button) v);
                }
            }
        });

        if (savedInstanceState == null) {
            Fragment f = new Tab1Fragment();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.container, f, TAB1_TAG);
            ft.commit();
            setSelectButton(btn); //?
        } //처음에 액티비티 띄울때 나오는 탭 , 중간에 끄고 다시시작해서 savedInstanceState가 있으면 실행하지 않음

        btn = (Button) findViewById(R.id.btn_tab2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment old = getSupportFragmentManager().findFragmentByTag(TAB2_TAG);  // 이미 생성되어 있으면 태그를 읽어서 다시 생성하지 않도록한다.
                if(old == null) {
                    Fragment f = new Tab2Fragment();
                    FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.container, f, TAB2_TAG);
                    ft.commit();
                    setSelectButton((Button) v);
                }
            }
        });
    }

        private void setSelectButton(Button button){ //버튼 셀렉트 하면 바뀌가 하는 코드
        if(selectButton != button){
            if(selectButton != null){
                selectButton.setSelected(false);
            }
            selectButton = button;
            selectButton.setSelected(true);
        }
    }


}
