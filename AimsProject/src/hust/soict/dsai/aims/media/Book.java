package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Book extends Media{
    private List<String> authors = new ArrayList<>();
    private static int nbBooks = 0;

    public boolean addAuthor(String authorName){
        if (!authors.contains(authorName)){
            authors.add(authorName);
            return true;
        }
        return false;
    }

    public void removeAuthor(String authorName){
        authors = authors.stream().filter(c -> !c.equals(authorName)).collect(Collectors.toList());
    }

    public List<String> getAuthors(){
        return authors;
    }

    public Book(String title){
        super(title);
        id = ++nbBooks;
    }

    public Book(String title, String category, float cost){
        super(title,category,cost);
        id = ++nbBooks;
    }

    public Book(String title, String category, List<String> authors, float cost){
        super(title, category, cost);
        this.authors = authors;
        id = ++nbBooks;
    }

    public String toString(){
        if (category.equals("")) {category = new String("Unknown");}
        return id + ". Book - " + title + " - " + category + " - " + authors.stream().reduce("",(i,j)->i+","+j) +  ": " + cost + " $";
    }
}
