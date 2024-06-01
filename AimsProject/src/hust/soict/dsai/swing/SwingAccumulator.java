package hust.soict.dsai.swing;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SwingAccumulator extends JFrame implements ActionListener {
    private JTextField tfInput;
    private JTextField tfOutput;
    private int sum = 0;

    public SwingAccumulator() {
        Container cp = getContentPane();
        cp.setLayout(new GridLayout(2, 2));

        cp.add(new JLabel("Enter an Integer:"));

        tfInput = new JTextField(10);
        cp.add(tfInput);
        tfInput.addActionListener(this);

        cp.add(new JLabel("Accumulated Sum:"));

        tfOutput = new JTextField(10);
        tfOutput.setEditable(false);
        cp.add(tfOutput);

        setTitle("Swing Accumulator");
        setSize(350, 120);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        int numberIn = Integer.parseInt(tfInput.getText());
        sum += numberIn;
        tfInput.setText("");
        tfOutput.setText(sum + "");
    }

    public static void main(String[] args) {
        new SwingAccumulator();
    }
}

