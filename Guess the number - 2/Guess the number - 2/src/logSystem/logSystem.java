package logSystem;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

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

    public void addLineToFile( String line) {
        String filePath = this.fileName + ".txt";
        try (FileWriter fileWriter = new FileWriter(filePath, true);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            bufferedWriter.write(line + "\n");
        } catch (IOException e) {
            System.err.println("Something went wrong with saving the line to the file");
        }
    }
}
