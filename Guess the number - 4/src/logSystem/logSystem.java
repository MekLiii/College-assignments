package logSystem;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class logSystem {
    public String fileName = "";

    public logSystem(String FileName){
        this.fileName = FileName;
    }
    public void createLogFile() {
        String filePath = fileName + ".txt";
        try {
            FileWriter fileWriter = new FileWriter(filePath);
        } catch (IOException e) {
            System.err.println("Something went wrong while creating the file");
        }
    }

        public void addLineToFile(String line) {
        try {
            Files.write(Paths.get(fileName), (line + System.lineSeparator()).getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.err.println("Cannot write to file");
        }
    }
}
