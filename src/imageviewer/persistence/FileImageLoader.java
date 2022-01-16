package imageviewer.persistence;
import imageviewer.model.Image;
import imageviewer.model.ProxyImage;
import java.io.File;
import java.io.FileFilter;

public class FileImageLoader implements ImageLoader {
    private final File[] files;
    private int current;
    
    
    public FileImageLoader(File folder) {
        this.current = 0;
        this.files = folder.listFiles(imageTypes());
    }
    
    public File[] getFiles() {
        return files;
    }
    
    private FileFilter imageTypes() {
        return new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.getName().endsWith(".jpg") |
                    pathname.getName().endsWith(".JPG") |
                        pathname.getName().endsWith(".png") |
                            pathname.getName().endsWith(".jfif") |
                                pathname.getName().endsWith(".gif") |
                                    pathname.getName().endsWith(".svg") |
                                        pathname.getName().endsWith(".ico") |
                                            pathname.getName().endsWith(".PNG");
                }
            };
        }
    
        @Override
        public Image load() {
            if(this.files.length > 0)
                return new ProxyImage(this.files[this.current]);
            return null;
    }

    @Override
    public Image next() {
        if(this.current == this.files.length - 1) {
            this.current = 0;
        }else{
            this.current++;   
        }
        return this.load();
    }

    @Override
    public Image prev() {
        if(this.current == 0) {
            this.current = this.files.length - 1;
        }else{
            this.current--;   
        }
        return this.load();
    }
}
