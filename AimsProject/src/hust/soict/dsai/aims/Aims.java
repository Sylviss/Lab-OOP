package hust.soict.dsai.aims;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.exception.PlayerException;
import hust.soict.dsai.swing.StoreScreen;

import java.util.Scanner;
public class Aims {
    public static final String LINE = "--------------------------------";

    public static void main2(){
                // Store store = new Store();
        // for (int i = 0; i < 10; i++) {
        //     int randomMediaType = (int) (Math.random() * 3) + 1;
        //     switch (randomMediaType) {
        //         case 1:
        //             store.addMedia(generateRandomBook());
        //             break;
        //         case 2:
        //             store.addMedia(generateRandomDVD());
        //             break;
        //         case 3:
        //             store.addMedia(generateRandomCD());
        //             break;
        //     }
        // }
        // for (int i = 0; i < 10; i++) {
        //     int randomMediaType = (int) (Math.random() * 3);
        //     switch (randomMediaType) {
        //         case 0:
        //             store.addMedia(generateRandomBook());
        //             break;
        //         case 1:
        //             store.addMedia(generateRandomDVD());
        //             break;
        //         case 2:
        //             store.addMedia(generateRandomCD());
        //             break;
        //     }
        // }
        // Cart cart = new Cart();
        // Scanner scanner = new Scanner(System.in);
        // showMenu(scanner,store,cart);
    }
    public static void main(String[] args){

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

    //#####################################################################

    public static Book generateRandomBook() {
        String[] titles = {"Book 1", "Book 2", "Book 3"};
        String[] categories = {"Category 1", "Category 2", "Category 3"};
        float[] costs = {10.0f, 20.0f, 30.0f};
        int randomIndex = (int) (Math.random() * titles.length);
        return new Book(titles[randomIndex], categories[randomIndex], costs[randomIndex]);
    }

    public static DigitalVideoDisc generateRandomDVD() {
        String[] titles = {"DVD 1", "DVD 2", "DVD 3"};
        String[] categories = {"Category 1", "Category 2", "Category 3"};
        float[] costs = {10.0f, 20.0f, 30.0f};
        int randomIndex = (int) (Math.random() * titles.length);
        return new DigitalVideoDisc(titles[randomIndex], categories[randomIndex],costs[randomIndex],1);
    }

    public static CompactDisc generateRandomCD() {
        String[] titles = {"CD 1", "CD 2", "CD 3"};
        String[] categories = {"Category 1", "Category 2", "Category 3"};
        float[] costs = {10.0f, 20.0f, 30.0f};
        String[] artists = {"Artist 1", "Artist 2", "Artist 3"};
        int randomIndex = (int) (Math.random() * titles.length);
        CompactDisc cd = new CompactDisc(titles[randomIndex], categories[randomIndex], costs[randomIndex], artists[randomIndex]);
        for (int i = 0; i < 5; i++) {
            Track track = new Track(i + 1,"Track " + (i + 1));
            cd.addTrack(track);
        }
        return cd;
    }

    //############################################################3
    
    public static void showMenu(Scanner scanner, Store store, Cart cart) {
        System.out.println("AIMS: ");
        System.out.println(LINE);
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println(LINE);
        System.out.println("Please choose a number: 0-1-2-3");  
        switch (scanner.nextInt()){
            case 0:
                return;
            case 1:
                storeMenu(scanner,store,cart);
                showMenu(scanner,store,cart);
                break;
            case 2:
                updateStore(scanner,store,cart);
                showMenu(scanner,store,cart);
                break;
            case 3:
                cart.print();
                cartMenu(scanner,store,cart);
                showMenu(scanner,store,cart);
                break;
            default:
                System.out.println("Invalid choice");
                showMenu(scanner,store,cart);
        }  
    }

    public static void storeMenu(Scanner scanner, Store store, Cart cart) {
        System.out.println("Options: ");
        System.out.println(LINE);
        System.out.println("1. See a media's details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("5. View store");
        System.out.println("0. Back");
        System.out.println(LINE);
        System.out.println("Please choose a number: 0-1-2-3-4-5");  
        switch (scanner.nextInt()){
            case 0:
                return;
            case 1:
                mediaDetail(scanner, store, cart);
                storeMenu(scanner, store, cart);
                break;
            case 2:
                addCart(scanner, store, cart);
                storeMenu(scanner, store, cart);
                break;
            case 3:
                playMediaMenu(scanner, store, cart);
                storeMenu(scanner, store, cart);
                break;
            case 4:
                cart.print();
                cartMenu(scanner, store, cart);
                storeMenu(scanner, store, cart);
                break;
            case 5:
                store.print();
                storeMenu(scanner, store, cart);
                break;
            default:
                System.out.println("Invalid choice");
                storeMenu(scanner, store, cart);
        }
    }

    public static void mediaDetail(Scanner scanner, Store store, Cart cart) {
        System.out.println("Enter the title of the media: ");
        scanner.nextLine();
        String title = scanner.nextLine();
        Media media = store.getMedia(title);
        if (media == null) {
            System.out.println("No media found with the given title.");
            return;
        }
        mediaDetailsMenu(scanner, store, cart, media);
    }

    public static void mediaDetailsMenu(Scanner scanner, Store store, Cart cart, Media media) {
        System.out.println("Options: ");
        System.out.println(LINE);
        System.out.println("1. Add to cart");
        if (media instanceof Playable){
            System.out.println("2. Play");
        }
        System.out.println("0. Back");
        System.out.println(LINE);
        System.out.println("Please choose a number: 0-1-2");
        switch (scanner.nextInt()){
            case 0:
                return;
            case 1:
                store.removeMedia(media);
                cart.addMedia(media);
                System.out.println("Media added successfully");
                break;
            case 2:
                if (media instanceof Playable){
                    try{
                    ((Playable) media).play();
                    mediaDetailsMenu(scanner, store, cart, media);
                    break;
                    } catch (PlayerException e){
                        System.out.println(e);
                        break;
                    }
                }
                else{
                    System.out.println("This media is not playable");
                }
            default:
                System.out.println("Invalid choice");
                mediaDetailsMenu(scanner, store, cart, media);
        }
    }

    public static void addCart(Scanner scanner, Store store, Cart cart) {
        System.out.println("Enter the title of the media: ");
        scanner.nextLine();
        String title = scanner.nextLine();
        Media media = store.getMedia(title);
        if (media == null) {
            System.out.println("No media found with the given title.");
            return;
        }
        store.removeMedia(media);
        cart.addMedia(media);
    }

    public static void playMediaMenu(Scanner scanner, Store store, Cart cart) {
        System.out.println("Enter the title of the media: ");
        scanner.nextLine();
        String title = scanner.nextLine();
        Media media = store.getMedia(title);
        if (media == null) {
            System.out.println("No media found with the given title.");
            return;
        }
        if (media instanceof Playable){
            try{
                ((Playable) media).play();
            } catch (PlayerException e){
                System.out.println(e);
            }
        }
        else{
            System.out.println("This media is not playable");
        }
    }

    public static void updateStore(Scanner scanner, Store store, Cart cart) {
        System.out.println("Options: ");
        System.out.println(LINE);
        System.out.println("1. Add a media");
        System.out.println("2. Remove a media");
        System.out.println("0. Back");
        System.out.println(LINE);
        System.out.println("Please choose a number: 0-1-2");
        switch (scanner.nextInt()){
            case 0:
                return;
            case 1:
                addMedia(scanner, store, cart);
                updateStore(scanner, store, cart);
                break;
            case 2:
                removeMedia(scanner, store, cart);
                updateStore(scanner, store, cart);
                break;
            default:
                System.out.println("Invalid choice");
                updateStore(scanner, store, cart);
        }
    }

    public static void addMedia(Scanner scanner, Store store, Cart cart) {
        System.out.println("Enter the type of media (1. Book, 2. DVD, 3. CD, 0. Return): ");
        switch (scanner.nextInt()) {
            case 1:
                addBook(scanner, store);
                break;
            case 2:
                addDVD(scanner, store);
                break;
            case 3:
                addCD(scanner, store);
                break;
            default:
                System.out.println("Invalid media type");
                addMedia(scanner, store, cart);
                break;
        }
    }

    public static void addBook(Scanner scanner, Store store) {
        System.out.println("Enter the title of the book: ");
        scanner.nextLine();
        String title = scanner.nextLine();
        System.out.println("Enter the category of the book: ");
        String category = scanner.nextLine();
        System.out.println("Enter the cost of the book: ");
        float cost = scanner.nextFloat();
        store.addMedia(new Book(title, category, cost));
    }

    public static void addDVD(Scanner scanner, Store store) {
        System.out.println("Enter the title of the DVD: ");
        scanner.nextLine();
        String title = scanner.nextLine();
        System.out.println("Enter the category of the DVD: ");
        String category = scanner.nextLine();
        System.out.println("Enter the cost of the DVD: ");
        float cost = scanner.nextFloat();
        store.addMedia(new DigitalVideoDisc(title, category, cost));
    }

    public static void addCD(Scanner scanner, Store store) {
        System.out.println("Enter the title of the CD: ");
        scanner.nextLine();
        String title = scanner.nextLine();
        System.out.println("Enter the category of the CD: ");
        String category = scanner.nextLine();
        System.out.println("Enter the cost of the CD: ");
        float cost = scanner.nextFloat();
        System.out.println("Enter the artist of the CD: ");
        String artist = scanner.nextLine();
        store.addMedia(new CompactDisc(title,category,cost,artist));
    }

    public static void removeMedia(Scanner scanner, Store store, Cart cart) {
        System.out.println("Enter the title of the media: ");
        scanner.nextLine();
        String title = scanner.nextLine();
        Media media = store.getMedia(title);
        if (media == null) {
            System.out.println("No media found with the given title.");
            return;
        }
        store.removeMedia(media);
    }

    public static void cartMenu(Scanner scanner, Store store, Cart cart) {
        System.out.println("Options: ");
        System.out.println(LINE);
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println(LINE);
        System.out.println("Please choose a number: 0-1-2-3-4-5");
        switch (scanner.nextInt()){
            case 0:
                return;
            case 1:
                filterMenu(scanner, store, cart);
                cartMenu(scanner, store, cart);
                break;
            case 2:
                sortMenu(scanner, store, cart);
                cartMenu(scanner, store, cart);
                break;
            case 3:
                removeMediaFromCart(scanner, store, cart);
                cartMenu(scanner, store, cart);
                break;
            case 4:
                playMediaFromCart(scanner, store, cart);
                cartMenu(scanner, store, cart);
                break;
            case 5:
                placeOrder(scanner, store, cart);
                cartMenu(scanner, store, cart);
                break;
            default:
                System.out.println("Invalid choice");
                cartMenu(scanner, store, cart);
        }
    }

    public static void filterMenu(Scanner scanner, Store store, Cart cart) {
        System.out.println("Options: ");
        System.out.println(LINE);
        System.out.println("1. Filter by title");
        System.out.println("2. Filter by id");
        System.out.println("0. Back");
        System.out.println(LINE);
        System.out.println("Please choose a number: 0-1-2");
        switch(scanner.nextInt()){
            case 1:
                filterByTitle(scanner, store, cart);
                break;
            case 2:
                filterById(scanner, store, cart);
                break;
            default:
                System.out.println("Invalid choice");
                filterMenu(scanner, store, cart);
        }
    }

    public static void filterByTitle(Scanner scanner, Store store, Cart cart) {
        System.out.println("Enter the title: ");
        scanner.nextLine();
        String title = scanner.nextLine();
        cart.search(title);
    }

    public static void filterById(Scanner scanner, Store store, Cart cart) {
        System.out.println("Enter the id: ");
        int id = scanner.nextInt();
        cart.search(id);
    }

    public static void sortMenu(Scanner scanner, Store store, Cart cart) {
        System.out.println("Options: ");
        System.out.println(LINE);
        System.out.println("1. Sort by title");
        System.out.println("2. Sort by cost");
        System.out.println("0. Back");
        System.out.println(LINE);
        System.out.println("Please choose a number: 0-1-2");
        switch(scanner.nextInt()){
            case 1:
                cart.sortByTitle();
                break;
            case 2:
                cart.sortByCost();
                break;
            default:
                System.out.println("Invalid choice");
                sortMenu(scanner, store, cart);
        }
    }

    public static void removeMediaFromCart(Scanner scanner, Store store, Cart cart) {
        System.out.println("Enter the title of the media: ");
        scanner.nextLine();
        String title = scanner.nextLine();
        if(cart.removeMedia(title)){
            System.out.println("No media found with the given title.");
            return;
        }
    }

    public static void playMediaFromCart(Scanner scanner, Store store, Cart cart) {
        System.out.println("Enter the title of the media: ");
        scanner.nextLine();
        String title = scanner.nextLine();
        Media media = cart.getMedia(title);
        if (media == null) {
            System.out.println("No media found with the given title.");
            return;
        }
        if (media instanceof Playable){
            try{
                ((Playable) media).play();
            } catch (PlayerException e){
                System.out.println(e);
            }
        }
        else{
            System.out.println("This media is not playable");
        }
    }

    public static void placeOrder(Scanner scanner, Store store, Cart cart) {
        System.out.println("Order placed successfully");
        cart.print();
        cart.clear();
    }
}
