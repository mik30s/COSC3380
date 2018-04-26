package tarleton;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Scanner;

public class Lab8 {

    public static void main(String[] args) 
            throws FileNotFoundException, IOException, InterruptedException 
    {
        File f = new File("mapped.txt");
        f.delete();
        Scanner sc = new Scanner(System.in);

        FileChannel fc = new RandomAccessFile(f, "rw").getChannel();

        long bufferSize=120;
        MappedByteBuffer mem = fc.map(FileChannel.MapMode.READ_WRITE, 0, bufferSize);
    
        while(true) { 
            System.out.print("What to do? [r/w]: ");
            String str = sc.nextLine();
            switch(str){
                case "r":
                    System.out.println("Reading data...");
                    mem.position(0);
                    for (int i = 0; i < mem.limit(); i++) {
                        System.out.print((char) mem.get());
                    }
                    System.out.println();
                    break;
                case "w":
                    System.out.println("Writing data...");
                    String msg = sc.nextLine();
                    mem.position(0);
                    mem.put(msg.getBytes());
                    break;
                default: break;
            }
        }
    }
}
