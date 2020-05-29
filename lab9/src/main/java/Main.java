package main.java;

import main.java.textio.Reader;
import main.java.textio.Writer;
import main.java.utils.TextReverser;
import main.java.utils.VowelMatcher;

import java.io.File;
import java.io.IOException;

public class Main {
    private final static String FILE_PATH = System.getProperty("user.dir") + "/src/main/resources/input/text.txt";
    private final static String OUT_DIR = System.getProperty("user.dir") + "/src/main/resources/output";
    private final static String OUTPUT_PATH = OUT_DIR + "/reversed.txt";

    public static void main(String[] args) throws IOException {
        VowelMatcher matcher = new VowelMatcher();
        Reader reader = new Reader();
        File inFile = new File(FILE_PATH);
        File outFile = new File(OUTPUT_PATH);
        File outDir = new File(OUT_DIR);

        String text = reader.getTextFromFile(inFile);
        String vowels = matcher.match(text);
        System.out.println("Слова, начинающиеся на гласную:");
        System.out.println(vowels);
        System.out.println("==========================");

        TextReverser textReverser = new TextReverser();
        String reversedText = textReverser.reverse(text);
        System.out.println("Текст наоборот:");
        System.out.println(reversedText);

        Writer writer = new Writer();
        if (outDir.mkdir()) {
            System.out.println("Директория успешно создана!");
        }
        writer.writeTextToFile(outFile, reversedText);
    }
}
