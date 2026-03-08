package Concurrency.MultithreadedWebCrawler;

import java.util.*;

/**
 * Test: Mock parser returns same-host links; crawl and collect URLs.
 */
public class WebCrawlerTest {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== Multithreaded Web Crawler Test ===\n");
        HtmlParser parser = url -> {
            if (url.contains("http://example.com")) {
                if (url.endsWith("/")) return Arrays.asList("http://example.com/a", "http://example.com/b");
                if (url.endsWith("/a")) return Arrays.asList("http://example.com/");
            }
            return Collections.emptyList();
        };
        WebCrawler crawler = new WebCrawler();
        List<String> result = crawler.crawl("http://example.com/", parser);
        System.out.println("Crawled: " + result);
        System.out.println("=== Done ===");
    }
}
