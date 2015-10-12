/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import co.com.jjcaicedo.filesSelector.FolderSelector;
import co.com.jjcaicedo.imageCenter.ImageCenter;
import co.com.jjcaicedo.imageconverter.Converter;
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
public class MainClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // TODO code application logic here

            String folderPath = "C:\\Users\\Juan\\Dropbox\\JuegaGamer\\paginas Juegos\\posts\\Blog\\Rock Band 4 Electric Trailer";
            FolderSelector fs = new FolderSelector();
            fs.listFilesForFolderPath(folderPath, false);
            for (int i = 0; i < FolderSelector.files.size(); i++) {
                if (FolderSelector.files.get(i).contains(".png")) {
                    Converter.PNGToJPG(FolderSelector.files.get(i));
                }
            }
            Dimension standarImage = new Dimension(1200 , 630 );
            Dimension miniImage = new Dimension(680, 226);
            for (int i = 0; i < FolderSelector.files.size(); i++) {
                if (FolderSelector.files.get(i).contains(".jpg")) {
                    if (FolderSelector.files.get(i).contains("portada")
                            || FolderSelector.files.get(i).contains("Portada")) {
                        ImageCenter.centerImage(FolderSelector.files.get(i), miniImage);

                    }
                    else{
                        ImageCenter.centerImage(FolderSelector.files.get(i), standarImage);
                    }
                }
            }
        
    }

}
