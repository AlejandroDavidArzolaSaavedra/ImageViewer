package imageviewer.controller;

import imageviewer.model.Image;
import imageviewer.persistence.FileImageLoader;
import java.io.File;

public class Main {
    public static void main(String[] args) {        
        File file = new File("C:\\Users\\Lab-DIS\\Pictures\\imagenes");
        FileImageLoader imageLoader = new FileImageLoader(file);
        Image image = imageLoader.load();
        Boolean faltanImagenes = false;
        if(imageLoader.getFiles().length == 0)
            faltanImagenes = true;
        MainFrame mainFrame = new MainFrame(imageLoader, faltanImagenes);
        mainFrame.getImageDisplay().show(image);
    }
}
