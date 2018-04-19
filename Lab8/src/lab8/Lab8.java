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

        int start = 0;
        long counter=1;
        long HUNDREDK=100000;
        long noOfMessage = HUNDREDK * 10 * 10; 
    
        while(true) {         
            mem.put(Charset.forName(System.getProperty("file.encoding")).encode("s"));
            Thread.sleep(2000);
        }
    }
}
