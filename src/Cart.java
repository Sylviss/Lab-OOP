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
        }
    }

    public void addDigitalVideoDisc(DigitalVideoDisc dvd1,DigitalVideoDisc dvd2){
        if(qtyOrdered + 2 <= MAX_NUMBER_ORDERED){
            itemsOrdered[qtyOrdered] = dvd1;
            itemsOrdered[qtyOrdered+1] = dvd2;
            qtyOrdered+=2;
            System.out.println("The discs have been added.");
        }
        else{
            System.out.println("The cart don't have that many slot left.");
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

    public int getQtyOrdered(){
        return qtyOrdered;
    }

    public void print(){
        System.out.print("***********************CART***********************\nOrdered Items:\n");
        for(int i = 0; i < qtyOrdered; i++){
            System.out.println(itemsOrdered[i].toString());
        }
        System.out.println("Total cost: " + totalCost() + "\n**************************************************");
    }
    
    public void search(int id){
        boolean matched = false;
        System.out.print("***********************CART***********************\nMatch Items:\n");
        for(int i = 0; i < qtyOrdered; i++){
            if (itemsOrdered[i].isMatch(id)){
                System.out.println(itemsOrdered[i].toString());
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
        for(int i = 0; i < qtyOrdered; i++){
            if (itemsOrdered[i].isMatch(title)){
                System.out.println(itemsOrdered[i].toString());
                matched = true;
            }
        }
        if(!matched){
            System.out.println("No match found");
        }
        System.out.println("**************************************************");
    }
}
