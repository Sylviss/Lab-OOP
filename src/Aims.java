public class Aims {
    public static void main(String[] args){
        Cart an0rder = new Cart();
        
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        an0rder.addDigitalVideoDisc(dvd1);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        an0rder.addDigitalVideoDisc(dvd2);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation", 18.99f);
        an0rder.addDigitalVideoDisc(dvd3);
        System.out.println("This order has: " + an0rder.getQtyOrdered() + " DVD");
        System.out.println("Total cost: " + an0rder.totalCost());
        an0rder.removeDigitalVideoDisc(dvd2);
        System.out.println("This order has: " + an0rder.getQtyOrdered() + " DVD");
        System.out.println("Total cost: " + an0rder.totalCost());  
        an0rder.print();  
    }
}
