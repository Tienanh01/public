package com.java.EverydayProject;

import java.io.File;

public class GetListFile {

    public static void main(String[] args) {
        File folder = new File("E:\\demoCache");
        File[] files = folder.listFiles();
        int fileCount = files.length;
        System.out.println("Number of files: " + fileCount);
    }
}
