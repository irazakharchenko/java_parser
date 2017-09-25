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
        Document doc = Jsoup.connect(globalUrl).get();
        // select category
        Elements ElementsGoods = doc.select("div#catalog_goods_block");

        String strElemNum, strElemUrl, strElemName;
        //  g-i-tile-catalog touch
        try{
            PrintWriter writer = new PrintWriter("results.csv", "UTF-8");
            for (Element element : ElementsGoods.select("div.g-i-tile")){
                // find each url
                strElemUrl = element.select("div.g-i-tile-i-image a").attr("href");
                strElemName = element.select("div.g-i-tile-i-image img").attr("title");
                strElemNum = element.select("a.g-rating-reviews-link").attr("data-count").toString();
                if (strElemUrl.length() > 2) {
                    System.out.println(strElemName);
                    System.out.println(strElemUrl);
                    System.out.println(strElemNum + " reviews." );
                    System.out.println();
                    writer.println(strElemName);
                    writer.println(strElemUrl);
                    writer.println(strElemNum + " reviews.");
                    writer.println();

                }

            }
            writer.close();
        } catch (IOException e) {
            // do something
        }


    }
}
