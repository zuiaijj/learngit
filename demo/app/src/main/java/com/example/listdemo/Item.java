package com.example.listdemo;

public class Item {
    private String name;
    private String golden_item_text = null;
    private String sliver_item_text = null;
    private int icon_imageId;
    private boolean isHead = false;
    private int liwubang_imageId1;
    private int liwubang_imageId2;
    private int liwubang_imageId3;

    public Item(String name, int icon_imageId, int liwubang_imageId1, int liwubang_imageId2, int liwubang_imageId3, String golden_item_text, String sliver_item_text, boolean isHead) {
        this.name = name;
        this.golden_item_text = golden_item_text;
        this.sliver_item_text = sliver_item_text;
        this.icon_imageId = icon_imageId;
        this.isHead = isHead;
        this.liwubang_imageId1 = liwubang_imageId1;
        this.liwubang_imageId2 = liwubang_imageId2;
        this.liwubang_imageId3 = liwubang_imageId3;
    }

    public Item(String name, int icon_imageId, int liwubang_imageId1, int liwubang_imageId2, int liwubang_imageId3) {
        this.name = name;
        this.icon_imageId = icon_imageId;
        this.liwubang_imageId1 = liwubang_imageId1;
        this.liwubang_imageId2 = liwubang_imageId2;
        this.liwubang_imageId3 = liwubang_imageId3;
    }

    public Item(String name, int icon_imageId, String golden_item_text, String sliver_item_text) {
        this.name = name;
        this.golden_item_text = golden_item_text;
        this.sliver_item_text = sliver_item_text;
        this.icon_imageId = icon_imageId;
    }

    public Item(String name, int icon_imageId) {
        this.name = name;
        this.icon_imageId = icon_imageId;
    }

    public String getName() {
        return name;
    }

    public String getgolden_item_text() {
        return golden_item_text;
    }

    public String getsliver_item_text() {
        return sliver_item_text;
    }

    public int getImageId() {
        return icon_imageId;
    }

    public boolean getisHead() {
        return isHead;
    }

    public int getliwubang_imageId1() {
        return liwubang_imageId1;
    }

    public int getliwubang_imageId2() {
        return liwubang_imageId2;
    }

    public int getliwubang_imageId3() {
        return liwubang_imageId3;
    }
}
