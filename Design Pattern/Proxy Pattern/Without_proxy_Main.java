// ============================================================
// File: Video.java
// Purpose: Represents the Data Model for a video resource.
// ============================================================
package WithoutProxy;

/**
 * Purpose: Represents the Data Model for a video resource.
 * Data Flow: Created by YouTubeServer and passed down to the downloader and client.
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
// File: YouTubeServer.java
// Purpose: Emulates the actual remote YouTube API/Server.
// Responsibility: Connects directly to infrastructure to retrieve data.
// Issue: Lacks any optimization or interceptor layers; execution is always heavy.
// ============================================================

/**
 * Purpose: Emulates the actual remote YouTube API/Server.
 * Responsibility: Connects directly to infrastructure to retrieve data.
 * Issue: Lacks any optimization or interceptor layers; execution is always heavy.
 */
class YouTubeServer {

    // Simulates a heavy network request to download a video
    public Video downloadVideo(String videoId) {
        System.out.println("[SERVER] Connecting to YouTube Server...");
        System.out.println("[SERVER] Downloading byte stream for video ID: " + videoId);
        
        // Simulating network latency
        try {
            Thread.sleep(1500); 
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        String title = "Sample Video (" + videoId + ")";
        System.out.println("[SERVER] Successfully fetched '" + title + "' from remote server.");
        return new Video(videoId, title);
    }
}


// ============================================================
// File: YouTubeDownloader.java
// Purpose: The User Interface component / Client Application helper.
// Data Flow: Interacts directly with the heavy YouTubeServer object.
// ============================================================

/**
 * Purpose: The User Interface component / Client Application helper.
 * Data Flow: Interacts directly with the heavy YouTubeServer object.
 */
class YouTubeDownloader {
    // Tightly coupled dependency to the concrete server implementation
    private final YouTubeServer apiService;

    public YouTubeDownloader(YouTubeServer apiService) {
        this.apiService = apiService;
    }

    // Renders the video page by requesting it directly from the server every time
    public void renderVideoPage(String videoId) {
        System.out.println("\n------------------------------------------------");
        System.out.println("[CLIENT] User opened video page for ID: " + videoId);
        
        Video video = apiService.downloadVideo(videoId);
        
        System.out.println("[CLIENT] Rendering video page: " + video.getTitle());
        System.out.println("------------------------------------------------");
    }
}


// ============================================================
// File: Main.java
// Role: Client Entry Point
// Purpose: Executes repeated requests to demonstrate system performance without a structural proxy layer.
// ============================================================

/**
 * Role: Client Entry Point
 * Purpose: Executes repeated requests to demonstrate system performance without a structural proxy layer.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== Running Project 1: WITHOUT Proxy Pattern ===");

        YouTubeServer server = new YouTubeServer();
        YouTubeDownloader downloader = new YouTubeDownloader(server);

        // Requesting the same video multiple times sequentially
        downloader.renderVideoPage("Video 1");   // 1st time: Server hit (1500ms)
        downloader.renderVideoPage("Video 1");   // 2nd time: Another server hit (1500ms) - REDUNDANT!
        downloader.renderVideoPage("Video 2");   // 1st time: Server hit (1500ms)
        downloader.renderVideoPage("Video 2");   // 2nd time: Another server hit (1500ms) - REDUNDANT!
        downloader.renderVideoPage("Video 1");   // 3rd time: Another server hit (1500ms) - REDUNDANT!
        downloader.renderVideoPage("Video 3");   // 1st time: Server hit (1500ms)
    }
}