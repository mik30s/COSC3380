package lab8;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;


public class Lab8 {

    public static void main(String[] args) 
            throws FileNotFoundException, IOException, InterruptedException 
    {
        File f = new File("mapped.txt");
        f.delete();

        FileChannel fc = new RandomAccessFile(f, "rw").getChannel();

        long bufferSize=8*1000;
        MappedByteBuffer mem =fc.map(FileChannel.MapMode.READ_WRITE, 0, bufferSize);
    
        while(true) { 
            System.out.println("Writing data...");
            mem.put(Charset.forName(System.getProperty("file.encoding")).encode("hello world\n"));
            Thread.sleep(2000);
        }
    }
}
