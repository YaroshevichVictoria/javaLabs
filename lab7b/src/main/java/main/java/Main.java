package main.java;

import main.java.services.Punctuation;
import main.java.services.Sentence;
import main.java.services.Text;
import main.java.services.Word;
import org.w3c.dom.ranges.Range;

import java.io.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private final static String FILE_PATH = System.getProperty("user.dir") + "/database/text.txt";

    public static void main(String[] args) throws FileNotFoundException {
        Text currentText = new Text(FILE_PATH);
        try {
            currentText.createText();
        } catch (IOException e) {
            System.out.println(e);
        }
        List<Sentence> sentenceList = currentText.getSentences();
        List<Word> uniqueWords = getUniqueWords(sentenceList);
        System.out.println("All the sentences:");
        printSentences(sentenceList);
        System.out.println("==================");
        if (uniqueWords.size() == 0) {
            System.out.println("No unique words");
        } else {
            for (Word uniqueWord : uniqueWords) {
                System.out.println("Unique word: " + uniqueWord.toString());
            }
        }
        System.out.println("==================");

        System.out.println(toUpperCaseForFirstLetter(sentenceList.toString()));

        //
    }

    private static List<Word> getUniqueWords(List<Sentence> sentenceList) {
        List<Word> uniqueWords = new ArrayList<>();
        Set<Word> firstSentenceWords = sentenceList.get(0).getWords();
        for (Word word : firstSentenceWords) {
            AtomicBoolean contains = new AtomicBoolean(false);
            for (int i = 1; i < sentenceList.size(); i += 1) {
                sentenceList.get(i).getWords().forEach(w -> {
                    if (w.toString().equals(word.toString())) {
                        contains.set(true);
                    }
                });
            }
            if (!contains.get()) {
                uniqueWords.add(word);
            }
        }

        return uniqueWords;
    }

    private static void printSentences(List<Sentence> sentenceList) {
        for (Sentence sentence : sentenceList) {
            System.out.println(sentence.getValue());
        }
    }

    private static String toUpperCaseForFirstLetter(String text) {
        StringBuilder builder = new StringBuilder(text);
        char []mn;
        for (int i=0;i<text.length();i++) {
        
        }


        for (int i = 0; i < text.length(); i++)
            if (Character.isAlphabetic(text.charAt(i)) && Character.isSpaceChar(text.charAt(i - 1)) && ((Character.isAlphabetic(text.charAt(i + 1)))||(Character.isAlphabetic(text.charAt(i + 2)))))
                builder.setCharAt(i, Character.toUpperCase(text.charAt(i)));

        return builder.toString();
    }}


