package hust.soict.dsai.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths; // Import the Paths class
import java.lang.StringBuilder;

public class NoGarbage {
    public static void main(String[] args) {
        String filename = "C:\\Users\\tungv\\Desktop\\1713798336.pdf";
        byte[] inputBytes = {0};
        long startTime, endTime;
        try {
            inputBytes = Files.readAllBytes(Paths.get(filename));
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
        startTime = System.currentTimeMillis();
        StringBuilder outputString = new StringBuilder();
        for (byte b: inputBytes){
            outputString.append((char)b);
        }
        endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }
}

