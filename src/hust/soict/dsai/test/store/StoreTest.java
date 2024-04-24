package hust.soict.dsai.test.store;
import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class StoreTest {
    public static void main(String[] args) {
        Store store = new Store();
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Matrix", "Sci-Fi", 2);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Inception", "Thriller", 2);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("The Avengers", "Action", 2);
        store.addDVD(dvd2);
        store.addDVD(dvd3);
        store.addDVD(dvd1);
        store.print();
        store.removeDVD(dvd1);
        store.print();
    }
}
