import Reporter.Reporter;
import objects.RozetkaPage;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import parser.Parser;
import parser.RozetkaProductParser;

import java.io.IOException;

public class Runner {
    final static Logger logger = LoggerFactory.getLogger(Runner.class);

    public static void main(String[] args) throws IOException {
        String id = args[0];
        String expectedReviewsQuantity = args[1];
        String expectedStarsQuantity = args[2];
        Parser parser = new RozetkaProductParser();
        Document document = parser.parse(id);
        RozetkaPage page = new RozetkaPage(document);
        Reporter r = new Reporter();
        r.result(expectedStarsQuantity, page.getStars().getQuantity());
        r.result(expectedReviewsQuantity, page.getReviews().getQuantity());
        logger.info("\n[USD Price]: " + page.getPrice().getUsdPrice());
    }
}
