/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.jjcaicedo.filesSelector;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Juan
 */
public class FolderSelector {

    public static List<String> files;

    public FolderSelector() {
        this.files = new ArrayList<String>();
    }

    public void listFilesForFolderPath(String folderPath) {
        File folder = new File(folderPath);
        if (folder.isDirectory()) {
            listFilesForFolder(folder);
        }
    }
/**
 * Return files into folder and subfolders
 * @param folder 
 */
    public void listFilesForFolder(final File folder) {
        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                listFilesForFolder(fileEntry);
            } else {
                System.out.println(fileEntry.getName());
                files.add(fileEntry.getAbsolutePath());
            }
        }
    }

    public void filesRename(String newFilesName, String fileExtention) {
        int contFile = 0;
        for (int i = 0; i < files.size(); i++) {
            if (files.get(i).contains(fileExtention)) {
                File f = new File(files.get(i));
                if (f.isFile()) {
                    f.renameTo(new File(f.getParent() + newFilesName + contFile + "." + fileExtention));
                    contFile++;
                }
            }
        }
    }

    public void deleteFilesFormat(String formatFile) {
        for (int i = 0; i < files.size(); i++) {
            if (files.get(i).contains(formatFile)) {
                File f = new File(files.get(i));
                if (f.isFile() && f.getName().contains(formatFile)) {
                    f.delete();
                }
            }
        }
    }
}
