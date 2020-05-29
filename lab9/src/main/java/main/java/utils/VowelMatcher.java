package main.java.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VowelMatcher {
    static Pattern vowelPattern = Pattern.compile("(?i)\\b[уеёаоэяиюУЕЁАОЭЯИЮ][^\\s]*(?=(\\s|$))");

    public String match(String text) {
        StringBuilder sb = new StringBuilder();
        Matcher vowelMather = vowelPattern.matcher(text);
        while (vowelMather.find()) {

            sb.append(vowelMather.group());
            sb.append(' ');
        }

        return sb.toString().trim();
    }
}
