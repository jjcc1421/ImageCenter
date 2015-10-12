/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.jjcaicedo.imageconverter;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

/**
 *
 * @author Juan
 */
public class Resizer {

    /**
     * we want the x and o to be resized when the JFrame is resized
     *
     * @param originalImage an x or an o. Use cross or oh fields.
     *
     * @param biggerWidth
     * @param biggerHeight
     * @return
     */
    public Image resizeToBig(Image originalImage, int biggerWidth, int biggerHeight) {
        Dimension bigger = new Dimension(biggerWidth, biggerHeight);
        Dimension imageDimension = new Dimension(originalImage.getWidth(null), originalImage.getHeight(null));
        imageDimension = getScaledDimension(imageDimension, bigger);
        //int type = BufferedImage.TYPE_INT_ARGB;
        int type = BufferedImage.TYPE_INT_RGB;

        BufferedImage resizedImage = new BufferedImage(biggerWidth, biggerHeight, type);
        Graphics2D g = resizedImage.createGraphics();

        g.setComposite(AlphaComposite.Src);
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        //g.drawImage(originalImage, 0, 0, biggerWidth, biggerHeight, Color.black, null);
        Dimension imagePosition= getCenterPosition(imageDimension,bigger);
        g.drawImage(originalImage, imagePosition.width, imagePosition.height, imageDimension.width, imageDimension.height, Color.black, null);
        g.dispose();

        return resizedImage;
    }

    public static Dimension getScaledDimension(Dimension imgSize, Dimension boundary) {

        int original_width = imgSize.width;
        int original_height = imgSize.height;
        int bound_width = boundary.width;
        int bound_height = boundary.height;
        int new_width = original_width;
        int new_height = original_height;

        // first check if we need to scale width
        if (original_width > bound_width) {
            //scale width to fit
            new_width = bound_width;
            //scale height to maintain aspect ratio
            new_height = (new_width * original_height) / original_width;
        }

        // then check if we need to scale even with the new height
        if (new_height > bound_height) {
            //scale height to fit instead
            new_height = bound_height;
            //scale width to maintain aspect ratio
            new_width = (new_height * original_width) / original_height;
        }

        return new Dimension(new_width, new_height);
    }

    public static Dimension getCenterPosition(Dimension imgDimension, Dimension boundary) {
        int new_width = 0;
        int new_height = 0;
        new_width = (boundary.width - imgDimension.width)/2;
        new_height = (boundary.height - imgDimension.height)/2;
        if (new_width < 0) {
            new_width = 0;
        }
        if (new_height < 0) {
            new_height = 0;
        }
        return new Dimension(new_width, new_height);
    }
}
