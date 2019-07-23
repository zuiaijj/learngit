package com.example.recyclerviewdemo2;

public class Item {
    private int imgId;
    private String buttonName;
    private int imgType;

    public Item(int imgId, int imgType) {
        this.imgId = imgId;
        this.imgType = imgType;
    }

    public Item(String buttonName, int imgType) {
        this.buttonName = buttonName;
        this.imgType = imgType;
    }

    public int getImgId() {
        return imgId;
    }

    public int getImgType() {
        return imgType;
    }

    public String getButtonName() {
        return buttonName;
    }
}
