package hust.soict.dsai.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import hust.soict.dsai.aims.Aims;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.screen.CartScreen;
import hust.soict.dsai.screen.UpdateBook;
import hust.soict.dsai.screen.UpdateCD;
import hust.soict.dsai.screen.UpdateDVD;

public class StoreScreen extends JFrame {
    private Store store;
    private Cart cart;
    private CartScreen cartScreen;
    private JPanel center;

    JPanel createNorth(){
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    JMenuBar createMenuBar(){
        JMenu menu = new JMenu("Option");

        JMenu smUpdateStore = new JMenu("Update Store");
        JMenuItem bookButton = new JMenuItem("Add Book");
        bookButton.addActionListener(e -> {
            new UpdateBook(this);
        });
        smUpdateStore.add(bookButton);
        
        JMenuItem cdButton = new JMenuItem("Add CD");
        cdButton.addActionListener(e -> {
            new UpdateCD(this);
        });
        smUpdateStore.add(cdButton);
        
        JMenuItem dvdButton = new JMenuItem("Add DVD");
        dvdButton.addActionListener(e -> {
            new UpdateDVD(this);
        });
        smUpdateStore.add(dvdButton);
        
        menu.add(smUpdateStore);
        menu.add(new JMenuItem("View Store"));
        menu.add(new JMenuItem("View Cart"));

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);

        return menuBar;
    }

    JPanel createHeader(){
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.CYAN);

        JButton cart = new JButton("View cart");
        cart.setPreferredSize(new Dimension(100,50));
        cart.setMaximumSize(new Dimension(100,50));

        cart.addActionListener(e->{
            this.cart.print();
            if(cartScreen == null){
                cartScreen = new CartScreen(this.cart);
            }
            else{
                cartScreen.setVisible(true);
            }
        });

        header.add(Box.createRigidArea(new Dimension(10,10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(cart);
        header.add(Box.createRigidArea(new Dimension(10,10)));

        return header;
    }

    public StoreScreen(Store store, Cart cart){
        this.store = store;
        this.cart = cart;
        this.center = createCenter();
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        
        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(this.center, BorderLayout.CENTER);

        setVisible(true);
        setTitle("Store");
        setSize(1024,768);
    }

    JPanel createCenter(){
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3,0,2,2));

        ArrayList<Media> mediaInStore = store.getItemsInStore();
        for(Media media: mediaInStore){
            MediaStore cell = new MediaStore(media,this);
            center.add(cell);
        }
        return center;
    }

    void addToCart(Media media){
        cart.addMedia(media);
    }

    public Store getStore(){
        return store;
    }

    public void updateCenter(){
        center.removeAll();
        ArrayList<Media> mediaInStore = store.getItemsInStore();
        for(Media media: mediaInStore){
            MediaStore cell = new MediaStore(media,this);
            center.add(cell);
        }
        this.revalidate();
        this.repaint();
    }

    public static void main(String[] args) {
        Store store = new Store();
        Cart cart = new Cart();
        for (int i = 0; i < 10; i++) {
            int randomMediaType = (int) (Math.random() * 3) + 1;
            switch (randomMediaType) {
                case 1:
                    store.addMedia(Aims.generateRandomBook());
                    break;
                case 2:
                    store.addMedia(Aims.generateRandomDVD());
                    break;
                case 3:
                    store.addMedia(Aims.generateRandomCD());
                    break;
            }
        }
        StoreScreen storeScreen = new StoreScreen(store,cart);
    }
}
