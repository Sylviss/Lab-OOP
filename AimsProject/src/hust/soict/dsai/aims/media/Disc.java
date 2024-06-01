package hust.soict.dsai.aims.media;

public abstract class Disc extends Media{
    protected String director;  
    protected int length;
    public String getDirector(){
        return director;
    }
    public int getLength(){
        return length;
    }
    Disc(String title){
        super(title);
    }
    Disc(String title, String category, float cost){
        super(title, category, cost);
    }
    Disc(String title, String category, String director, float cost){
        super(title, category, cost);
        this.director = director;
    }
    Disc(String title, String category, float cost, int length){
        super(title, category, cost);
        this.length = length;
    }
    Disc(String title, String category, String director, int length, float cost){
        super(title, category, cost);
        this.director = director;
        this.length = length;
    }
}
