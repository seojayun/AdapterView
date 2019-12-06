package com.example.customlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

//CustomListView
//
//        1. 메인엑티비티
//        2. 메인xml - 리스트뷰 생성
//        3. 어뎁터
//        4. 커스텀 리스트뷰 아이템 전용 xml   - 한 항목당 제작
//        5. 데이터 클래스(ListView에 들어갈 자료) - 변수 선언 및 생성자 생성 (캡슐화)


public class MainActivity extends AppCompatActivity {

    ListView listView1;
    MyAdapter adapter;
    Integer posterID[] =  {R.drawable.baseballsub,R.drawable.baseballsub,R.drawable.baseballsub,R.drawable.baseballsub,R.drawable.baseballsub,R.drawable.baseballsub,R.drawable.baseballsub,R.drawable.baseballsub,R.drawable.baseballsub,R.drawable.baseballsub} ; //16.ItemData에 넘겨주기 위한 배열 변수선언
    String title[] = {"써니","완득이","괴물","라디오스타","비열한거리","왕의남자","아일랜드","웰컴투동막골","헬보이","백투더퓨쳐"};
    String content[] = {"7공주 프로젝트","내 인생이 꼬이기 시작했다.","가족의 사투가 시작되었다.","언제나 나를 최고라고...","지금 여기 그 남자의...","질투와 열망이 부른...","이제 거대한 미래가 창조된다.","1950년 지금은 전쟁중...",
            "잘 생긴 얼굴만 세상을 구하는 것은 아니지...","과거로 여행을..."};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView1=(ListView)findViewById(R.id.listView1);

        List<ItemData> data = new ArrayList<>();//17.동적 배열 생성
        for(int i = 0; i<posterID.length; i++) { //18.for문 작성
           data.add(new ItemData(posterID[i],title[i],content[i]));  //19.동적배열에 값을 넣는데, 생성하면서 값을 넣는다.(생성자에 3개를 생성햇으므로 3개를 입력하라고 표기된다.)
        }
        adapter=new MyAdapter(this,data);  //20.어뎁터에 값 대입
        listView1.setAdapter(adapter);  //21.리스트뷰에 최종적으로 setAdapter 시킨다.adapter를...


    }
}
