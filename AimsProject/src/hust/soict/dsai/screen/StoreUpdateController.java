package hust.soict.dsai.screen;

import hust.soict.dsai.swing.StoreScreen;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public abstract class StoreUpdateController {
    StoreScreen store;

    @FXML
    TextField tfTitle;

    @FXML
    TextField tfCategory;

    @FXML
    TextField tfCost;

    @FXML
    abstract void addBtnPressed();

    StoreUpdateController(StoreScreen store) {
        this.store = store;
    }
}
