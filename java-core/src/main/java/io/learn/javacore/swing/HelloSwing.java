package io.learn.javacore.swing;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class HelloSwing extends JFrame {
    private JButton button;
    private JLabel label;
    private JPanel panel;

    public HelloSwing() {
        this.button = new JButton();
        this.label = new JLabel();
        this.panel = new JPanel();

        this.button.setText("Click Me!");
        this.button.setToolTipText("Click the button");

        this.setTitle("Hello World from Swing");
        this.setSize(500, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        panel.add(button);
        panel.add(label);
        this.add(panel);

        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                buttonMouseClicked(e);
            }
        });
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new HelloSwing();
            }
        });
    }

    private void buttonMouseClicked(MouseEvent e) {
        label.setText("Hello World");
    }

}
