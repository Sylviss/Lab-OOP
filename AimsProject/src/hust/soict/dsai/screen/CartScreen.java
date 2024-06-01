package hust.soict.dsai.screen;

import java.io.IOException;

import javax.swing.JFrame;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class CartScreen extends JFrame {
    private Cart cart;
    public CartScreen(Cart cart) {
        super();
        this.cart = cart;
    
        JFXPanel fxPanel = new JFXPanel();
        this.add(fxPanel);
    
        this.setTitle("Cart");
        this.setVisible(true);
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("cart.fxml"));
                    CartScreenController controller = new CartScreenController(cart);
                    controller.updateCost();
                    loader.setController(controller);
                    Parent root = loader.load();
                    fxPanel.setScene(new Scene(root));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public static void main(String[] args) {
        Cart cart = new Cart();
        cart.addMedia(new Book("The Lion King 1", "Animation 1", 19.95f));
        cart.addMedia(new DigitalVideoDisc("The Lion King 1", "Animation 2", 19.95f));
        cart.addMedia(new Book("The Lion King 2", "Animation 3", 19.95f));
        cart.addMedia(new DigitalVideoDisc("The Lion King 2", "Animation 4", 19.95f));
        cart.addMedia(new Book("The Lion King 3", "Animation 5", 19.95f));
        cart.addMedia(new DigitalVideoDisc("The Lion King 3", "Animation 6", 19.95f));
        new CartScreen(cart);
    }

    
}
    