package ch.swisscheese38.tuttibot;

import java.io.IOException;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String... args) throws IOException {
        final String url = "https://www.tutti.ch/de/q/suche/?sorting=newest&page=1&query=puch+maxi";
        final Document doc = Jsoup.connect(url).get();

        final Elements itemDivs = doc.select("div[data-private-srp-listing-item-id]");
        final List<String> itemIds = itemDivs.eachAttr("data-private-srp-listing-item-id");

        itemIds.forEach(logger::info);
    }
}
