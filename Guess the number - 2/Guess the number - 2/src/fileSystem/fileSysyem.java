package fileSystem;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class fileSysyem {

    public static void saveResultsInFile(String fileName, int attempts) {
        String filePath = fileName + ".txt";
        try (FileWriter fileWriter = new FileWriter(filePath, true);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            bufferedWriter.write(Integer.toString(attempts) + ",");
        } catch (IOException e) {
            System.err.println("Something went wrong with saving result");
        }
    }
}
