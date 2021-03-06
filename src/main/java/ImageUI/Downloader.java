package ImageUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Downloader implements ActionListener {
    private String location;

    public Downloader(String Location){
        this.location=Location;
    }

    @Override
    public void actionPerformed(ActionEvent e) {//downloads the image from the url of the selected image to the default download folder of the computer system
            System.out.println("Downloading Image");
            try(InputStream in = new URL(location).openStream()){
                String home = System.getProperty("user.home");
                File file_name = new File(location);
                String path = home + "/Downloads/" + file_name.getName();
                File file = new File(path);
                if(file.exists() && !file.isDirectory()) {
                    Toolkit.getDefaultToolkit().beep();
                    System.out.println("Image already present in download directory");
                    JOptionPane.showMessageDialog(null, "The Image already exists at: "+path);
                }
                else{
                    Files.copy(in, Paths.get(path));
                    System.out.println("Download successful");
                    JOptionPane.showMessageDialog(null, "The Image has been downloaded to: "+path);
                }

            } catch (IOException ioException) {
                ioException.printStackTrace();
                System.out.println("Could not connect to database");
                JOptionPane.showMessageDialog(null, "Could not connect to database, please check your internet connection");
            }

    }
}
