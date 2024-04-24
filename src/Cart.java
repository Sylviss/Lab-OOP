public class Cart {
    public static final int MAX_NUMBER_ORDERED = 20;
    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBER_ORDERED];
    private int qtyOrdered = 0;

    public void addDigitalVideoDisc(DigitalVideoDisc disc){
        if(qtyOrdered < MAX_NUMBER_ORDERED){
            itemsOrdered[qtyOrdered] = disc;
            qtyOrdered++;
            System.out.println("The disc has been added.");
        }
        else{
            System.out.println("The cart is almost full.");
        }
    }

    // public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList){
    //     if(qtyOrdered + dvdList.length <= MAX_NUMBER_ORDERED){
    //         for(int i = 0; i < dvdList.length; i++){
    //             itemsOrdered[qtyOrdered] = dvdList[i];
    //             qtyOrdered++;
    //             System.out.println("The disc has been added.");
    //         }
    //     }
    //     else{
    //         System.out.println("The cart don't have that many slot left.");
    //         return;
    //     }
    // }

    // This is prefered
    public void addDigitalVideoDisc(DigitalVideoDisc... dvdList){
        if(qtyOrdered + dvdList.length <= MAX_NUMBER_ORDERED){
            for(int i = 0; i < dvdList.length; i++){
                itemsOrdered[qtyOrdered] = dvdList[i];
                qtyOrdered++;
                System.out.println("The disc has been added.");
            }
        }
        else{
            System.out.println("The cart don't have that many slot left.");
            return;
        }
    }

    public void removeDigitalVideoDisc(DigitalVideoDisc disc){
        for(int i = 0; i < qtyOrdered; i++){
            if(itemsOrdered[i] == disc){
                for(int j = i; j < qtyOrdered - 1; j++){
                    itemsOrdered[j] = itemsOrdered[j + 1];
                }
                qtyOrdered--;
                System.out.println("The disc has been removed.");
                return;
            }
        }
        System.out.println("The disc is not in the cart.");
    }

    public float totalCost(){
        float total = 0;
        for(int i = 0; i < qtyOrdered; i++){
            total += itemsOrdered[i].getCost();
        }
        return total;
    }

    public int getQtyOrdered() {
        return qtyOrdered;
    }
}
