package main.java;

import main.java.services.Sentence;
import main.java.services.Text;
import main.java.services.Word;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    private final static String FILE_PATH = System.getProperty("user.dir") + "/database/text.txt";

    public static void main(String[] args) {
        Text currentText = new Text(FILE_PATH);
        try {
            currentText.createText();
        } catch (IOException e) {
            System.out.println(e);
        }
        List<Sentence> sentenceList = currentText.getSentences();
        List<Word> uniqueWords = getUniqueWords(sentenceList);
        if (uniqueWords.size() == 0) {
            System.out.println("No unique words");
        } else {
            for (Word uniqueWord : uniqueWords) {
                System.out.println("Unique word: " + uniqueWord.toString());
            }
        }

        // ====================
        System.out.println("==================");
        System.out.println("All the sentences:");
        printSentences(sentenceList);

        List<Sentence> commonSentences = getCommonSentences(sentenceList);
        System.out.println("=====================================");
        System.out.println("The sentences that have common words:");
        printSentences(commonSentences);
    }

    private static List<Word> getUniqueWords(List<Sentence> sentenceList) {
        List<Word> uniqueWords = new ArrayList<>();
        Set<Word> firstSentenceWords = sentenceList.get(0).getWords();
        for (Word word: firstSentenceWords) {
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

    private static List<Sentence> getCommonSentences(List<Sentence> sentenceList) {
        List<Sentence> commonSentences = new ArrayList<>();

        for (int i = 0; i < sentenceList.size(); i += 1) {
            AtomicBoolean contains = new AtomicBoolean(false);
            AtomicInteger indexToAdd = new AtomicInteger();

            for (Word word: sentenceList.get(i).getWords()) {
                for (int j = i + 1; j < sentenceList.size(); j += 1) {
                    if (commonSentences.contains(sentenceList.get(j))) {
                        continue;
                    }

                    int finalJ = j;

                    sentenceList.get(j).getWords().forEach(w -> {
                        if (w.toString().equals(word.toString())) {
                            contains.set(true);
                            indexToAdd.set(finalJ);
                        }
                    });
                }
            }

            if (contains.get()) {
                commonSentences.add(sentenceList.get(i));
                commonSentences.add(sentenceList.get(indexToAdd.get()));
            }
        }

        return commonSentences;
    }
}
