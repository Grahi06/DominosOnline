package service;

import java.io.*;

public class FileService {

    // Write data into file
    public static void writeToFile(String filePath, String data, boolean append) {

        try {

            BufferedWriter bw = new BufferedWriter(
                    new FileWriter(filePath, append));

            bw.write(data);
            bw.newLine();
            bw.close();

        } catch (Exception e) {
            System.out.println("File writing error!");
        }
    }

    // Read file data and print
    public static void readFile(String filePath) {

        try {

            BufferedReader br = new BufferedReader(
                    new FileReader(filePath));

            String line;

            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

            br.close();

        } catch (Exception e) {
            System.out.println("File reading error!");
        }
    }
}