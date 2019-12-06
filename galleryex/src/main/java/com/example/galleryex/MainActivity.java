package com.example.galleryex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Gallery gallery1;
    ImageView ivPoster;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("갤러리 영화 포스터");

        gallery1=(Gallery)findViewById(R.id.gallery1);
        ivPoster=(ImageView)findViewById(R.id.invisible);

        MyGalleryAdapter myGalleryAdapter = new MyGalleryAdapter(this);  //3.  어뎁터뷰 생성
        gallery1.setAdapter(myGalleryAdapter);//3-1 장착
    }

    public class MyGalleryAdapter extends BaseAdapter { //1.어뎁터 뷰 생성을위한 클래스 생성 후  메소드 생성
        Context context;
        Integer posterID[] = {R.drawable.mov01,R.drawable.mov02,R.drawable.mov03,R.drawable.mov04,R.drawable.mov05,R.drawable.mov06,R.drawable.mov07,R.drawable.mov08,R.drawable.mov09,R.drawable.mov10};
        String posterNameID[] = {"써니","완득이","괴물","라디오스타","비열한거리","왕의남자","아일랜드","웰컴투동막골","헬보이","백투더퓨쳐"};

        public MyGalleryAdapter(Context context) {  //2.생성자 생성
           this.context=context;  //2-1 생성자 메소드에 context 값 입력
        }

        @Override
        public int getCount() {
            return posterID.length;
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
            ImageView imageView = new ImageView(context); //4. 이미지뷰 생성
            imageView.setLayoutParams(new Gallery.LayoutParams(200,300));
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageView.setPadding(5,5,5,5);
            imageView.setImageResource(posterID[position]);

            int pos = position;
            imageView.setOnTouchListener(new View.OnTouchListener() {  //5..setOnTouchListener  클린 리스너가 아닌 터치 리스너 사용함
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    ImageView ivPoster = (ImageView)findViewById(R.id.ivPoster);
                    Toast.makeText(getApplicationContext(),posterNameID[position],Toast.LENGTH_SHORT).show();
                    ivPoster.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    ivPoster.setImageResource(posterID[position]);

                    return false;
                }
            });
            return imageView;
        }

    }
}
