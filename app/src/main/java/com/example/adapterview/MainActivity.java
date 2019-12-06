package com.example.adapterview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //리스트뷰

    ListView list1;
    String p12Team [] = { "한국","일본","대만","멕시코","미국","호주","쿠바"};   //지금은 배열로 했지만 나중에는 DB로 입력한다.
    int rank[] = {3,1,4,7,2,5,6};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list1=(ListView)findViewById(R.id.list1);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_single_choice,p12Team);   //1.어레이어뎁터 생성 ,android.R.layout.simple_list_item_1  기본적으로 제공하는 모양의 것들 중에서 만들었다. 나중에 직접 만들려면 xml로 만들어서 인플레이트 시킨다.
        list1.setChoiceMode(ListView.CHOICE_MODE_SINGLE);  //4. simple_list_item_multiple_choice 또는 .simple_list_item_single_choice 모양은 반드시 이 부분을 세팅 시켜 줘야 된다.
        list1.setAdapter(adapter);  // 2. 리스트뷰에 setAdapter(adapter)장착!
        list1.setOnItemClickListener(new AdapterView.OnItemClickListener() {  //3. setOnItemClickListener 생성 후 메소드에 할 일 수행
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),"세계랭킹:"+rank[position]+"위",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
