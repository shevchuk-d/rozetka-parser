package objects;

import org.jsoup.nodes.Element;

import java.util.List;

public class Reviews extends RozetkaPageElement {

    private String quantity;
    private List<Review> reviews;

    public Reviews(Element element) {
        super(element);
        System.out.println(element.html());
        this.quantity = countReviews();
    }

    public String getQuantity() {
        return quantity;
    }

    private String countReviews() {
        return element.text()
                .replace("отзывов", "")
                .trim();
    }
}
