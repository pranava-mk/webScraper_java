import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class WebScraper {
    public static void main(String[] args) throws IOException {
        URL url = new URL(args[0]);
        Document document = Jsoup.connect(url.toString()).get();

        Elements links = document.select("a[href]");
        List<String> linkList = new ArrayList<>();
        for (Element link : links) {
            linkList.add(link.attr("abs:href"));
        }

        String fileName = url.getHost().replaceAll("[^a-zA-Z0-9-_\\.]", "_") + ".csv";
        File file = new File(fileName);
        FileWriter writer = new FileWriter(file);

        for (String link : linkList) {
            writer.write(link + "\n");
        }
        writer.close();
    }
}
