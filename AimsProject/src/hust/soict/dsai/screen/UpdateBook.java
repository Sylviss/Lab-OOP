package hust.soict.dsai.screen;

import javax.swing.JFrame;

import hust.soict.dsai.swing.StoreScreen;

import java.io.IOException;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class UpdateBook extends JFrame {
    StoreScreen store;

    public UpdateBook(StoreScreen store) {
        super();
        this.store = store;
        JFXPanel fxPanel = new JFXPanel();
        this.add(fxPanel);

        this.setTitle("Update Book");
        this.setVisible(true);
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("UpdateBook.fxml"));
                    loader.setController(new BookUpdateController(store));
                    Parent root = loader.load();
                    fxPanel.setScene(new Scene(root));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        this.setSize(400, 400);
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    }

}
