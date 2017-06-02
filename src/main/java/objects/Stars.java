package objects;

import org.jsoup.nodes.Element;

public class Stars extends RozetkaPageElement {

    private String quantity;

    public Stars(Element element) {
        super(element);
        this.quantity = countStars();
    }

    public String getQuantity() {
        return quantity;
    }

    private String countStars() {
        String actualStarsRaw = element.attr("style")
                .replace("width:", "")
                .replace("%", "")
                .trim();
        int actualStarsRawInt = Integer.parseInt(actualStarsRaw);
        return String.valueOf(actualStarsRawInt / 20) +
                ((actualStarsRawInt % 20) !=0
                        ? ("." + (actualStarsRawInt % 20) * 5 / 10)
                        : "");
    }
}
