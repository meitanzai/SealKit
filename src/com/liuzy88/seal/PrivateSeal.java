package com.liuzy88.seal;

import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

public abstract class PrivateSeal extends Seal {
    /**
     * 生成私人印章图片，并保存到指定路径
     */
    public static void draw(int imageSize, int lineSize, Words words, String append, String pngPath) throws Exception {
        save(draw(imageSize, lineSize, words, append), pngPath);
    }

    /**
     * 生成私人印章图片
     */
    public static BufferedImage draw(int imageSize, int lineSize, Words words, String append) throws Exception {
        if (words == null || words.getFontText().length() < 2 || words.getFontText().length() > 4) {
            throw new Exception("FontText.length illegal!");
        }

        int fixH = 18;
        int fixW = 2;

        //1.画布
        BufferedImage bi = new BufferedImage(imageSize, imageSize / 2, BufferedImage.TYPE_4BYTE_ABGR);

        //2.画笔
        Graphics2D g2d = bi.createGraphics();

        //2.1设置画笔颜色
        g2d.setPaint(Color.RED);

        //2.2抗锯齿设置
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        //3.写签名
        int marginW = fixW + lineSize;
        float marginH;
        FontRenderContext context = g2d.getFontRenderContext();
        Rectangle2D rectangle;
        Font f;

        if (words.getFontText().length() == 2) {
            if (append != null && append.trim().length() > 0) {
                bi = drawThreeFont(bi, g2d, words.setFontText(words.getFontText() + append), lineSize, imageSize, fixH,
                        fixW, true);
            } else {
                f = new Font(words.getFontFamily(), Font.BOLD, words.getFontSize());
                g2d.setFont(f);
                rectangle = f.getStringBounds(words.getFontText().substring(0, 1), context);
                marginH = (float) (Math.abs(rectangle.getCenterY()) * 2 + marginW) + fixH - 4;
                g2d.drawString(words.getFontText().substring(0, 1), marginW, marginH);
                marginW += Math.abs(rectangle.getCenterX()) * 2 + (words.getFontSpace() == null ?
                        INIT_BEGIN :
                        words.getFontSpace());
                g2d.drawString(words.getFontText().substring(1), marginW, marginH);

                //拉伸
                BufferedImage nbi = new BufferedImage(imageSize, imageSize, bi.getType());
                Graphics2D ng2d = nbi.createGraphics();
                ng2d.setPaint(Color.RED);
                ng2d.drawImage(bi, 0, 0, imageSize, imageSize, null);

                //画正方形
                ng2d.setStroke(new BasicStroke(lineSize));
                ng2d.drawRect(0, 0, imageSize, imageSize);
                ng2d.dispose();
                bi = nbi;
            }
        } else if (words.getFontText().length() == 3) {
            if (append != null && append.trim().length() > 0) {
                bi = drawFourFont(bi, words.setFontText(words.getFontText() + append), lineSize, imageSize, fixH,
                        fixW);
            } else {
                bi = drawThreeFont(bi, g2d, words.setFontText(words.getFontText()), lineSize, imageSize, fixH, fixW,
                        false);
            }
        } else {
            bi = drawFourFont(bi, words, lineSize, imageSize, fixH, fixW);
        }

        return bi;
    }

    /**
     * 画三字
     */
    private static BufferedImage drawThreeFont(BufferedImage bi, Graphics2D g2d, Words font, int lineSize,
                                               int imageSize, int fixH, int fixW, boolean isWithYin) {
        fixH -= 9;
        int marginW = fixW + lineSize;
        //设置字体
        Font f = new Font(font.getFontFamily(), Font.BOLD, font.getFontSize());
        g2d.setFont(f);
        FontRenderContext context = g2d.getFontRenderContext();
        Rectangle2D rectangle = f.getStringBounds(font.getFontText().substring(0, 1), context);
        float marginH = (float) (Math.abs(rectangle.getCenterY()) * 2 + marginW) + fixH;
        int oldW = marginW;

        if (isWithYin) {
            g2d.drawString(font.getFontText().substring(2, 3), marginW, marginH);
            marginW += rectangle.getCenterX() * 2 + (font.getFontSpace() == null ? INIT_BEGIN : font.getFontSpace());
        } else {
            marginW += rectangle.getCenterX() * 2 + (font.getFontSpace() == null ? INIT_BEGIN : font.getFontSpace());
            g2d.drawString(font.getFontText().substring(0, 1), marginW, marginH);
        }

        //拉伸
        BufferedImage nbi = new BufferedImage(imageSize, imageSize, bi.getType());
        Graphics2D ng2d = nbi.createGraphics();
        ng2d.setPaint(Color.RED);
        ng2d.drawImage(bi, 0, 0, imageSize, imageSize, null);

        //画正方形
        ng2d.setStroke(new BasicStroke(lineSize));
        ng2d.drawRect(0, 0, imageSize, imageSize);
        ng2d.dispose();
        bi = nbi;

        g2d = bi.createGraphics();
        g2d.setPaint(Color.RED);
        g2d.setFont(f);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        if (isWithYin) {
            g2d.drawString(font.getFontText().substring(0, 1), marginW, marginH += fixH);
            rectangle = f.getStringBounds(font.getFontText(), context);
            marginH += Math.abs(rectangle.getHeight());
            g2d.drawString(font.getFontText().substring(1), marginW, marginH);
        } else {
            g2d.drawString(font.getFontText().substring(1, 2), oldW, marginH += fixH);
            rectangle = f.getStringBounds(font.getFontText(), context);
            marginH += Math.abs(rectangle.getHeight());
            g2d.drawString(font.getFontText().substring(2, 3), oldW, marginH);
        }
        return bi;
    }

    /**
     * 画四字
     */
    private static BufferedImage drawFourFont(BufferedImage bi, Words font, int lineSize, int imageSize, int fixH,
                                              int fixW) {
        int marginW = fixW + lineSize;
        //拉伸
        BufferedImage nbi = new BufferedImage(imageSize, imageSize, bi.getType());
        Graphics2D ng2d = nbi.createGraphics();
        ng2d.setPaint(Color.RED);
        ng2d.drawImage(bi, 0, 0, imageSize, imageSize, null);

        //画正方形
        ng2d.setStroke(new BasicStroke(lineSize));
        ng2d.drawRect(0, 0, imageSize, imageSize);
        ng2d.dispose();
        bi = nbi;

        Graphics2D g2d = bi.createGraphics();
        g2d.setPaint(Color.RED);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        FontRenderContext context = g2d.getFontRenderContext();

        Font f = new Font(font.getFontFamily(), Font.BOLD, font.getFontSize());
        g2d.setFont(f);
        Rectangle2D rectangle = f.getStringBounds(font.getFontText().substring(0, 1), context);
        float marginH = (float) (Math.abs(rectangle.getCenterY()) * 2 + marginW) + fixH;

        g2d.drawString(font.getFontText().substring(2, 3), marginW, marginH);
        int oldW = marginW;
        marginW +=
                Math.abs(rectangle.getCenterX()) * 2 + (font.getFontSpace() == null ? INIT_BEGIN : font.getFontSpace());

        g2d.drawString(font.getFontText().substring(0, 1), marginW, marginH);
        marginH += Math.abs(rectangle.getHeight());

        g2d.drawString(font.getFontText().substring(3, 4), oldW, marginH);

        g2d.drawString(font.getFontText().substring(1, 2), marginW, marginH);

        return bi;
    }

}
