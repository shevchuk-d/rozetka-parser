package objects;

import org.jsoup.nodes.Element;

public abstract class RozetkaPageElement {
    protected Element element;

    public RozetkaPageElement(Element element) {
        this.element = element;
    }
}
