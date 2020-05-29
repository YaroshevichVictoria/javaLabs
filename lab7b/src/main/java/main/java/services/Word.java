package main.java.services;

public class Word {
    String value;

    public Word(String string) {
        value = string;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
