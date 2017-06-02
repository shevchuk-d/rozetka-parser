package parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class RozetkaProductParser implements Parser{

    public static final String ROZETKA_SEARCH_URL = "http://rozetka.com.ua/search/?text=";

    public Document parse(String productId) throws IOException {
        return Jsoup.connect(ROZETKA_SEARCH_URL + productId).get();
    }
}
