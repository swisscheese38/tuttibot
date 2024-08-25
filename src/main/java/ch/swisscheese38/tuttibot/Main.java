package ch.swisscheese38.tuttibot;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String... args) throws IOException {
        //final Request request = Request.post("https://www.tutti.ch/api/v10/graphql");
        //final HttpResponse response = request.execute().returnResponse();
        //logger.info(response.toString());

        final String url = "https://www.tutti.ch/de/q/suche/?sorting=newest&page=1&query=puch+maxi";
        final Document doc = Jsoup.connect(url).get();
        final Elements itemDivs = doc.select("div[data-private-srp-listing-item-id]");
        for (final Element itemDiv : itemDivs) {
            final String itemId = itemDiv.attr("data-private-srp-listing-item-id");
            final String title = itemDiv.selectXpath("div[2]/h3").first().text();
            final Elements divs = itemDiv.selectXpath("div[2]/div");
            final String placeAndTime = divs.get(0).text();
            final String description = divs.get(1).text();
            final String price = divs.get(2).text();
            logger.info(itemId);
            logger.info(title);
            logger.info(placeAndTime);
            logger.info(description);
            logger.info(price);
        }
    }
}
