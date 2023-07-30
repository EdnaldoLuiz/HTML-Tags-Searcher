package com.nuti.nuti;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ContadorDeTags {

    public static void countTags(String html) {
        Document doc = Jsoup.parse(html);
        Elements tags = doc.select("*");
        
        for (Element tag : tags) {
            String tagName = tag.tagName();
            System.out.println(tagName);
        }
    }
}
