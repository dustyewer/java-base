package com.yewer.nio;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class NioTest {
    public static void main(String[] args) throws IOException {
//        BioFileTranTest.fileTran(new File("/home/yewer/download/ideaIU-2017.3.7.tar.gz"),new File("/home/yewer/download/dst.gz"));
//        NioFileTranTest.fileTran(new File("/home/yewer/download/ideaIU-2017.3.7.tar.gz"),new File("/home/yewer/download/dst.gz"));
        NioMemMapFileTranTest.fileTran(Paths.get("/home/yewer/download/ideaIU-2017.3.7.tar.gz"),Paths.get("/home/yewer/download/dst.gz"));
    }
}
