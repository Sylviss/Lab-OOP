package hust.soict.dsai.aims.media;
import java.util.Comparator;

public abstract class Media { 
    public static final Comparator<Media> COMPARE_BY_TITLE_COST = Comparator.comparing(Media::getTitle).thenComparing(Media::getCost);
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = Comparator.comparing(Media::getCost).thenComparing(Media::getTitle);
    protected int id;
    protected String title;
    protected String category;
    protected float cost;
    
    Media() {
    }

    Media(String title) {
        this.title = title;
    }

    Media(String title, String category) {
        this(title);
        this.category = category;
    }

    Media(String title, String category, float cost) {
        this(title, category);
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public float getCost() {
        return cost;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public boolean isMatch(int id){
        return Integer.toString(this.id).contains(Integer.toString(id));
    }

    public boolean isMatch(String title){
        return this.title.contains(title);
    }

    public abstract String toString();

    public boolean equals(Object o){
        return o!=null&&getClass()==o.getClass()&& title == ((Media) o).title;
    }

    public boolean sameTitle(String title){
        return this.title.equals(title);
    }
}
