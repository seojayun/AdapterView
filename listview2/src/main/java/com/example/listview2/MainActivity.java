package com.example.listview2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

//리스트뷰 동적 추가 및 삭제

public class MainActivity extends AppCompatActivity {
    EditText edtItem;
    Button btnAdd;
    ListView listView1;
    ArrayList<String> list = new ArrayList<String>();   //  1. 동적 배열 생성  길이 size,  add추가 및 remove삭제 가능

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtItem=(EditText)findViewById(R.id.edtItem);
        btnAdd=(Button)findViewById(R.id.btnAdd);
        listView1=(ListView)findViewById(R.id.listView1);

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list); //2. 동적배열 생성한 것을 집어 넣는다.
        listView1.setAdapter(adapter);  //3. 어뎁터 장착

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.add(edtItem.getText().toString());  //4. edttext의 글자를 가져옴//동적배열은 add를 쓴다.
                adapter.notifyDataSetChanged();  // 5..notifyDataSetChanged(); 기존데이터에서 새로운 데이터로 교체해준다(새로고침이라고 생각하면됨)
            }
        });
        listView1.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) { //6. onItemLongClick 롱 클릭은 꾹 눌렀을때 동작
                list.remove(position); //7.삭제한다. 삭제되면 나머지 자료들이 배열번호가 알아서 수정된다.
                adapter.notifyDataSetChanged();
                return false;
            }
        });

    }
}
