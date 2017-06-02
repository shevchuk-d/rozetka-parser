package objects;

import org.jsoup.nodes.Document;

public class RozetkaPage {
    private Document document;
    private Price price;
    private Stars stars;
    private Reviews reviews;

    public RozetkaPage(Document document) {
        this.document = document;
        stars = new Stars(document.getElementsByClass("g-rating-stars-i-medium").first());
        reviews = new Reviews(document.getElementsByClass("g-rating-reviews-link-medium").first());
        price = new Price(document.getElementsByTag("script").stream()
                .filter(element -> element.html().contains("var pricerawjson ="))
                .findAny()
                .orElse(null));
    }

    public Price getPrice() {
        return price;
    }

    public Stars getStars() {
        return stars;
    }

    public Reviews getReviews() {
        return reviews;
    }
}
