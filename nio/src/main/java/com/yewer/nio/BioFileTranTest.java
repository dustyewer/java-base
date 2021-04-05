package main.java.com.yewer.nio;

import java.io.*;
import java.net.SocketPermission;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;

public class BioFileTranTest {
    public static long fileTran(File src, File dst) throws IOException {
        long begin=ZonedDateTime.now().toInstant().toEpochMilli();
        if(!dst.exists()){
            dst.createNewFile();
        }

        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(src));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dst));
        byte[] bytes = new byte[1024*1024];
        int len ;
        while ((len=bis.read(bytes))!=-1){
            bos.write(bytes,0,len);
        }
        long end = ZonedDateTime.now().toInstant().toEpochMilli();
        System.out.println(end-begin);
        return end-begin;
    }
}
