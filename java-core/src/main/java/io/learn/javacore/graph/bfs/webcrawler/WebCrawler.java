package io.learn.javacore.graph.bfs.webcrawler;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebCrawler {
    private Queue<String> queue;
    private List<String> discoveredWebsites;

    public WebCrawler() {
        this.queue = new LinkedList<>();
        this.discoveredWebsites = new ArrayList<>();
    }

    public void discoverWeb(String staringPage) {
        this.queue.add(staringPage);
        this.discoveredWebsites.add(staringPage);

        while(!queue.isEmpty()) {
            String webSite = this.queue.remove();
            String rawHtml = readUrl(webSite);
            String regexp = "https://(\\w+\\.)*(\\w+)";
            Pattern pattern = Pattern.compile(regexp);
            Matcher matcher = pattern.matcher(rawHtml);
            while (matcher.find()) {
                String actualUrl = matcher.group();
                if (!discoveredWebsites.contains(actualUrl)) {
                    discoveredWebsites.add(actualUrl);
                    System.out.println("Website has bee found with URL: " + actualUrl);
                    queue.add(actualUrl);
                }
            }
        }
    }

    private String readUrl(String webSite) {
        String rawHtml = "";
        try {
            URL url = new URL(webSite);
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            String inputLine = "";
            while ((inputLine = reader.readLine()) != null) {
                rawHtml += inputLine;
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rawHtml;
    }
}
