package com.example.customlistview;
//CustomListView
//
//        1. 메인엑티비티
//        2. 메인xml - 리스트뷰 생성
//        3. 어뎁터
//        4. 커스텀 리스트뷰 아이템 전용 xml   - 한 항목당 제작
//        5. 데이터 클래스(ListView에 들어갈 자료) - 변수 선언 및 생성자 생성 (캡슐화)
public class ItemData {
   private int imgID;   //1.클래스 생성 후 정수형 변수 선언 private ->캡슐화(정보은닉) 임의로 필드에 접근하지 못하게 하기 위함
    private  String title;  //2.String 변수 선언
    private  String content; //3 .String 변수 선언

    public ItemData(int imgID,String title,String content) {  //4.생성자 생성 (code -> 오버라이드 메소드)
        this.imgID=imgID;
        this.title=title;
        this.content=content;
    }
    public int getImgID () { //5.나중에 int ,String 값을 받아오기 위해 생성
        return imgID;
    }
    public String getTitle() {
        return  title;
    }
    public   String getContent() {
        return  content;
    }
    public void setImgID(int imgID) {
        this.imgID=imgID;
    }
    public void setTitle(String title) {
        this.title=title;
    }
    public  void  setContent(String content) {
        this.content=content;
    }
}
