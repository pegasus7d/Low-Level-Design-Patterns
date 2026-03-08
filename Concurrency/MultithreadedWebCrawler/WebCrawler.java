package Concurrency.MultithreadedWebCrawler;

import java.util.*;
import java.util.concurrent.*;

/**
 * Concurrency interview: Multithreaded Web Crawler (LeetCode 1242 style).
 * Crawl startUrl and all same-host links using multiple threads; avoid duplicates.
 *
 * TODO: Use ExecutorService, Set for visited (e.g. ConcurrentHashMap.newKeySet()), crawl same-host URLs only.
 */
public class WebCrawler {
    public List<String> crawl(String startUrl, HtmlParser parser) throws InterruptedException {
        // TODO: Get host from startUrl; visited set; executor; BFS/DFS with worker threads; return list of crawled URLs
        List<String> result = new ArrayList<>();
        result.add(startUrl);
        return result;
    }

    private String getHost(String url) {
        int i = url.indexOf("://");
        if (i < 0) return "";
        int j = url.indexOf("/", i + 3);
        return j < 0 ? url.substring(i + 3) : url.substring(i + 3, j);
    }
}
