package javagames.render;

import javagames.util.FrameRateCalculator;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

public class HelloWorldApp extends JFrame {

    private static final int WIDTH = 320;
    private static final int HEIGHT = 240;
    private static final int FPS_LOCATION_X = 30;
    private static final int FPS_LOCATION_Y = 30;


    private transient FrameRateCalculator frameRateCalculator;

    public HelloWorldApp() {
        this.frameRateCalculator = new FrameRateCalculator();
    }

    private void createAndShowGui() {
        GamePanel gamePanel = new GamePanel();
        gamePanel.setBackground(Color.WHITE);
        gamePanel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.getContentPane().add(gamePanel);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Hello World");
        this.pack();
        this.frameRateCalculator.initialize();
        this.setVisible(true);
    }

    private class GamePanel extends JPanel {
        @Override
        public void paint(Graphics g) {
            super.paint(g);
            onPaint(g);
        }

        private void onPaint(Graphics g) {
            frameRateCalculator.calculate();
            g.setColor(Color.BLACK);
            g.drawString(frameRateCalculator.getFrameRate(), FPS_LOCATION_X, FPS_LOCATION_Y);
            repaint();
        }
    }

    public static void main(String[] args) {
        final HelloWorldApp app = new HelloWorldApp();
        SwingUtilities.invokeLater(app::createAndShowGui);
    }
}
