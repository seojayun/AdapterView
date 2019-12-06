package com.example.customlistview;

//CustomListView
//
//        1. 메인엑티비티
//        2. 메인xml - 리스트뷰 생성
//        3. 어뎁터
//        4. 커스텀 리스트뷰 아이템 전용 xml   - 한 항목당 제작
//        5. 데이터 클래스(ListView에 들어갈 자료) - 변수 선언 및 생성자 생성 (캡슐화)

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends BaseAdapter {  //1. extends BaseAdapter 상속 후 메소드 생성 및 생성자 생성
    private Context context;  //2.Context 변수 선언 - 어뎁터를 연결하기 위한
    private List<ItemData> itemDataList;  //3.동적 배열인데 클래스가 왔다.  -> 예전에 그림판 할때 만듦   itemDataList안에는 3가지가 있다. imgID, title, content
    private LayoutInflater mInflater;  //4. getView 에서 직접 만들 것이 아닌, item_listview.xml를 인플레이트 시키기 위해 생성된 변수

    public MyAdapter(Context context, List<ItemData> itemDataList) {  //11.자료를 받으면서 생성
        this.context=context;
        this.itemDataList=itemDataList;
        this.mInflater=LayoutInflater.from(context);  //12.context로부터 LayoutInflater 받는다
    }

    @Override
    public int getCount() {
        return itemDataList.size();  //5.배열의 크기만큼 리턴한다
    }

    @Override
    public Object getItem(int position) {
        return itemDataList.get(position); //6.itemDataList의 위치값을 리턴한다.
    }

    @Override
    public long getItemId(int position) {
        return position;    //7. 위치값을 리턴한다.
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView = convertView; // 8.기본적인 정보를 제공해줌
        if(itemView==null) {
            itemView=mInflater.inflate(R.layout.item_listview,null);  //9.item_listview.xml를 인플레이트 시켜 대입

        }
        ImageView ivPoster = (ImageView) itemView.findViewById(R.id.ivPoster);   //10.itemView. 안에 있음
        TextView tvTitle = (TextView)itemView.findViewById(R.id.tvTitle);
        TextView tvContent = (TextView)itemView.findViewById(R.id.tvContent);
        ItemData itemData = itemDataList.get(position);//13. ItemData class의 데이터를 받기 위한 변수 선언(그리드뷰)
        ivPoster.setImageResource(itemData.getImgID());
        tvTitle.setText(itemData.getTitle());
        tvContent.setText(itemData.getContent());  //14.각각의 이미지뷰와 텍스트뷰에 맞는 내용들을 세팅시킨다.

        return itemView;  //15.itemView를 리턴한다.   -->MainActivity로 이동
    }
}
