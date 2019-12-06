package com.example.girdview;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    GridView gridView1;
//그리드뷰

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView1=(GridView)findViewById(R.id.gridView1);

        MyGridAdapter adapter = new MyGridAdapter(this);  //5. onCreate 메소드 안에 어뎁터를 생성한다. (그림을 넣을 준비)
        gridView1.setAdapter(adapter);//11.gridView1에 adapter를 장착시킨다.


    }


    public class  MyGridAdapter extends BaseAdapter {  //1. 클래스 생성 후 빨간 밑줄 뜨면 메소드 생성한다.
        Context context; //3. Context 변수 선언
        Integer  posterID[] =  {R.drawable.mov01, R.drawable.mov02, R.drawable.mov03, R.drawable.mov04, R.drawable.mov05, R.drawable.mov06, R.drawable.mov07, R.drawable.mov08, R.drawable.mov09, R.drawable.mov10,
                R.drawable.mov01, R.drawable.mov02, R.drawable.mov03, R.drawable.mov04, R.drawable.mov05, R.drawable.mov06, R.drawable.mov07, R.drawable.mov08, R.drawable.mov09, R.drawable.mov10,
                R.drawable.mov01, R.drawable.mov02, R.drawable.mov03, R.drawable.mov04, R.drawable.mov05, R.drawable.mov06, R.drawable.mov07, R.drawable.mov08, R.drawable.mov09, R.drawable.mov10};//6.배치하기위한 그림 배열 선언

        String posterName[] = {"써니","완득이","괴물","라디오스타","비열한거리","왕의남자","아일랜드","웰컴투동막골","헬보이","백투더퓨쳐",
                "써니","완득이","괴물","라디오스타","비열한거리","왕의남자","아일랜드","웰컴투동막골","헬보이","백투더퓨쳐",
                "써니","완득이","괴물","라디오스타","비열한거리","왕의남자","아일랜드","웰컴투동막골","헬보이","백투더퓨쳐"};




        public MyGridAdapter(Context c) {// 2. 생성자 매소드 생성(code -> 오버라이딩 메소드 제일처음)

            context=c;
        }

        @Override
        public int getCount() {

            return posterID.length;  //12. 리턴해주는 숫자 만큼 보여주기 때문에, 일정값이 아닌 배열의 길이(posterID.length) 만큼 보여주는 것으로 설정한다.
        }



        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {

            //13.한줄당 3개씩 출력되도록 설정했는데, 여백이 많이 남았기 때문에, xml의 x,y값을 가져와서 get view 해주면, 여백등을 조절할 수 있다.
            Display display = ((WindowManager)getSystemService(WINDOW_SERVICE)).getDefaultDisplay();
            int x = (int) (display.getWidth()/3);
            int y = (int) (x*1.5);
            //13.한줄당 3개씩 출력되도록 설정했는데, 여백이 많이 남았기 때문에, xml의 x,y값을 가져와서 get view 해주면, 여백등을 조절할 수 있다.

            ImageView imageView = new ImageView(context);   //8. Image View 생성
            imageView.setLayoutParams(new GridView.LayoutParams(x,y));              //13-1 LayoutParams  x,y 값을 대입한다.

            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);   //9.기본이 FIT_CENTER 고 늘리려면 FIT_XY
            imageView.setPadding(5,5,5,5);
            imageView.setImageResource(posterID[position]);  //10.배열의 포지션 만큼 가져온다는 의미

            final int pos = position;
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    View dialogView = (View)View.inflate(MainActivity.this,R.layout.dialog,null);
                    AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                    ImageView ivPoster = (ImageView) dialogView.findViewById(R.id.ivPoster);
                    ivPoster.setImageResource(posterID[pos]);
                    dlg.setTitle(posterName[pos]);
                    dlg.setIcon(R.drawable.aassvvb);
                    dlg.setView(dialogView);
                    dlg.setNegativeButton("닫기",null);
                    dlg.show();
                }
            });


            return imageView;




        }
    }
}
