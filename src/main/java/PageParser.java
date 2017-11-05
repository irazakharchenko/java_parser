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
        int max_rew = 0, min_rew = 9999999, cur_rew;
        try {
            PrintWriter writer = new PrintWriter("results.csv", "UTF-8");
            int i = 0;
            for (Element element : ElementsGoods.select("div.g-i-tile")) {
                // find each url

                strElemName = elementsCssQuerty(element, "div.g-i-tile-i-image img", "title");
                strElemUrl = elementsCssQuerty(element, "div.g-i-tile-i-image a", "href");
                strElemNum = elementsCssQuerty(element, "a.g-rating-reviews-link", "data-count");
                new WriterToCsv().writeToCsv(writer, strElemUrl, strElemName, strElemNum);
                if(strElemNum.length() > 0) {
                    cur_rew = Integer.parseInt(strElemNum);
                    if( cur_rew > max_rew)
                        max_rew = cur_rew;
                    else if (cur_rew < min_rew)
                        min_rew = cur_rew;

                }
            }
            writer.close();

            String lineWithMinMax = "min review is " + new Integer(min_rew).toString() +
                    "\nmax review is " + new Integer(max_rew).toString() + "." ;
            new WriterToCsv().writeOneLine(writer, lineWithMinMax);

        } catch (IOException e) {
            // do something
        } catch (NullPointerException n){

        }
    }



}
