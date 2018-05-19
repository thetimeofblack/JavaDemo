package coreJava.practice1;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Scanner;

public class FileIO {
    public static void main(String[] args) throws IOException{
        Scanner reader = new Scanner(Paths.get("D:\\test.txt"),"UTF-8");
        while (reader.hasNext()){
            System.out.println(reader.nextLine());
        }
        PrintWriter writer = new PrintWriter(new File("D:\\test.txt"),"UTF-8");
        writer.print("is a great book for us");
    }
}
