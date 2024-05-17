package hust.soict.dsai.aims.store;
import java.util.ArrayList;
import java.util.List;

import hust.soict.dsai.aims.media.Media;

public class Store {
    List<Media> itemsInStore = new ArrayList<>();

    public Store(){}
    public void addMedia(Media media){
        itemsInStore.add(media);
        System.out.println("The item is added to the store");
    }
    public void removeMedia(Media media){
        if (itemsInStore.remove(media)){
            System.out.println("The item is removed from the store");
        }
        else{
            System.out.println("Cannot found this item");
        }
    }
    public void print(){
        System.out.print("***********************Store**********************\nOrdered Items:\n");
        for (Media media : itemsInStore) {
            System.out.println(media.toString());
        }
        System.out.println("**************************************************");
        
    }
    public Media getMedia(String title){
        Media media = itemsInStore.stream().filter(med -> med.sameTitle(title)).findFirst().orElse(null);
        return media;
    }
}
