package hust.soict.dsai.screen;

import java.util.ArrayList;

import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.Track;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import hust.soict.dsai.swing.StoreScreen;

public class CDUpdateController extends StoreUpdateController {
    private ArrayList<Track> tracks = new ArrayList<>();
    @FXML
    TextField tfArtist;

    @FXML
    TextField tfDirector;

    @FXML
    TextField tfLength;

    @FXML
    ListView<Track> trackList;

    public ArrayList<Track> getTracks() {
        return tracks;
    }

    public ListView<Track> getLvTracks() {
        return trackList;
    }

    CDUpdateController(StoreScreen store) {
        super(store);
    }

    @FXML
    void addBtnPressed() {
        String title = tfTitle.getText();
        String category = tfCategory.getText();
        float cost = Float.parseFloat(tfCost.getText());
        String director = tfDirector.getText();
        int length = Integer.parseInt(tfLength.getText());
        String artist = tfArtist.getText();
        for (Track track : tracks) {
            trackList.getItems().add(track);
        }
        CompactDisc cd = new CompactDisc(title, category, artist, director, cost);
        for (Track track : tracks) {
            cd.addTrack(track);
        }
        store.getStore().addMedia(cd);
        store.updateCenter();
    }

    @FXML
    void addTrackBtnPressed() {
        AddTrack addTrack = new AddTrack(this);
    }

}
