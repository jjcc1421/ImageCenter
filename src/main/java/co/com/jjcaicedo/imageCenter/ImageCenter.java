/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.jjcaicedo.imageCenter;

import co.com.jjcaicedo.imageconverter.Resizer;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.image.RenderedImage;
import java.io.File;
import javax.imageio.ImageIO;

/**
 *
 * @author Juan
 */
public class ImageCenter {

    public static void centerImage(String filePath, Dimension bigDimension) {
        File file = new File(filePath);
        if (file.isFile()) {
            centerImage(file, bigDimension);
        }
    }

    public static void centerImage(File file, Dimension bigDimension) {
        try {
            Image image = null;
            image = ImageIO.read(file);
            image=centerImage(image, bigDimension);
            ImageIO.write((RenderedImage) image, "jpg", file);
        } catch (Exception e) {

        }
    }

    public static Image centerImage(Image image, Dimension bigDimension) {
        Resizer r=new Resizer();
        image = r.resizeToBig(image, bigDimension.width, bigDimension.height);
        return image;
    }

}
