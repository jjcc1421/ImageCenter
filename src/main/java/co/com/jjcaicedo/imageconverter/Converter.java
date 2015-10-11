/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.jjcaicedo.imageconverter;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;

/**
 *
 * @author Juan
 */
public class Converter {
    public static void PNGToJPG(String filePath) {

	BufferedImage bufferedImage;
		
	try {
			
	  //read image file
          File imageFile=new File(filePath);
          String fileName=imageFile.getName();
          String[] parts = fileName.split(Pattern.quote("."));
          fileName=parts[0];
	  bufferedImage = ImageIO.read(imageFile);

	  // create a blank, RGB, same width and height, and a black background
	  BufferedImage newBufferedImage = new BufferedImage(bufferedImage.getWidth(),
			bufferedImage.getHeight(), BufferedImage.TYPE_INT_RGB);
	  newBufferedImage.createGraphics().drawImage(bufferedImage, 0, 0, Color.black, null);

	  // write to jpeg file
	  ImageIO.write(newBufferedImage, "jpg", new File(imageFile.getParentFile()+"//"+fileName+".jpg"));

	  System.out.println("Done");
          System.out.println(fileName);
			
	} catch (IOException e) {

	  e.printStackTrace();

	}
    }

}
