package fileio;

import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;

public class Main {
    public static void main(String[] args) throws IOException {
        File i = new File("./hello.txt");
        try {
            i.createNewFile();
            System.out.println(i.getTotalSpace());
        } catch (IOException e) {
            e.printStackTrace();
        }

        File i1 = new File("Hello1.txt");
        try {
            var f1=new FileInputStream(i1);
            FileChannel f1c = f1.getChannel();
            System.out.println(f1c.size());


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        get FileDesc

        BasicFileAttributes ba= Files.readAttributes(i1.toPath(), BasicFileAttributes.class);
        System.out.println(ba);
        System.out.println(ba.isDirectory());
        System.out.println(i1.isDirectory());

    }
}
