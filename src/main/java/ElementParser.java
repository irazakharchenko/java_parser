import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public abstract class ElementParser {
    public String elementsCssQuerty(Element element, String cssQuerty, String attributeKey) {
        return element.select(cssQuerty).attr(attributeKey).toString();
    }

    public Elements elementsCssQuerty(Element element, String cssQuerty){
        return element.select(cssQuerty);
    }
}
