package ch.swisscheese38.tuttibot;

import java.io.IOException;

public class Main {

    public static void main(String... args) throws IOException {
        final Search maxiSearch = new Search("puch+maxi");
        maxiSearch.search();
    }
}
