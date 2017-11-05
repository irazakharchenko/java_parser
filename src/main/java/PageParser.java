import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.io.PrintWriter;

public class PageParser extends ElementParser{
    public void parserByUrl(String globalUrl) throws IOException {
        Document doc = Jsoup.connect(globalUrl).get();
        // select category

        Elements ElementsGoods = elementsCssQuerty(doc,"div#catalog_goods_block" );
        String strElemNum, strElemUrl, strElemName;
        //  g-i-tile-catalog touch
        try {
            PrintWriter writer = new PrintWriter("results.csv", "UTF-8");
            for (Element element : ElementsGoods.select("div.g-i-tile")) {
                // find each url

                strElemName = elementsCssQuerty(element, "div.g-i-tile-i-image img", "title");
                strElemUrl = elementsCssQuerty(element, "div.g-i-tile-i-image a", "href");
                strElemNum = elementsCssQuerty(element, "a.g-rating-reviews-link", "data-count");
                new WriterToCsv().writeToCsv(writer, strElemUrl, strElemName, strElemNum);

            }
            writer.close();
        } catch (IOException e) {
            // do something
        }
    }



}
