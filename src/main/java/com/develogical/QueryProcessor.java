package com.develogical;

public class QueryProcessor {

    public String process(String query) {
        if (query.toLowerCase().contains("shakespeare")) {
            return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                    "English poet, playwright, and actor, widely regarded as the greatest " +
                    "writer in the English language and the world's pre-eminent dramatist.";
        } else if (query.toLowerCase().contains("asimov")) {
            return "Isaac Asimov (2 January 1920 - 6 April 1992) was an\n" +
                    "American writer and professor of Biochemistry, famous for\n" +
                    "his works of hard science fiction and popular science.";
        }
        return "";
    }
}
