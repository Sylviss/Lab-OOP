package hust.soict.dsai.aims.media;

import hust.soict.dsai.exception.PlayerException;

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

    public String play() throws PlayerException{
        if(length>0){
            String res = "";
            res+=("Playing track: " + this.getTitle());
            res+="\n";
            res+=("Track length: " + this.getLength());
            res+="\n";
            return res;
        }
        else{
            throw new PlayerException("ERROR: Track length is non-positive");
        }
    }

    public boolean equals(Object o){
        return o!=null && o.getClass() == getClass() && title == ((Track) o).title && length == ((Track) o).length;
    }

    public String toString(){
        return "Track - " + this.getTitle() + " - " + this.getLength();
    }
}
