package ch.swisscheese38.tuttibot;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String... args) throws IOException {
        final String url = "https://www.tutti.ch/de/q/suche/?sorting=newest&page=1&query=puch+maxi";
        final Document doc = Jsoup.connect(url).get();
        logger.info(doc.title());
    }
}
