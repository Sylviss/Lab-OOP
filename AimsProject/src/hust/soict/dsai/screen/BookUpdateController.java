package hust.soict.dsai.screen;

import java.util.ArrayList;
import java.util.Arrays;

import hust.soict.dsai.aims.media.Book;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import hust.soict.dsai.swing.StoreScreen;
import javax.swing.JFrame;

public class BookUpdateController extends StoreUpdateController {
    @FXML
    TextField tfAuthors;

    BookUpdateController(StoreScreen store) {
        super(store);
    }

    @FXML
    void addBtnPressed() {
        String title = tfTitle.getText();
        String category = tfCategory.getText();
        float cost = Float.parseFloat(tfCost.getText());
        ArrayList<String> authors = new ArrayList<String>(Arrays.asList(tfAuthors.getText().split(",")));
        Book book = new Book(title, category, authors, cost);
        store.getStore().addMedia(book);
        store.updateCenter();
    }

}
