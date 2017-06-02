package objects;

import com.google.gson.Gson;
import org.jsoup.nodes.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Properties;


public class Price extends RozetkaPageElement{
    private final static Logger logger = LoggerFactory.getLogger(Price.class);

    private String usdPrice;
    private String oldUsdPrice;
    private String price;
    private String oldPrice;

    public Price(Element element) {
        super(element);
        this.price = readFild("price");
        this.oldPrice = readFild("old_price");
        this.usdPrice = readFild("usd_price");
        this.oldUsdPrice = readFild("old_usd_price");
    }

    private String readFild(String property) {
        String scriptContent = element.html();
        String json = null;
        try {
            json = URLDecoder.decode(scriptContent.substring(scriptContent.indexOf("\"") + 1
                                                                ,  scriptContent.lastIndexOf("\""))
                                        , "UTF-8");
        } catch (UnsupportedEncodingException e) {
            logger.error(e.getMessage(), e);
        }
        return new Gson().fromJson(json, Properties.class).getProperty(property);
    }

    public String getUsdPrice() {
        return usdPrice;
    }

    public String getOldUsdPrice() {
        return oldUsdPrice;
    }

    public String getPrice() {
        return price;
    }

    public String getOldPrice() {
        return oldPrice;
    }
}
