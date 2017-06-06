import Reporter.Reporter;
import objects.RozetkaPage;
import org.jsoup.nodes.Document;
import org.junit.Assert;
import org.junit.Test;
import parser.Parser;
import parser.RozetkaProductParser;

import java.io.IOException;

public class RunnerTest {

    @Test
    public void checkNumberOfReviews_shouldBe49() throws IOException {
        String id = "5000299223017";
        String expectedReviewsQuantity = "49";
        Parser parser = new RozetkaProductParser();
        Document document = parser.parse(id);
        RozetkaPage page = new RozetkaPage(document);
        Assert.assertEquals(expectedReviewsQuantity, page.getReviews().getQuantity());
    }

    @Test
    public void checkNumberOfStars_shouldBe5() throws IOException {
        String id = "5000299223017";
        Parser parser = new RozetkaProductParser();
        String expectedStarsQuantity = "5";
        Document document = parser.parse(id);
        RozetkaPage page = new RozetkaPage(document);
        Assert.assertEquals(expectedStarsQuantity, page.getStars().getQuantity());
    }

    @Test
    public void logPriceInUsd() throws IOException {
        String id = "5000299223017";
        Parser parser = new RozetkaProductParser();
        Document document = parser.parse(id);
        RozetkaPage page = new RozetkaPage(document);
        Runner.logger.info("\n[USD Price]: " + page.getPrice().getUsdPrice());
    }
}
