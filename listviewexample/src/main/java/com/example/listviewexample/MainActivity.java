package com.example.listviewexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnadd,btnRemove,btnNameAdd;
    EditText edtResult;
    ListView listview1;
    ArrayList<String> list = new ArrayList<String>();
        int num;
    private ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnadd=(Button)findViewById(R.id.btnadd);
        btnRemove=(Button)findViewById(R.id.btnRemove);
        btnNameAdd=(Button)findViewById(R.id.btnNameAdd);
        edtResult=(EditText)findViewById(R.id.edtResult);
        listview1=(ListView)findViewById(R.id.listview1);

        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_single_choice,list);
        listview1.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        listview1.setAdapter(adapter);

        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.add(edtResult.getText().toString()); // ArrayList<String>형 변수 midList에 에디트텍스트 내용을 추가한다.
                adapter.notifyDataSetChanged(); // notifyDataSetChanged()메서드를 호출하여 추가된 항목이 보이도록 한다.
                edtResult.setText("");
            }
        });

        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.remove(listview1.getCheckedItemPosition()); // 선택되어 있는 리스트를 삭제함.
                adapter.notifyDataSetChanged(); // notifyDataSetChanged()메서드를 호출하여 삭제된 후 남은 항목이 보이도록 한다.





            }
        });

        btnNameAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(  // TeacherActivity에 대화상자(Dialog)를 생성한다.
                        MainActivity.this);
                dlg.setTitle("등록정보"); // 대화상자의 제목
                dlg.setMessage("서재윤"); // 대화상자 메시지 내용
                dlg.show(); // 대화상자를 화면에 출력한다.

            }
        });
        registerForContextMenu(listview1); //리스트 뷰변수를 컨텍스트 메뉴를 등록
        listview1.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { //해당리스트의 롱 클릭했을때 동작하는 리스너를 정의함.
            public boolean onItemLongClick(AdapterView<?> arg0, View arg1,  //롱클릭메서드로 동작하는 코드를 작성
                                           int arg2, long arg3) {
                num = arg2;  //롱 클릭했을때 컨텍스트 메뉴에서 Delete를 클릭했을때 삭제할 arg2를 num변수에 보관
                return false;
            }
        });

    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,  // onCreateContextMenu()메소드를 오버라이딩하여 메뉴 파일 등록
                                    ContextMenu.ContextMenuInfo menuInfo) {
        // TODO Auto-generated method stub
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add(0, 1, 0, "Delete"); // 컨텍스트 메뉴
        menu.add(0, 2, 0, "update"); // 컨텍스트 메뉴
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

//        if(item.getItemId()==1) {
//            list.remove(num);
//        adapter.notifyDataSetChanged();
//        }else if(item.getItemId()==2) {
//            list.add(edtResult.getText().toString());
//        adapter.notifyDataSetChanged();
//        }

        switch (item.getItemId()) {
        case 1:   // 컨텍스트 메뉴에서 Delete를 클릭하면 num에 해당하는 리스트 삭제
        list.remove(num);
        adapter.notifyDataSetChanged();
        break;
        case 2:  // 컨텍스트 메뉴에서 update를 클릭하면 에디트텍스트에 있는 내용이 리스트에 추가
        list.add(edtResult.getText().toString());
        adapter.notifyDataSetChanged();
        break;
    }
        return super.onContextItemSelected(item);
    }



    }






//
//
//public class TeacherActivity extends AppCompatActivity {
//    ArrayList<String> midList; // 배열 리스트 변수 선언
//    ListView list; // 리스트 뷰 변수선언
//    ArrayAdapter<String> adapter; // 어댑터뷰의 모양을 설정하고 데이터를 채워주는 배열 어댑터변수 선언
//    EditText edtItem; // 직접 단어를 입력할 에디터텍스트 변수 선언
//    Button btnInsert; // 추가 버튼 객체 변수 선언
//    Button btnDel; //삭제 버튼 객체 변수 선언
//    Button btnInfo; //등록정보 버튼 객체 변수 선언
//    int num; // 롱 클릭했을때 컨텍스트 메뉴에 넘겨줄 값을 받을 변수 선언
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState); // 수퍼클래스인 Activity 클래스의 onCreate메소드를 호출한다.
//        setContentView(R.layout.main); // main.xml의 레이아웃을 화면으로 표시해준다.
//        midList = new ArrayList<String>(); //midList변수에 비어있는 ArrayList<String>형 변수 대입
//        list = (ListView) findViewById(R.id.listView1); //list변수에 xml파일의 리스트뷰 위젯 id를 대입
//        adapter = new ArrayAdapter<String>(this,
//                android.R.layout.simple_list_item_single_choice, midList); //어댑터변수 모양을 라디오버튼형태로 하고 적용시킬 배열을 지정
//        edtItem = (EditText) findViewById(R.id.edtInput);  //edtItem변수에 xml파일의 에디터덱스트 위젯 id를 대입
//        list.setChoiceMode(ListView.CHOICE_MODE_SINGLE); //리스트 변수에 싱글선택을 하도록 설정
//        list.setAdapter(adapter); //생성한 어레이어댑터를 list변수에 적용
//        btnInsert = (Button) findViewById(R.id.btnInsert); //btnInsert변수에 xml파일의 버튼 위젯 id를 대입
//        btnInsert.setOnClickListener(new View.OnClickListener() { // 추가버튼을 클릭했을때 동작하는 리스너를 정의함.
//            public void onClick(View v) {  // 클릭메서드로 버튼을 클릭했을때 동작하는 코드를 작성한다.
//                // TODO Auto-generated method stub
//                midList.add(edtItem.getText().toString()); // ArrayList<String>형 변수 midList에 에디트텍스트 내용을 추가한다.
//                adapter.notifyDataSetChanged(); // notifyDataSetChanged()메서드를 호출하여 추가된 항목이 보이도록 한다.
//            }
//        });
//        btnDel = (Button) findViewById(R.id.btnDel); //btnDel변수에 xml파일의 버튼 위젯 id를 대입
//        btnDel.setOnClickListener(new View.OnClickListener() { // 삭제버튼을 클릭했을때 동작하는 리스너를 정의함.
//            public void onClick(View v) { // 클릭메서드로 버튼을 클릭했을때 동작하는 코드를 작성한다.
//                // TODO Auto-generated method stub
//                midList.remove(list.getCheckedItemPosition()); // 선택되어 있는 리스트를 삭제함.
//                adapter.notifyDataSetChanged(); // notifyDataSetChanged()메서드를 호출하여 삭제된 후 남은 항목이 보이도록 한다.
//            }
//        });
//        btnInfo = (Button) findViewById(R.id.btnInfo);//btnInfo변수에 xml파일의 버튼 위젯 id를 대입
//        btnInfo.setOnClickListener(new View.OnClickListener() {// 등록정보 버튼을 클릭했을때 동작하는 리스너를 정의함.
//            public void onClick(View v) { // 클릭메서드로 버튼을 클릭했을때 동작하는 코드를 작성한다.
//                // TODO Auto-generated method stub
//                AlertDialog.Builder dlg = new AlertDialog.Builder(  // TeacherActivity에 대화상자(Dialog)를 생성한다.
//                        TeacherActivity.this);
//                dlg.setTitle("등록정보"); // 대화상자의 제목
//                dlg.setMessage("최원철"); // 대화상자 메시지 내용
//                dlg.show(); // 대화상자를 화면에 출력한다.
//            }
//        });
//        registerForContextMenu(list); //리스트 뷰변수를 컨텍스트 메뉴를 등록
//        list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { //해당리스트의 롱 클릭했을때 동작하는 리스너를 정의함.
//            public boolean onItemLongClick(AdapterView<?> arg0, View arg1,  //롱클릭메서드로 동작하는 코드를 작성
//                                           int arg2, long arg3) {
//                num = arg2;  //롱 클릭했을때 컨텍스트 메뉴에서 Delete를 클릭했을때 삭제할 arg2를 num변수에 보관
//                return false;
//            }
//        });
//    }
//    @Override
//    public void onCreateContextMenu(ContextMenu menu, View v,  // onCreateContextMenu()메소드를 오버라이딩하여 메뉴 파일 등록
//                                    ContextMenuInfo menuInfo) {
//        // TODO Auto-generated method stub
//        super.onCreateContextMenu(menu, v, menuInfo);
//        menu.add(0, 1, 0, "Delete"); // 컨텍스트 메뉴
//        menu.add(0, 2, 0, "update"); // 컨텍스트 메뉴
//    }
//    @Override
//    public boolean onContextItemSelected(MenuItem item) { //메뉴 선택 시 동작할 내용을 코딩함.
//        // TODO Auto-generated method stub
//        switch (item.getItemId()) {
//            case 1:   // 컨텍스트 메뉴에서 Delete를 클릭하면 num에 해당하는 리스트 삭제
//                midList.remove(num);
//                adapter.notifyDataSetChanged();
//                break;
//            case 2:  // 컨텍스트 메뉴에서 update를 클릭하면 에디트텍스트에 있는 내용이 리스트에 추가
//                midList.add(edtItem.getText().toString());
//                adapter.notifyDataSetChanged();
//                break;
//        }
//        return super.onContextItemSelected(item); //선택된 텍스트 메뉴에 대해 실행후 리턴
//    }
//}