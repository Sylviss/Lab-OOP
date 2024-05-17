package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CompactDisc extends Disc implements Playable{
    private static int nbCompactDiscs = 0;
    private String artist;
    private List<Track> tracks = new ArrayList<>();
    public String getArtist(){
        return artist;
    }
    public int getLength(){
        return tracks.stream().map(Track::getLength).reduce(0,(i,j)->i+j);
    }
    public CompactDisc(String title, String artist){
        super(title);
        this.artist = artist;
        id = ++nbCompactDiscs;
    }
    public CompactDisc(String title, String category, float cost, String artist){
        super(title,category,cost);
        this.artist = artist;
        id = ++nbCompactDiscs;
    }
    public CompactDisc(String title, String category, String artist, String director, float cost){
        super(title, category, director, cost);
        this.artist = artist;
        id = ++nbCompactDiscs;
    }

    public boolean addAuthor(Track track){
        if (!tracks.contains(track)){
            tracks.add(track);
            return true;
        }
        return false;
    }

    public void removeAuthor(Track track){
        tracks = tracks.stream().filter(c -> !c.equals(track)).collect(Collectors.toList());
    }
    public void play(){
        System.out.println("Playing CD: " + this.getTitle());
        System.out.println("CD length: " + this.getLength());
        System.out.println("...................................................");
        for (Track track : tracks){
            track.play();
            System.out.println("...................................................");
        }
    }

    public String toString(){
        return id + ". CD - " + this.getTitle() + " - " + this.getCategory() + " - " + this.getDirector() + " - " + this.getLength() + " : " + this.getCost() + "$" + tracks.stream().map(Track::toString).reduce("",(i,j)->i+"\n"+j);
    }

    public void addTrack(Track track){
        if (!tracks.contains(track)){
            tracks.add(track);
        }
    }

    public void removeTrack(Track track){
        tracks.remove(track);
    }
}
