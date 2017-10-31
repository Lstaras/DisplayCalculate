package com.example.caogl.displaycalculate;

/**
 * Created by caogl on 2017-10-24.
 */

public class Entry {
    private String text1;//成员变量
    private String text2;
    private int imageId;

    public Entry(int imageId, String text1, String text2) {//构造函数
        this.imageId = imageId;
        this.text1 = text1;
        this.text2 = text2;
    }

    public String getText1() {
        return text1;
    }

    public void setText1(String text1) {
        this.text1 = text1;
    }

    public String getText2() {
        return text2;
    }

    public void setText2(String text2) {
        this.text2 = text2;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
