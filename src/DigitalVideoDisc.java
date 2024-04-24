public class DigitalVideoDisc {
    private String title;
    private String cagetory;
    private String director;
    private int length;
    private float cost;
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
        id = ++nbDigitalVideoDiscs;
    }
    public DigitalVideoDisc(String title, String category, String director, float cost){
        this(title, category, cost);
        this.director = director;
        id = ++nbDigitalVideoDiscs;
    }
    public DigitalVideoDisc(String title, String category, String director, int length, float cost){
        this(title, category, director, cost);
        this.length = length;
        id = ++nbDigitalVideoDiscs;
    }
}
