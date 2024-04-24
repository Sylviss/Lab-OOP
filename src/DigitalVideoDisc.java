public class DigitalVideoDisc {
    private String title;
    private String cagetory = "Unknown";
    private String director = "Unknown";
    private int length = 0;
    private float cost = 0;
    private int id;
    private static int nbDigitalVideoDiscs = 0;

    public void setTitle(String title){
        this.title = title;
    }
    public String getTitle(){
        return title;
    }
    public String getCategory(){
        return cagetory;
    }
    public String getDirector(){
        return director;
    }
    public int getLength(){
        return length;
    }
    public float getCost(){
        return cost;
    }

    public DigitalVideoDisc(String title){
        this.title = title;
        id = ++nbDigitalVideoDiscs;
    }
    public DigitalVideoDisc(String title, String category, float cost){
        this(title);
        this.cagetory = category;
        this.cost = cost;
    }
    public DigitalVideoDisc(String title, String category, String director, float cost){
        this(title, category, cost);
        this.director = director;
    }
    public DigitalVideoDisc(String title, String category, String director, int length, float cost){
        this(title, category, director, cost);
        this.length = length;
    }
    public String toString(){
        String trueLength;
        if (length == 0) {trueLength = "Unknown";}
        else {trueLength = Integer.toString(length);}
        return id + ". DVD - " + title + " - " + cagetory + " - " + director + " - " + trueLength + ": " + cost + " $";
    }
    public boolean isMatch(int id){
        return Integer.toString(this.id).contains(Integer.toString(id));
    }
    public boolean isMatch(String title){
        return this.title.contains(title);
    }
}
