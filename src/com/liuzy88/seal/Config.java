package com.liuzy88.seal;

import java.awt.*;

public class Config {
    private Integer imageSize = 300;
    private Color color = Color.RED;
    private Seal.Words mainFont;
    private Seal.Words viceFont;
    private Seal.Words titleFont;
    private Seal.Words centerFont;
    private Seal.Circle borderCircle;
    private Seal.Circle borderInnerCircle;
    private Seal.Circle innerCircle;

    public Config setMainFont(Seal.Words mainFont) {
        this.mainFont = mainFont;
        return this;
    }

    public Config setViceFont(Seal.Words viceFont) {
        this.viceFont = viceFont;
        return this;
    }

    public Config setTitleFont(Seal.Words titleFont) {
        this.titleFont = titleFont;
        return this;
    }

    public Config setCenterFont(Seal.Words centerFont) {
        this.centerFont = centerFont;
        return this;
    }

    public Config setBorderCircle(Seal.Circle borderCircle) {
        this.borderCircle = borderCircle;
        return this;
    }

    public Config setBorderInnerCircle(Seal.Circle borderInnerCircle) {
        this.borderInnerCircle = borderInnerCircle;
        return this;
    }

    public Config setInnerCircle(Seal.Circle innerCircle) {
        this.innerCircle = innerCircle;
        return this;
    }

    public Config setImageSize(Integer imageSize) {
        this.imageSize = imageSize;
        return this;
    }

    public Integer getImageSize() {
        return imageSize;
    }

    public Color getColor() {
        return color;
    }

    public Seal.Words getMainFont() {
        return mainFont;
    }

    public Seal.Words getViceFont() {
        return viceFont;
    }

    public Seal.Words getTitleFont() {
        return titleFont;
    }

    public Seal.Words getCenterFont() {
        return centerFont;
    }

    public Seal.Circle getBorderCircle() {
        return borderCircle;
    }

    public Seal.Circle getBorderInnerCircle() {
        return borderInnerCircle;
    }

    public Seal.Circle getInnerCircle() {
        return innerCircle;
    }
}
