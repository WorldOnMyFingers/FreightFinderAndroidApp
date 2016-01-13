package com.example.emrebabayigit.pickoapp.models;

/**
 * Created by emrebabayigit on 12/01/2016.
 */
public class Dimensions {

    public int Width;
    public int Height;
    public int LeftMargin;
    public int RightMargin;
    public int TopMargin;
    public int BottomMargin;
    public String Layout_Gravity;
    private int TextSize;

    public int getWidth() {
        return Width;
    }

    public void setWidth(int width) {
        Width = width;
    }

    public int getHeight() {
        return Height;
    }

    public void setHeight(int height) {
        Height = height;
    }

    public int getLeftMargin() {
        return LeftMargin;
    }

    public void setLeftMargin(int leftMargin) {
        LeftMargin = leftMargin;
    }

    public int getRightMargin() {
        return RightMargin;
    }

    public void setRightMargin(int rightMargin) {
        RightMargin = rightMargin;
    }

    public int getTopMargin() {
        return TopMargin;
    }

    public void setTopMargin(int topMargin) {
        TopMargin = topMargin;
    }

    public int getBottomMargin() {
        return BottomMargin;
    }

    public void setBottomMargin(int bottomMargin) {
        BottomMargin = bottomMargin;
    }

    public String getLayout_Gravity() {
        return Layout_Gravity;
    }

    public void setLayout_Gravity(String layout_Gravity) {
        Layout_Gravity = layout_Gravity;
    }

    public int getTextSize() {
        return TextSize;
    }

    public void setTextSize(int textSize) {
        TextSize = textSize;
    }
}
