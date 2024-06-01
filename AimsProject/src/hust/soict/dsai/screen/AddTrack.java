package hust.soict.dsai.screen;

import java.io.IOException;

import javax.swing.JFrame;

import hust.soict.dsai.aims.media.Track;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;

public class AddTrack extends JFrame {
    CDUpdateController parent;

    public AddTrack(CDUpdateController parent) {
        super();

        this.parent = parent;

        JFXPanel fxPanel = new JFXPanel();
        this.add(fxPanel);

        this.setTitle("Add Track");
        this.setVisible(true);
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("addTrack.fxml"));
                    loader.setController(new AddTrackController());
                    Parent root = loader.load();
                    fxPanel.setScene(new Scene(root));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        this.setSize(300, 300);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private class AddTrackController {
        @FXML
        TextField tfTitle;
        @FXML
        TextField tfLength;

        @FXML
        void addBtnPressed() {
            String title = tfTitle.getText();
            int length = Integer.parseInt(tfLength.getText());
            Track dvd = new Track(length,title);
            parent.getLvTracks().getItems().add(dvd);
            parent.getLvTracks().refresh();
            System.out.println("Track added");
        }

    }

}
