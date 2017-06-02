package parser;

import org.jsoup.nodes.Document;

import java.io.IOException;

public interface Parser {

    Document parse(String pageIdentifier) throws IOException;
}
