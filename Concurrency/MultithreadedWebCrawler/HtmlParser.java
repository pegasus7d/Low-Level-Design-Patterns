package Concurrency.MultithreadedWebCrawler;

import java.util.List;

/**
 * Mock interface (like LeetCode 1242). Returns list of URLs from a page.
 */
public interface HtmlParser {
    List<String> getUrls(String url);
}
