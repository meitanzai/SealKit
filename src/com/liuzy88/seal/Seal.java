package com.liuzy88.seal;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public abstract class Seal {

    /**
     * 默认从10x10的位置开始画，防止左上部分画布装不下
     */
    protected final static int INIT_BEGIN = 5;

    protected static void save(BufferedImage bi, String fullPath) throws IOException {
        ImageIO.write(bi, "png", new File(fullPath));
    }

    public static class Circle {
        private Integer lineSize;
        private Integer width;
        private Integer height;

        public Integer getLineSize() {
            return lineSize;
        }

        public Circle setLineSize(Integer lineSize) {
            this.lineSize = lineSize;
            return this;
        }

        public Integer getWidth() {
            return width;
        }

        public Circle setWidth(Integer width) {
            this.width = width;
            return this;
        }

        public Integer getHeight() {
            return height;
        }

        public Circle setHeight(Integer height) {
            this.height = height;
            return this;
        }
    }

    public static class Words {

        private String fontText;
        private Boolean isBold = true;
        private String fontFamily = "宋体";
        private Integer fontSize;
        private Double fontSpace;
        private Integer marginSize;

        public Words setFontSpace(Double fontSpace) {
            this.fontSpace = fontSpace;
            return this;
        }

        public Words setMarginSize(Integer marginSize) {
            this.marginSize = marginSize;
            return this;
        }

        public Words setFontFamily(String fontFamily) {
            this.fontFamily = fontFamily;
            return this;
        }

        public Words setFontText(String fontText) {
            this.fontText = fontText;
            return this;
        }

        public Words setFontSize(Integer fontSize) {
            this.fontSize = fontSize;
            return this;
        }

        public Words setBold(Boolean bold) {
            isBold = bold;
            return this;
        }

        public String getFontText() {
            return fontText;
        }

        public String getFontFamily() {
            return fontFamily;
        }

        public Integer getFontSize() {
            return fontSize;
        }

        public Double getFontSpace() {
            return fontSpace;
        }

        public Integer getMarginSize() {
            return marginSize;
        }

        public Boolean isBold() {
            return isBold;
        }
    }
}
