package hust.soict.dsai.test.disc;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class TestPassingParameter {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        DigitalVideoDisc jungleCD = new DigitalVideoDisc("Jungle");
        DigitalVideoDisc cinderellaCD = new DigitalVideoDisc("Cinderella");
        
        swap(jungleCD,cinderellaCD);
        System.out.println("jungle CD title: " + jungleCD.getTitle());
        System.out.println("cinderella CD title: " + cinderellaCD.getTitle());
        
        DigitalVideoDisc[] res = better_swap(jungleCD,cinderellaCD);
        jungleCD = res[0];
        cinderellaCD = res[1];
        System.out.println("jungle CD title: " + jungleCD.getTitle());
        System.out.println("cinderella CD title: " + cinderellaCD.getTitle());  
        
        jungleCD = new DigitalVideoDisc("Jungle");
        cinderellaCD = new DigitalVideoDisc("Cinderella");
        changeTitle(jungleCD, cinderellaCD.getTitle());
        System.out.println("jungle CD title: " + jungleCD.getTitle());
    }

    public static void swap(Object a1, Object a2){
        Object tmp = a1;
        a1 = a2;
        a2 = tmp;
    }

    public static DigitalVideoDisc[] better_swap(DigitalVideoDisc a1, DigitalVideoDisc a2){
        return new DigitalVideoDisc[] {a2,a1};
    }

    public static void changeTitle(DigitalVideoDisc dvd, String title){
        String oldTitle = dvd.getTitle();
        dvd.setTitle(title);
        dvd = new DigitalVideoDisc(oldTitle);
    }
}
