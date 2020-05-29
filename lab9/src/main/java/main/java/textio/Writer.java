package main.java.textio;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Writer {
    public void writeTextToFile(File file, String text) throws IOException {
        if (file.createNewFile()) {
            System.out.println("Файл создан: " + file.getName());
        } else {
            System.out.println("Файл уже существует");
        }

        try (FileWriter fileWriter = new FileWriter(file);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            bufferedWriter.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
