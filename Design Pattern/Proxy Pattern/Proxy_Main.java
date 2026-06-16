// ============================================================
// File: Video.java
// Purpose: Represents the Data Model for a video resource.
// ============================================================
package WithProxy;

/**
 * Purpose: Represents the Data Model for a video resource.
 * Unchanged from Project 1 to preserve encapsulation constraints.
 */
class Video {
    private final String id;
    private final String title;

    public Video(String id, String title) {
        this.id = id;
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}


// ============================================================
// File: ThirdPartyYouTubeLib.java
// Role: Subject Interface
// Purpose: Defines the common interface contract for both the Real Subject and the Proxy.
// ============================================================

/**
 * Role: Subject Interface
 * Purpose: Defines the common interface contract for both the Real Subject and the Proxy.
 * Why it exists: Enables polymorphism. The client can interact with the Proxy or the Real Subject 
 * interchangeably without knowing (or caring) about the caching layer behind it.
 */
interface ThirdPartyYouTubeLib {
    Video downloadVideo(String videoId);
}


// ============================================================
// File: ThirdPartyYouTubeClass.java
// Role: Real Subject
// Purpose: The actual service containing heavy business logic and network/database connections.
// ============================================================

/**
 * Role: Real Subject
 * Purpose: The actual service containing heavy business logic and network/database connections.
 * Data Flow: Only invoked when the Proxy determines that the requested data cannot be resolved locally.
 */
class ThirdPartyYouTubeClass implements ThirdPartyYouTubeLib {

    @Override
    public Video downloadVideo(String videoId) {
        System.out.println("[SERVER] Connecting to remote YouTube Server architecture...");
        System.out.println("[SERVER] Downloading heavy byte stream for video ID: " + videoId);
        
        // Emulating heavy network overhead
        try {
            Thread.sleep(1500); 
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        String title = "Optimized Video (" + videoId + ")";
        System.out.println("[SERVER] Successfully pulled '" + title + "' across the network backend.");
        return new Video(videoId, title);
    }
}


// ============================================================
// File: CachedYouTubeClass.java
// Role: Proxy
// Purpose: Wraps the Real Subject to control access, intercept requests, and add a caching mechanism.
// ============================================================

import java.util.HashMap;
import java.util.Map;

/**
 * Role: Proxy
 * Purpose: Wraps the Real Subject to control access, intercept requests, and add a caching mechanism.
 * 
 * Why HashMap is used:
 * - A HashMap provides average O(1) time complexity for lookup and insertion operations.
 * - By mapping a unique unique identifier (String videoId) to an instantiated object (Video), 
 *   we eliminate linear scanning search overloads (O(n)) completely.
 * 
 * How it reduces server requests:
 * - Acts as an application-level Cache Interceptor. It checks internal memory states before delegates.
 */
class CachedYouTubeClass implements ThirdPartyYouTubeLib {
    
    // Concrete reference to the real backend service object
    private final ThirdPartyYouTubeLib realService;
    
    // Internal Cache Registry using HashMap for O(1) performance
    private final Map<String, Video> cache;

    public CachedYouTubeClass(ThirdPartyYouTubeLib realService) {
        this.realService = realService;
        this.cache = new HashMap<>();
    }

    @Override
    public Video downloadVideo(String videoId) {
        // Step 1: Evaluate structural lookup state
        if (cache.containsKey(videoId)) {
            // Performance Advantage: O(1) Retrieval time bypassing downstream server trips completely.
            System.out.println("[PROXY] >>> CACHE HIT <<< Found metadata locally for ID: " + videoId);
            return cache.get(videoId);
        }

        // Step 2: Handle Cache Miss cleanly by delegating work down to Real Subject
        System.out.println("[PROXY] >>> CACHE MISS <<< No local record for ID: " + videoId + ". Delegating to Real Service.");
        
        Video downloadedVideo = realService.downloadVideo(videoId);
        
        // Step 3: Populate internal cache layer to neutralize subsequent structural hits
        cache.put(videoId, downloadedVideo);
        System.out.println("[PROXY] Persisted video object '" + downloadedVideo.getTitle() + "' inside local cache storage.");
        
        return downloadedVideo;
    }
}


// ============================================================
// File: YouTubeDownloader.java
// Role: Client Application Helper
// Purpose: Executes operational demands using the Subject Interface definition.
// ============================================================

/**
 * Role: Client Application Helper
 * Purpose: Executes operational demands using the Subject Interface definition.
 * Decoupling Principle: This class works exclusively with ThirdPartyYouTubeLib. It is entirely 
 * unaware of whether it is communicating directly with the real server or an operational proxy cache.
 */
class YouTubeDownloader {
    private final ThirdPartyYouTubeLib apiService;

    // Accepts the interface polymorphism wrapper (Constructor Injection)
    public YouTubeDownloader(ThirdPartyYouTubeLib apiService) {
        this.apiService = apiService;
    }

    public void renderVideoPage(String videoId) {
        System.out.println("\n------------------------------------------------");
        System.out.println("[CLIENT] User opened video page for ID: " + videoId);
        
        // Polymorphic invocation calls Proxy or Real Subject seamlessly
        Video video = apiService.downloadVideo(videoId);
        
        System.out.println("[CLIENT] Rendering video page: " + video.getTitle());
        System.out.println("------------------------------------------------");
    }
}


// ============================================================
// File: Main.java
// Role: Client Runtime Entry Point
// Purpose: Initializes the Proxy ecosystem by linking the structural wrappers together.
// ============================================================

/**
 * Role: Client Runtime Entry Point
 * Purpose: Initializes the Proxy ecosystem by linking the structural wrappers together.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== Running Project 2: WITH Proxy Pattern ===");

        // 1. Initialize the Target Real Subject dependency
        ThirdPartyYouTubeLib realService = new ThirdPartyYouTubeClass();

        // 2. Wrap the Real Subject inside our Caching Proxy interceptor layer
        ThirdPartyYouTubeLib proxyService = new CachedYouTubeClass(realService);

        // 3. Pass the Proxy into the client container application seamlessly (Constructor Injection)
        YouTubeDownloader downloader = new YouTubeDownloader(proxyService);

        // Run download routines to verify cache state mutations
        downloader.renderVideoPage("Video 1");   // 1st time: CACHE MISS -> Server Hit
        downloader.renderVideoPage("Video 1");   // 2nd time: CACHE HIT  -> Zero Server Overhead
        downloader.renderVideoPage("Video 2");   // 1st time: CACHE MISS -> Server Hit
        downloader.renderVideoPage("Video 2");   // 2nd time: CACHE HIT  -> Instant Return
        downloader.renderVideoPage("Video 1");   // 3rd time: CACHE HIT  -> Instant Return
        downloader.renderVideoPage("Video 3");   // 1st time: CACHE MISS
    }
}