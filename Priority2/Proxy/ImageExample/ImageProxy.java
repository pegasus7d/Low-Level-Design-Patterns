package Priority2.Proxy.ImageExample;

// Proxy - lazy loading: creates RealImage only when display() is first called
// TODO: Hold filename and RealImage (null initially). display(): if image is null, create new RealImage(filename), then image.display()
public class ImageProxy implements Image {
    private final String filename;
    private RealImage image; // null until first display()
    public ImageProxy(String filename) { this.filename = filename; }
    public void display() {
        // TODO: if (image == null) image = new RealImage(filename); then image.display();
        if (image == null) image = new RealImage(filename);
        image.display();
    }
}
