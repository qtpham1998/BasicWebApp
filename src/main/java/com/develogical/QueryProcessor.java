package com.develogical;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QueryProcessor {

    public String process(String query) {
        try {
            query = URLDecoder.decode(query, StandardCharsets.UTF_8.name());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        if (query.toLowerCase().contains("shakespeare")) {
            return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                    "English poet, playwright, and actor, widely regarded as the greatest " +
                    "writer in the English language and the world's pre-eminent dramatist.";
        } else if (query.toLowerCase().contains("asimov")) {
            return "Isaac Asimov (2 January 1920 - 6 April 1992) was an\n" +
                    "American writer and professor of Biochemistry, famous for\n" +
                    "his works of hard science fiction and popular science.";
        } else if (query.toLowerCase().contains("name")) {
            return "HYAT";
        } else if (query.toLowerCase().contains("multiplied")) {
            Pattern p = Pattern.compile("what is (\\d+) multiplied by (\\d+)");
            Matcher m = p.matcher(query);
            if (m.find()) {
                return String.valueOf(Integer.parseInt(m.group(1)) * Integer.parseInt(m.group(2)));
            }
            return "0";
        } else if (query.toLowerCase().contains("plus")) {
            int firstOp = Integer.parseInt(query.toLowerCase(). split("%20|\\s+")[2]);
            int secondOp = Integer.parseInt(query.toLowerCase(). split("%20|\\s+")[4]);
            return String.valueOf(firstOp + secondOp);
        } else if (query.toLowerCase().contains("largest")) {
            String[] words = query.split("largest: ");
            String[] numbers = words[1].split(", ");
            int[] ints = new int[numbers.length()];
            for (int i = 0; i < numbers.length(); i++) {
                ints[i] = Integer.valueOf(numbers[i]);
            }
        }
            return String.valueOf(max(ints));
        return "";
    }
}
