package javagames.render;

import javagames.util.FrameRateCalculator;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferStrategy;

public class ActiveRenderingExample extends JFrame implements Runnable {

    private transient FrameRateCalculator frameRateCalculator;
    private transient BufferStrategy bufferStrategy;
    private volatile boolean running;
    private transient Thread gameThread;

    public ActiveRenderingExample() {
        this.frameRateCalculator = new FrameRateCalculator();
    }

    private void createAndShowGui() {
        Canvas canvas = new Canvas();
        canvas.setSize(320, 240);
        canvas.setBackground(Color.BLACK);
        canvas.setIgnoreRepaint(true);
        getContentPane().add(canvas);
        setTitle("Active Rendering");
        setIgnoreRepaint(true);
        pack();
        setVisible(true);
        canvas.createBufferStrategy(2);
        this.bufferStrategy = canvas.getBufferStrategy();
        this.gameThread = new Thread(this);
        this.gameThread.start();
    }

    @Override
    public void run() {
        this.running = true;
        frameRateCalculator.initialize();
        while (this.running) {
            gameLoop();
        }
    }

    private void gameLoop() {
        do {
            do {
                Graphics graphics = null;
                try {
                    graphics = this.bufferStrategy.getDrawGraphics();
                    graphics.clearRect(0, 0, getWidth(), getHeight());
                    render(graphics);
                } finally {
                    if (graphics != null) {
                        graphics.dispose();
                    }
                }
            } while (this.bufferStrategy.contentsRestored());
            this.bufferStrategy.show();
        } while (this.bufferStrategy.contentsLost());
    }

    private void render(Graphics graphics) {
        this.frameRateCalculator.calculate();
        graphics.setColor(Color.GREEN);
        graphics.drawString(frameRateCalculator.getFrameRate(), 30, 30);
    }

    private void onWindowClosing() {
        try {
            this.running = false;
            this.gameThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.exit(0);
    }

    public static void main(String[] args) {
        final ActiveRenderingExample app = new ActiveRenderingExample();
        app.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                app.onWindowClosing();
            }
        });
        SwingUtilities.invokeLater(app::createAndShowGui);
    }


}
