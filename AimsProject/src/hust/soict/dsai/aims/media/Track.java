package hust.soict.dsai.aims.media;

public class Track implements Playable{
    private int length;
    private String title;
    
    public Track(int length, String title){
        this.length = length;
        this.title = title;
    }

    public int getLength() {
        return this.length;
    }

    public String getTitle() {
        return this.title;
    }

    public void play() {
        System.out.println("Playing track: " + this.getTitle());
        System.out.println("Track length: " + this.getLength());
    }

    public boolean equals(Object o){
        return o!=null && o.getClass() == getClass() && title == ((Track) o).title && length == ((Track) o).length;
    }

    public String toString(){
        return "Track - " + this.getTitle() + " - " + this.getLength();
    }
}
