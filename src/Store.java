public class Store {
    private int storeLimit = 100000;
    private DigitalVideoDisc itemsInStore[] = new DigitalVideoDisc[storeLimit];
    private int currentIndex = 0;

    public Store(){}
    public void addDVD(DigitalVideoDisc dvd){
        if(currentIndex < storeLimit){
            itemsInStore[currentIndex] = dvd;
            currentIndex++;
        }
        else{
            System.out.println("Store is full");
        }
    }
    public void removeDVD(DigitalVideoDisc dvd){
        for(int i = 0; i < currentIndex; i++){
            if(itemsInStore[i]==dvd){
                for(int j = i; j < currentIndex - 1; j++){
                    itemsInStore[j] = itemsInStore[j + 1];
                }
                currentIndex--;
                break;
            }
        }
    }
    public void print(){
        System.out.print("***********************Store**********************\nOrdered Items:\n");
        for(int i = 0; i < currentIndex; i++){
            System.out.println(itemsInStore[i].toString());
        }
        System.out.println("**************************************************");
        
    }
}
