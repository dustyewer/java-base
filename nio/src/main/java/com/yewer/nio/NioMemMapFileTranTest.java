package main.java.com.yewer.nio;

import java.io.File;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.ZonedDateTime;

public class NioMemMapFileTranTest
{
    public static long fileTran(Path src, Path dst) throws IOException {
        long begin= ZonedDateTime.now().toInstant().toEpochMilli();
        FileChannel inChannel = FileChannel.open(src, StandardOpenOption.READ);
        FileChannel outChannel = FileChannel.open(dst, StandardOpenOption.READ,StandardOpenOption.WRITE,StandardOpenOption.CREATE);

        MappedByteBuffer inMapBuff = inChannel.map(FileChannel.MapMode.READ_ONLY,0,inChannel.size());
        MappedByteBuffer outMapBuff = outChannel.map(FileChannel.MapMode.READ_WRITE,0,inChannel.size());

        byte[] dstByte= new byte[inMapBuff.limit()];
        inMapBuff.get(dstByte);
        outMapBuff.put(dstByte);
        long end = ZonedDateTime.now().toInstant().toEpochMilli();
        System.out.println(end-begin);
        return end-begin;

    }
}
