/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import co.com.jjcaicedo.filesSelector.FolderSelector;
import co.com.jjcaicedo.imageconverter.Converter;
import co.com.jjcaicedo.imageconverter.Resizer;
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
        FolderSelector fs = new FolderSelector();
        fs.listFilesForFolderPath("D:\\Documentos\\TestJava");
        for (int i = 0; i < FolderSelector.files.size(); i++) {
            Converter.PNGToJPG(FolderSelector.files.get(i));
        }
        for (int i = 0; i < FolderSelector.files.size(); i++) {
            Converter.PNGToJPG(FolderSelector.files.get(i));
        }
        //Converter.PNGToJPG(null, null);

        Resizer r = new Resizer();
        //File sourceimage = new File("D:\\Documentos\\TestJava\\FFXV-Wiz-Chocobo-Post1.jpg");
        File sourceimage = new File("D:\\Documentos\\TestJava\\test.jpg");
        Image image = null;
        try {

            image = ImageIO.read(sourceimage);
            image = r.resizeToBig(image, 1200, 800);
            //image.
            //ImageIO.write((RenderedImage) image, "jpg", new File("D:\\Documentos\\TestJava\\FFXV-Wiz-Chocobo-Post2.jpg"));
            ImageIO.write((RenderedImage) image, "jpg", new File("D:\\Documentos\\TestJava\\test2.jpg"));

        } catch (Exception e) {
        }

    }

}
