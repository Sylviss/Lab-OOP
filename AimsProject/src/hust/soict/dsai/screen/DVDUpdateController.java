package hust.soict.dsai.screen;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import hust.soict.dsai.swing.StoreScreen;

public class DVDUpdateController extends StoreUpdateController {
    @FXML
    TextField tfDirector;
    @FXML
    TextField tfLength;

    DVDUpdateController(StoreScreen store) {
        super(store);
    }

    @FXML
    void addBtnPressed() {
        String title = tfTitle.getText();
        String category = tfCategory.getText();
        float cost = Float.parseFloat(tfCost.getText());
        String director = tfDirector.getText();
        int length = Integer.parseInt(tfLength.getText());
        DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, director, length, cost);
        store.getStore().addMedia(dvd);
        store.updateCenter();
    }

}
