package com.example.fragmentdemo;

public class ImageItem {
    private int imgId;
    private String buttonName;
    private int imgType;

    public ImageItem(int imgId, int imgType) {
        this.imgId = imgId;
        this.imgType = imgType;
    }

    public ImageItem(String buttonName, int imgType) {
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

