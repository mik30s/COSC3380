package lab8_reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;


public class Lab8_reader {

    public static void main(String[] args) 
            throws FileNotFoundException, IOException, InterruptedException 
    {
        FileChannel fc = new RandomAccessFile(new File("mapped.txt"), "rw").getChannel();
  
        long bufferSize=8*1000;
        MappedByteBuffer mem = fc.map(FileChannel.MapMode.READ_ONLY, 0, bufferSize);
        
        System.out.println("Encoding: " + System.getProperty("file.encoding"));
        byte[] buffer = new byte[8];
        while(true) {
            mem.get(buffer);
            //CharBuffer charBuffer = Charset.forName(System.getProperty("file.encoding")).decode(mem.);
            System.out.println("Data:" + new String(buffer));
            Thread.sleep(2000);
        }
    }
}
