import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.io.PrintWriter;

public class main_class {
    public static void main(String[] args) throws IOException {
        // connect to url
        String globalUrl = "https://rozetka.com.ua/ua/vdr/c153617/";

        new PageParser().parserByUrl(globalUrl);
    }
}
