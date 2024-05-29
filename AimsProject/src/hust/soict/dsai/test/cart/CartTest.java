package hust.soict.dsai.test.cart;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import java.util.ArrayList;
import hust.soict.dsai.aims.media.*;

public class CartTest {
    public static void main(String[] args) {
        ArrayList<Media> cart = new ArrayList<Media>();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("DVD 1", "Action", "Director 1", 120, 19.95f);
        cart.add(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("DVD 2", "Comedy", "Director 2", 90, 14.99f);
        cart.add(dvd2);

        CompactDisc cd1 = new CompactDisc("CD 1", "Pop", "Artist 1", "Director 1", 9.99f);
        cart.add(cd1);

        Book book1 = new Book("Book 1", "Author 1", 29.99f);
        cart.add(book1);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("DVD 3", "Drama", "Director 3", 150, 24.99f);
        cart.add(dvd3);

        CompactDisc cd2 = new CompactDisc("CD 2", "Rock", "Artist 2", "Director 1", 12.99f);
        cart.add(cd2);

        Book book2 = new Book("Book 2", "Author 2", 19.99f);
        cart.add(book2);

        DigitalVideoDisc dvd4 = new DigitalVideoDisc("DVD 4", "Thriller", "Director 4", 110, 17.99f);
        cart.add(dvd4);

        CompactDisc cd3 = new CompactDisc("CD 3", "R&B", "Artist 3", "Director 1", 11.99f);
        cart.add(cd3);

        Book book3 = new Book("Book 3", "Author 3", 14.99f);
        cart.add(book3);

        DigitalVideoDisc dvd5 = new DigitalVideoDisc("DVD 5", "Sci-Fi", "Director 5", 130, 21.99f);
        cart.add(dvd5);

        for (Media media : cart) {
            System.out.println(media.toString());
        }
    }
}