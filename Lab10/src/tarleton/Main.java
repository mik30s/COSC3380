package tarleton;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Scanner;

import static java.nio.file.FileVisitResult.*;

public class Main extends SimpleFileVisitor<Path> {

    // Print information about
    // each type of file.
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attr) {
        System.out.format("Directory: %s Size %d bytes%n",
                file.toAbsolutePath(), attr.size());
        return CONTINUE;
    }

    // Print each directory visited.
    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) {
        System.out.format("Directory: %s Size: %d %n", dir, 0);
        return CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file,
                                           IOException exc) {
        System.err.println(exc);
        return CONTINUE;
    }

    public static void main(String[] args) throws IOException {
	    Scanner sc  = new Scanner(System.in);
	    System.out.print("Enter a directory: ");
	    String dirStr = sc.nextLine();
        Files.walkFileTree(new File(dirStr).toPath(), new Main());
        System.out.println("Done!");
    }
}
