package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
public class Cart {
    private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();

    public void addMedia(Media media){
        itemsOrdered.add(media);
        System.out.println("The media has been added.");
    }

    public void addMedia(Media... mediaList){
        for (Media media : mediaList) {
            itemsOrdered.add(media);
        }
        System.out.println("The media has been added.");
    }

    public void removeMedia(Media media){
    if (itemsOrdered.remove(media)){
        System.out.println("The media has been removed.");
    }
    else 
        System.out.println("The media is not in the cart.");
    }

    public float totalCost(){
        return itemsOrdered.stream().map(Media::getCost).reduce((float) 0,(i,j)->i+j);
    }

    public void print(){
        System.out.print("***********************CART***********************\nOrdered Items:\n");
        for(Media media:itemsOrdered){
            System.out.println(media.toString());
        }
        System.out.println("Total cost: " + totalCost() + "\n**************************************************");
    }
    
    public void search(int id){
        boolean matched = false;
        System.out.print("***********************CART***********************\nMatch Items:\n");
        for(Media media: itemsOrdered){
            if (media.isMatch(id)){
                System.out.println(media.toString());
                matched = true;
            }
        }
        if(!matched){
            System.out.println("No match found");
        }
        System.out.println("**************************************************");
    }
    public void search(String title){
        boolean matched = false;
        System.out.print("***********************CART***********************\nMatch Items:\n");
        for(Media media: itemsOrdered){
            if (media.isMatch(title)){
                System.out.println(media.toString());
                matched = true;
            }
        }
        if(!matched){
            System.out.println("No match found");
        }
        System.out.println("**************************************************");
    }

    public void sortByTitle(){
        itemsOrdered.sort(Media.COMPARE_BY_TITLE_COST);
    }

    public void sortByCost(){
        itemsOrdered.sort(Media.COMPARE_BY_COST_TITLE);
    }

    public boolean removeMedia(String title){
        Media media = itemsOrdered.stream().filter(med -> med.sameTitle(title)).findFirst().orElse(null);
        if (media!=null) {
            itemsOrdered.remove(media);
            return true;
        }
        else {
            System.out.println("Cannot found this item");
            return false;
        }
    }

    public Media getMedia(String title){
        Media media = itemsOrdered.stream().filter(med -> med.sameTitle(title)).findFirst().orElse(null);
        return media;
    }

    public void clear(){
        itemsOrdered.clear();
    }

    public ObservableList<Media> getItemsOrdered(){
        return itemsOrdered;
    }
}
