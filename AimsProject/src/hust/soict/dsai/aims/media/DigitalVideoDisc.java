package hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Disc implements Playable{
    private static int nbDigitalVideoDiscs = 0;
    public DigitalVideoDisc(String title){
        super(title);
        id = ++nbDigitalVideoDiscs;
    }
    public DigitalVideoDisc(String title, String category, float cost){
        super(title,category,cost);
        id = ++nbDigitalVideoDiscs;

    }
    public DigitalVideoDisc(String title, String category, String director, float cost){
        super(title, category, director, cost);
        id = ++nbDigitalVideoDiscs;
    }
    public DigitalVideoDisc(String title, String category, String director, int length, float cost){
        super(title, category, director, length, cost);
        id = ++nbDigitalVideoDiscs;
    }
    public String toString(){
        String trueLength;
        if (length == 0) {trueLength = new String("Unknown");}
        else {trueLength = Integer.toString(length);}
        if (director == null) {director = new String("Unknown");}
        if (category == null) {category = new String("Unknown");}
        return id + ". DVD - " + title + " - " + category + " - " + director + " - " + trueLength + ": " + cost + " $";
    }

    public void play() {
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }
}
