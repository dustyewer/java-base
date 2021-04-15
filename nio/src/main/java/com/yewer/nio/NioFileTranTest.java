package com.yewer.nio;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.time.ZonedDateTime;

public class NioFileTranTest {
    public static long fileTran(File src,File dst) throws IOException {
        long begin= ZonedDateTime.now().toInstant().toEpochMilli();
        if(!dst.exists()){
            dst.createNewFile();
        }
        RandomAccessFile read = new RandomAccessFile(src,"rw");
        RandomAccessFile write = new RandomAccessFile(dst,"rw");

        FileChannel readChannel = read.getChannel();
        FileChannel writeChanel = write.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024*1024);
        while(readChannel.read(byteBuffer)>0){
            byteBuffer.flip();
            writeChanel.write(byteBuffer);
            byteBuffer.clear();
        }
        readChannel.close();
        writeChanel.close();
        long end = ZonedDateTime.now().toInstant().toEpochMilli();
        System.out.println(end-begin);
        return end-begin;

    }
}
