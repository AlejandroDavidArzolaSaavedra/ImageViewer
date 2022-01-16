package imageviewer.controller;
import imageviewer.persistence.ImageLoader;
import imageviewer.ui.ImageDisplay;
import imageviewer.ui.SwingImageDisplay;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class MainFrame extends JFrame {
    private ImageDisplay imageDisplay;
    private final ImageLoader imageLoader;

    public MainFrame(ImageLoader imageLoader, boolean bandera) {
        this.imageLoader = imageLoader;
        this.setTitle("Image Viewer");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(800,600);
        this.setLocationRelativeTo(null);
        this.getContentPane().add(imageDisplay());
        if(bandera) {
            this.getContentPane().add(toolBarWithoutImage(),BorderLayout.SOUTH);
        }else{
            this.getContentPane().add(toolBar(),BorderLayout.SOUTH);
        }
        this.setVisible(true);
    }
    
    private JPanel toolBar() {
        JPanel panel = new JPanel();
        panel.add(prevButton());
        panel.add(nextButton());
        return panel;
    }
    
    private Component toolBarWithoutImage() {
        JPanel panel = new JPanel();
        JLabel label = new JLabel();
        label.setText("No hay imagenes, vuelva a intentarlo");
        label.setFont(new Font("Serif", Font.PLAIN, 14));
        panel.add(label);
        return panel;
    }
    
    private JButton prevButton() {
        JButton button = new JButton("<");
        button.addActionListener(prevImage());
        return button;
    }
    
    private ActionListener prevImage() {
        return (ActionEvent e) -> { imageDisplay.show(imageLoader.prev());};
    }
    
    private JButton nextButton() {
        JButton button = new JButton(">");
        button.addActionListener(nextImage());
        return button;
    }
    
    private ActionListener nextImage() {
        return (ActionEvent e) -> { imageDisplay.show(imageLoader.next());};
    }
    
    private JPanel imageDisplay() {
        SwingImageDisplay sid = new SwingImageDisplay();
        this.imageDisplay = sid;
        return sid;
    }
    
    public ImageDisplay getImageDisplay() {
        return imageDisplay;
    }
}
