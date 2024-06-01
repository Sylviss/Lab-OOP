package hust.soict.dsai.swing;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MediaStore extends JPanel{
    private Media media;
    private StoreScreen storeScreen;
    private ActionListener addToCart = new ActionListener(){
        public void actionPerformed(ActionEvent e){
            storeScreen.addToCart(media);
        }
    };
    private ActionListener play = new ActionListener() {
        public void actionPerformed(ActionEvent e){
            JLabel label;
            try{
                label = new JLabel(((Playable)media).play());
            } catch (Exception ex){
                label = new JLabel("Cannot play this media");
            }
            JDialog d = new JDialog();
            d.add(label);
            d.setSize(200,100);
            d.setTitle("Playing");
            d.setVisible(true);
        }
    };

    public MediaStore(Media media, StoreScreen storeScreen){
        this.media = media;
        this.storeScreen = storeScreen;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
        title.setAlignmentX(CENTER_ALIGNMENT);
        
        JLabel cost = new JLabel(""+media.getCost()+" $");
        title.setAlignmentX(CENTER_ALIGNMENT);

        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));
        
        JButton addToCartButton = new JButton("Add to cart");
        addToCartButton.addActionListener(this.addToCart);
        container.add(addToCartButton);
    
        if(media instanceof Playable){
            JButton playButton = new JButton("Play");
            playButton.addActionListener(play);            
            container.add(playButton);
        }

        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue());
        this.add(container);

        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
}
