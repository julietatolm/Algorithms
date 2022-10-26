package org.class_10_11_outSearcher;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileSearchear {
    public static void main(String[] args) {
        ArrayList<File> fileList = new ArrayList<>();
        getFiles(new File(""), fileList);
        for (File file : fileList) {
            System.out.println(file.getAbsolutePath());
        }
    }

    private static void getFiles(File rootFile, List<File> fileList) {
        if (rootFile.isDirectory()) {
            System.out.println("searching..." + rootFile.getAbsolutePath());
            File[] directoryFiles = rootFile.listFiles();
            if (directoryFiles != null) {
                for (File file: directoryFiles) {
                    if (file.isDirectory()) {
                        getFiles(file, fileList);
                    } else {
                        if (file.getName().toLowerCase().endsWith(".jpg")) {
                            fileList.add(file);
                        }
                    }
                }
            }
        }
    }
}
