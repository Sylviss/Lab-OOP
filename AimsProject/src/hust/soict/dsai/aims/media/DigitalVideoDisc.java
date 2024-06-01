package hust.soict.dsai.aims.media;

import hust.soict.dsai.exception.PlayerException;

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

    public DigitalVideoDisc(String title, String category, float cost, int length){
        super(title,category,cost,length);
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

    public String play() throws PlayerException{
        if (length>0){
            String res = "";
            res+=("Playing DVD: " + this.getTitle());
            res+="\n";
            res+=("DVD length: " + this.getLength());
            res+="\n";
            return res;
        }
        else{
            throw new PlayerException("ERROR: DVD length is non-positive");
        }
    }
}
