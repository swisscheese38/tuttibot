package ch.swisscheese38.tuttibot;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Map;
import java.util.HashMap;

public class Search {

    private static final String BASE_URL = "https://www.tutti.ch/de/q/suche/?sorting=newest&page=1&query=";

    private final Logger logger = LoggerFactory.getLogger(Search.class);
    private final Map<String, Result> resultMap = new HashMap<>();

    private String query;

    public Search(final String query) {
        this.query = query;
    }

    public void search() throws IOException {
        final Document doc = Jsoup.connect(BASE_URL + query).get();
        final Elements itemDivs = doc.select("div[data-private-srp-listing-item-id]");
        for (final Element itemDiv : itemDivs) {
            final String itemId = itemDiv.attr("data-private-srp-listing-item-id");
            final String title = itemDiv.selectXpath("div[2]/h3").first().text();
            final Elements divs = itemDiv.selectXpath("div[2]/div");
            //final String placeAndTime = divs.get(0).text();
            //final String description = divs.get(1).text();
            final int price = parsePrice(divs.get(2).text());

            if (!resultMap.containsKey(itemId)) {
                // new hit
                resultMap.put(itemId, new Result(itemId, title, price));
            }
        }
        logger.info("resultMap.size(): " + resultMap.size());
    }

    public void readHistory() {
    }

    private int parsePrice(final String price) {
        return Integer.parseInt(
            price.substring(
                0, 
                price.indexOf(".", 0))
            .replaceAll("'", "")
        );
    }

}
