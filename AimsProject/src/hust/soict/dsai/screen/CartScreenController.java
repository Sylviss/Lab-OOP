package hust.soict.dsai.screen;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import hust.soict.dsai.exception.PlayerException;
import javafx.beans.property.FloatProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableStringValue;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class CartScreenController {
    private Cart cart;

    private StringProperty totalCostString;

    @FXML
    private Label totalCost;

    @FXML
    private Button btnOrder;

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private TableView<Media> tblMedia;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private TableColumn<Media, String> colMediaCategory;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

        @FXML
    private RadioButton radioBtnFilterId;

    @FXML
    private RadioButton radioBtnFilterTitle;

    @FXML
    private TextField tfFilter;
    
    public CartScreenController(Cart cart) {
        super();
        this.cart = cart;
        this.totalCostString = new SimpleStringProperty();
    }

    @FXML
    private void initialize() {
        totalCostString.set(Float.toString(cart.totalCost())+" $");
        colMediaTitle.setCellValueFactory(
            new PropertyValueFactory<Media, String>("title"));
        colMediaCategory.setCellValueFactory(
            new PropertyValueFactory<Media, String>("category"));
        colMediaCost.setCellValueFactory(
            new PropertyValueFactory<Media, Float>("cost"));
        tblMedia.setItems(this.cart.getItemsOrdered());

        btnPlay.setVisible(false);
        btnRemove.setVisible(false);
    
        tblMedia.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Media>() {
            public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
                if (newValue != null) {
                    updateButtonBar(newValue);
                }
            }
        });

        tfFilter.textProperty().addListener(new ChangeListener<String>() {
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                showFilteredMedia(newValue);
            }
        });

        totalCost.textProperty().bind(totalCostString);
    }

    void showFilteredMedia(String newValue){
        FilteredList<Media> newList = new FilteredList<>(this.cart.getItemsOrdered());
        if(!newValue.equals("")){
            if(radioBtnFilterTitle.isSelected()){
                newList.setPredicate(t -> t.isMatch(newValue));
            }
            else{
                try{
                    newList.setPredicate(t -> t.isMatch(Integer.parseInt(newValue)));
                } catch (NumberFormatException e){
                    
                }
            }
        }
        tblMedia.setItems(newList);
    }

    void updateButtonBar(Media media){
        btnRemove.setVisible(true);
        if (media instanceof Playable){
            btnPlay.setVisible(true);
        } else {
            btnPlay.setVisible(false);
        }
    }

    @FXML
    void btnRemovePressed(ActionEvent event){
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        cart.removeMedia(media);
        totalCostString.set(Float.toString(cart.totalCost())+" $");
    }

    @FXML
    void placeOrderPressed(){
        JDialog dialog = new JDialog();
        String playContent = "Ordered " + Float.toString(cart.totalCost())+" $";
        JLabel label = new JLabel();
        dialog.add(label);
        label.setText(playContent);
        dialog.setSize(300,200);
        dialog.setTitle("Order");
        cart.clear();
        updateCost();
        dialog.setVisible(true);
        dialog.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @FXML
    void btnPlayPressed(){
        JDialog dialog = new JDialog();
        String playContent = null;
        try {
            playContent = ((Playable)tblMedia.getSelectionModel().getSelectedItem()).play();
        } catch (PlayerException e) {
            playContent = e.getMessage();
        }
        JLabel label = new JLabel();
        dialog.add(label);
        label.setText(playContent);
        dialog.setSize(300,200);
        dialog.setTitle("Playing");
        dialog.setVisible(true);
        dialog.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    void updateCost(){
        totalCostString.set(Float.toString(cart.totalCost())+" $");
    }
}
